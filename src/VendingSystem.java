import java.util.*;

public class VendingSystem {

	public HashMap<Integer, VendingMachine> maquinas = new HashMap<Integer, VendingMachine>();

	public VendingSystem() {

	}

	public void ListaMaquinas() {

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
