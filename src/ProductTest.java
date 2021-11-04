import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testProduct() {
		
	}

	@Test
	public void testGetPrecio() {
		
	}

	@Test
	public void testSetPrecioValido() {
		Product p = new Product ("111111111117","Bruce Springsteen", Instant.now(), 0.00);
		p.setPrecio(3.80);
		assertEquals(3.80, p.getPrecio(),0);
		p.setPrecio(0.00);
		assertEquals(0.00, p.getPrecio(),0);
	}
	
	@Test
	public void testValidarUPC() {
		
	}

}
