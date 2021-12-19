package es.uva.poo.practica;

import java.util.*;

/**
 * Representa las funcionalidades y atributos de un pack de productos, el cual
 * es un vendible que esta dentro de la maquina.
 * 
 * @author guirodr
 */

public class Pack extends Vendible {

	private Product[] productosPack;
	private String identificador;
	private final static double descuento = 0.8;

	/**
	 * Crea un nuevo pack de productos con un identificador, un nombre.
	 * 
	 * @author guirodr
	 * @param id 	cadena de caracteres el cual representa el identificador unico del pack.
	 * @param nom 	cadena de caracteres el cual representa el nombre del pack.
	 * @param p 	array de objetos producto los cuales son los que van a estar dentro del pack, pero sin haber ninguno repetido
	 * 
	 * @throws IllegalArgumentException si alguno de los parametros es nulo.
	 * @throws IllegalArgumentException Si alguno de los elementos del array es nulo.
	 * @throws IllegalArgumentException Si el array solo tiene un producto, ya que para ser un pack tiene que ser como minimo
	 * 									dos productos.
	 * @throws IllegalArgumentException Si hay algun producto repetido dentro del array que ha entrado como parametro
	 */
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
				if (p[i].getUpc().equals(p[y].getUpc())) {
					throw (new IllegalArgumentException("No puede haber productos repetidos en el pack"));
				}
				
			}
		}
		productosPack = p;
		identificador = id;
	}

	/**
	 * Se obtiene el precio del pack realizando el descuento.
	 * 
	 * @author guirodr
	 * @return double con el precio del pack. 
	 */
	
	@Override
	public double getPrecio() {
		double precioTotal = 0.0;
		for (int i = 0; i < productosPack.length; i++) {
			precioTotal += productosPack[i].getPrecio();
		}
		return (descuento * precioTotal);
	}

	/**
	 * Se obtiene el numero de productos que tiene el pack
	 * 
	 * @return numero entero que representa el numero total de productos dentro del pack
	 */
	public int numeroProductos() {
		return productosPack.length;
	}

	/**
	 * Comprueba si un producto esta dentro del pack o no.
	 * 
	 * @param upc	identificador del producto que queremos saber si esta en el pack
	 * @return variable booleana que indica si el producto esta (true) o no (false).
	 */
	public boolean comprobarProducto(String upc) {
		for (Product producto : productosPack) {
			if (upc.equals(producto.getUpc())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Te devuelve una lista con los productos que estan dentro del pack
	 * 
	 * @return lista con todos los productos que estan en el pack.
	 */

	public List<Product> listaProductos() {
		return Arrays.asList(productosPack);
	}
	
	/**
	 * Añadimos un producto al pack.
	 * 
	 * @param p producto que queremos añadir al pack
	 * @throws IllegalArgumentException Si el producto que queremos meter ya esta dentro del pack
	 */

	public void nuevoProducto(Product p) {
		for (Product producto : productosPack) {
			if(producto.getUpc().equals(p.getUpc())) {
				throw (new IllegalArgumentException("No puede haber productos repetidos en el pack"));
			}
		}
		
		productosPack = Arrays.copyOf(productosPack, productosPack.length + 1);
		productosPack[productosPack.length - 1] = p;
	}

	
	/**
	 * Eliminamos un producto del pack
	 * @param upc	identificador del producto que queremos borrar
	 */
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
	
	/**
	 * Devuelve el identificador unico del pack
	 * @return identificador cadena de caracteres que representan el codigo unico del pack
	 */

	public String getIdentificador() {
		return identificador;
	}


}
