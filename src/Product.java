import java.security.InvalidParameterException;
import java.time.Instant;

/**
 * Representa las funcionalidades y atributos de un producto, el cual se puede
 * encontrar en una línea de una máquina en una cantidad menor o igual a la
 * cantidad máxima definida por la línea en cuestión.
 * 
 * @author guirodr
 * @author josbarb
 */
public class Product {

	public double precio;
	public Instant fecha;
	public String nombre;
	public String UPC;

	/**
	 * Crea un nuevo producto con las características indicadas.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param cod							cadena de caracteres correspondiendo al número entero 
	 * 										identificador de un producto
	 * @param nom   						String que indica el nombre del 
	 * 										producto
	 * @param fecha							fecha de consumo preferente del 
	 * 										producto
	 * @param precio						número de tipo doble que indica el 
	 * 										precio del producto
	 * @throws IllegalArgumentException 	si alguna de las características del 
	 * 										producto son nulas
	 * @throws IllegalArgumentException 	si el dígito de control del UPC dado no
	 *                                   	verifica su validez
	 */
	public Product(String cod, String nom, Instant fecha, double precio) {
		if (cod == null || nom == null || fecha == null) {
			throw new IllegalArgumentException("Argumento mal introducido");
		} else {
			if (validarUPC(cod)) {
				UPC = cod;
				nombre = nom;
				this.fecha = fecha;
				this.precio = precio;
			} else {
				throw new IllegalArgumentException("UPC introducido es erróneo");
			}
		}
	}

	/**
	 * Devuelve el precio de un producto.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return precio		número de tipo doble representando el precio del 
	 * 						producto tratado
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de un producto.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param precio						número de tipo doble representando el 
	 * 										nuevo precio del producto tratado
	 * @throws IllegalArgumentException		si el precio no tiene valor positivo o 
	 * 										nulo
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
	 * @param UPC	cadena de caracteres correspondiendo al número entero 
	 * 				identificador de un producto
	 * @return 	variable booleana indicando si el UPC identificador de un producto
	 *		   	es válido (true) o no (false)
	 */

	public boolean validarUPC(String UPC) {
		if (UPC.length() != 12 || Double.parseDouble(UPC) < 0) {
			return false;
		} else {
			double suma = 0;
			double redondeo = 0;
			for (int i = 0; i < UPC.length() - 1; i++) {
				if (i % 2 == 0) {
					suma = Character.getNumericValue(UPC.charAt(i)) * 3 + suma;
				} else {
					suma = Character.getNumericValue(UPC.charAt(i)) + suma;
				}
			}
			if (suma % 10 != 0) {
				redondeo = Math.ceil(suma / 10);
				redondeo = redondeo * 10;
			} else {
				redondeo = suma;
			}
			if (Character.getNumericValue(UPC.charAt(UPC.length() - 1)) != Math.abs(suma - redondeo)) {
				return false;
			} else {
				return true;
			}
		}
	}
}