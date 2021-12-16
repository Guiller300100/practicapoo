package es.uva.poo.practica;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class VendingSystemTest {
	
	//private Map<String, VendingCity> redprovincias = new HashMap<>();
	private List<VendingCity> sedes = new ArrayList<>();
	private List<VendingMachine> maquinas = new ArrayList<>();

	@Before
	public void inizializar() {
		maquinas.add(new VendingMachine(0, 3, 1));
		sedes.add(new VendingCity(maquinas, "Valladolid"));
	}
	
	
	@Test
	public void testVendingSystem() {
		
		VendingSystem vs = new VendingSystem(sedes);
		assertNotNull(vs);
	}

}
