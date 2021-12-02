package es.uva.poo.practica;
/**
 * @author guirodr
 * 
 * Representa las funcionalidades y atributos de una línea, la cual se encuentra
 * en una máquina y contiene un cierto número de un tipo de producto que puede
 * como máximo alcanzar un valor máximo.
 * 
 * @author guirodr
 * @author josbarb
 */
public class Linea {

	private Product producto;
	private int stock;
	private int maxStock;

	/**
	 * Crea una nueva línea vacía con las características indicadas.
	 * 
	 * @author guirodr
	 * @param producto    					producto contenido en la línea
	 * @param profundidad 					número entero indicando el máximo de 
	 * 										productos que puede contener la línea
	 * @throws IllegalArgumentException		si la máxima capacidad de la línea es 
	 * 										nula o negativa
	 */
	public Linea(Product producto, int profundidad) {
		if (profundidad > 0) {
			this.setProducto(producto);
			maxStock = profundidad;
		} else
			throw new IllegalArgumentException("la profundidad es erronea");
	}

	/**
	 * Rellena una línea de productos al igualar el número de productos contenidos
	 * con el máximo posible para dicha línea.
	 * 
	 * @author guirodr
	 * @param producto 						producto de la línea a rellenar
	 * @throws IllegalArgumentException		si el producto es nulo
	 */
	public void rellenar(Product producto) {
		if (producto == null) {
			throw new IllegalArgumentException("Producto nulo");
		} else {
			this.setProducto(producto);
			setStock(maxStock);
		}
	}

	/**
	 * Decrementa el número de productos contenidos en una línea de 1.
	 * 
	 * @author guirodr
	 */
	public void productoComprado() {
		setStock(getStock() - 1);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

}
