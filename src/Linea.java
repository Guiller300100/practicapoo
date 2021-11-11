/**
 * Representa las funcionalidades y atributos de una línea, la cual se encuentra
 * en una máquina y contiene un cierto número de un tipo de producto que puede
 * como máximo alcanzar un valor tope.
 * 
 * @author guirodr
 * @author josbarb
 */
public class Linea {

	public Product producto;
	public int stock;
	public int maxStock;

	/**
	 * Crea una nueva línea vacía con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param producto    producto contenido en la línea
	 * @param profundidad número entero indicando el máximo de productos que puede
	 *                    contener la línea
	 */
	public Linea(Product producto, int profundidad) {
		if (profundidad > 0) {
			this.producto = producto;
			maxStock = profundidad;
		} else
			throw new IllegalArgumentException("la profundidad es erronea");
	}

	/**
	 * Rellena una línea de productos al igualar el número de productos contenidos
	 * con el máximo posible para dicha línea.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param producto producto de la línea a rellenar
	 */
	public void rellenar(Product producto) {
		if (producto == null) {
			throw new IllegalArgumentException("Producto nulo");
		} else {
			this.producto = producto;
			stock = maxStock;
		}
	}

	/**
	 * Decrementa el número de productos contenidos en una línea de 1.
	 * 
	 * @author guirodr
	 * @author josbarb
	 */
	public void productoComprado() {
		// TODO Auto-generated method stub
		stock--;
	}

}
