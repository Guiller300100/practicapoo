package es.uva.poo.practica;
/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {

	private String nombre="Bruce Springsteen";
	private VendingMachine m;
	private static String credencial="A156Bv09_1zXo894";
	private TarjetaMonedero t = new TarjetaMonedero(credencial);

	@Test
	public void testVendingMachine() {
		m = new VendingMachine(0, 3, 10);
		assertNotNull(m);
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
		m = new VendingMachine(0, 3, 10);
		assertNotNull(m);
		m.setEstado(false);
		assertFalse(m.getEstado());
	}

	@Test
	public void testGetEstado() {
		m = new VendingMachine(0, 3, 10);
		assertNotNull(m);
		assertTrue(m.getEstado());
	}

	@Test
	public void testGetLinea() {
		m = new VendingMachine(0, 3, 10);
		assertNotNull(m);
		m.getLinea(1);
	}

	@Test
	public void testComprobarLineas() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00), 0);
		m.comprobarLineas();
		m = new VendingMachine(1, 1, 10);
		assertNotNull(m);
		m.comprobarLineas();
	}

	@Test
	public void testRellenarLinea() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarLineaNegativo() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarLineaFueraDelRango() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 0.00), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRellenarProductoNulo() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(null, 1);
	}

	@Test
	public void testCompra() {
		m = new VendingMachine(0, 2, 10);
		assertNotNull(m);
		t.recargaSaldo(credencial, 1);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 1), 1);
		m.compra(t, 1,"6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraLineaVacia() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		t.recargaSaldo(credencial, 1);
		m.compra(t, 0,"6Z1y00Nm31aA-571");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCompraMaquinaNoOperativa() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		t.recargaSaldo(credencial, 1);
		m.setEstado(false);
		assertFalse(m.getEstado());
		m.compra(t, 0,"6Z1y00Nm31aA-571");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCompraLineaNegativa() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		t.recargaSaldo("credencial", 1);
		m.compra(t, -1, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraDineroInsuficiente() {
		m = new VendingMachine(0, 2, 10);
		assertNotNull(m);
		t.recargaSaldo(credencial, 1);
		m.rellenarLinea(new Product("111111111117", nombre, new GregorianCalendar(2021, 1, 30), 3), 0);
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraSinDinero() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.compra(t, 0, "6Z1y00Nm31aA-571");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompraTarjetaNula() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.compra(null, 0, "6Z1y00Nm31aA-571");
	}

	@Test
	public void testComprobarLinea() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		assertTrue(m.comprobarLinea(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testComprobarLineaNegativa() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.comprobarLinea(-1);
	}
	
	@Test
	public void testgetId() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		assertEquals(0,m.getId());
	}
}
