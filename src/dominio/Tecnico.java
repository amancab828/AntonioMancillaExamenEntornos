package dominio;

public class Tecnico extends Empleado{
	private int categoria;
	
	public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
		super(dni, nombre, apellidos, sueldoBase);
		this.categoria=categoria;
	}
	
	@Override
	public double getSueldo() {
		double sueldo;
		
		sueldo = this.getSueldoBase() + categoria*100;
		
		return sueldo;
	}

    @Override
    public String toString() {
    	return String.format("Nombre: %s\nApellidos: %s\nDNI: %s\nSueldo base: %.2f\nCategoria: %d", 
				nombre, apellidos, dni, sueldoBase, categoria);
    }
}
