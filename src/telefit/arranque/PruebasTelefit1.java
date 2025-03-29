package telefit.arranque;

import java.util.Arrays;
import java.util.List;

import telefit.actividades.TipoActividad;
import telefit.actividades.Dia;
import telefit.actividades.Turno;
import telefit.excepciones.TelefitException;
import telefit.excepciones.UsuarioException;
import telefit.gimnasio.Gimnasio;
import telefit.gimnasio.Sala;
import telefit.usuarios.GestorUsuarios;
import telefit.usuarios.Monitor;
import telefit.usuarios.Usuario;


public class PruebasTelefit1 {

	/**
	 * Método main(). No se esperan parámetros.
	 * @param args parámetros por línea de comandos que no se tratan.
	 */
	public static void main(String[] args) {

		//*********************************************
		//**INICIALIZACION GESTOR USUARIOS Y GIMNASIO**
		//*********************************************
		// Instancio el gestor de usuarios
		GestorUsuarios gu = new GestorUsuarios();
		// Instancio el gimnasio
		Gimnasio gim = new Gimnasio();

		System.out.println("///////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 0");
		System.out.println("///////////////////////////\n");
		casosUsoIter0(gu);

		System.out.println("\n\n\n///////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 1");
		System.out.println("///////////////////////////\n");
		casosUsoIter1(gu, gim);
	}


