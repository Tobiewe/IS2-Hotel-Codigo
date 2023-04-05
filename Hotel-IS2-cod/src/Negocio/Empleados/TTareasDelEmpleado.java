package Negocio.Empleados;

public class TTareasDelEmpleado {
	
	private Integer id_tareas;
	private Integer id_empleado;
	
	public TTareasDelEmpleado(Integer id_tareas,  Integer id_empleado){
		
		this.id_empleado = id_empleado;
		this.id_tareas = id_tareas;
		
	}

	public Integer getId_tareas() {
		return id_tareas;
	}

	public void setId_tareas(Integer id_tareas) {
		this.id_tareas = id_tareas;
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

}
