package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class VendingCityTest {


	private List<VendingMachine> m = new ArrayList<>();
	private String provincia = "Valladolid";
	private VendingCity vc = new VendingCity(m, provincia);
	private Product p = new Product("111111111117", "Bruce Springsteen", new GregorianCalendar(2021, 1, 30), 0.00);
	VendingMachine maquina1 = new VendingMachine(1, 1, 1);

	@Before
	public void inicializar() {
		m = new ArrayList<>();
		vc = new VendingCity(m, provincia);
		maquina1 = new VendingMachine(1, 1, 1);
	}
	
	@Test
	public void testVendingCity() {
		m.add(maquina1);
		m.add(maquina1);
		VendingCity t = new VendingCity(m, provincia);
		assertNotNull(t);
		assertEquals(1, t.maquinasTotales());
		assertEquals(maquina1, t.getMaquina(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingCityListaNula() {
		new VendingCity(null, provincia);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVendingCityProvinciaNula() {
		new VendingCity(m, null);
	}

	@Test
	public void testGetMaquinas() {
		assertEquals(0, vc.getMaquinas().size());
	}

	@Test
	public void testNuevaMaquina() {
		vc.nuevaMaquina(maquina1);
		assertEquals(1, vc.maquinasTotales());
		assertEquals(maquina1, vc.getMaquina(1));
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaIdExiste() {
		vc.nuevaMaquina(maquina1);
		VendingMachine maquina2 = new VendingMachine(1, 1, 1);
		vc.nuevaMaquina(maquina2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNuevaMaquinaNula() {
		vc.nuevaMaquina(null);
	}

	@Test
	public void testgetMaquina() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testgetMaquinaNoExiste() {
		vc.getMaquina(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testgetMaquinaIdNegativo() {
		vc.getMaquina(-1);
	}

	@Test
	public void testBorrarMaquina() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		vc.borrarMaquina(1);
		assertEquals(0, vc.getMaquinas().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBorrarMaquinaNoExisteId() {
		vc.borrarMaquina(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBorrarMaquinaIdNegativo() {
		vc.borrarMaquina(-2);
	}

	@Test
	public void testListaMaquinas() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		vc.listaMaquinas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testListaMaquinasNoHayMaquinas() {
		vc.listaMaquinas();
	}

	@Test
	public void testMaquinasOperativas() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		VendingMachine maquina2 = new VendingMachine(2, 1, 1);
		vc.nuevaMaquina(maquina2);
		assertNotNull(vc.getMaquina(2));
		vc.modificarEstado(2, false);
		vc.maquinasOperativas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaquinasOperativasNoHayMaquinas() {
		vc.maquinasOperativas();
	}

	@Test
	public void testListaMaquinasLineaVacia() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		VendingMachine maquina2 = new VendingMachine(2, 1, 1);
		vc.nuevaMaquina(maquina2);
		assertNotNull(vc.getMaquina(2));
		vc.getMaquina(2).rellenarLinea(p, 0);
		assertNotNull(vc.listaMaquinasLineaVacia());
	}

	@Test
	public void testListaMaquinasLineaVaciaNoHayNingunaVacia() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		VendingMachine maquina2 = new VendingMachine(2, 1, 1);
		vc.nuevaMaquina(maquina2);
		assertNotNull(vc.getMaquina(2));
		vc.getMaquina(2).rellenarLinea(p, 0);
		vc.getMaquina(1).rellenarLinea(p, 0);
		vc.listaMaquinasLineaVacia();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testListaMaquinasLineaVaciaNoHayMaquinas() {
		vc.listaMaquinasLineaVacia();
	}

	@Test
	public void testModificarEstado() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		vc.modificarEstado(1, false);
		assertFalse(vc.getMaquina(1).getEstado());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testModificarEstadoIdNulo() {
		vc.nuevaMaquina(maquina1);
		vc.modificarEstado(-1, false);
	}

	@Test
	public void testMaquinasTotales() {
		vc.nuevaMaquina(maquina1);
		assertNotNull(vc.getMaquina(1));
		assertEquals(1, vc.maquinasTotales());
	}

	@Test
	public void testgetProvincia() {
		assertEquals(provincia, vc.getProvincia());
	}

}
