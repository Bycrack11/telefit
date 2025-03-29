package	telefit.actividades;

import telefit.actividades.*;
import telefit.excepciones.*;

public class Actividades {

	private Dia dia;
	private Turno turno;
	private TipoActividad tipoActiv;

	public Actividades (Dia d, Turno t, TipoActividad ta) {

		dia  = d;
		turno = t;
		tipoActiv = ta;

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


	public String toString() {
		String cadena = "Dia: " + getDia() + "\nTurno: " + getTurno() + "\nTipo Actividad: " + getTipo();
		return cadena;
	}
}
