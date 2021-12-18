package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class LineaTest {

	private Product p = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
	private Linea l;
	
	@Before
	public void inicializar() {
		assertNotNull(p);
		l = new Linea(p, 10);
		assertNotNull(l);
	}

	@Test
	public void testLinea() {
		assertEquals(p, l.getVendible());
		assertEquals(10, l.getmaxStock());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNegativa() {
		new Linea(p, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLineaProfundidadNula() {
		new Linea(p, 0);
	}

	@Test
	public void testRellenar() {
		l.rellenar(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarProductoNulo() {
		l.rellenar(null);
	}

	@Test
	public void testProductoComprado() {
		l.vendibleComprado();
	}

	@Test
	public void testGetStock() {
		Linea l = new Linea(p, 10);
		l.rellenar(p);
		assertEquals(10, l.getStock());
	}
	
	@Test
	public void testGetVendible() {
		Linea l = new Linea(p, 10);
		l.rellenar(p);
		assertEquals(10, l.getStock());
	}

}
