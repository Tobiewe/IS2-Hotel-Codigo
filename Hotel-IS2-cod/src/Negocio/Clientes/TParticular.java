package Negocio.Clientes;

public class TParticular extends TCliente {

	public TParticular(Integer id, String correo, Integer telefono, String nombre, String CIF, String apellidos,
			String NIF) {
		super(id, correo, telefono, nombre, null, apellidos, NIF);
		// TODO Auto-generated constructor stub
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


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
}
