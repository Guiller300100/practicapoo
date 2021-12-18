package es.uva.poo.practica;

import java.util.*;

public class Pack extends Vendible {

	private Product[] productosPack;
	private String identificador;
	private final static double descuento = 0.8;

	public Pack(String id, String nom, Product[] p) {
		super(nom, id);
		if (id == null || nom == null || p == null) {
			throw (new IllegalArgumentException("No puede haber parametros nulos"));
		}
		for (Product producto : p) {
			if (producto == null) {
				throw (new IllegalArgumentException("No puede haber productos nulos"));
			}
		}
		if (p.length < 2) {
			throw (new IllegalArgumentException("No tiene el minimo de productos"));
		}
		for (int i = 0; i < p.length - 1; i++) {
			for (int y = i + 1; y < p.length; y++) {
				if (productosPack[i].getUpc().equals(productosPack[y].getUpc())) {
					throw (new IllegalArgumentException("No puede haber productos repetidos en el pack"));
				}
			}
		}
		productosPack = p;
		identificador = id;
	}

	@Override
	public double getPrecio() {
		double precioTotal = 0.0;
		for (int i = 0; i < productosPack.length; i++) {
			precioTotal += productosPack[i].getPrecio();
		}
		return (descuento * precioTotal);
	}

	public int numeroProductos() {
		return productosPack.length;
	}

	public boolean comprobarProducto(String upc) {
		for (Product producto : productosPack) {
			if (upc.equals(producto.getUpc())) {
				return true;
			}
		}
		return false;
	}

	public List<Product> listaProductos() {
		return Arrays.asList(productosPack);
	}

	public void nuevoProducto(Product p) {
		productosPack = Arrays.copyOf(productosPack, productosPack.length + 1);
		productosPack[productosPack.length - 1] = p;
	}

	public void eliminarProducto(String upc) {
		if (!comprobarProducto(upc)) {
			return;
		}
		Product[] nuevoPack = new Product[productosPack.length - 1];
		int i = 0;
		for (Product p : productosPack) {
			if (!p.getUpc().equals(upc)) {
				nuevoPack[i] = p;
				i++;
			}
		}
		productosPack = nuevoPack;
	}

	public String getIdentificador() {
		return identificador;
	}


}
