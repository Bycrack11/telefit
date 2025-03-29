package telefit.gimnasio;

import java.util.List;

import telefit.actividades.Dia;
import telefit.actividades.TipoActividad;
import telefit.actividades.Turno;
import telefit.usuarios.Monitor;

public class Sala { //abstract no deja instanciar

	private String sid; 
	private int capacidad; 
	private List<TipoActividad> lta;
	


	public Sala(String sid, int cap, List<TipoActividad> lta) {
		this.sid = sid; //para ambiguedades usar "this" para que este se refiera
		capacidad = cap;
		this.lta = lta;
		
	}


	
	
	//NUEVA ACTIVIDAD
	
	public void nuevaActividad(TipoActividad ta, Dia d, Turno t, Monitor mon) {
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Método que devuelve la id
	 * 
	 * @return id
	 */
	public  String getSid() {
		return sid;
	}

	/**
	 * Método que devuelve la capacidad
	 * 
	 * @return capacidad
	 */
	public  int getCapacidad() {
		return capacidad;
	}

	
	
	//GET Agenda
	
	public String getAgenda() {
		return agenda;///AGENDA
	}
	
	/**
	 * Método que devuelve una descripción de la sala
	 * 
	 * @return descripción
	 */
	@Override
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		String cadena = "Sala: " + getSid() + 
				"\n Capacidad: " + getCapacidad();
		return cadena;
	}

	
	public boolean disponibilidad(Dia d, Turno t) {
		for (//array actividades?)
	}



}

//Import telefit.gimnasio.Sala en la PruebasTelefit1




