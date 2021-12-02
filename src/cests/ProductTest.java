package cests;
/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

import clases.*;

public class ProductTest {

	@Test
	public void testProduct() {
		assertNotNull(new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductUPCNulo() {
		assertNotNull(new Product(null, "Bruce Springsteen", Instant.now(), 0.00));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductNombreNulo() {
		assertNotNull(new Product("111111111117", null, Instant.now(), 0.00));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductFechaNulo() {
		assertNotNull(new Product("111111111117", "Bruce Springsteen", null, 0.00));
	}

	@Test
	public void testGetPrecio() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		assertEquals(0.00, p.getPrecio(), 0);
	}

	@Test
	public void testSetPrecioValido() {
		Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);
		p.setPrecio(3.80);
		assertEquals(3.80, p.getPrecio(), 0);
		p.setPrecio(0.00);
		assertEquals(0.00, p.getPrecio(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPrecioNegativo() {
		Product p = new Product("111111111117", "Bruce Springteen", Instant.now(), 0.00);
		p.setPrecio(-1.50);
	}

	@Test
	public void testValidarUPC() {
		Product p = new Product("111111111117", "Bruce Springteen", Instant.now(), 0.00);
		assertNotNull(p);
		assertTrue(p.validarUPC(p.UPC));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCNegativo() {
		new Product("-11111111117", "Bruce Springteen", Instant.now(), 0.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCCorto() {
		new Product("11111111117", "Bruce Springteen", Instant.now(), 0.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarUPCInvalido() {
		new Product("111111111107", "Bruce Springteen", Instant.now(), 0.00);
	}
}
