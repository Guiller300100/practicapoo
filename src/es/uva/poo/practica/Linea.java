package es.uva.poo.practica;

/**
 * @author guirodr
 * 
 *         Representa las funcionalidades y atributos de una linea, la cual se
 *         encuentra en una maquina y contiene un cierto numero de un tipo de
 *         vendible que puede como maximo alcanzar un valor maximo.
 * 
 * @author guirodr
 */
public class Linea {

	private Vendible vendible;
	private int stock;
	private int maxStock;

	/**
	 * Crea una nueva linea vacia con las caracteristicas indicadas.
	 * 
	 * @author guirodr
	 * @param vendible    vendible contenido en la linea
	 * @param profundidad numero entero indicando el maximo de productos que puede
	 *                    contener la linea
	 * @throws IllegalArgumentException si la maxima capacidad de la linea es nula
	 *                                  o negativa
	 */
	public Linea(Product vendible, int profundidad) {
		if (profundidad > 0) {
			this.setVendible(vendible);
			maxStock = profundidad;
		} else
			throw new IllegalArgumentException("la profundidad es erronea");
	}

	/**
	 * Rellena una linea de vendibles al igualar el numero de vendibles contenidos
	 * con el maximo posible para dicha linea.
	 * 
	 * @author guirodr
	 * @param vendible vendible de la linea a rellenar
	 * @throws IllegalArgumentException si el vendible es nulo
	 */
	public void rellenar(Vendible vendible) {
		if (vendible == null) {
			throw new IllegalArgumentException("Producto nulo");
		} else {
			this.setVendible(vendible);
			setStock(maxStock);
		}
	}

	/**
	 * Decrementa el numero de vendibles contenidos en una linea de 1.
	 * 
	 * @author guirodr
	 */
	public void vendibleComprado() {
		setStock(getStock() - 1);
	}
	
	/**
	 * Devuelve el stock que tiene la linea en ese momento
	 * 
	 * @return stock numero entero que representa la cantidad de vendibles que quedan
	 */

	public int getStock() {
		return stock;
	}
	
	/**
	 * Rellena el stock contenido en la linea
	 * 
	 * @param stock entero que representa la cantidad de vendibles que hay en la linea
	 */

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Devuelve el objeto vendible que se encuentra en la linea
	 * 
	 * @return vendible objeto que se encuentra en la linea
	 */

	
	public Vendible getVendible() {
		return vendible;
	}

	/**
	 * Cambia el Vendible contenido en la linea
	 * 
	 * @param vendible Vendible que representa el vendible que se va a meter en una linea
	 */
	
	public void setVendible(Vendible vendible) {
		this.vendible = vendible;
	}
	
	/**
	 * Devuelve la profundidad que tiene la linea
	 * 
	 * @return maxStock numero entero que representa la cantidad de vendibles que puede llegar a almacenar la linea
	 */


	public int getmaxStock() {
		return maxStock;
	}

}
