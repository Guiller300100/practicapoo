package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingSystemTest {
	
	private List<VendingCity> sedes = new ArrayList<>();
	private List<VendingMachine> maquinas = new ArrayList<>();

	@Before
	public void inizializar() {
		maquinas.add(new VendingMachine(0, 3, 1));
		sedes.add(new VendingCity(maquinas, "Valladolid"));
	}
	
	
	@Test
	public void testVendingSystem() {
		sedes.add(new VendingCity(maquinas, "Valladolid"));
		VendingSystem vs = new VendingSystem(sedes);
		assertNotNull(vs);
		assertTrue(vs.comprobarSede("Valladolid"));
		assertEquals(1, vs.numProvincias());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVendingSystemNulo() {
		new VendingSystem(null);
	}
	
	

}
