package telefit.excepciones;

public class TelefitException extends Exception {

	/** Las clases que derivan de Exception deben tener un atributo como éste */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor para crear una excepción relativa a salas
	 * @param causa de la excepción
	 */
	public TelefitException(String causa) {
		super(causa);
	}
}
