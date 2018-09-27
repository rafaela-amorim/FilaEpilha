package fila;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

public class Fila<T> implements Queue{
	
	T[] fila;
	int head;
	int tail;
	
	public Fila(int tamanho) {
		fila = (T[]) new Object[tamanho];
		head = -1;
		tail = -1;
	}
	
	@Override
	public void enqueue(Object element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		if (isEmpty()) 
			head = 0;
		tail = (tail + 1) % fila.length;	// incrementa em módulo
		fila[tail] = (T) element;
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		
		T saida = fila[head];
		if (head == tail) {
			head = -1;
			tail = -1;
		} else 
			head = (head + 1) % fila.length;	// incrementa em módulo
		return saida;
	}

	@Override
	public Object head() {
		T saida = null;
		if (!isEmpty())
			saida = fila[head];
		return (Object) saida;
	}

	@Override
	public boolean isEmpty() {
		return head == -1 && tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((tail + 1) % fila.length) == head;
	}
	
}
