package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class VendibleTest {

	private Vendible v;

	@Before
	public void inicializar() {
		v = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
		assertNotNull(v);
	}

	@Test
	public void testVendible() {
		assertEquals("111111111117", v.getId());
		assertEquals("Bruce Springsteen", v.getNombre());
		assertEquals(0.0, v.getPrecio(), 0);
	}	
	
	@Test
	public void testGetNombre() {
		assertEquals("Bruce Springsteen", v.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		v.setNombre("Julio Iglesias");
		assertEquals("Julio Iglesias", v.getNombre());
	}
	
}
