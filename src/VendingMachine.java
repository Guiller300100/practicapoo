
public class VendingMachine {

	private int id;
	private boolean estado;
	private static int maximostock=10;
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public  boolean getEstado() {
		return this.estado;
	}
	
	public VendingMachine(int identificador) {
		id=identificador;
		estado=true;
	}

}
