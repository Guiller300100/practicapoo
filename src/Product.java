import java.security.InvalidParameterException;
import java.time.Instant;

public class Product {

	public double precio;
	public Instant fecha;
	public String nombre;
	public String UPC;

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
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
