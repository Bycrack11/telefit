package telefit.gimnasio; //definir el package

import telefit.usuarios.Monitor;
import telefit.excepciones.TelefitException;
import telefit.excepciones.UsuarioException;
import java.util.*;
import telefit.actividades.*;


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
			Sala nuevaSala = new Sala(sid, cap, lta); // crea nuevo objeto sala si Id es unico
			salas.put(sid, nuevaSala); //añade la sala al mapa de salas

		}
	}


	//REGRISTRAR ACTIVIDAD

	public void registrarActividad(TipoActividad ta, Dia d, Turno t, int capmin, Monitor mon) 
			throws TelefitException, UsuarioException {
		
		Sala salaDisponible = null; //inicializar a 0
		
		/**
		 * 1. sala disponible en dia y turno
		 * 2. sala con capacidad mayor o igual a la minima
		 * 3. sala permite tipo de actividad
		 */
		
		
		for (Sala sala : salas.values()) { //<String, Sala>, nombre random, <> salas
			if (sala.disponibilidad(d, t) && sala.getCapacidad() >= capmin && sala.getTiposPermitidos().contains(ta)) { 

				salaDisponible = sala; //encontramos sala que cumpla todo
				break;
			}   
		}

		if (salaDisponible == null) { //error si salaDisponible sigue siendo nula
			throw new TelefitException ("No hay ninguna sala disponible en ese horario para la actividad " + ta + " y con capacidad suficiente");
		}

		if (!mon.disponibilidad(d,t)) { //error si el monitor no tiene disponibilidad
			throw new TelefitException("El usuario "+ mon.getNombre() + " no tiene disponibilidad en ese turno");
		}

		salaDisponible.nuevaActividad(ta, d, t, mon); //añadimos actividad a la salaDisponile
		Actividades nuevaActividad = new Actividades (d, t, ta, capmin, salaDisponible, mon); //crear actividad 
		mon.agregarActividad(nuevaActividad); //guardar  en monitor
	}

	//GET AGENDA SALA

	public String getAgendaSala(String sid) 
			throws TelefitException {
		if(!salas.containsKey(sid)) // ! sirve para decir lo contrario
			throw new TelefitException("No existe la sala " + sid); 
		return salas.get(sid).getAgenda();

	}
}




