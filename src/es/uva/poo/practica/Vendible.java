package es.uva.poo.practica;

public abstract class Vendible {

	private String nombre;
	private String upc;
	
	protected Vendible(String nom, String id) {
		nombre = nom;
		upc = id;
	}
	

	public String getNombre() {
		return nombre;
	}
	
	public String getUpc() {
		return upc;
	}
	
	public abstract double getPrecio();
}
