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
	/* El constructor es por si nos pasan un sistema de maquinas ya creado */
	private Map<Integer, VendingMachine> maquinas = new HashMap<>();

	/**
	 * Crea una nueva red de máquinas con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param sistema_maquina mapa
	 */
	public VendingSystem(Map<Integer, VendingMachine> sistema_maquina) {
		maquinas.putAll(sistema_maquina);
	}

	/**
	 * Crea una nueva máquina en la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id          número entero indicando el número identificador de la
	 *                    máquina
	 * @param numLineas   número entero indicando el número de líneas contenidas en
	 *                    la máquina
	 * @param profundidad número entero indicando el número máximo de productos de
	 *                    un mismo tipo que pueden ser contenidos por cada línea de
	 *                    la máquina
	 * @return
	 * @throws InvalidParameterException si el identificador ya corresponde a una
	 *                                   máquina de la red
	 * @see VendingMachine
	 */
	public void nuevaMaquina(int id, int numLineas, int profundidad) {
		if (id >= 0 && numLineas > 0 && profundidad > 0) {
			if (maquinas.containsKey(id)) {
				throw (new IllegalArgumentException("ID ya en uso"));
			} else {
				VendingMachine maquina = new VendingMachine(id, numLineas, profundidad);
				maquinas.put(id, maquina);
			}
		} else {
			throw (new IllegalArgumentException("Parametros mal introducidos"));
		}

	}

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
	 * @param clave número entero indicando el identificador de la máquina a borrar
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
	 * @return total número entero indicando el número de máquinas vending
	 *         operativas en la red
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
	 * @return maquinasLineaVacia lista de máquinas de la red con al menos una línea
	 *         vacía
	 */
	public ArrayList<VendingMachine> listaMaquinasLineaVacia() {
		ArrayList<VendingMachine> maquinasLineaVacia = new ArrayList<VendingMachine>();
		for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
			if (iterante.getValue().getLineaVacia()) {
				maquinasLineaVacia.add(iterante.getValue());
			}
		}
		return maquinasLineaVacia;
	}

	/**
	 * Da un estado (operativa/fuera de servicio) a una máquina de la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id     número entero indicando el número identificador de la máquina
	 * @param estado variable booleana indicando si la máquina está operativa (valor
	 *               true) o fuera de servicio (valor false)
	 */
	public void modificarEstado(int id, boolean estado) {
		maquinas.get(id).setEstado(estado);
	}

}
