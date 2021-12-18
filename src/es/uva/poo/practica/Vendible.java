package es.uva.poo.practica;

public abstract class Vendible {

	private String nombre;
	private String id;
	
	public Vendible(String nom, String cod) {
		nombre = nom;
		id = cod;
	}
	
	
	public String getId() {
		return id;
	}
	
	public abstract double getPrecio();


	public  String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
