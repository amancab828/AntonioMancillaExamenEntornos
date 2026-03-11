package app;

import dominio.Plantilla;
import utils.Consola;

public class Main {

	public static void main(String[] args) {
		Plantilla plantilla = new Plantilla();
		Consola consola = new Consola();
		GestorEmpleados gestorEmpleados = new GestorEmpleados(plantilla, consola);
		
		gestorEmpleados.ejecutar();
	}

}
