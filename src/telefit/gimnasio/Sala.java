package telefit.gimnasio;

import java.util.*;
import telefit.actividades.*;
import telefit.usuarios.Monitor;

public class Sala { //abstract no deja instanciar

	private String sid; 
	private int capacidad; 
	private List<TipoActividad> lta;
	private List<Actividades> actividades;



	public Sala(String sid, int cap, List<TipoActividad> lta) {
		this.sid = sid; //para ambiguedades usar "this" para que este se refiera
		capacidad = cap;
		this.lta = lta; //actividades permitidas
		this.actividades = new ArrayList<>(); //crea una lista nueva para guardad las actividades
	}


	//NUEVA ACTIVIDAD

	public void nuevaActividad(TipoActividad ta, Dia d, Turno t, Monitor mon) {
		Actividades nuevaActividad = new Actividades(d, t, ta, this.capacidad, this, mon); //crea una actividad nueva (nombre random) dentro de Actividades [this es para referirse a esta sala]
		actividades.add(nuevaActividad); //añade la actividad nueva a la lista actividades

	}


	public boolean disponibilidad(Dia d, Turno t){
		for (Actividades actividad : actividades) { //List<Actividades>, nombre random, <> actividades [bucle para leer toda la lista]
			if(actividad.getDia() == d && actividad.getTurno() == t){
				return false; //si son iguales, no está disponible
			}
		}
		return true; //esta disponble
	}



	 public List<TipoActividad> getTiposPermitidos() { //actividades permitidas
		 return lta;
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



	//GET Agenda (componer una cadena para luego imprimirla)

	public String getAgenda() {
		StringBuilder agenda = new StringBuilder();
		agenda.append("AGENDA DE LA SALA ").append(sid).append("\n");
		
		//orden cronologico
		/**
		 * 1º lista
		 * 2º comparador
		 * 2.1º Actividades::getDia (referencia a getDia de actividades.java) compara los dias obtenidos y los coloca por orden de la lista Dia (lunes, martes, miercoles...)
		 * 2.2º Ya están las actividades por orden semanal
		 * 2.3º Actividades::getTurno (referencia a getTurno de actividades.java) compara los turnos por el orden de la lista Turno (matinal, mediodia...) y los coloca en ese orden habiendoles colocado antes por el orden de dias
		 */
		Collections.sort(actividades, Comparator.comparing(Actividades::getDia).thenComparing(Actividades::getTurno));
		
		//ir uno por uno en la lista de actividades
		for (Actividades actividad : actividades) {
			agenda.append(" -------\n");
			agenda.append(actividad.toString()).append("\n"); //llama a la acena impresa de actividades
			agenda.append(" Apuntados: NINGUNO\n");
		}
		agenda.append(" -------\n");
		return agenda.toString();
	}
	
}






