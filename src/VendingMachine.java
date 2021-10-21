import java.util.ArrayList;

public class VendingMachine {

	private int id;
	private boolean estado;
	private boolean lineaVacia = false;
	ArrayList<Linea> lineas = new ArrayList<Linea>();

	/**
	 * @param estado the estado to set
	 */
	public VendingMachine(int identificador, int numlineas, int profundidad) {
		id = identificador;
		estado = true;
		for (int i = 0; i < numlineas; i++) {
			lineas.add(new Linea(null, profundidad));
		}
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public Linea getLinea(int numlinea) {
		return lineas.get(numlinea);
	}

	public boolean getLineaVacia() {
		return lineaVacia;
	}
	
	public void comprobarLinea() {
		for(Linea linea: lineas) {
			if(linea.stock==0) {
				lineaVacia=true;
			}
		}
	}
}
