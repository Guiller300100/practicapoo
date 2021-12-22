package es.uva.poo.practica;

/**
 * @author guirodr
 **/

import java.util.GregorianCalendar;

/**
 * Representa las funcionalidades y atributos de un producto, el cual se puede
 * encontrar en una linea de una maquina en una cantidad menor o igual a la
 * cantidad maxima definida por la linea en cuestion.
 * 
 * @author guirodr
 */
public class Product extends Vendible {

	private double precio;
	private GregorianCalendar fecha;
	private String upc;

	/**
	 * Crea un nuevo producto con las caracteristicas indicadas. Llama al
	 * constructor de Vendible.
	 * 
	 * @author guirodr
	 * @param cod    cadena de caracteres correspondiendo al numero entero
	 *               identificador de un producto
	 * @param nom    String que indica el nombre del producto
	 * @param fecha  fecha de consumo preferente del producto
	 * @param precio numero de tipo doble que indica el precio del producto
	 * @throws IllegalArgumentException si alguna de las caracteristicas del
	 *                                  producto son nulas
	 * @throws IllegalArgumentException si el digito de control del UPC dado no
	 *                                  verifica su validez
	 */
	public Product(String cod, String nom, GregorianCalendar caducidad, double precio) {
		super(nom, cod);
		if (cod == null || nom == null || caducidad == null) {
			throw new IllegalArgumentException("Argumento mal introducido");
		}
		if (!validarUPC(cod)) {
			throw new IllegalArgumentException("UPC introducido es erroneo");
		}
		setUpc(cod);
		fecha = caducidad;
		setPrecio(precio);
	}
	
	/**
	 * Devuelve el precio de un producto.
	 * 
	 * @author guirodr
	 * @return precio numero de tipo doble representando el precio del producto
	 *         tratado
	 * @throws IllegalArgumentException Ha pasado un producto nulo como parametro
	 */
	
	@Override
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de un producto.
	 * 
	 * @author guirodr
	 * @param precio numero de tipo doble representando el nuevo precio del producto
	 *               tratado
	 * @throws IllegalArgumentException si el precio no tiene valor positivo o nulo
	 */
	public void setPrecio(double precio) {
		if (precio < 0) {
			throw (new IllegalArgumentException("El precio tiene que ser 0 o mayor"));
		} else {
			this.precio = precio;
		}
	}

	/**
	 * Devuelve una variable booleana tras determinar si el UPC identificador de un
	 * producto es valido o no.
	 * 
	 * @param UPC cadena de caracteres correspondiendo al numero entero
	 *            identificador de un producto
	 * @return variable booleana indicando si el UPC identificador de un producto es
	 *         valido (true) o no (false)
	 */

	private boolean validarUPC(String upc) {
		boolean r;
		if (upc.length() != 12 || Double.parseDouble(upc) < 0) {
			r = false;
		} else {
			double suma = 0;
			double redondeo = 0;
			for (int i = 0; i < upc.length() - 1; i++) {
				if (i % 2 == 0) {
					suma = Character.getNumericValue(upc.charAt(i)) * 3 + suma;
				} else {
					suma = Character.getNumericValue(upc.charAt(i)) + suma;
				}
			}
			if (suma % 10 != 0) {
				redondeo = Math.ceil(suma / 10);
				redondeo = redondeo * 10;
			} else {
				redondeo = suma;
			}
			if (Character.getNumericValue(upc.charAt(upc.length() - 1)) != Math.abs(suma - redondeo)) {
				r = false;
			} else {
				r = true;
			}
		}
		return r;
	}

	/**
	 * Devuelve el upc del producto.
	 * 
	 * @return upc Cadena de caracteres que representa el upc del producto.
	 */
	public String getUpc() {
		return upc;
	}

	/**
	 * Modifica el upc de un producto.
	 * 
	 * @author guirodr
	 * @param upc Cadena de caracteres que representa el upc que se quiere asignar
	 *            al producto.
	 * @throws IllegalArgumentException si el que se quiere asignar no es valido
	 */

	public void setUpc(String upc) {
		if (!validarUPC(upc)) {
			throw (new IllegalArgumentException("El upc no es valido"));
		}
		this.upc = upc;
	}

	/**
	 * Devuelve la fecha de caducidad del producto.
	 * 
	 * @return fecha GregorianCalendar que representa la fecha de caducidad de un
	 *         producto
	 */

	public GregorianCalendar getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha de caducidad de un producto.
	 * 
	 * @param fecha GregorianCalendar que representa la fecha de caducidad que
	 *              queremos poner a un producto.
	 * @throws IllegalArgumentException si la fecha introducida es nula
	 */

	public void setFecha(GregorianCalendar fecha) {
		if (fecha == null) {
			throw (new IllegalArgumentException("La fecha introducida es nula"));
		}
		this.fecha = fecha;
	}

}