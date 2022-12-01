package com.paracamplus.ilp3.ilp3tme7;

import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class CoroutineInstance extends Thread {
	private Invocable invocable;
	private Object[] arguments;
	private Interpreter interpreter;
	
	public CoroutineInstance(Invocable invocable,Object[] arguments,Interpreter interpreter){
		this.invocable = invocable;
		this.arguments = arguments;
		this.interpreter = interpreter;
		start();
	}
	
	
	public void run() {
		try {
			invocable.apply(interpreter, arguments);
		} catch (EvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
