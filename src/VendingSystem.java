import java.security.InvalidParameterException;
import java.util.*;

/**
 * Representa las funcionalidades y atributos de una red de máquinas, la cual contiene una 
 * serie de máquinas.
 * 
 * @author guirodr
 * @author josbarb
 */
public class VendingSystem {

	public Map<Integer, VendingMachine> maquinas = new HashMap<Integer, VendingMachine>();
	public VendingSystem() {
		
	}
	
	/**
	 * Crea una nueva máquina en la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id							número entero indicando el número identificador de la máquina
	 * @param numLineas						número entero indicando el número de líneas contenidas en la máquina
	 * @param profundidad					número entero indicando el número máximo de productos de un mismo tipo que pueden ser contenidos por cada línea de la máquina
	 * @throws InvalidParameterException	si el identificador ya corresponde a una máquina de la red
	 * @see VendingMachine
	 */
	public void NuevaMaquina(int id, int numLineas, int profundidad) {
		if (maquinas.containsKey(id)) {
			throw(new InvalidParameterException("ID ya en uso"));
		} else {
			VendingMachine maquina = new VendingMachine(id, numLineas, profundidad);
			maquinas.put(id, maquina);
		}

	}
	
	/**
	 * 
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param clave			
	 */
	public void BorrarMaquina(int clave) {
		maquinas.remove(clave);
	}
	
	/**
	 * 
	 * 
	 * @author guirodr
	 * @author josbarb
	 */
	public void ListaMaquinas() {
		maquinas.values();
	}
	
	/**
	 * Devuelve el número de máquinas vending operativas en la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return total		número entero indicando el número de máquinas vending operativas en la red
	 */
	public int MaquinasOperativas() {
		int total=0;
		for(Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
			if(iterante.getValue().getEstado()) {
				total++;
			}
		}
		return total;
	}
	
	/**
	 * CAMELCASE ARRAYLIST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return 
	 */
	public ArrayList<VendingMachine> ListaMaquinasLineaVacia() {
		ArrayList <VendingMachine> MaquinasLineaVacia = new ArrayList<VendingMachine>();
		for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
			if(iterante.getValue().getLineaVacia()) {
				MaquinasLineaVacia.add(iterante.getValue());
			}
		}
		return MaquinasLineaVacia;
	}
	
	/**
	 * 
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id
	 * @param producto
	 * @param numlinea		número entero indicando
	 */
	public void RellenarLinea(int id, Product producto, int numlinea) {
		maquinas.get(id).getLinea(numlinea).rellenar(producto);
	}
	/**
	 * Modifica el estado de una máquina de la red.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param id			número entero indicando si 
	 * @param estado		variable booleana indicando si la máquina está operativa (valor true) o fuera de servicio (valor false)
	 */
	public void ModificarEstado(int id, boolean estado) {
		maquinas.get(id).setEstado(estado);
	}
	
}
