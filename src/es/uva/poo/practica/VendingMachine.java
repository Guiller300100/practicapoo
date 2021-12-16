package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Representa las funcionalidades y atributos de una máquina vending, la cual
 * contiene una serie de líneas con productos y forma parte de una red de
 * máquinas vending. La string credencial_compra da permiso a la máquina para
 * descontar saldo de la tarjeta monedero del cliente.
 * 
 * @author guirodr
 */
public class VendingMachine {

	private int id;
	private boolean estado;
	ArrayList<Linea> lineas = new ArrayList<>();

	/**
	 * Crea una nueva máquina vending con las características indicadas.
	 * 
	 * @author guirodr
	 * @param identificador número entero indicando el número identificador de la
	 *                      máquina
	 * @param numLineas     número entero indicando el número de líneas contenidas
	 *                      en la máquina
	 * @param profundidad   número entero indicando el número máximo de productos de
	 *                      un mismo tipo que pueden ser contenidos por cada línea
	 *                      de la máquina
	 * @throws IllegalArgumentException si el identificador es negativo, o el número
	 *                                  de líneas o la profundidad no son positivos
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
	 * Modifica el estado de una máquina.
	 * 
	 * @author guirodr
	 * @param estado variable booleana indicando si la máquina está operativa (valor
	 *               true) o fuera de servicio (valor false)
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el estado de una máquina.
	 * 
	 * @author guirodr
	 * @return estado variable booleana indicando si la máquina está operativa
	 *         (valor true) o fuera de servicio (valor false)
	 */
	public boolean getEstado() {
		return this.estado;
	}

	/**
	 * Devuelve la línea correspondiente al índice indicado.
	 * 
	 * @author guirodr
	 * @param numLinea número entero indicando el índice de una línea en la máquina
	 *                 tratada
	 * @return lineas.get(numlinea) línea correspondiente al índice numlinea en el
	 *         conjunto de lineas correspondiente a la máquina tratada
	 */
	public Linea getLinea(int numLinea) {
		return lineas.get(numLinea);
	}

	/**
	 * Comprueba si la máquina contiene alguna línea vacía y si es el caso da valor
	 * true a la booleana indicando la presencia de líneas vacías.
	 * 
	 * @author guirodr
	 * @return lineaVacia variable booleana indicando si la máquina tiene al menos
	 *         una línea vacía o no
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
	 * Rellena completamente una línea de la máquina referida con un cierto
	 * producto.
	 * 
	 * @author guirodr
	 * @param producto producto con el que rellenar la línea
	 * @param numLinea número entero indicando el índice de una línea en la máquina
	 *                 tratada
	 * @throws IllegalArgumentException si el producto es nulo
	 * @throws IllegalArgumentException si la línea es negativa
	 */

	public void rellenarLinea(Vendible producto, int numLinea) {
		if (producto == null) {
			throw (new IllegalArgumentException("Producto es nulo"));
		} else {
			if (numLinea < 0 || numLinea >= lineas.size()) {
				throw (new IllegalArgumentException("Número de línea mal introducido"));
			} else {
				getLinea(numLinea).rellenar(producto);
				this.comprobarLineas();
			}
		}
	}

	/**
	 * Realiza la compra en de un producto contenido en una de las líneas de una
	 * máquina, en caso de que sea posible (saldo suficiente y línea conteniendo el
	 * producto no estando vacía).
	 * 
	 * @author guirodr
	 * @param t                tarjeta monedero con la que el cliente desea comprar
	 *                         el producto.
	 * @param numLinea         variable entera indicando la línea de la que se está
	 *                         comprando un producto.
	 * @param credencialCompra cadena de caracteres componiendo el credencial
	 *                         necesario para descontar saldo de la tarjeta monedero
	 * @throws IllegalArgumentException si la tarjeta es nula
	 * @throws IllegalArgumentException si la tarjeta no tiene saldo
	 * @throws IllegalArgumentException si la línea de la que se quiere comprar está
	 *                                  vacía
	 * @see TarjetaMonedero#getSaldoActual()
	 * @see VendingMachine#comprobarLinea(int)
	 * @see Linea#productoComprado()
	 * @see TarjetaMonedero#descontarDelSaldo(String, double)
	 */
	public void compra(TarjetaMonedero t, int numLinea, String credencialCompra) {
		if (t == null) {
			throw (new IllegalArgumentException("Tarjeta es nula"));
		} else {
			if (t.getSaldoActual() != 0.0) {
				if (!comprobarLinea(numLinea)) {
					if (lineas.get(numLinea).getProducto().getPrecio() > t.getSaldoActual()) {
						throw (new IllegalArgumentException("Tarjeta sin saldo suficiente"));
					} else {
						lineas.get(numLinea).productoComprado();
						t.descontarDelSaldo(credencialCompra, lineas.get(numLinea).getProducto().getPrecio());
					}
				} else {
					throw (new IllegalArgumentException("Línea vacía"));
				}
			} else {
				throw (new IllegalArgumentException("Tarjeta sin saldo"));
			}
		}
	}

	/**
	 * Devuelve una variable booleana indicando si una línea está vacía o no.
	 * 
	 * @param numLinea número entero indicando la línea a comprobar
	 * @return variable booleana indicando si la línea está vacía (true) o no
	 *         (false)
	 * @throws IllegalArgumentException si el número indicando la línea es negativo
	 */

	public boolean comprobarLinea(int numLinea) {
		if (numLinea < 0) {
			throw (new IllegalArgumentException("Línea negativa"));
		}
		boolean r;
		if (getLinea(numLinea).getStock() == 0) {
			r = true;
		} else {
			r = false;
		}
		return r;

	}

	public int getId() {
		return id;
	}
}
