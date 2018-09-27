package pilha;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

public class Pilha<T> implements Stack {

	T[] pilha;
	int top;

	/**
	 * Inicializa o array de generics que representa a pilha, e o ponteiro top é
	 * iniciado "fora" do array.
	 * 
	 * @param tamanho O usuário passa o tamanho máximo que a pilha deve ter.
	 */
	public Pilha(int tamanho) {
		pilha = (T[]) new Object[tamanho];
		top = -1;
	}
	
	@Override
	public void push(Object element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		pilha[++top] = (T) element;
	}

	@Override
	public Object pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		return pilha[top--];
	}

	@Override
	public Object top() {
		T saida = null;
		if (top > -1) 	saida = pilha[top];
		return saida;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == pilha.length - 1;
	}

}
