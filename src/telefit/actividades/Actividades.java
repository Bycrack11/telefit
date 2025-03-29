package	telefit.actividades; //info sala

import telefit.usuarios.Monitor;
import telefit.gimnasio.Sala;

public class Actividades {

	private Dia dia;
	private Turno turno;
	private TipoActividad tipoActiv;
	private int capacidadMin;
	private Sala sala;
	private Monitor monitor;

	public Actividades (Dia d, Turno t, TipoActividad ta, int capmin, Sala sala, Monitor monitor) {

		dia  = d;
		turno = t;
		tipoActiv = ta;
		capacidadMin = capmin;
		this.sala = sala;
		this.monitor = monitor;
	}


	public Dia getDia() {
		return dia;
	}

	public Turno getTurno() {
		return turno;
	}

	public TipoActividad getTipo() {
		return tipoActiv;
	}

	public Sala getSala() {
		return sala;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public int getCapacidadMinima() { //cambiar por capacidad maxima??
		return capacidadMin;
	}

	
	//lo usamos para componer la agenda
	public String toString() {
		String cadena = "Actividad tipo: " + tipoActiv + "\n Sala: " + sala.getSid() + "\n Dia: " + getDia() + "\n Turno: " + getTurno() + "\n Monitor: " + monitor.getNombre() + "\n Capacidad: " + sala.getCapacidad();
		return cadena;
	}
}
