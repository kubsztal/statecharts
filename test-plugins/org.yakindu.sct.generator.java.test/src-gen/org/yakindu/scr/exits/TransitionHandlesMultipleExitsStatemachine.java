/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.exits;

import java.util.LinkedList;
import java.util.Queue;

public class TransitionHandlesMultipleExitsStatemachine implements ITransitionHandlesMultipleExitsStatemachine {
	protected class InterfaceImpl implements Interface {
	
		private boolean e;
		
		
		public void raiseE() {
			inEventQueue.add(new Runnable() {
				@Override
				public void run() {
					e = true;
				}
			});
			runCycle();
		}
		
		private boolean f;
		
		
		public void raiseF() {
			inEventQueue.add(new Runnable() {
				@Override
				public void run() {
					f = true;
				}
			});
			runCycle();
		}
		
		private boolean g;
		
		
		public void raiseG() {
			inEventQueue.add(new Runnable() {
				@Override
				public void run() {
					g = true;
				}
			});
			runCycle();
		}
		
		private long x;
		
		public long getX() {
			return x;
		}
		
		public void setX(long value) {
			this.x = value;
		}
		
	}
	
	protected InterfaceImpl defaultInterface;
	
	private boolean initialized = false;
	
	public enum State {
		MAIN_REGION_A,
		MAIN_REGION_A_R_AA,
		MAIN_REGION_B,
		MAIN_REGION_B_R_BB,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private Queue<Runnable> inEventQueue = new LinkedList<Runnable>();
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public TransitionHandlesMultipleExitsStatemachine() {
		defaultInterface = new InterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		
		defaultInterface.setX(0);
		
		isExecuting = false;
	}
	
	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		enterSequence_main_region_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		exitSequence_main_region();
		isExecuting = false;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		nextEvent();
		do { 
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				case MAIN_REGION_A_R_AA:
					main_region_A_r_AA_react(true);
					break;
				case MAIN_REGION_B_R_BB:
					main_region_B_r_BB_react(true);
					break;
				default:
					// $NULLSTATE$
				}
			}
			
			clearInEvents();
			nextEvent();
		} while (((defaultInterface.e || defaultInterface.f) || defaultInterface.g));
		
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void clearInEvents() {
		defaultInterface.e = false;
		defaultInterface.f = false;
		defaultInterface.g = false;
	}
	
	protected void nextEvent() {
		if(!inEventQueue.isEmpty()) {
			inEventQueue.poll().run();
			return;
		}
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case MAIN_REGION_A:
			return stateVector[0].ordinal() >= State.
					MAIN_REGION_A.ordinal()&& stateVector[0].ordinal() <= State.MAIN_REGION_A_R_AA.ordinal();
		case MAIN_REGION_A_R_AA:
			return stateVector[0] == State.MAIN_REGION_A_R_AA;
		case MAIN_REGION_B:
			return stateVector[0].ordinal() >= State.
					MAIN_REGION_B.ordinal()&& stateVector[0].ordinal() <= State.MAIN_REGION_B_R_BB.ordinal();
		case MAIN_REGION_B_R_BB:
			return stateVector[0] == State.MAIN_REGION_B_R_BB;
		default:
			return false;
		}
	}
	
	public Interface getInterface() {
		return defaultInterface;
	}
	
	public void raiseE() {
		defaultInterface.raiseE();
	}
	
	public void raiseF() {
		defaultInterface.raiseF();
	}
	
	public void raiseG() {
		defaultInterface.raiseG();
	}
	
	public long getX() {
		return defaultInterface.getX();
	}
	
	public void setX(long value) {
		defaultInterface.setX(value);
	}
	
	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();
		enterSequence_main_region_B_default();
		react();
	}
	
	private void effect_main_region_B_tr0() {
		exitSequence_main_region_B();
		enterSequence_main_region_A_default();
		react();
	}
	
	private void effect_main_region_B_tr1() {
		exitSequence_main_region_B();
		defaultInterface.setX(defaultInterface.getX() * 2);
		
		enterSequence_main_region_A_default();
		react();
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		enterSequence_main_region_A_r_default();
	}
	
	/* 'default' enter sequence for state AA */
	private void enterSequence_main_region_A_r_AA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.MAIN_REGION_A_R_AA;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		enterSequence_main_region_B_r_default();
	}
	
	/* 'default' enter sequence for state BB */
	private void enterSequence_main_region_B_r_BB_default() {
		nextStateIndex = 0;
		stateVector[0] = State.MAIN_REGION_B_R_BB;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_main_region_A_r_default() {
		react_main_region_A_r__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_main_region_B_r_default() {
		react_main_region_B_r__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		exitSequence_main_region_A_r();
	}
	
	/* Default exit sequence for state AA */
	private void exitSequence_main_region_A_r_AA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		exitSequence_main_region_B_r();
	}
	
	/* Default exit sequence for state BB */
	private void exitSequence_main_region_B_r_BB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case MAIN_REGION_A_R_AA:
			exitSequence_main_region_A_r_AA();
			break;
		case MAIN_REGION_B_R_BB:
			exitSequence_main_region_B_r_BB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_main_region_A_r() {
		switch (stateVector[0]) {
		case MAIN_REGION_A_R_AA:
			exitSequence_main_region_A_r_AA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_main_region_B_r() {
		switch (stateVector[0]) {
		case MAIN_REGION_B_R_BB:
			exitSequence_main_region_B_r_BB();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_A_r__entry_Default() {
		enterSequence_main_region_A_r_AA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_B_r__entry_Default() {
		enterSequence_main_region_B_r_BB_default();
	}
	
	/* The reactions of exit ex1. */
	private void react_main_region_A_r_ex1() {
		effect_main_region_A_tr0();
	}
	
	/* The reactions of exit ex2. */
	private void react_main_region_A_r_ex2() {
		effect_main_region_A_tr0();
	}
	
	/* The reactions of exit ex1. */
	private void react_main_region_B_r_ex1() {
		effect_main_region_B_tr0();
	}
	
	/* The reactions of exit ex2. */
	private void react_main_region_B_r_ex2() {
		effect_main_region_B_tr1();
	}
	
	/* The reactions of exit ex3. */
	private void react_main_region_B_r_ex3() {
		effect_main_region_B_tr0();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = react();
		}
		return did_transition;
	}
	
	private boolean main_region_A_r_AA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (defaultInterface.e) {
				exitSequence_main_region_A_r_AA();
				defaultInterface.setX(1);
				
				react_main_region_A_r_ex1();
			} else {
				if (defaultInterface.f) {
					exitSequence_main_region_A_r_AA();
					defaultInterface.setX(2);
					
					react_main_region_A_r_ex2();
				} else {
					did_transition = false;
				}
			}
		}
		if (did_transition==false) {
			did_transition = main_region_A_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = react();
		}
		return did_transition;
	}
	
	private boolean main_region_B_r_BB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (defaultInterface.e) {
				exitSequence_main_region_B_r_BB();
				defaultInterface.setX(11);
				
				react_main_region_B_r_ex1();
			} else {
				if (defaultInterface.f) {
					exitSequence_main_region_B_r_BB();
					defaultInterface.setX(12);
					
					react_main_region_B_r_ex2();
				} else {
					if (defaultInterface.g) {
						exitSequence_main_region_B_r_BB();
						defaultInterface.setX(10);
						
						react_main_region_B_r_ex3();
					} else {
						did_transition = false;
					}
				}
			}
		}
		if (did_transition==false) {
			did_transition = main_region_B_react(try_transition);
		}
		return did_transition;
	}
	
}
