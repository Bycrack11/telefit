package telefit.gimnasio; //definir el package


import telefit.actividades.TipoActividad; //importar
import telefit.usuarios.Monitor;
import telefit.excepciones.TelefitException;
import telefit.excepciones.UsuarioException;
import java.util.*;
import telefit.actividades.Dia;
import telefit.actividades.Turno;

public class Gimnasio {

	/**
	 * Mapa de salas del sistema
	 */
	private Map<String, Sala> salas;
	/**
	 * Constructor que inicializa el mapa de usuarios
	 */
	public Gimnasio() {
		// inicializo mapa de salas
		salas = new HashMap<>();
	}

	public void crearSala(String sid, int cap, List<TipoActividad> lta) 
			throws TelefitException{
		//if para comprobar repeticiones de sid (ID sala) [soltar error si hay repe]
		if(salas.containsKey(sid)) 
			throw new TelefitException("Ya existe la sala " + sid);
		else {
			Sala nuevaSala = new Sala(sid, cap, lta); // lista TipoActividades (lta)
			salas.put(sid, nuevaSala);

		}
	}



	//REGRISTRAR ACTIVIDAD

	public void registrarActividad(TipoActividad ta, Dia d, Turno t, int capmin, Monitor mon) 
			throws TelefitException, UsuarioException {
		
		Sala salaDisponible = null;
		
		for (Sala sala : salas.values()) {
			if (sala.disponibilidad(d, t) && sala.getCapacidad() >= capmin && sala.actividadDispo() //falta compararlo con la capacidad y disponibilidad de la sala. Ademas hay que crear sala.disponible, la cual dice si ina sala está disponible para un dia y turno (crear aquí en sala) 
		}
		

	}

	//GET AGENDA SALA

	public String getAgendaSala(String sid) 
			throws TelefitException, UsuarioException {
		if(!salas.containsKey(sid)) // ! sirve para decir lo contrario
			throw new TelefitException("No existe la sala " + sid); 
		return salas.get(sid).getAgenda();

	}





}




