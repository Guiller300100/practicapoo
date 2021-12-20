package es.uva.poo.practica;

public abstract class Vendible {

	/**
	 * Clase abstracta que hereda a Pack y Product.
	 * Representa las funcionalidades y atributos de un vendible, el cual se almacena
	 * en las lineas de una maquina.
	 * 
	 * @author guirodr
	 */
	
	private String nombre;
	private String id;
	
	/**
	 * Crea un Vendible con un nombre y un identificador
	 * @param nom Cadena de caracteres que representa el nombre del Vendible
	 * @param cod Cadena de caracteres que representa el identificador del Vendible
	 */
	public Vendible(String nom, String cod) {
		nombre = nom;
		id = cod;
	}
	
	/**
	 * Devuelve el identificador del Vendible
	 * 
	 * @return id Cadena de caracteeres que representa el identificador
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo abstracto que devuelve el precio.
	 * 
	 * @return un numero double que representa el precio.
	 */
	public abstract double getPrecio();


	/**
	 * Devuelve el nombre del Vendible
	 * 
	 * @return nombre Cadena de caracteeres que representa el nombre del Vendible
	 */
	
	public  String getNombre() {
		return nombre;
	}
	
	/**
	 * Modifica el nombre del Vendible.
	 * @param nombre Cadena que representa el nombre del Vendible.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
