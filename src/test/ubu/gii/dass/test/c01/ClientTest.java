package ubu.gii.dass.test.c01;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import ubu.gii.dass.c01.Client;
import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;

/**
 * Prueba todos los caminos del Cliente.
 * 
 * @author Iván Arjona Alonso, Marta Monje Blanco
 */
public class ClientTest {
	
	/**
	 * Prueba el main del cliente.
	 * Test method for {@link ubu.gii.dass.c01.Client#main(String[])}.
	 * 
	 * @throws DuplicatedInstanceException 
	 * @throws NotFreeInstanceException 
	 */
	@Test
	public void testMain() {
		// Solo hay un camino, por lo que solo hay que ejecutarlo una vez.
		try {
			String[] args = null;
			Client.main(args);
		} catch(Exception e) {
			// Falla si salta alguna excepción sin controlar.
			fail();
		}
	}
	
	/**
	 * Instance un cliente.
	 * Test method for {@link ubu.gii.dass.c01.Client}.
	 * 
	 * @throws DuplicatedInstanceException 
	 * @throws NotFreeInstanceException 
	 */
	@Test
	public void instancia() {
		Client client = new Client();
		assertTrue(client instanceof Client);
	}
}
