package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {

	private String nombre = "Bruce Springsteen";
	private VendingMachine m;
	private static String credencial = "A156Bv09_1zXo894";
	private TarjetaMonedero t = new TarjetaMonedero(credencial);

	@Before
	public void inicializar() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
	}

	@Test
	public void testVendingMachine() {
		assertEquals(0, m.getId());
		assertEquals(1, m.numLineas());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingMachineIdNegativo() {
		new VendingMachine(-1, 5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingMachineNumLineasNegativo() {
		new VendingMachine(1, -5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingMachineProfundidadNegativo() {
		new VendingMachine(1, 5, -10);
	}

	@Test
	public void testSetEstado() {
		m.setEstado(false);
		assertFalse(m.getEstado());
	}

	@Test
	public void testGetEstado() {
		assertTrue(m.getEstado());
	}

	@Test
	public void testNumLineas() {
		assertEquals(1, m.numLineas());
	}

	@Test
	public void testGetLinea() {
		assertEquals(0, m.getLinea(0).getStock());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineaNegativa() {
		m.getLinea(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineaFueraDeRango() {
		m.getLinea(20);
	}

	@Test
	public void testComprobarLineas() {
		assertTrue(m.comprobarLineas());
		m.rellenarLinea(new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00), 0);
		assertFalse(m.comprobarLineas());
	}

	@Test
	public void testRellenarLinea() {
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarLineaNegativo() {
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarLineaFueraDelRango() {
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarProductoNulo() {
		m.rellenarLinea(null, 1);
	}

	@Test
	public void testCompra() {
		t.recargaSaldo(credencial, 1);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 1), 0);
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraLineaVacia() {
		t.recargaSaldo(credencial, 1);
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraMaquinaNoOperativa() {
		t.recargaSaldo(credencial, 1);
		m.setEstado(false);
		assertFalse(m.getEstado());
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraLineaNegativa() {
		t.recargaSaldo("credencial", 1);
		m.compra(t, -1, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraDineroInsuficiente() {
		t.recargaSaldo(credencial, 1);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 3), 0);
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraSinDinero() {
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraTarjetaNula() {
		m.compra(null, 0, "6Z1y00Nm31aA-571");
	}

	@Test
	public void testComprobarLinea() {
		assertTrue(m.comprobarLinea(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testComprobarLineaNegativa() {
		m.comprobarLinea(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testComprobarLineaFueraDeRango() {
		m.comprobarLinea(20);
	}

	@Test
	public void testgetId() {
		assertEquals(0, m.getId());
	}
}
