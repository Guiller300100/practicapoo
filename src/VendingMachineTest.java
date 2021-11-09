import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {
	
	private VendingMachine m;
	private TarjetaMonedero t = new TarjetaMonedero("A156Bv09_1zXo894");
	
	@Test
	public void testVendingMachine() {
		m = new VendingMachine(0, 3, 10);
		assertNotNull(m);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testVendingMachineIdNegativo() {
		new VendingMachine(-1, 5, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testVendingMachineNumLineasNegativo() {
		new VendingMachine(1, -5, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
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
	public void testComprobarLinea() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product ("111111111117","Bruce Springsteen", Instant.now(), 0.00), 0);
		m.comprobarLineas();
		m = new VendingMachine(1, 1, 10);
		assertNotNull(m);
		m.comprobarLineas();
	}

	@Test
	public void testRellenarLinea() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product ("111111111117","Bruce Springsteen", Instant.now(), 0.00), 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRellenarLineaNegativo() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.rellenarLinea(new Product ("111111111117","Bruce Springsteen", Instant.now(), 0.00), -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCompraSinDinero() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		m.compra(t, 0);
	}
	
	@Test
	public void testCompra() {
		m = new VendingMachine(0, 2, 10);
		assertNotNull(m);
		t.recargaSaldo("A156Bv09_1zXo894", 1);
		m.rellenarLinea(new Product ("111111111117","Bruce Springsteen", Instant.now(), 1), 0);
		m.compra(t, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCompraLineaVacia() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		t.recargaSaldo("A156Bv09_1zXo894", 1);
		m.compra(t, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCompraLineaNegativa() {
		m = new VendingMachine(0, 1, 10);
		assertNotNull(m);
		t.recargaSaldo("A156Bv09_1zXo894", 1);
		m.compra(t, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCompraDineroInsuficiente() {
		m = new VendingMachine(0, 2, 10);
		assertNotNull(m);
		t.recargaSaldo("A156Bv09_1zXo894", 1);
		m.rellenarLinea(new Product ("111111111117","Bruce Springsteen", Instant.now(), 3), 0);
		m.compra(t, 0);
	}
}
