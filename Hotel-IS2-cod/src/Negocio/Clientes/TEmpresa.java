package Negocio.Clientes;

public class TEmpresa extends TCliente {


	public TEmpresa(Integer id, String correo, Integer telefono, String nombre, String CIF, String apellidos,
			String NIF, Boolean activo, String tipo) {
		super(id, correo, telefono, nombre, CIF, null, null, activo, tipo);
	}


	public String getCIF() {
		return CIF;
	}


	public void setCIF(String cIF) {
		CIF = cIF;
	}

}
