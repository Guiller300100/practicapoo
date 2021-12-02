package tests;
import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

import clases.*;

public class LineaTest {

	Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
	
	@Test
	public void testLinea() {
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNegativa() {
		assertNotNull(p);
		new Linea(p, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNula() {
		assertNotNull(p);
		new Linea(p, 0);
	}

	@Test
	public void testRellenar() {
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
		l.rellenar(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarProductoNulo() {
		Linea l = new Linea(p, 10);
		assertNotNull(l);
		l.rellenar(null);
	}

	@Test
	public void testProductoComprado() {
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
		l.productoComprado();
	}

}
