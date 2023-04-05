package Negocio.Departamentos;

public class TDepartamento {
	
	private Integer id;
	private String jefe;
	private String nombre;
	private Boolean activado;
	
	public TDepartamento(Integer id, String jefe, String nombre, Boolean activado){
		
		this.setId(id);
		this.setJefe(jefe);
		this.setNombre(nombre);
		this.setActivado(activado);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivado() {
		return activado;
	}

	public void setActivado(Boolean activado) {
		this.activado = activado;
	}

}
