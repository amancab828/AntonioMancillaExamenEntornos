package utils;

import java.util.Scanner;

public class Consola implements IEntradaSalida{
	private Scanner sc;
	
	public Consola() {
		this.sc = new Scanner(System.in);
	}
	
	public void imprimir(String texto) {
		System.out.print(texto);
	}
	public void imprimirLinea(String texto) {
		System.out.println(texto);
	}
	public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine();
        return texto.trim();
	}
	public int leerEntero(String mensaje) {
        int numero = 0;
        boolean ok = false;

        while (!ok) {
            System.out.print(mensaje);
            String texto = sc.nextLine();
            texto = texto.trim();

            try {
                numero = Integer.parseInt(texto);
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR - Introduce un número entero válido.");
            }
        }
        return numero;
	}
	public double leerImporte(String mensaje) {
        double numero = 0;
        boolean ok = false;

        while (!ok) {
            System.out.print(mensaje);
            String texto = sc.nextLine();
            texto = texto.trim();

            try {
                numero = Double.parseDouble(texto);
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR - Introduce un número decimal válido.");
            }
        }
        return numero;
	}
	public void mostrarMenu() {
		System.out.println("1 - Contratar empleado");
		System.out.println("2 - Listar todos los empleados");
		System.out.println("3 - Listar empleados con filtro");
		System.out.println("4 - Salir");
	}
	public void limpiarPantalla() {
		for (int i = 1; i<=50; i++) {
			System.out.println();
		}
	}
	public void pausa() {
		System.out.println("Pulse una tecla para continuar...");
		sc.nextLine();
	}
}
