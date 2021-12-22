package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class VendingSystemTest {

	private List<VendingCity> sedes = new ArrayList<>();
	private List<VendingMachine> maquinas = new ArrayList<>();
	private VendingSystem vs;

	@Before
	public void inicializar() {
		maquinas.add(new VendingMachine(0, 3, 1));
		sedes.add(new VendingCity(maquinas, "Valladolid"));
		vs = new VendingSystem(sedes);
		assertNotNull(vs);
	}

	@Test
	public void testVendingSystem() {
		sedes.add(new VendingCity(maquinas, "Valladolid"));
		vs = new VendingSystem(sedes);
		assertTrue(vs.comprobarSede("Valladolid"));
		assertEquals(1, vs.numProvincias());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVendingSystemNulo() {
		new VendingSystem(null);
	}

	@Test
	public void testCrearSede() {
		vs.crearSede("Palencia", maquinas);
		assertNotNull(vs.getSede("Palencia"));
		assertEquals(1, vs.numMaquinas("Palencia"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCrearSedeProvinciaNulo() {
		vs.crearSede(null, maquinas);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearSedeListaNula() {
		vs.crearSede("Palencia", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCrearSedeExistente() {
		vs.crearSede("Valladolid", maquinas);
	}

	@Test
	public void testBorrarSede() {
		vs.borrarSede("Valladolid");
		assertEquals(0, vs.numProvincias());
		assertFalse(vs.comprobarSede("Valladolid"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBorrarSedeProvinciaNula() {
		vs.borrarSede(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBorrarSedeNoExiste() {
		vs.borrarSede("Valladolid");
		vs.borrarSede("Valladolid");
	}

	@Test
	public void testNumMaquinas() {
		assertEquals(1, vs.numMaquinas("Valladolid"));
		vs.borrarSede("Valladolid");
		assertEquals(0, vs.numMaquinas("Valladolid"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumMaquinasProvinciaNula() {
		vs.numMaquinas(null);
	}

	@Test
	public void testListaMaquinasSede() {
		assertEquals(1, vs.listaMaquinasSede("Valladolid").size());
		assertNotNull(vs.listaMaquinasSede("Valladolid"));
		vs.borrarSede("Valladolid");
		assertEquals(0, vs.listaMaquinasSede("Valladolid").size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testListaMaquinasSedeProvinciaNula() {
		vs.listaMaquinasSede(null);
	}
	
	@Test
	public void testNumProvincia() {
		assertEquals(1, vs.numProvincias());
	}
	
	@Test
	public void testListaNomProvincia() {
		List<String> lista = vs.listaNomProvincias();
		assertEquals(1, lista.size());
		assertEquals("valladolid", lista.get(0));
	}

	@Test
	public void testListaMaqProvincias() {
		Map<String, Integer> mapa = vs.listaMaqProvincias();
		int i = mapa.get("valladolid");
		assertEquals(1, i);
		assertEquals(1, mapa.size());
	}
	
	@Test
	public void testComprobarSede() {
		assertTrue(vs.comprobarSede("Valladolid"));
		assertFalse(vs.comprobarSede("palencia"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testComprobarSedeProvinciaNula() {
		vs.comprobarSede(null);
	}

	@Test
	public void testGetSede() {
		assertNotNull(vs.getSede("Valladolid"));
		assertEquals(1, vs.getSede("Valladolid").maquinasTotales());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSedeStringNulo() {
		vs.getSede(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetSedeNoExiste() {
		vs.getSede("Palencia");
	}
	
}
