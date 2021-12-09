package es.uva.poo.practica;

import java.util.*;
public class VendingSystem {

	private Map<String, Map<Integer, VendingMachine>> redprovincias = new HashMap<>();
	
	public VendingSystem() {

		
	}
	
	public void crearSede(String provincia, Map<Integer, VendingMachine> maquinas) {
		
		redprovincias.put(provincia, new VendingCity(maquinas).getMaquinas());
	}

}
