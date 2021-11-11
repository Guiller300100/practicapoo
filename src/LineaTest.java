/**
 * @author guirodr
 * @author josbarb
 **/

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

public class LineaTest {

	@Test
	public void testLinea() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNegativa() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertNotNull(p);
		Linea l = new Linea(p, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNula() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertNotNull(p);
		Linea l = new Linea(p, 0);
	}

	@Test
	public void testRellenar() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
		l.rellenar(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarProductoNulo() {
		Linea l = new Linea(new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00), 10);
		assertNotNull(l);
		l.rellenar(null);
	}

	@Test
	public void testProductoComprado() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertNotNull(p);
		Linea l = new Linea(p, 10);
		assertNotNull(l);
		l.productoComprado();
	}

}
