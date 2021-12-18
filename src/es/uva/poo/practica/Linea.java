package es.uva.poo.practica;

/**
 * @author guirodr
 * 
 *         Representa las funcionalidades y atributos de una línea, la cual se
 *         encuentra en una máquina y contiene un cierto número de un tipo de
 *         vendible que puede como máximo alcanzar un valor máximo.
 * 
 * @author guirodr
 * @author josbarb
 */
public class Linea {

	private Vendible vendible;
	private int stock;
	private int maxStock;

	/**
	 * Crea una nueva línea vacía con las características indicadas.
	 * 
	 * @author guirodr
	 * @param vendible    vendible contenido en la línea
	 * @param profundidad número entero indicando el máximo de productos que puede
	 *                    contener la línea
	 * @throws IllegalArgumentException si la máxima capacidad de la línea es nula
	 *                                  o negativa
	 */
	public Linea(Product vendible, int profundidad) {
		if (profundidad > 0) {
			this.setProducto(vendible);
			maxStock = profundidad;
		} else
			throw new IllegalArgumentException("la profundidad es erronea");
	}

	/**
	 * Rellena una línea de vendibles al igualar el número de vendibles contenidos
	 * con el máximo posible para dicha línea.
	 * 
	 * @author guirodr
	 * @param vendible vendible de la línea a rellenar
	 * @throws IllegalArgumentException si el vendible es nulo
	 */
	public void rellenar(Vendible vendible) {
		if (vendible == null) {
			throw new IllegalArgumentException("Producto nulo");
		} else {
			this.setProducto(vendible);
			setStock(maxStock);
		}
	}

	/**
	 * Decrementa el número de vendibles contenidos en una línea de 1.
	 * 
	 * @author guirodr
	 */
	public void vendibleComprado() {
		setStock(getStock() - 1);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Vendible getVendible() {
		return vendible;
	}

	public void setProducto(Vendible vendible) {
		this.vendible = vendible;
	}

	public int getmaxStock() {
		return maxStock;
	}

}
