import java.util.*;

public class VendingSystem {

	public HashMap<Integer, VendingMachine> maquinas = new HashMap<Integer, VendingMachine>();

	public VendingSystem() {

	}

	public int MaquinasOperativas() {
		int total=0;
		for(int i =0; i<maquinas.size();i++) {
			if(maquinas.get(i).getEstado()) {
				total++;
			}
		}
		return total;
	}
	public void ListaMaquinas() {
		maquinas.values();
	}

	public void NuevaMaquina(int id) {
		if (maquinas.containsKey(id)) {

		} else {
			VendingMachine maquina = new VendingMachine(id);
			maquinas.put(id, maquina);
		}

	}

	public void BorrarMaquina(int clave) {
		maquinas.remove(clave);
	}

}
