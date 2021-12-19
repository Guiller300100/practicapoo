package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Representa las funcionalidades y atributos de una maquina vending, la cual
 * contiene una serie de lineas con productos y forma parte de una red de
 * maquinas vending.
 * 
 * @author guirodr
 */
public class VendingMachine {

	private int id;
	private boolean estado;
	ArrayList<Linea> lineas = new ArrayList<>();

	/**
	 * Crea una nueva maquina vending con las caracteristicas indicadas.
	 * 
	 * @author guirodr
	 * @param identificador numero entero indicando el numero identificador de la
	 *                      maquina
	 * @param numLineas     numero entero indicando el numero de lineas contenidas
	 *                      en la maquina
	 * @param profundidad   numero entero indicando el numero maximo de productos de
	 *                      un mismo tipo que pueden ser contenidos por cada linea
	 *                      de la maquina
	 * @throws IllegalArgumentException si el identificador es negativo, o el numero
	 *                                  de lineas o la profundidad no son positivos
	 */
	public VendingMachine(int identificador, int numLineas, int profundidad) {
		if (identificador >= 0 && numLineas > 0 && profundidad > 0) {
			id = identificador;
			estado = true;
			for (int i = 0; i < numLineas; i++) {
				lineas.add(new Linea(null, profundidad));
			}
		} else {
			throw (new IllegalArgumentException("Parametros mal introducidos"));
		}
	}

	/**
	 * Modifica el estado de una maquina.
	 * 
	 * @author guirodr
	 * @param estado variable booleana indicando si la maquina esta operativa (valor
	 *               true) o fuera de servicio (valor false)
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el estado de una maquina.
	 * 
	 * @author guirodr
	 * @return estado variable booleana indicando si la maquina esta operativa
	 *         (valor true) o fuera de servicio (valor false)
	 */
	
	public boolean getEstado() {
		return this.estado;
	}

	/**
	 * Devuelve la linea correspondiente al indice indicado.
	 * 
	 * @author guirodr
	 * @param numLinea numero entero indicando el indice de una linea en la maquina
	 *                 tratada
	 * @return lineas.get(numlinea) linea correspondiente al indice numlinea en el
	 *         conjunto de lineas correspondiente a la maquina tratada
	 */
	
	public Linea getLinea(int numLinea) {
		return lineas.get(numLinea);
	}

	/**
	 * Comprueba si la maquina contiene alguna linea vacia y si es el caso da valor
	 * true a la booleana indicando la presencia de lineas vacias.
	 * 
	 * @author guirodr
	 * @return lineaVacia variable booleana indicando si la maquina tiene al menos
	 *         una linea vacia o no
	 */
	public boolean comprobarLineas() {
		boolean v = false;
		for (Linea linea : lineas) {
			if (linea.getStock() == 0) {
				v = true;
				return v;
			} else
				v = false;
		}
		return v;
	}

	/**
	 * Rellena completamente una linea de la maquina referida con un cierto
	 * producto.
	 * 
	 * @author guirodr
	 * @param producto producto con el que rellenar la linea
	 * @param numLinea numero entero indicando el indice de una linea en la maquina
	 *                 tratada
	 * @throws IllegalArgumentException si el producto es nulo
	 * @throws IllegalArgumentException si la linea es negativa
	 */

	public void rellenarLinea(Vendible producto, int numLinea) {
		if (producto == null) {
			throw (new IllegalArgumentException("Producto es nulo"));
		} else {
			if (numLinea < 0 || numLinea >= lineas.size()) {
				throw (new IllegalArgumentException("Número de linea mal introducido"));
			} else {
				getLinea(numLinea).rellenar(producto);
				this.comprobarLineas();
			}
		}
	}

	/**
	 * Realiza la compra en de un producto contenido en una de las lineas de una
	 * maquina, en caso de que sea posible (saldo suficiente y linea conteniendo el
	 * producto no estando vacia).
	 * 
	 * @author guirodr
	 * @param t                tarjeta monedero con la que el cliente desea comprar
	 *                         el producto.
	 * @param numLinea         variable entera indicando la linea de la que se esta
	 *                         comprando un producto.
	 * @param credencialCompra cadena de caracteres componiendo el credencial
	 *                         necesario para descontar saldo de la tarjeta monedero
	 * @throws IllegalArgumentException si la tarjeta es nula
	 * @throws IllegalArgumentException si la maquina donde quiere comprar esta fuera de servicio
	 * @throws IllegalArgumentException si la tarjeta no tiene saldo
	 * @throws IllegalArgumentException si la linea de la que se quiere comprar esta
	 *                                  vacia
	 * @throws IllegalArgumentException si la tarjeta no tiene el saldo suficienta para comprar
	 * @see TarjetaMonedero#getSaldoActual()
	 * @see VendingMachine#comprobarLinea(int)
	 * @see Linea#productoComprado()
	 * @see TarjetaMonedero#descontarDelSaldo(String, double)
	 */
	public void compra(TarjetaMonedero t, int numLinea, String credencialCompra) {
		if (t == null) {
			throw (new IllegalArgumentException("Tarjeta es nula"));
		}
		if (!this.estado) {
			throw (new IllegalArgumentException("Maquina no operativa"));
		}
		if (t.getSaldoActual() == 0.0) {
			throw (new IllegalArgumentException("Tarjeta sin saldo"));
		}
		if (comprobarLinea(numLinea)) {
			throw (new IllegalArgumentException("Linea vacia"));
		}
		if (lineas.get(numLinea).getVendible().getPrecio() > t.getSaldoActual()) {
			throw (new IllegalArgumentException("Tarjeta sin saldo suficiente"));
		}

		lineas.get(numLinea).vendibleComprado();
		t.descontarDelSaldo(credencialCompra, lineas.get(numLinea).getVendible().getPrecio());
	}

	/**
	 * Devuelve una variable booleana indicando si una linea esta vacia o no.
	 * 
	 * @param numLinea numero entero indicando la linea a comprobar
	 * @return variable booleana indicando si la linea esta vacia (true) o no
	 *         (false)
	 * @throws IllegalArgumentException si el numero indicando la linea es negativo
	 */

	public boolean comprobarLinea(int numLinea) {
		if (numLinea < 0) {
			throw (new IllegalArgumentException("Linea negativa"));
		}
		boolean r;
		if (getLinea(numLinea).getStock() == 0) {
			r = true;
		} else {
			r = false;
		}
		return r;

	}

	/**
	 * Devuelve una variable entera indicando el identificador de la maquina
	 *  
	 * @return id variable entera que indica el identificador de la maquina referida
	 */
	
	public int getId() {
		return id;
	}
}
