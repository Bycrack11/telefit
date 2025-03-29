package telefit.arranque;

import java.util.List;

import telefit.excepciones.UsuarioException;
import telefit.usuarios.GestorUsuarios;
import telefit.usuarios.Usuario;


public class PruebasTelefit0 {

	/**
	 * Método main(). No se esperan parámetros.
	 * @param args parámetros por línea de comandos que no se tratan.
	 */
	public static void main(String[] args) {

		//**********************************
		//**INICIALIZACION GESTOR USUARIOS**
		//**********************************
		// Instancio el gestor de usuarios
		GestorUsuarios gu = new GestorUsuarios();

		System.out.println("///////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 0");
		System.out.println("///////////////////////////\n");
		casosUsoIter0(gu);
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
}
