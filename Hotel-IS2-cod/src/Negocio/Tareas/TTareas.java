package Negocio.Tareas;

public class TTareas {
	
	private Integer id;
	private String descripcion;
	private String lugar;
	private String nombre;
	private Integer id_empleado;
	

	
	public TTareas(Integer id, String descripcion, String lugar, String nombre, Integer id_empleado){
		
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.nombre = nombre;
		this.id_empleado = id_empleado;
		
	}

	public Integer getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}


}
