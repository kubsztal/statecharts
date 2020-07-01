/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.declarations;

import org.yakindu.sct.rx.Observable;

public class DeclarationsStatemachine implements IDeclarationsStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean evA;
		
		
		public void raiseEvA() {
			evA = true;
		}
		
		private boolean evB;
		
		
		protected void raiseEvB() {
			evB = true;
			evBObservable.next(null);
		}
		
		private Observable<Void> evBObservable = new Observable<Void>();
		
		public Observable<Void> getEvB() {
			return evBObservable;
		}
		
		private boolean evC;
		
		private boolean evCValue;
		
		
		public void raiseEvC(boolean value) {
			evCValue = value;
			evC = true;
		}
		protected boolean getEvCValue() {
			if (! evC ) 
				throw new IllegalStateException("Illegal event value access. Event EvC is not raised!");
			return evCValue;
		}
		
		private boolean evD;
		
		private long evDValue;
		
		
		protected void raiseEvD(long value) {
			evDValue = value;
			evD = true;
			evDObservable.next(value);
		}
		
		private Observable<Long> evDObservable = new Observable<Long>();
		
		public Observable<Long> getEvD() {
			return evDObservable;
		}
		
		private boolean evE;
		
		private double evEValue;
		
		
		public void raiseEvE(double value) {
			evEValue = value;
			evE = true;
		}
		protected double getEvEValue() {
			if (! evE ) 
				throw new IllegalStateException("Illegal event value access. Event EvE is not raised!");
			return evEValue;
		}
		
		private boolean evF;
		
		private String evFValue;
		
		
		protected void raiseEvF(String value) {
			evFValue = value;
			evF = true;
			evFObservable.next(value);
		}
		
		private Observable<String> evFObservable = new Observable<String>();
		
		public Observable<String> getEvF() {
			return evFObservable;
		}
		
		private boolean varA;
		
		public boolean getVarA() {
			return varA;
		}
		
		public void setVarA(boolean value) {
			this.varA = value;
		}
		
		private long varB;
		
		public long getVarB() {
			return varB;
		}
		
		public void setVarB(long value) {
			this.varB = value;
		}
		
		private double varC;
		
		public double getVarC() {
			return varC;
		}
		
		public void setVarC(double value) {
			this.varC = value;
		}
		
		private String varD;
		
		public String getVarD() {
			return varD;
		}
		
		public void setVarD(String value) {
			this.varD = value;
		}
		
		private long varE;
		
		public long getVarE() {
			return varE;
		}
		
		public void setVarE(long value) {
			this.varE = value;
		}
		
	}
	
	protected class SCIIfAImpl implements SCIIfA {
	
		private boolean evA;
		
		
		public void raiseEvA() {
			evA = true;
		}
		
		private boolean evB;
		
		
		protected void raiseEvB() {
			evB = true;
			evBObservable.next(null);
		}
		
		private Observable<Void> evBObservable = new Observable<Void>();
		
		public Observable<Void> getEvB() {
			return evBObservable;
		}
		
		private boolean evC;
		
		private boolean evCValue;
		
		
		public void raiseEvC(boolean value) {
			evCValue = value;
			evC = true;
		}
		protected boolean getEvCValue() {
			if (! evC ) 
				throw new IllegalStateException("Illegal event value access. Event EvC is not raised!");
			return evCValue;
		}
		
		private boolean evD;
		
		private long evDValue;
		
		
		protected void raiseEvD(long value) {
			evDValue = value;
			evD = true;
			evDObservable.next(value);
		}
		
		private Observable<Long> evDObservable = new Observable<Long>();
		
		public Observable<Long> getEvD() {
			return evDObservable;
		}
		
		private boolean evE;
		
		private double evEValue;
		
		
		public void raiseEvE(double value) {
			evEValue = value;
			evE = true;
		}
		protected double getEvEValue() {
			if (! evE ) 
				throw new IllegalStateException("Illegal event value access. Event EvE is not raised!");
			return evEValue;
		}
		
		private boolean evF;
		
		private String evFValue;
		
		
		protected void raiseEvF(String value) {
			evFValue = value;
			evF = true;
			evFObservable.next(value);
		}
		
		private Observable<String> evFObservable = new Observable<String>();
		
		public Observable<String> getEvF() {
			return evFObservable;
		}
		
		private boolean varA;
		
		public boolean getVarA() {
			return varA;
		}
		
		public void setVarA(boolean value) {
			this.varA = value;
		}
		
		private long varB;
		
		public long getVarB() {
			return varB;
		}
		
		public void setVarB(long value) {
			this.varB = value;
		}
		
		private double varC;
		
		public double getVarC() {
			return varC;
		}
		
		public void setVarC(double value) {
			this.varC = value;
		}
		
		private String varD;
		
		public String getVarD() {
			return varD;
		}
		
		public void setVarD(String value) {
			this.varD = value;
		}
		
		private long varE;
		
		public long getVarE() {
			return varE;
		}
		
		public void setVarE(long value) {
			this.varE = value;
		}
		
	}
	
	private static class SCInterfaceEvBuf {
		private boolean evA;
		private boolean evC;
		
		private boolean evCValue;
		private boolean evE;
		
		private double evEValue;
	}
	private static class SCIIfAEvBuf {
		private boolean evA;
		private boolean evC;
		
		private boolean evCValue;
		private boolean evE;
		
		private double evEValue;
	}
	private static class DeclarationsStatemachineInternalEvBuf {
		private boolean evInA;
		private boolean evInB;
		private boolean evInC;
		
		private boolean evInCValue;
		private boolean evInD;
		
		private long evInDValue;
		private boolean evInE;
		
		private double evInEValue;
		private boolean evInF;
		
		private String evInFValue;
	}
	private static class DeclarationsStatemachineEvBuf {
		private SCInterfaceEvBuf iface = new SCInterfaceEvBuf();
		private SCIIfAEvBuf ifaceIfA = new SCIIfAEvBuf();
		private DeclarationsStatemachineInternalEvBuf internal = new DeclarationsStatemachineInternalEvBuf();
	}
	protected SCInterfaceImpl sCInterface;
	
	protected SCIIfAImpl sCIIfA;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_A,
		main_region_B,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private boolean evInA;
	private boolean evInB;
	private boolean evInC;
	
	private boolean evInCValue;
	private boolean evInD;
	
	private long evInDValue;
	private boolean evInE;
	
	private double evInEValue;
	private boolean evInF;
	
	private String evInFValue;
	private boolean varInA;
	
	protected boolean getVarInA() {
		return varInA;
	}
	
	protected void setVarInA(boolean value) {
		this.varInA = value;
	}
	
	
	private long varInB;
	
	protected long getVarInB() {
		return varInB;
	}
	
	protected void setVarInB(long value) {
		this.varInB = value;
	}
	
	
	private double varInC;
	
	protected double getVarInC() {
		return varInC;
	}
	
	protected void setVarInC(double value) {
		this.varInC = value;
	}
	
	
	private String varInD;
	
	protected String getVarInD() {
		return varInD;
	}
	
	protected void setVarInD(String value) {
		this.varInD = value;
	}
	
	
	private long varInE;
	
	protected long getVarInE() {
		return varInE;
	}
	
	protected void setVarInE(long value) {
		this.varInE = value;
	}
	
	
	private DeclarationsStatemachineEvBuf _current = new DeclarationsStatemachineEvBuf();
	
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public DeclarationsStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIIfA = new SCIIfAImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		
		clearInEvents();
		clearInternalEvents();
		
		sCInterface.setVarA(false);
		
		sCInterface.setVarB(1);
		
		sCInterface.setVarC(1.0);
		
		sCInterface.setVarD("myString");
		
		sCInterface.setVarE(0x10);
		
		sCIIfA.setVarA(false);
		
		sCIIfA.setVarB(1);
		
		sCIIfA.setVarC(1.0);
		
		sCIIfA.setVarD("myString");
		
		sCIIfA.setVarE(0x10);
		
		setVarInA(false);
		
		setVarInB(1);
		
		setVarInC(1.0);
		
		setVarInD("myString");
		
		setVarInE(0x10);
		
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
		swapInEvents();
		do { 
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				case main_region_A:
					main_region_A_react(true);
					break;
				case main_region_B:
					main_region_B_react(true);
					break;
				default:
					// $NullState$
				}
			}
			
			swapInternalEvents();
		} while ((((((_current.internal.evInA || _current.internal.evInB) || _current.internal.evInC) || _current.internal.evInD) || _current.internal.evInE) || _current.internal.evInF));
		
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void swapInEvents() {
		_current.iface.evA = sCInterface.evA;
		sCInterface.evA = false;
		
		_current.iface.evC = sCInterface.evC;
		_current.iface.evCValue = sCInterface.evCValue;
		sCInterface.evC = false;
		
		_current.iface.evE = sCInterface.evE;
		_current.iface.evEValue = sCInterface.evEValue;
		sCInterface.evE = false;
		
		_current.ifaceIfA.evA = sCIIfA.evA;
		sCIIfA.evA = false;
		
		_current.ifaceIfA.evC = sCIIfA.evC;
		_current.ifaceIfA.evCValue = sCIIfA.evCValue;
		sCIIfA.evC = false;
		
		_current.ifaceIfA.evE = sCIIfA.evE;
		_current.ifaceIfA.evEValue = sCIIfA.evEValue;
		sCIIfA.evE = false;
	}
	
	private void clearInEvents() {
		sCInterface.evA = false;
		sCInterface.evC = false;
		sCInterface.evE = false;
		sCIIfA.evA = false;
		sCIIfA.evC = false;
		sCIIfA.evE = false;
	}
	
	private void swapInternalEvents() {
		_current.iface.evA = false;
		_current.iface.evC = false;
		_current.iface.evE = false;
		_current.ifaceIfA.evA = false;
		_current.ifaceIfA.evC = false;
		_current.ifaceIfA.evE = false;
		_current.internal.evInA = evInA;
		evInA = false;
		
		_current.internal.evInB = evInB;
		evInB = false;
		
		_current.internal.evInC = evInC;
		_current.internal.evInCValue = evInCValue;
		evInC = false;
		
		_current.internal.evInD = evInD;
		_current.internal.evInDValue = evInDValue;
		evInD = false;
		
		_current.internal.evInE = evInE;
		_current.internal.evInEValue = evInEValue;
		evInE = false;
		
		_current.internal.evInF = evInF;
		_current.internal.evInFValue = evInFValue;
		evInF = false;
	}
	
	private void clearInternalEvents() {
		evInA = false;
		evInB = false;
		evInC = false;
		evInD = false;
		evInE = false;
		evInF = false;
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_A:
			return stateVector[0] == State.main_region_A;
		case main_region_B:
			return stateVector[0] == State.main_region_B;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCIIfA getSCIIfA() {
		return sCIIfA;
	}
	
	private void raiseEvInA() {
		evInA = true;
	}
	
	private void raiseEvInB() {
		evInB = true;
	}
	
	private void raiseEvInC(boolean value) {
		evInCValue = value;
		evInC = true;
	}
	private boolean getEvInCValue() {
		if (! evInC ) 
			throw new IllegalStateException("Illegal event value access. Event EvInC is not raised!");
		return evInCValue;
	}
	
	private void raiseEvInD(long value) {
		evInDValue = value;
		evInD = true;
	}
	private long getEvInDValue() {
		if (! evInD ) 
			throw new IllegalStateException("Illegal event value access. Event EvInD is not raised!");
		return evInDValue;
	}
	
	private void raiseEvInE(double value) {
		evInEValue = value;
		evInE = true;
	}
	private double getEvInEValue() {
		if (! evInE ) 
			throw new IllegalStateException("Illegal event value access. Event EvInE is not raised!");
		return evInEValue;
	}
	
	private void raiseEvInF(String value) {
		evInFValue = value;
		evInF = true;
	}
	private String getEvInFValue() {
		if (! evInF ) 
			throw new IllegalStateException("Illegal event value access. Event EvInF is not raised!");
		return evInFValue;
	}
	
	public void raiseEvA() {
		sCInterface.raiseEvA();
	}
	
	public Observable<Void> getEvB() {
		return sCInterface.getEvB();
	}
	
	public void raiseEvC(boolean value) {
		sCInterface.raiseEvC(value);
	}
	
	public Observable<Long> getEvD() {
		return sCInterface.getEvD();
	}
	
	public void raiseEvE(double value) {
		sCInterface.raiseEvE(value);
	}
	
	public Observable<String> getEvF() {
		return sCInterface.getEvF();
	}
	
	public boolean getVarA() {
		return sCInterface.getVarA();
	}
	
	public void setVarA(boolean value) {
		sCInterface.setVarA(value);
	}
	
	public long getVarB() {
		return sCInterface.getVarB();
	}
	
	public void setVarB(long value) {
		sCInterface.setVarB(value);
	}
	
	public double getVarC() {
		return sCInterface.getVarC();
	}
	
	public void setVarC(double value) {
		sCInterface.setVarC(value);
	}
	
	public String getVarD() {
		return sCInterface.getVarD();
	}
	
	public void setVarD(String value) {
		sCInterface.setVarD(value);
	}
	
	public long getVarE() {
		return sCInterface.getVarE();
	}
	
	public void setVarE(long value) {
		sCInterface.setVarE(value);
	}
	
	/* Entry action for state 'A'. */
	private void entryAction_main_region_A() {
		setVarInA(false);
		
		setVarInB(1);
		
		setVarInC(1.1);
		
		setVarInD("blub");
		
		setVarInE(1);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		entryAction_main_region_A();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_A:
			exitSequence_main_region_A();
			break;
		case main_region_B:
			exitSequence_main_region_B();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (_current.internal.evInA) {
					exitSequence_main_region_A();
					enterSequence_main_region_B_default();
				} else {
					if (_current.internal.evInC) {
						exitSequence_main_region_A();
						enterSequence_main_region_A_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (_current.internal.evInB) {
					exitSequence_main_region_B();
					enterSequence_main_region_A_default();
				} else {
					if (_current.internal.evInD) {
						exitSequence_main_region_B();
						enterSequence_main_region_B_default();
					} else {
						if (_current.internal.evInE) {
							exitSequence_main_region_B();
							enterSequence_main_region_B_default();
						} else {
							if (_current.internal.evInF) {
								exitSequence_main_region_B();
								enterSequence_main_region_A_default();
							} else {
								did_transition = false;
							}
						}
					}
				}
			}
		}
		return did_transition;
	}
	
}
