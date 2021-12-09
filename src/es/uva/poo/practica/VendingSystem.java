package es.uva.poo.practica;

import java.util.*;

public class VendingSystem {

	private Map<String, VendingCity> redprovincias = new HashMap<>();

	public VendingSystem(List<VendingCity> sedes) {
		if (sedes == null) {
			throw new IllegalArgumentException("El mapa es nulo");
		} else {
			for (VendingCity sede : sedes) {
				if (!redprovincias.containsKey(sede.getProvincia())) {
					redprovincias.put(sede.getProvincia(), sede);
				}
			}
		}
	}

	public void crearSede(String provincia, List<VendingMachine> maquinas) {
		if (provincia == null) {
			throw new IllegalArgumentException("El codigo de la provincia es nulo");
		} else if (redprovincias.containsKey(provincia)) {
			throw new IllegalArgumentException("Ya existe una provincia con ese codigo");
		} else {
			redprovincias.put(provincia, new VendingCity(maquinas, provincia));
		}
	}

	public void borrarSede(String provincia) {
		if (redprovincias.containsKey(provincia)) {
			redprovincias.remove(provincia);
		} else {
			throw new IllegalArgumentException("El codigo de la provincia no esta en la red");
		}
	}

	public int numMaquinas(String provincia) {
		if (comprobarSede(provincia)) {
			return redprovincias.get(provincia).maquinasTotales();
		} else {
			return 0;
		}
	}

	public List<VendingMachine> listaMaquinasSede(String provincia) {
		if (comprobarSede(provincia)) {
			return redprovincias.get(provincia).listaMaquinas();
		} else {
			return new ArrayList<>();
		}
	}

	public int numProvincias() {
		return redprovincias.size();
	}

	public List<String> listaNomProvincias() {
		return new ArrayList<>(redprovincias.keySet());
	}

	public boolean comprobarSede(String provincia) {
		if (redprovincias.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna sede creada"));
		} else if (!redprovincias.containsKey(provincia)) {
			throw (new IllegalArgumentException("No existe dicha sede"));
		} else {
			return true;
		}
	}
}
