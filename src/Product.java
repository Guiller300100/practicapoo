import java.security.InvalidParameterException;
import java.time.Instant;

/**
 * Representa las funcionalidades y atributos de un producto, el cual se puede encontrar en una 
 * línea de una máquina en una cantidad menor o igual a la cantidad máxima definida por la línea 
 * en cuestión.
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
	 * @param cod
	 * @param nom							String que indica el nombre del producto
	 * @param fecha							fecha de consumo preferente del producto
	 * @param precio						número de tipo doble que indica el precio del producto
	 * @throws InvalidParameterException	si el dígito de control del UPC dado no verifica su validez
	 */
	public Product(String cod, String nom, Instant fecha, double precio) {
		if (cod.length() != 12) {
			throw (new InvalidParameterException("Tamaño UPC erroneo"));
		} else {
			double suma = 0;
			for (int i = 0; i < cod.length() - 1; i++) {
				if (i % 2 == 0) {
					suma = Character.getNumericValue(cod.charAt(i)) * 3 + suma;
				} else {
					suma = Character.getNumericValue(cod.charAt(i)) + suma;
				}
			}
			if (Character.getNumericValue(cod.charAt(cod.length() - 1)) != Math.abs(suma - Math.ceil(suma))) {
				throw (new InvalidParameterException("UPC introducido es erroneo"));
			} else {
				UPC = cod;
				nombre = nom;
				this.fecha = fecha;
				this.precio = precio;
			}
		}
	}

	/**
	 * Devuelve el precio de un producto.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @return precio		número de tipo doble representando el precio del producto tratado
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de un producto.
	 * 
	 * @author guirodr
	 * @author josbarb
	 * @param precio		número de tipo doble representando el nuevo precio del producto tratado
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
