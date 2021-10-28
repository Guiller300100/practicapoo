import java.security.InvalidParameterException;
import java.util.*;

public class VendingSystem {

	public Map<Integer, VendingMachine> maquinas = new HashMap<Integer, VendingMachine>();
	public VendingSystem() {
		
	}
	public void NuevaMaquina(int id, int numLineas, int profundidad) {
		if (maquinas.containsKey(id)) {
			throw(new InvalidParameterException("ID ya en uso"));
		} else {
			VendingMachine maquina = new VendingMachine(id, numLineas, profundidad);
			maquinas.put(id, maquina);
		}

	}
	
	public void BorrarMaquina(int clave) {
		maquinas.remove(clave);
	}
	
	public void ListaMaquinas() {
		maquinas.values();
	}
	
	public int MaquinasOperativas() {
		int total=0;
		for(Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
			if(iterante.getValue().getEstado()) {
				total++;
			}
		}
		return total;
	}
	
	public ArrayList<VendingMachine> ListaMaquinasLineaVacia() {
		ArrayList <VendingMachine> MaquinasLineaVacia = new ArrayList<VendingMachine>();
		for (Map.Entry<Integer, VendingMachine> iterante : maquinas.entrySet()) {
			if(iterante.getValue().getLineaVacia()) {
				MaquinasLineaVacia.add(iterante.getValue());
			}
		}
		return MaquinasLineaVacia;
	}
	
	public void RellenarLinea(int id, Product producto, int numlinea) {
		maquinas.get(id).getLinea(numlinea).Rellenar(producto);
	}
	
	public void ModificarEstado(int id, boolean estado) {
		maquinas.get(id).setEstado(estado);
	}
	
}
