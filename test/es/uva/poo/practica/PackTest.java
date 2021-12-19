package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class PackTest {
	
	private Product producto1 = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
	private Product producto2 = new Product("000000000000", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
	private Product producto3 = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
	Product[] p = {producto1, producto2};

	@Test
	public void testPack() {
		Pack paquete = new Pack("1", "chuches", p);
	}

}
