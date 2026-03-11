package dominio;

public class Comercial extends Empleado{
	private double ventas;
	
	public Comercial(String dni, String nombre, String apellidos, double sueldoBase) {
		super(dni, nombre, apellidos, sueldoBase);
	}
	
	public void setVentas(double ventas) {
		this.ventas=ventas;
	}
	
	@Override
	public double getSueldo() {
		double sueldo;
		
		sueldo = this.getSueldoBase() + ventas*0.1;
		
		return sueldo;
	}
	
	@Override
    public String toString() {
    	return String.format("Nombre: %s\nApellidos: %s\nDNI: %s\nSueldo base: %.2f\nVentas: %.2f", 
				nombre, apellidos, dni, sueldoBase, ventas);
    }
}
