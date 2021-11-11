import java.security.InvalidParameterException;
import java.util.*;

/**
 * Representa las funcionalidades y atributos de una red de máquinas, la cual
 * contiene una serie de máquinas.
 * 
 * @author guirodr
 * @author josbarb
 */
public class VendingSystem {
	/* El constructor es por si nos pasan un sistema de máquinas ya creado */
	private Map<Integer, VendingMachine> maquinas = new HashMap<>();

	/**
	 * Crea una nueva red de máquinas con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param sistema_maquina				mapa correspondiente a la red de máquinas a crear
	 * @throws IllegalArgumentException		si el mapa es nulo
	 */
	public VendingSystem(Map<Integer, VendingMachine> sistema_maquina) {
		if (sistema_maquina == null) {
			throw new IllegalArgumentException("El mapa es nulo");
		} else {
			maquinas.putAll(sistema_maquina);
		}
	}

	/**
	 * Devuelve la red de máquinas
	 * 
	 * @return maquinas		mapa correspondiente a la red de máquinas
	 */

	public Map<Integer, VendingMachine> getMaquinas() {
		return maquinas;
	}

	/**
	 * Crea una nueva máquina en la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id          					número entero indicando el número identificador de la
	 *                    					máquina
	 * @param numLineas   					número entero indicando el número de líneas contenidas en
	 *                    					la máquina
	 * @param profundidad 					número entero indicando el número máximo de productos de
	 *                    					un mismo tipo que pueden ser contenidos por cada línea de
	 *                    					la máquina
	 * @throws IllegalArgumentException		si el identificador ya corresponde a una
	 *                                   	máquina de la red de máquinas
	 * @see VendingMachine
	 */
	public void nuevaMaquina(int id, int numLineas, int profundidad) {
		if (maquinas.containsKey(id)) {
			throw (new IllegalArgumentException("ID ya en uso"));
		} else {
			maquinas.put(id, new VendingMachine(id, numLineas, profundidad));
		}

	}

	/**
	 * Devuelve la máquina correspondiente a un identificador
	 * 
	 * @param id							número entero indicando el número identificador de la 
	 * 										máquina vending
	 * @return máquina vending correspondiente al identificador en la red de máquinas
	 * @throws IllegalArgumentException		si el identificador no se corresponde
	 * 										con ninguna máquina de la red de máquinas
	 */

	public VendingMachine getMaquina(int id) {
		if (maquinas.containsKey(id)) {
			return maquinas.get(id);
		} else {
			throw (new IllegalArgumentException("Maquina con ese ID no existe"));
		}
	}

	/**
	 * Borra la máquina correspondiente a un identificador de la red de máquinas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param clave 						número entero indicando el identificador 
	 * 										de la máquina a borrar
	 * @throws IllegalArgumentException		si el identificador no se corresponde
	 * 										con ninguna máquina de la red de máquinas 
	 */
	public void borrarMaquina(int clave) {
		if (maquinas.containsKey(clave)) {
			maquinas.remove(clave);
		} else {
			throw (new IllegalArgumentException("Maquina con ese ID no existe"));
		}
	}

	/**
	 * Muestra la lista completa de máquinas de la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @throws IllegalArgumentException		si la red de máquinas no contiene ninguna máquina
	 */
	public void listaMaquinas() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna maquina creada"));
		} else {
			maquinas.values();
		}
	}

	/**
	 * Devuelve el número de máquinas vending operativas en la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return total 						número entero indicando el número de máquinas vending
	 *         								operativas en la red
	 * @throws IllegalArgumentException		si la red de máquinas no contiene ninguna máquina
	 */
	public int maquinasOperativas() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna maquina creada"));
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
	 * Devuelve una lista de todas las máquinas de la red con al menos una línea
	 * vacía.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @throws IllegalArgumentException		si no hay ninguna máquina de la red con alguna línea vacía
	 */
	public void listaMaquinasLineaVacia() {
		if (maquinas.size() == 0) {
			throw (new IllegalArgumentException("No hay ninguna maquina creada"));
		} else {
			Map<Integer, VendingMachine> maquinasLineaVacia = new HashMap<>();
			for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
				if (iterante.getValue().comprobarLineas()) {
					maquinasLineaVacia.put(iterante.getKey(), iterante.getValue());
				}
			}
			if (!maquinasLineaVacia.values().isEmpty()) {
				maquinasLineaVacia.values();
			} else
				throw (new IllegalArgumentException("No hay ninguna maquina con alguna linea vacia"));
		}
	}

	/**
	 * Da un estado (operativa/fuera de servicio) a una máquina de la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id     	número entero indicando el número identificador de la máquina
	 * @param estado 	variable booleana indicando si la máquina está operativa (valor
	 *               	true) o fuera de servicio (valor false)
	 */
	public void modificarEstado(int id, boolean estado) {
		maquinas.get(id).setEstado(estado);
	}

}
