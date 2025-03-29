package telefit.usuarios;

public class Socio extends Usuario {
		
	/**
	 * Constructor que crea una instancia de esta clase	 * 
	 * @param login (ÚNICO)
	 * @param clave (en claro)
	 * @param nombre
	 */
	public Socio(String l, String c, String n) {
		super(l, c, n);
	}
	
	/**
	 * Método que devuelve una descripción del socio
	 * 
	 * @return descripción
	 */
	@Override
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		String cadena = super.toString();
		cadena += "\n Tipo: Socio";
		return cadena;
	}
}
