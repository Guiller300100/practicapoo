package es.uva.poo.practica;
/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;


public class ProductTest {

	private String nombre = "Bruce Springteen";
	private String upc="111111111117";
	private Product p = new Product(upc, nombre, new GregorianCalendar(2021, 1, 30), 0.00);
	
	
	@Test
	public void testProduct() {
		assertNotNull(p);
		assertEquals(nombre, p.getNombre());
		assertEquals(upc, p.getUpc());
		assertEquals(0.0, p.getPrecio(), 0);
		assertEquals(new GregorianCalendar(2021, 1, 30), p.getFecha());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductUPCNulo() {
		assertNotNull(new Product(null, nombre, new GregorianCalendar(2021, 1, 30), 0.00));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductNombreNulo() {
		assertNotNull(new Product(upc, null, new GregorianCalendar(2021, 1, 30), 0.00));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductFechaNulo() {
		assertNotNull(new Product(upc, nombre, null, 0.00));
	}

	@Test
	public void testGetPrecio() {
		assertEquals(0.00, p.getPrecio(), 0);
	}

	@Test
	public void testSetPrecioValido() {
		p.setPrecio(3.80);
		assertEquals(3.80, p.getPrecio(), 0);
		p.setPrecio(0.00);
		assertEquals(0.00, p.getPrecio(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPrecioNegativo() {
		p.setPrecio(-1.50);
	}

	@Test
	public void testGetUPC() {
		assertEquals(upc, p.getUpc());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCNegativo() {
		new Product("-11111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCCorto() {
		new Product("11111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCInvalido() {
		new Product("111111111107", nombre, new GregorianCalendar(2021, 1, 30), 0.00);
	}
	
	@Test
	public void testgetFecha() {
		assertEquals(new GregorianCalendar(2021, 1, 30), p.getFecha());
	}
	
	@Test
	public void testsetFecha() {
		p.setFecha(new GregorianCalendar(2021, 1, 30));
		assertEquals(new GregorianCalendar(2021, 1, 30), p.getFecha());
	}
	
	@Test
	public void testgetNombre() {
		assertEquals(nombre, p.getNombre());
	}
	
	@Test
	public void testsetNombre() {
		p.setNombre(nombre);
		assertEquals(nombre, p.getNombre());
	}
}
