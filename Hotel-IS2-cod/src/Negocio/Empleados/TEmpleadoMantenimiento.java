package Negocio.Empleados;

public class TEmpleadoMantenimiento extends TEmpleados {

	public TEmpleadoMantenimiento(Integer id, Float sueldo, String nombre, String apellidos, Boolean activo,
			String correo, Integer telefono, String especialidad) {
		
		super(id, sueldo, nombre, apellidos, activo, correo, telefono, null, especialidad);

	}
	
	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
