package Producto;

public class Empleado extends Persona{
	protected int id;
	protected String puesto;
	protected double salario;
	
	public Empleado(int id, String puesto, double salario) {
		super();
		this.id = id;
		this.puesto = puesto;
		this.salario = salario;
	}
	public Empleado(String puesto, double salario) {
		super();
		this.puesto = puesto;
		this.salario = salario;
	}
	public Empleado() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Empleado [id=" + id + ", puesto=" + puesto + ", salario=" + salario + "]";
	}
	
	

}
