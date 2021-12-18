package es.uva.poo.practica;

import java.util.*;



public class VendingSystem {

	private Map<String, VendingCity> redprovincias = new HashMap<>();

	public VendingSystem(List<VendingCity> sedes) {
		if (sedes == null) {
			throw new IllegalArgumentException("La lista es nula");
		} else {
			for (VendingCity sede : sedes) {
				if (!redprovincias.containsKey(sede.getProvincia().toLowerCase())) {
					redprovincias.put(sede.getProvincia().toLowerCase(), sede);
				}
			}
		}
	}

	public void crearSede(String provincia, List<VendingMachine> maquinas) {
		if (provincia == null) {
			throw new IllegalArgumentException("El codigo de la provincia es nulo");
		} else if (redprovincias.containsKey(provincia.toLowerCase())) {
			throw new IllegalArgumentException("Ya existe una provincia con ese codigo");
		} else {
			redprovincias.put(provincia.toLowerCase(), new VendingCity(maquinas, provincia.toLowerCase()));
		}
	}

	public void borrarSede(String provincia) {
		if (redprovincias.containsKey(provincia.toLowerCase())) {
			redprovincias.remove(provincia.toLowerCase());
		} else {
			throw new IllegalArgumentException("El codigo de la provincia no esta en la red");
		}
	}

	public int numMaquinas(String provincia) {
		if (comprobarSede(provincia.toLowerCase())) {
			return redprovincias.get(provincia.toLowerCase()).maquinasTotales();
		} else {
			return 0;
		}
	}

	public List<VendingMachine> listaMaquinasSede(String provincia) {
		if (comprobarSede(provincia.toLowerCase())) {
			return redprovincias.get(provincia.toLowerCase()).listaMaquinas();
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
	
	public Map<String, Integer> listaMaqProvincias(){
		Map<String,Integer> m = new HashMap<>();
		List<String> provincias = new ArrayList<>(redprovincias.keySet());
		for (String provincia : provincias) {
			m.put(provincia, redprovincias.get(provincia).maquinasTotales());
		}
		return m;
	}

	public boolean comprobarSede(String provincia) {
		if (!redprovincias.containsKey(provincia.toLowerCase())) {
			return false;
		} 
			return true;
	}
	
	public VendingCity getSede(String provincia) {
		if(provincia == null) {
			throw (new IllegalArgumentException("Parametro introducido nulo"));
		}
		
		if(!redprovincias.containsKey(provincia.toLowerCase())) {
			throw (new IllegalArgumentException("No hay ninguna sede creada en esa provincia"));
		}
		VendingCity sedeseleccionada = redprovincias.get(provincia.toLowerCase());
		return sedeseleccionada;
	}
	
}
