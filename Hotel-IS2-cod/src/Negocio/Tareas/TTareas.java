package Negocio.Tareas;

public class TTareas {
	
	private Integer id;
	private String descripcion;
	private String lugar;
	private String nombre;
	private Boolean activa;
	

	
	public TTareas(Integer id, String descripcion, String lugar, String nombre, Boolean activa){
		
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.nombre = nombre;
		this.activa = activa;
		
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
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


	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}


}
