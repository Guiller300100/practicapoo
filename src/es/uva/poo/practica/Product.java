package es.uva.poo.practica;

/**
 * @author guirodr
 **/


import java.util.GregorianCalendar;

/**
 * Representa las funcionalidades y atributos de un producto, el cual se puede
 * encontrar en una línea de una máquina en una cantidad menor o igual a la
 * cantidad máxima definida por la línea en cuestión.
 * 
 * @author guirodr
 * @author josbarb
 */
public class Product extends Vendible {

	private double precio;
	private GregorianCalendar fecha;
	private String nombre;
	private String upc;

	/**
	 * Crea un nuevo producto con las características indicadas.
	 * 
	 * @author guirodr
	 * @param cod    cadena de caracteres correspondiendo al número entero
	 *               identificador de un producto
	 * @param nom    String que indica el nombre del producto
	 * @param fecha  fecha de consumo preferente del producto
	 * @param precio número de tipo doble que indica el precio del producto
	 * @throws IllegalArgumentException si alguna de las características del
	 *                                  producto son nulas
	 * @throws IllegalArgumentException si el dígito de control del UPC dado no
	 *                                  verifica su validez
	 */
	public Product(String cod, String nom, GregorianCalendar caducidad, double precio) {
		super(nom, cod);
		if (cod == null || nom == null || caducidad == null) {
			throw new IllegalArgumentException("Argumento mal introducido");
		} else {
			if (validarUPC(cod)) {
				setUpc(cod);
				this.nombre = nom;
				fecha = caducidad;
				setPrecio(precio);
			} else {
				throw new IllegalArgumentException("UPC introducido es erróneo");
			}
		}
	}

	/**
	 * Devuelve el precio de un producto.
	 * 
	 * @author guirodr
	 * @return precio número de tipo doble representando el precio del producto
	 *         tratado
	 */
	@Override
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de un producto.
	 * 
	 * @author guirodr
	 * @param precio número de tipo doble representando el nuevo precio del producto
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
	 * producto es válido o no.
	 * 
	 * @param UPC cadena de caracteres correspondiendo al número entero
	 *            identificador de un producto
	 * @return variable booleana indicando si el UPC identificador de un producto es
	 *         válido (true) o no (false)
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

	@Override
	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}