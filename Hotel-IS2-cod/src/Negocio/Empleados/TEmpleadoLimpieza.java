package Negocio.Empleados;

public class TEmpleadoLimpieza extends TEmpleados {



	public TEmpleadoLimpieza(Integer id, Float sueldo, String nombre, String apellidos, Boolean activo, String correo,
			Integer telefono, String lugar, String especialidad, Integer id_Departamento) {
		
		super(id, sueldo, nombre, apellidos, activo, correo, telefono, lugar, null, id_Departamento);
		// TODO Auto-generated constructor stub
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
