package es.uva.poo.practica;

import java.util.*;

public class VendingSystem {

	private Map<String, VendingCity> redprovincias = new HashMap<>();

	public VendingSystem() {

	}

	public void crearSede(String provincia, Map<Integer, VendingMachine> maquinas) {
		if (provincia == null) {
			throw new IllegalArgumentException("El codigo de la provincia es nulo");
		} else {
			redprovincias.put(provincia, new VendingCity(maquinas));
		}
	}

}
