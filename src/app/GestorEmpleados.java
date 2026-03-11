package app;

import java.util.Collections;
import java.util.Comparator;
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
            	case 1 -> {
            		contratarEmplado();
            		consola.pausa();
            		consola.limpiarPantalla();
            	}
            	case 2 -> {
            		listarTodos();
            		consola.pausa();
            		consola.limpiarPantalla();
            	}
            	case 3 -> {
            		listarPorFiltro();
            		consola.pausa();
            		consola.limpiarPantalla();
            	}
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
            	plantilla.agregarEmpleado(tecnico);
            }
            case 2 -> {
            	dni = consola.leerTexto("DNI: ");
            	nombre = consola.leerTexto("Nombre: ");
            	apellidos = consola.leerTexto("Apellidos: ");
            	sueldoBase = consola.leerImporte("Sueldo Base: ");
            	ventas = consola.leerImporte("Ventas: ");
            	comercial = new Comercial(dni, nombre, apellidos, sueldoBase);
            	comercial.setVentas(ventas);
            	plantilla.agregarEmpleado(comercial);
            }
            default -> consola.imprimirLinea("Opción no válida, inténtalo de nuevo.");
        }	
	}
	private void listarTodos() {
		listarEmpleados(plantilla.getEmpleadosPorNombre(""));
	}
	private void listarPorFiltro() {
		listarEmpleados(plantilla.getEmpleadosPorNombre(""));
	}
	private void listarEmpleados(List<Empleado> empleados) {
		for (Empleado e : empleados) {
			consola.imprimirLinea(e.toString());
		}
	}
	private void ordenarPorNombre(List<Empleado> empleados) {
		Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
	}
}
