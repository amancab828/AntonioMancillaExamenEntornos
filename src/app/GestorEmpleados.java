package app;

import java.util.List;

import dominio.Comercial;
import dominio.Empleado;
import dominio.Plantilla;
import dominio.Tecnico;
import utils.IEntradaSalida;

public class GestorEmpleados {
	private Plantilla plantilla;
	private IEntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
		this.plantilla=plantilla;
		this.consola=consola;
	}
	
	public void ejecutar() {
		int opcion;
        do {
            consola.mostrarMenu();
            opcion = consola.leerEntero("Elige una opción");

            switch (opcion) {
            	case 1 -> contratarEmplado();
            	case 2 -> listarTodos();
            	case 3 -> listarPorFiltro();
            	case 4 -> consola.imprimirLinea("Saliendo");
            	default -> consola.imprimirLinea("Opción no válida, inténtalo de nuevo.");
            }

        } while (opcion != 4);
	}
	
	private void contratarEmplado() {
		int opcion, categoria;
		String dni, nombre, apellidos;
		double sueldoBase, ventas;
		Tecnico tecnico;
		Comercial comercial;
        do {
    		consola.imprimirLinea("1 - Técnico");
    		consola.imprimirLinea("2 - Comercial");
            opcion = consola.leerEntero("Elige una opción");

            switch (opcion) {
            	case 1 -> {
            		dni = consola.leerTexto("DNI: ");
            		nombre = consola.leerTexto("Nombre: ");
            		apellidos = consola.leerTexto("Apellidos: ");
            		sueldoBase = consola.leerImporte("Sueldo Base: ");
            		categoria = consola.leerEntero("Categoria: ");
            		tecnico = new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
            	}
            	case 2 -> {
            		dni = consola.leerTexto("DNI: ");
            		nombre = consola.leerTexto("Nombre: ");
            		apellidos = consola.leerTexto("Apellidos: ");
            		sueldoBase = consola.leerImporte("Sueldo Base: ");
            		ventas = consola.leerImporte("Ventas: ");
            		comercial = new Comercial(dni, nombre, apellidos, sueldoBase);
            		comercial.setVentas(ventas);
            	}
            	default -> consola.imprimirLinea("Opción no válida, inténtalo de nuevo.");
            }

        } while (opcion != 4);

		opcion = consola.leerEntero("Elige una opción");
		
	}
	private void listarTodos() {

	}
	private void listarPorFiltro() {
		
	}
	private void listarEmpleados(List<Empleado> empleados) {
		for (Empleado e : empleados) {
			consola.imprimir("Nombre: ");
			consola.imprimirLinea(e.getNombre());
			consola.imprimir("Apellidos: ");
			consola.imprimirLinea(e.getApellidos());
			consola.imprimir("DNI: ");
			consola.imprimirLinea(e.getDni());
			consola.imprimir("Sueldo base: ");
			consola.imprimirLinea(e.getSueldoBase().toString());
		}
	}
	private void ordenarPorNombre(List<Empleado> empleados) {
		
	}
}
