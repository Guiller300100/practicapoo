package es.uva.poo.practica;
/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.*;

import org.junit.Test;


public class VendingCityTest {

	private List<VendingMachine> m = new ArrayList<>();
	private String provincia = "Valladolid";
	private VendingCity vs = new VendingCity(m, provincia);

	private Product p = new Product("111111111117", "Bruce Springsteen", Instant.now(), 0.00);

	@Test
	public void testVendingCity() {
		VendingMachine maquina1 = new VendingMachine(1, 1, 1);
		m.add(maquina1);
		m.add(maquina1);
		VendingCity t = new VendingCity(m, provincia);
		assertNotNull(t);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingCityNulo() {
		new VendingCity(null, provincia);
	}

	@Test
	public void testNuevaMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaIdNegativo() {
		vs.nuevaMaquina(-1, 5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaNumLineasNegativo() {
		vs.nuevaMaquina(1, -5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaProfundidadNegativo() {
		vs.nuevaMaquina(1, 5, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaIdExiste() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(1, 4, 3);
	}

	@Test
	public void testgetMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testgetMaquinaNoExiste() {
		vs.getMaquina(1);
	}

	@Test
	public void testBorrarMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.borrarMaquina(1);
		assertEquals(0, vs.getMaquinas().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBorrarMaquinaNoExisteId() {
		vs.borrarMaquina(2);
	}

	@Test
	public void testListaMaquinas() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.listaMaquinas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testListaMaquinasNoHayMaquinas() {
		vs.listaMaquinas();
	}

	@Test
	public void testMaquinasOperativas() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(2, 5, 10);
		assertNotNull(vs.getMaquina(2));
		vs.modificarEstado(2, false);
		vs.maquinasOperativas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaquinasOperativasNoHayMaquinas() {
		vs.maquinasOperativas();
	}

	@Test
	public void testListaMaquinasLineaVacia() {
		vs.nuevaMaquina(1, 1, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(2, 1, 10);
		assertNotNull(vs.getMaquina(2));
		vs.getMaquina(2).rellenarLinea(p, 0);
		assertNotNull(vs.listaMaquinasLineaVacia());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testListaMaquinasLineaVaciaNoHayMaquinas() {
		vs.listaMaquinasLineaVacia();
	}

	@Test
	public void testListaMaquinasLineaVaciaNoHayNingunaVacia() {
		vs.nuevaMaquina(1, 1, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(2, 1, 10);
		assertNotNull(vs.getMaquina(2));
		vs.getMaquina(2).rellenarLinea(p, 0);
		vs.getMaquina(1).rellenarLinea(p, 0);
		vs.listaMaquinasLineaVacia();
	}

	@Test
	public void testModificarEstado() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.modificarEstado(1, false);
		assertFalse(vs.getMaquina(1).getEstado());
	}

	@Test
	public void testMaquinasTotales() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		assertEquals(1, vs.maquinasTotales());
	}
	
}
