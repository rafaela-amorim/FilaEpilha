package pilha;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

public interface Stack<T> {
	
	public void push(T element) throws StackOverflowException;
	public T pop() throws StackUnderflowException;
	public T top();
	public boolean isEmpty();
	public boolean isFull();
	
}
