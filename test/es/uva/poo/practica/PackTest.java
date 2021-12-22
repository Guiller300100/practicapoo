package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class PackTest {

	private Product producto1 = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 1);
	private Product producto2 = new Product("000000000000", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 2);
	private Product[] p = { producto1, producto2 };
	private Pack paquete = new Pack("1", "chuches", p);

	@Test
	public void testPack() {

		assertEquals("1", paquete.getIdentificador());
		assertEquals("chuches", paquete.getNombre());
		assertEquals(2, paquete.numeroProductos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackIdNulo() {
		new Pack(null, "chuches", p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackNombreNulo() {
		new Pack("1", null, p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackArrayNulo() {
		new Pack("1", "chuches", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackProductoNulo() {
		Product[] p1 = { producto1, null, producto2 };
		new Pack("1", "chuches", p1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackArrayPequeño() {
		Product[] p1 = { producto1 };
		new Pack("1", "chuches", p1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackDosProductosIguales() {
		Product[] p1 = { producto1, producto1 };
		new Pack("1", "chuches", p1);
	}

	@Test
	public void testGetPrecio() {
		assertEquals(2.4, paquete.getPrecio(), 0.0000001);
	}

	@Test
	public void testnumeroProductos() {
		assertEquals(2, paquete.numeroProductos());
	}

	@Test
	public void testComprobarProducto() {
		assertTrue(paquete.comprobarProducto("000000000000"));
		assertFalse(paquete.comprobarProducto("000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testcomprobarProductoNulo() {
		paquete.comprobarProducto(null);
	}

	@Test
	public void testListaProductos() {
		assertEquals(p[0], paquete.listaProductos().get(0));
	}

	@Test
	public void testNuevoProducto() {
		paquete.nuevoProducto(new Product("222222222224", "Chetos", new GregorianCalendar(2021, 1, 30), 2));
		paquete.comprobarProducto("222222222224");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevoProductoNulo() {
		paquete.nuevoProducto(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevoProductoRepetido() {
		paquete.nuevoProducto(producto1);
	}

	@Test
	public void testEliminarProducto() {
		Product[] p1 = { producto1, new Product("222222222224", "Chetos", new GregorianCalendar(2021, 1, 30), 2),
				producto2 };
		Pack paquete1 = new Pack("1", "chuches", p1);
		paquete1.eliminarProducto("000000000000");
		assertFalse(paquete1.comprobarProducto("000000000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEliminarProductoNulo() {
		paquete.eliminarProducto("1111");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEliminarProductoMenorQueDos() {
		paquete.eliminarProducto("000000000000");
	}
	
	@Test
	public void testgetIdentificador() {
		assertEquals("1", paquete.getIdentificador());
	}

}
