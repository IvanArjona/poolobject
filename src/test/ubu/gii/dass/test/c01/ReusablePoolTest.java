/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Arjona Iván
 * @author Monje Marta
 *
 */
public class ReusablePoolTest {
	
	private ReusablePool pool;
	
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pool = null;
	}

	/**
	 * Comprueba la obtención de la instancia.
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool pool = ReusablePool.getInstance();
		// No es nulo
		assertNotNull(pool);
		// El objeto devuelto es una instancia de ReusablePool
		assertTrue(pool instanceof ReusablePool);
	}

	/**
	 * Comprueba AcquireReusable
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
	@Test(expected = NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
		Reusable r1 = pool.acquireReusable();
		Reusable r2 = pool.acquireReusable();
		
		//comprueba que se devuelve una instancia de Reusable
		assertTrue(r1 instanceof Reusable);
		assertTrue(r2 instanceof Reusable);
		
		pool.acquireReusable();
	}

	
	/**
	 * Comprueba la liberación de un objeto Reusable
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws NotFreeInstanceException 
	 */
	@Test(expected = DuplicatedInstanceException.class)
	public void testReleaseReusable() throws DuplicatedInstanceException, NotFreeInstanceException {
		Reusable r = pool.acquireReusable();
		pool.releaseReusable(r);
		// Lanza excepción DuplicatedInstanceException
		pool.releaseReusable(r);
	}
	
	/**
	 * Comprueba que la cadena que devuelve el método acaba de forma correcta
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#Reusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws NotFreeInstanceException 
	 */
	@Test
	public void testReusable() throws NotFreeInstanceException {
		Reusable r = pool.acquireReusable();
		String rs = r.util();
		//Comprobamos que el final de la cadena devuela es esta
		assertTrue(rs.endsWith("Uso del objeto Reutilizable"));
	}
}
