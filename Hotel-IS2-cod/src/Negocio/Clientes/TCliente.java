package Negocio.Clientes;

public class TCliente {
	
	private Integer id;
	private String correo;
	private Integer telefono;
	protected String nombre;
	protected String CIF;
	protected String apellidos;
	protected String NIF;
	private Boolean activo;

	
	public TCliente(Integer id, String correo, Integer telefono, String nombre, String CIF, String apellidos,  String NIF, Boolean activo){
		
		this.id = id;
		this.correo = correo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.CIF = CIF;
		this.apellidos = apellidos;
		this.NIF =  NIF;
		this.activo = activo;
		
	}


	public Integer getId() {
		return id;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCIF() {
		return CIF;
	}


	public void setCIF(String cIF) {
		CIF = cIF;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
