public class Linea {
	
	public Product producto;
	public int stock;
	public int maxStock;
	
	public Linea(Product producto, int profundidad) {
		this.producto=producto;
		maxStock = profundidad;
	}
	public void Rellenar(Product producto) {
		this.producto=producto;
		stock = maxStock;
	}
	public void ProductoComprado() {
		// TODO Auto-generated method stub
		stock--;
	}

}
