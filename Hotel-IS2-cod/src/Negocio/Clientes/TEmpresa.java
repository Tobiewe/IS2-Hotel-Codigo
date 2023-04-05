package Negocio.Clientes;

public class TEmpresa extends TCliente {

	public TEmpresa(Integer id, String correo, Integer telefono, String nombre, String CIF, String apellidos,
			String NIF) {
		super(id, correo, telefono, nombre, CIF, null, null);
		// TODO Auto-generated constructor stub
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

}
