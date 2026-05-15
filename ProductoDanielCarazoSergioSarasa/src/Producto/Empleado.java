package Producto;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
	protected String puesto;
	protected double salario;
	public Empleado(int id, String dni, String nombre, String puesto, double salario) {
		super(id, dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}
	public Empleado(String dni, String nombre, String puesto, double salario) {
		super(dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}
	
	
	public Empleado() {
		super();
		
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Empleado [puesto=" + puesto + ", salario=" + salario + ", getId()=" + getId() + ", getDni()=" + getDni()
				+ ", getNombre()=" + getNombre() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
