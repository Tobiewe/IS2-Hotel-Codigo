package Negocio.Clientes;

import java.util.Collection;
import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;

public class SAClienteIMP implements SACliente{

	@Override
	public Integer crear(TCliente cliente) {
		//Creamos el dao
		DAOCliente daoCliente = FactoriaIntegracion.getInstance();
		return null;
	}

	@Override
	public Integer modificar(TCliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminar(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TCliente mostrarUno(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TCliente> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
