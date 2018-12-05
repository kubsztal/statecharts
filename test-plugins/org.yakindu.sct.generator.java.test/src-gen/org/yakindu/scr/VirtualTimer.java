package org.yakindu.scr;

import java.util.PriorityQueue;
import java.util.Queue;
import org.yakindu.scr.ITimer;
import org.yakindu.scr.ITimerCallback;

public class VirtualTimer implements ITimer {
	
	private long stopTime = 0;
	protected long currentTime = 0;
	protected long cyclePeriod = 0;
	protected long scheduleCount = 0;

	private Queue<VirtualTimeTask> tasks;

	public abstract static class VirtualTimeTask implements Runnable, Comparable<VirtualTimeTask> {

		long nextExecutionTime = 0;
		long interval = 0;
		long period = -1;
		long scheduleOrder = 0;
		boolean isCanceled = false;

		public int compareTo(VirtualTimeTask o) {
			if (nextExecutionTime != o.nextExecutionTime) {
				return (int) (nextExecutionTime - o.nextExecutionTime);
			} else if (o instanceof CycleTimeEventTask && !(this instanceof CycleTimeEventTask)) {
				return -1;
			} else if (!(o instanceof CycleTimeEventTask) && this instanceof CycleTimeEventTask) {
				return 1;
			} else if (period != o.period) {				
				return (int) (period - o.period);
			}
			return (int) (scheduleOrder - o.scheduleOrder);
		}

		public boolean isCanceled() {
			return isCanceled;
		}

		public void cancel() {
			isCanceled = true;
		}
	}

	public static class VirtualTimeEventTask extends VirtualTimeTask {

		private final int eventID;
		private ITimerCallback callback;

		public VirtualTimeEventTask(ITimerCallback callback, int eventID) {
			this.callback = callback;
			this.eventID = eventID;
		}

		public int getEventId() {
			return eventID;
		}

		public void run() {
			callback.timeElapsed(eventID);
		}

	}
	
	public static class CycleTimeEventTask extends VirtualTimeTask {

		private IStatemachine statemachine;

		public CycleTimeEventTask(IStatemachine statemachine) {
			this.statemachine = statemachine;
		}

		public void run() {
			statemachine.runCycle();
		}

	}

	public VirtualTimer() {
		tasks = new PriorityQueue<VirtualTimeTask>();
	}
	
	public VirtualTimer(long cyclePeriod) {
		tasks = new PriorityQueue<VirtualTimeTask>();
		this.cyclePeriod = cyclePeriod;
	}

	public void timeLeap(long ms) {
		stopTime = currentTime + ms;
		processTasks();
	}
	
	public void cycleLeap(long cycles){
		for(int i = 1; i<=cycles; i++){
			timeLeap(cyclePeriod);
		}
	}

	@Override
	public void setTimer(ITimerCallback callback, int eventID, long duration, boolean isPeriodical) {
		if (duration <= 0)
			duration = 1;
		VirtualTimeEventTask timeEventTask = new VirtualTimeEventTask(callback, eventID);
		if (isPeriodical) {
			schedulePeriodicalTask(timeEventTask, duration, duration);
		} else {
			scheduleTask(timeEventTask, duration);
		}
	}

	@Override
	public void unsetTimer(ITimerCallback callback, int eventID) {
		VirtualTimeTask timerTask = getTask(eventID);
		if (timerTask != null)
			timerTask.cancel();
	}

	public void scheduleTask(VirtualTimeTask task, long interval) {
		task.interval = interval;
		scheduleInternal(task, currentTime + interval, -1);
	}

	public void schedulePeriodicalTask(VirtualTimeTask task, long interval, long period) {
		scheduleInternal(task, currentTime + interval, period);
	}

	private void scheduleInternal(VirtualTimeTask task, long time, long period) {
		task.nextExecutionTime = time;
		task.period = period;
		task.scheduleOrder = scheduleCount;
		scheduleCount++;
		tasks.add(task);
	}

	protected VirtualTimeTask getTask(int eventName) {
		for (VirtualTimeTask virtualTimeTask : tasks) {
			if (!(virtualTimeTask instanceof VirtualTimeEventTask))
				continue;
			if (((VirtualTimeEventTask) virtualTimeTask).getEventId() == eventName)
				return virtualTimeTask;
		}
		return null;
	}

	protected void processTasks() {
		boolean processTasks = !tasks.isEmpty();
		while (processTasks) {
			VirtualTimeTask task = tasks.peek();
			if (task == null)
				break;
			if (task.isCanceled) {
				tasks.remove();
				continue;
			}

			if (task.nextExecutionTime <= stopTime) {
				currentTime = task.nextExecutionTime;
				task = tasks.poll();
				task.run();
				if (task.period > -1) {
					schedulePeriodicalTask(task, task.period, task.period);
				}
			} else {
				currentTime = stopTime;
				processTasks = false;
			}
		}
	}

	public synchronized void stop() {
		for (VirtualTimeTask timerTask : tasks) {
			timerTask.cancel();
		}
		cancel();
	}

	public void cancel() {
		synchronized (tasks) {
			tasks.clear();
		}
	}

}
