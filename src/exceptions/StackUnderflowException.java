package exceptions;

public class StackUnderflowException extends Exception {
	
	public StackUnderflowException() {
		super("Stack is empty");
	}
}
