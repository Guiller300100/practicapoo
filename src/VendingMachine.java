import java.security.InvalidParameterException;
import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Representa las funcionalidades y atributos de una máquina vending, la cual
 * contiene una serie de líneas con productos y forma parte de una red de
 * máquinas vending. La string credencial_compra da permiso a la máquina para
 * descontar saldo de la tarjeta monedero del cliente.
 * 
 * @author guirodr
 * @author josbarb
 */
public class VendingMachine {

	private int id;
	private boolean estado;
	private boolean lineaVacia;
	private static String credencial_compra = "6Z1y00Nm31aA-571";
	ArrayList<Linea> lineas = new ArrayList<Linea>();

	/**
	 * Crea una nueva máquina vending con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param identificador número entero indicando el número identificador de la
	 *                      máquina
	 * @param numlineas     número entero indicando el número de líneas contenidas
	 *                      en la máquina
	 * @param profundidad   número entero indicando el número máximo de productos de
	 *                      un mismo tipo que pueden ser contenidos por cada línea
	 *                      de la máquina
	 */
	public VendingMachine(int identificador, int numlineas, int profundidad) {
		if (identificador >= 0 && numlineas > 0 && profundidad > 0) {
			id = identificador;
			estado = true;
			lineaVacia = true;
			for (int i = 0; i < numlineas; i++) {
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
	 * @author josbarb
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
	 * @author josbarb
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
	 * @author josbarb
	 * @param numlinea número entero indicando el índice de una línea en la máquina
	 *                 tratada
	 * @return lineas.get(numlinea) línea correspondiente al índice numlinea en el
	 *         conjunto de lineas correspondiente a la máquina tratada
	 */
	public Linea getLinea(int numlinea) {
		return lineas.get(numlinea);
	}

	/**
	 * Comprueba si la máquina contiene alguna línea vacía y si es el caso da valor
	 * true a la booleana indicando la presencia de líneas vacías.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return lineaVacia Devuelve la variable booleana lineaVacia donde indica si
	 *         la maquina tiene al menos una linea vacia o no
	 */
	public boolean comprobarLineas() {
		for (Linea linea : lineas) {
			if (linea.stock == 0) {
				lineaVacia = true;
				return lineaVacia;
			} else
				lineaVacia = false;
		}
		return lineaVacia;
	}

	/**
	 * Rellena completamente una línea de la máquina referida con un cierto
	 * producto.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param producto producto con el que rellenar la línea
	 * @param numlinea número entero indicando el índice de una línea en la máquina
	 *                 tratada
	 */

	public void rellenarLinea(Product producto, int numlinea) {
		if (producto == null) {
			throw (new IllegalArgumentException("Producto es nulo"));
		} else {
			if (numlinea < 0 || numlinea >= lineas.size()) {
				throw (new IllegalArgumentException("Numero de linea mal introducida"));
			} else {

				getLinea(numlinea).rellenar(producto);
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
	 * @author josbarb
	 * @param t        tarjeta monedero con la que el cliente desea comprar el
	 *                 producto.
	 * @param numlinea variable entera indicando la línea de la que se está
	 *                 comprando un producto.
	 * @throws InvalidParameterException si la tarjeta no tiene saldo
	 * @throws InvalidParameterException si la línea de la que se quiere comprar
	 *                                   está vacía
	 * @see getSaldoActual
	 * @see comprobarLinea
	 * @see productoComprado
	 * @see descontarDelSaldo
	 */
	public void compra(TarjetaMonedero t, int numlinea) {
		if (t == null) {
			throw (new IllegalArgumentException("Tarjeta es nula"));
		} else {
			if (t.getSaldoActual() != 0.0) {
				if (!comprobarLinea(numlinea)) {
					if (lineas.get(numlinea).producto.getPrecio() > t.getSaldoActual()) {
						throw (new IllegalArgumentException("Tarjeta sin saldo suficiente"));
					} else {
						lineas.get(numlinea).productoComprado();
						t.descontarDelSaldo(credencial_compra, lineas.get(numlinea).producto.getPrecio());
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
	 * Este es para comprobar si una linea sola esta vacia o no
	 * 
	 * @param linea
	 * @return
	 */
	public boolean comprobarLinea(int linea) {
		if (linea < 0) {
			throw (new IllegalArgumentException("Línea negativa"));
		} else {
			if (getLinea(linea).stock == 0) {
				return true;
			} else
				return false;
		}
	}
}
