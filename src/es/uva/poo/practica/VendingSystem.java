package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import java.util.*;

/**
 * Representa las funcionalidades y atributos de un sistema de maquinas, la cual
 * alberga sedes en diferentes provincias.
 * 
 * @author guirodr
 */

public class VendingSystem {

	private Map<String, VendingCity> redprovincias = new HashMap<>();
	
	/**
	 * Crea un nuevo sistema de sedes, con las caracteristicas indicadas.
	 * 
	 * @param sedes Lista de sedes con la que se va a crear el sistema
	 * 
	 * @throws IllegalArgumentException por si la lista es nula
	 */

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
	
	/**
	 * Crea una sede con una lista de maquinas y con un identificador para la provincia
	 * @param provincia Cadena de caracteres que representa el codigo de la provincia
	 * @param maquinas Lista de maquinas donde tiene todas las maquinas de la sede
	 * 
	 * @throws IllegalArgumentException Si el codigo de provincia es nula
	 * @throws IllegalArgumentException Si el codigo de provincia ya existe
	 */

	public void crearSede(String provincia, List<VendingMachine> maquinas) {
		if (provincia == null) {
			throw new IllegalArgumentException("El codigo de la provincia es nulo");
		} else if (comprobarSede(provincia)) {
			throw new IllegalArgumentException("Ya existe una provincia con ese codigo");
		} else {
			redprovincias.put(provincia.toLowerCase(), new VendingCity(maquinas, provincia.toLowerCase()));
		}
	}
	
	/**
	 * Borrar una sede del sistema
	 * @param provincia Cadena que representa el identificador de la provincia
	 * 
	 * @throws IllegalArgumentException El codigo de provincia no existe en la red
	 */

	public void borrarSede(String provincia) {
		if (redprovincias.containsKey(provincia.toLowerCase())) {
			redprovincias.remove(provincia.toLowerCase());
		} else {
			throw new IllegalArgumentException("El codigo de la provincia no esta en la red");
		}
	}
	
	/**
	 * Devuelve el total de maquinas que tiene una sede 
	 * @param provincia Cadena que representa el identificador de la provincia
	 * @return numero entero que representa el total de maquinas en una sede
	 */

	public int numMaquinas(String provincia) {
		if (comprobarSede(provincia.toLowerCase())) {
			return redprovincias.get(provincia.toLowerCase()).maquinasTotales();
		} else {
			return 0;
		}
	}
	
	/**
	 * Devuelve una lista de maquinas que tiene una sede
	 * @param provincia Cadena que representa el identificador de una provincia
	 * @return Lista de las maquinas de una sede
	 */

	public List<VendingMachine> listaMaquinasSede(String provincia) {
		if (comprobarSede(provincia.toLowerCase())) {
			return redprovincias.get(provincia.toLowerCase()).listaMaquinas();
		} else {
			return new ArrayList<>();
		}
	}
	
	/**
	 * Devuelve el numero de provincias que hay en el sistema
	 * 
	 * @return numero entero que representa el total de provincias en la red
	 */

	public int numProvincias() {
		return redprovincias.size();
	}
	
	/**
	 * Devuelve una lista de cadenas con los nombres de las provincias
	 * 
	 * @return Lista de cadenas con los nombres de las provincias de la red.
	 */

	public List<String> listaNomProvincias() {
		return new ArrayList<>(redprovincias.keySet());
	}
	
	/**
	 * Mapa que contiene la provincia y que tiene asociado el numero de maquinas que tiene esa provincia
	 * 
	 * @return mapa con una cadena de caracteres como clave y un numero entero como el valor asociado.
	 */
	
	public Map<String, Integer> listaMaqProvincias(){
		Map<String,Integer> m = new HashMap<>();
		List<String> provincias = new ArrayList<>(redprovincias.keySet());
		for (String provincia : provincias) {
			m.put(provincia, redprovincias.get(provincia).maquinasTotales());
		}
		return m;
	}

	/**
	 * Comprueba si una sede existe en la red
	 * @param provincia cadena de caracteres que representa el indetificador de la provincia
	 * @return variable booleana que es true si la sede ya esta en la red o false si la sede no esta en la red
	 */
	public boolean comprobarSede(String provincia) {
		if (!redprovincias.containsKey(provincia.toLowerCase())) {
			return false;
		} 
			return true;
	}
	
	/**
	 * Devuelve la sede asociada al identificador de la provincia
	 * 
	 * @param provincia Cadena de caracteres que representa el identificador de la provincia
	 * 
	 * @return sedeseleccionada devuelve un objeto VendingCity que representa a una sede completa.
	 */
	
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
