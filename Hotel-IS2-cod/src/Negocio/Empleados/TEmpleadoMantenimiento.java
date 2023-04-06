package Negocio.Empleados;

public class TEmpleadoMantenimiento extends TEmpleados {


	
	public TEmpleadoMantenimiento(Integer id, Float sueldo, String nombre, String apellidos, Boolean activo,
			String correo, Integer telefono, String lugar, String especialidad, Integer id_Departamento) {
		
		super(id, sueldo, nombre, apellidos, activo, correo, telefono, null, especialidad, id_Departamento);
		// TODO Auto-generated constructor stub
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
