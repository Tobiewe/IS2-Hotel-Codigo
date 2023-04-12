package Negocio.Empleados;

public class TEmpleados {
	
	private Integer id;
	private Float sueldo;
	private String nombre;
	private String apellidos;
	private Boolean activo;
	private String correo;
	private Integer telefono;
	private Integer id_Departamento;


	
	public TEmpleados(Integer id, Float sueldo, String nombre, String apellidos, Boolean activo , String correo, Integer telefono, Integer id_Departamento){
		
		this.id = id;
		this.sueldo = sueldo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.activo = activo;
		this.correo = correo;
		this.telefono = telefono;
		this.id_Departamento = id_Departamento;
		
	}


	public Integer getId() {
		return id;
	}


	public Float getSueldo() {
		return sueldo;
	}


	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public Integer getId_Departamento() {
		return id_Departamento;
	}


	public void setId_Departamento(Integer id_Departamento) {
		this.id_Departamento = id_Departamento;
	}
	
}