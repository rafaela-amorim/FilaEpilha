package pilha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

public class PilhaTest {
	
	Pilha pilha;
	
	@Before
	public void inicializa() {
		pilha = new Pilha(5);
	}
	
	@Test
	public void testPush() throws StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		pilha.push(2);
		pilha.push(5);
	}
	
	@Test(expected=StackOverflowException.class)
	public void testPushComException() throws StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		pilha.push(2);
		pilha.push(5);
		// esse aqui tem q lançar exceção
		pilha.push(6);
	}

	@Test
	public void testPop() throws StackUnderflowException, StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		assertEquals(4, pilha.pop());
	}
	
	@Test(expected=StackUnderflowException.class)
	public void testPopComExcecao() throws StackUnderflowException, StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		
		pilha.pop();
		pilha.pop();
		pilha.pop();
		// esse deve lançar exceção:
		pilha.pop();
	}
	
	@Test
	public void testTop() throws StackOverflowException {
		pilha.push(4);
		pilha.push(1);
		pilha.push(3);
		assertEquals(3, pilha.top());
	}
	
	@Test
	public void testTopPilhaVazia() throws StackOverflowException, StackUnderflowException {
		pilha.push(4);
		pilha.push(1);
		pilha.pop();
		pilha.pop();
		assertNull(pilha.top());
	}

	@Test
	public void testIsEmpty() throws StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		assertFalse(pilha.isEmpty());
	}
	
	@Test
	public void testIsEmptyVazia() throws StackOverflowException, StackUnderflowException {
		pilha.push(1);
		pilha.pop();
		assertTrue(pilha.isEmpty());
	}
	
	@Test
	public void testIsFull() throws StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		pilha.push(4);
		pilha.push(1);
		assertTrue(pilha.isFull());
	}
	
	@Test
	public void testIsFullNao() throws StackOverflowException {
		pilha.push(1);
		pilha.push(3);
		pilha.push(4);
		assertFalse(pilha.isFull());
	}

}
