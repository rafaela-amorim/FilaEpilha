package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

public class FilaTest {
	
	Fila fila;
	
	@SuppressWarnings("rawtypes")
	@Before
	public void inicializa() {
		fila = new Fila(5);
	}
	
	@Test
	public void testEnqueue() throws QueueOverflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		assertEquals(1, fila.head());
	}
	
	@Test(expected=QueueOverflowException.class)
	public void testEnqueueComExcecao() throws QueueOverflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		// esse aqui deve lançar exceção:
		fila.enqueue(6);
	}
	
	@Test
	public void testDequeue() throws QueueOverflowException, QueueUnderflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		assertEquals(1, fila.dequeue());
	}
	
	@Test(expected=QueueUnderflowException.class)
	public void testDequeueComExcecao() throws QueueOverflowException, QueueUnderflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		fila.dequeue();
		fila.dequeue();
		// esse aqui deve lançar exceção:
		fila.dequeue();
	}
	
	@Test
	public void testHead() throws QueueOverflowException{
		fila.enqueue(1);
		fila.enqueue(2);
		assertEquals(1, fila.head());
		fila.enqueue(3);
		assertEquals(1, fila.head());
	}
	
	@Test
	public void testHeadNull() throws QueueOverflowException, QueueUnderflowException{
		fila.enqueue(1);
		fila.dequeue();
		assertTrue(fila.isEmpty());
		assertNull(fila.head());
	}
	
	@Test
	public void testIsEmpty() throws QueueUnderflowException, QueueOverflowException{
		fila.enqueue(1);
		fila.enqueue(2);
		fila.dequeue();
		fila.dequeue();
		assertTrue(fila.isEmpty());
	}
	
	@Test
	public void testIsEmptyNao() throws QueueOverflowException{
		fila.enqueue(1);
		fila.enqueue(2);
		assertFalse(fila.isEmpty());
	}
	
	@Test
	public void testIsFull() throws QueueOverflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		assertTrue(fila.isFull());
	}
	
	@Test
	public void testIsFullNao() throws QueueOverflowException {
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(2);
		assertFalse(fila.isFull());
	}

}