	/**
	 * Método en el que se crean varios usuarios y se listan
	 * @param gu el gestor de usuarios
	 */
	private static void casosUsoIter0(GestorUsuarios gu) {
		System.out.println("/// CREAR USUARIOS ///\n");
		// Creo usuarios
		try {
			// el administrador
			gu.crearUsuario("admin", "admin", "Laura Admin", "Administrador");
			// varios monitores
			gu.crearUsuario("chuck", "clave", "Chuck Norris", "Monitor");
			gu.crearUsuario("jane", "clave", "Jane Fonda", "Monitor");
			// varios socios
			gu.crearUsuario("luisa", "clave", "Luisa Flex", "Socio");
			gu.crearUsuario("antonio", "clave", "Antonio Hogan", "Socio");
			gu.crearUsuario("alicia", "clave", "Alicia Mancuernas", "Socio");
			gu.crearUsuario("kike", "clave", "Enrique Masa", "Socio");
			gu.crearUsuario("pablo", "clave", "Pablo Burpees", "Socio");
			System.out.println("(ésta fallará...)");
			gu.crearUsuario("jane", "clave", "Juana Lanas", "Socio");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n/// LISTAR USUARIOS ///\n");

		System.out.println("El listado de socios...");
		try {
			List<Usuario> socios = gu.listarUsuariosTipo("Socio");
			System.out.println("\nHay "+socios.size()+" usuarios de tipo \"Socio\"\n");
			for (Usuario soc :socios)
				System.out.println(soc.toString()+"\n");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("El listado de monitores...");
		try {
			List<Usuario> mons = gu.listarUsuariosTipo("Monitor");
			System.out.println("\nHay "+mons.size()+" usuarios de tipo \"Monitor\"\n");
			for (Usuario mon : mons)
				System.out.println(mon.toString()+"\n");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
	}

	/**
	 * Método en el que se crean salas en el gimnasio, se registran actividades,
	 * se consulta la agenda de salas y la agenda de monitores
	 * @param gu el gestor de usuarios
	 * @param gim el gimnasio
	 */
	private static void casosUsoIter1(GestorUsuarios gu, Gimnasio gim) {
		System.out.println("/// CREAR SALAS ///\n");

		System.out.println("Se crean varias salas...");
		try {
			gim.crearSala("Violeta", 6, Arrays.asList(TipoActividad.PILATES, TipoActividad.YOGA));
			gim.crearSala("Verde", 4, Arrays.asList(TipoActividad.PILATES, TipoActividad.YOGA));
			gim.crearSala("Púrpura", 3, Arrays.asList(TipoActividad.SPINNING));
			gim.crearSala("Naranja", 1, Arrays.asList(TipoActividad.MASAJE));
			gim.crearSala("Roja", 1, Arrays.asList(TipoActividad.MASAJE));
			System.out.println("(ésta fallará...)");
			gim.crearSala("Violeta", 2, Arrays.asList(TipoActividad.SPINNING));			
		} catch (TelefitException e) {
			System.out.println(e.getMessage());
		}


		System.out.println("\n\n/// REGISTRAR ACTIVIDADES ///\n");

		// ----------------------------
		// -- Usuario jane (MONITOR) --
		// ----------------------------
		System.out.println("\njane registra varias actividades");
		Monitor jane = (Monitor) gu.getUsuario("jane"); // cast de Usuario a Monitor
		if (jane != null) {
			try {
				gim.registrarActividad(TipoActividad.PILATES, Dia.LUNES, Turno.MATINAL, 3, jane);
				gim.registrarActividad(TipoActividad.YOGA, Dia.LUNES, Turno.MEDIODIA, 5, jane);
				gim.registrarActividad(TipoActividad.PILATES, Dia.MIERCOLES, Turno.MATINAL, 3, jane);
				gim.registrarActividad(TipoActividad.YOGA, Dia.MIERCOLES, Turno.MEDIODIA, 5, jane);
				System.out.println("(ésta fallará...)");
				gim.registrarActividad(TipoActividad.MASAJE, Dia.LUNES, Turno.MATINAL, 1, jane);	
			} catch (UsuarioException | TelefitException e) {
				System.out.println(e.getMessage());
			}
		}			

		// ----------------------------
		// -- Usuario chuck (MONITOR) --
		// ----------------------------		
		System.out.println("\nchuck registra varias actividades");
		Monitor chuck = (Monitor) gu.getUsuario("chuck"); // cast de Usuario a Monitor
		if (chuck != null) {
			try {
				gim.registrarActividad(TipoActividad.SPINNING, Dia.JUEVES, Turno.MATINAL, 3, chuck);
				gim.registrarActividad(TipoActividad.SPINNING, Dia.MARTES, Turno.MATINAL, 3, chuck);
				gim.registrarActividad(TipoActividad.YOGA, Dia.MARTES, Turno.MEDIODIA, 3, chuck);
				gim.registrarActividad(TipoActividad.YOGA, Dia.MIERCOLES, Turno.MATINAL, 3, chuck);
				gim.registrarActividad(TipoActividad.PILATES, Dia.VIERNES, Turno.MEDIODIA, 3, chuck);
				gim.registrarActividad(TipoActividad.PILATES, Dia.JUEVES, Turno.TARDE, 3, chuck);
				System.out.println("(ésta fallará...)");
				gim.registrarActividad(TipoActividad.YOGA, Dia.LUNES, Turno.MEDIODIA, 5, chuck);
			} catch (UsuarioException | TelefitException e) {
				System.out.println(e.getMessage());
			}
			try {
				gim.registrarActividad(TipoActividad.MASAJE, Dia.MARTES, Turno.TARDE, 1, chuck);
				gim.registrarActividad(TipoActividad.MASAJE, Dia.VIERNES, Turno.TARDE, 1, chuck);
				System.out.println("(ésta fallará...)");
				gim.registrarActividad(TipoActividad.MASAJE, Dia.LUNES, Turno.TARDE, 2, chuck);
			} catch (UsuarioException | TelefitException e) {
				System.out.println(e.getMessage());
			}
		}


		System.out.println("\n\n/// VER AGENDA SALAS ///\n");

		System.out.println("Miramos la agenda de varias salas ");
		try {
			System.out.println("\n" + gim.getAgendaSala("Violeta"));
			System.out.println("\n" + gim.getAgendaSala("Verde"));
			System.out.println("\n" + gim.getAgendaSala("Púrpura"));
			System.out.println("\n" + gim.getAgendaSala("Roja"));
			System.out.println("\n(ésta fallará...)");
			System.out.println(gim.getAgendaSala("Azabache"));
		} catch (TelefitException e) {
			System.out.println(e.getMessage());
		}	


		System.out.println("\n\n/// VER AGENDA MONITORES ///\n");

		System.out.println("Miramos la agenda de los monitores");
		if (jane != null)
			System.out.println("\n" + jane.getAgenda());
		if (chuck != null)
			System.out.println("\n" + chuck.getAgenda());		
	}
}
