package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import java.util.*;

/**
 * Representa las funcionalidades y atributos de una sede de maquinas, la cual
 * contiene una serie de maquinas.
 * 
 * @author guirodr
 */
public class VendingCity {
	/* El constructor es por si nos pasan un sistema de maquinas ya creado */
	private Map<Integer, VendingMachine> maquinas = new HashMap<>();
	private String provincia;


	/**
	 * Crea una nueva red de maquinas con las caracteristicas indicadas.
	 * 
	 * @author guirodr
	 * @param sistemamaquinas lista de maquinas con las que crearemos la red cogiendo el id de dentro del objeto VendingMachine
	 * @param provinc cadena que representa el codigo de la provincia
	 * @throws IllegalArgumentException si el mapa es nulo
	 */
	public VendingCity(List<VendingMachine> sistemamaquinas, String provinc) {
		if (sistemamaquinas == null) {
			throw new IllegalArgumentException("El mapa es nulo");
		} else {
			for (VendingMachine maquina : sistemamaquinas) {
				if (!maquinas.containsKey(maquina.getId())) {
					maquinas.put(maquina.getId(), maquina);
				}
			}
			provincia = provinc;
		}
	}

	/**
	 * Devuelve la red de maquinas
	 * 
	 * @return maquinas mapa correspondiente a la red de maquinas
	 */

	public Map<Integer, VendingMachine> getMaquinas() {
		return new HashMap<>(maquinas);
	}

	/**
	 * Crea una nueva  en la red.
	 * 
	 * @author guirodr
	 * @param maq		Un objeto VendingMachine que se va a almacenar en la sede, si no esta metida ya
	 * @throws IllegalArgumentException si el identificador ya corresponde a una
	 *                                   de la red de maquinas
	 * @see VendingMachine
	 */
	public void nuevaMaquina(VendingMachine maq) {
		if (maquinas.containsKey(maq.getId())) {
			throw (new IllegalArgumentException("ID ya en uso"));
		} else {
			maquinas.put(maq.getId(), maq);
		}

	}

	/**
	 * Devuelve la  correspondiente a un identificador
	 * 
	 * @param id numero entero indicando el numero identificador de la 
	 *           vending
	 * @return vending correspondiente al identificador en la red de
	 *         maquinas
	 * @throws IllegalArgumentException si el identificador no se corresponde con
	 *                                  ninguna  de la red de maquinas
	 */

	public VendingMachine getMaquina(int id) {
		if (maquinas.containsKey(id)) {
			VendingMachine m = maquinas.get(id);
			return m;
		} else {
			throw (new IllegalArgumentException("Maquina con ese ID no existe"));
		}
	}

	/**
	 * Borra la  correspondiente a un identificador de la red de maquinas.
	 * 
	 * @author guirodr
	 * @param clave numero entero indicando el identificador de la  a borrar
	 * @throws IllegalArgumentException si el identificador no se corresponde con
	 *                                  ninguna  de la red de maquinas
	 */
	public void borrarMaquina(int clave) {
		if (maquinas.containsKey(clave)) {
			maquinas.remove(clave);
		} else {
			throw (new IllegalArgumentException("Maquina con ese ID no existe"));
		}
	}

	/**
	 * Muestra la lista completa de maquinas de la red.
	 * 
	 * @author guirodr
	 * @throws IllegalArgumentException si la red de maquinas no contiene ninguna
	 *                                  
	 * @return lista completa de maquinas de la red de maquinas
	 */
	public List<VendingMachine> listaMaquinas() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna  en el sistema"));
		} else {
			return new ArrayList<>(maquinas.values());
		}
	}

	/**
	 * Devuelve el numero de maquinas vending operativas en la red.
	 * 
	 * @author guirodr
	 * @return total numero entero indicando el numero de maquinas vending
	 *         operativas en la red
	 * @throws IllegalArgumentException si la red de maquinas no contiene ninguna
	 *                                  
	 */
	public int maquinasOperativas() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna  creada"));
		} else {
			int total = 0;
			for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
				if (iterante.getValue().getEstado()) {
					total++;
				}
			}
			return total;
		}

	}

	/**
	 * Devuelve una lista de todas las maquinas de la red de maquinas con al menos
	 * una linea vacia.
	 * 
	 * @author guirodr
	 * @throws IllegalArgumentException si no hay ninguna  de la red con
	 *                                  alguna linea vacia
	 * @return lista de maquinas de la red de maquinas con alguna linea vacia, si no tiene ninguna, devolvera una lista vacia
	 */
	public List<VendingMachine> listaMaquinasLineaVacia() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No se ha creado ninguna maquina"));
		} else {
			Map<Integer, VendingMachine> maquinasLineaVacia = new HashMap<>();
			for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
				if (iterante.getValue().comprobarLineas()) {
					maquinasLineaVacia.put(iterante.getKey(), iterante.getValue());
				}
			}
			if (!maquinasLineaVacia.values().isEmpty()) {
				return new ArrayList<>(maquinasLineaVacia.values());
			} else
				return new ArrayList<>();
		}
	}

	/**
	 * Da un estado (operativa/fuera de servicio) a una  de la red.
	 * 
	 * @author guirodr
	 * @param id     numero entero indicando el numero identificador de la 
	 * @param estado variable booleana indicando si la  está operativa (valor
	 *               true) o fuera de servicio (valor false)
	 */
	public void modificarEstado(int id, boolean estado) {
		maquinas.get(id).setEstado(estado);
	}
	
	/**
	 * Devuelve un entero con el numero de maquinas que hay en esa sede, sean operativas o no.
	 * 
	 * @author guirodr
	 * @return entero con el valor de todas las maquinas que tiene esa sede.
	 */

	public int maquinasTotales() {
		return maquinas.size();
	}
	
	/**
	 * Devuelve el codigo de la provincia de la cual es sede.
	 * 
	 * @author guirodr
	 * @return cadena de caracteres refiriendose a la provincia.
	 */
	
	public String getProvincia() {
		return provincia;
	}
}
