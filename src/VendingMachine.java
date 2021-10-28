import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.omg.CORBA.DynAnyPackage.Invalid;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachine {

	private int id;
	private boolean estado;
	private boolean lineaVacia = false;
	private static String credencial_compra = "6Z1y00Nm31aA-571";
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
	
	public void Compra(TarjetaMonedero t, int numlinea) {
		if(t.getSaldoActual()!=0.0) {
			comprobarLinea();
			if(!lineaVacia) {
				lineas.get(numlinea).ProductoComprado();
				t.descontarDelSaldo(credencial_compra, lineas.get(numlinea).producto.getPrecio());
			}
		}else {
			throw(new InvalidParameterException("Tarjeta sin saldo"));
		}
	}
}
