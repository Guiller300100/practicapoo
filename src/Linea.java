/**
 * Representa las funcionalidades y atributos de la clase línea, la cual se encuentra
 * en una máquina.
 * 
 * 
 * 
 * 
 * @author guirodr
 * @author josbarb
 */
public class Linea {
	
	public Product producto;
	public int stock;
	public int maxStock;
	
	/**
	 * Crea una línea con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param producto						tipo de producto contenido en la línea
	 * @param profundidad					número máximo de productos que puede contener la línea
	 */
	public Linea(Product producto, int profundidad) {
		this.producto=producto;
		maxStock = profundidad;
	}
	
	/**
	 * Incrementa el número de productos de una línea igualándolo al máximo posible
	 * para dicha línea.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param producto						producto de la línea a rellenar
	 */
	public void Rellenar(Product producto) {
		this.producto=producto;
		stock = maxStock;
	}
	public void ProductoComprado() {
		// TODO Auto-generated method stub
		stock--;
	}

}
