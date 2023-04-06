package Negocio.Clientes;

import java.util.Collection;
import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;

public class SAClienteIMP implements SACliente{

	@Override
	public Integer crear(TCliente entradaCliente) {
		//Creamos el dao
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente auxCliente = daoCliente.MostrarUno(entradaCliente.getId());
		
		if(auxCliente != null)
		{
			if(!auxCliente.getActivo())
			{
				entradaCliente.setActivo(true);
				//Dependiendo de resupuesta de Antonio
				//entradaCliente.setId(auxCliente.getId())
				//Llamar a modificar Cliente del DAO
			}
			else 
				return -1;
				
		}
		return entradaCliente.getId();
	}

	@Override
	public Integer modificar(TCliente cliente) {
		if(cliente.getCorreo().trim().equals("") || cliente.getTelefono() < 111111111 || cliente.getTelefono() > 999999999)
		{
			
		}
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
