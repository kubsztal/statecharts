/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.eventdriven;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.sct.IStatemachine;
import org.yakindu.sct.ITimerCallback;

public interface IEventDrivenTriggeredByTimeEventStatemachine extends ITimerCallback,IStatemachine {
	
	public interface Interface {
	
		public long getX();
		
		public void setX(long value);
		
		public long getTransition_count();
		
		public void setTransition_count(long value);
		
	}
	
	public Interface getInterface();
	
}
