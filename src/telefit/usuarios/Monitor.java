package telefit.usuarios;

import telefit.actividades.*;
import telefit.actividades.Actividades;
import java.util.*;

public class Monitor extends Usuario {
	
	private List<Actividades> actividades; //lista actividades
	
	public Monitor(String l, String c, String n) {
		super(l, c, n);
		this.actividades = new ArrayList<>(); //cargar lista actividades
	}
	
	public boolean disponibilidad(Dia d, Turno t) {
		for (Actividades actividad: actividades) { //List<Actividades>, nombre random, <> actividades [bucle para leer toda la lista]
			if (actividad.getDia() == d && actividad.getTurno() == t) {
				return false; //si son iguales, no está disponible
			}
		}
		return true; //esta disponble
	}
		
	public void agregarActividad(Actividades actividad){
		actividades.add(actividad); //añadir activvidad al monitor
	}

	
	//Agenda monitor

	public String getAgenda(){
		StringBuilder agenda = new StringBuilder();
		agenda.append("AGENDA DEL MONITOR ").append(this.getNombre()).append("\n");
		
		Collections.sort(actividades, Comparator.comparing(Actividades::getDia).thenComparing(Actividades::getTurno));
		
		for (Actividades actividad : actividades) {
			agenda.append(" -------\n");
			agenda.append(actividad.toString()).append("\n");
			agenda.append(" Apuntados: NINGUNO\n");
		}
		agenda.append(" -------\n");
		return agenda.toString();
	}


	//uso caso 0?
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		String cadena = super.toString();
		cadena += "\n Tipo: Monitor";
		return cadena;
	}
}
