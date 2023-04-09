package Negocio.Clientes;

import java.util.Collection;
import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;

public class SAClienteIMP implements SACliente{

	@Override

	public Integer crear(TCliente entradaCliente) {
		//Creamos el dao
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tCliente = daoCliente.MostrarUno(entradaCliente.getId());
		
		if(tCliente != null)
		{
			if(!tCliente.getActivo())
			{
				entradaCliente.setActivo(true);
				//Dependiendo de resupuesta de Antonio
				//entradaCliente.setId(auxCliente.getId())
				//Llamar a modificar Cliente del DAO
			}
			else 
				return -1;
				
		}
		//Si positivo no pasa nada
		return entradaCliente.getId();
	}
	@Override
	public Integer modificar(TCliente cliente) {
		if(cliente.getCorreo().trim().equals("") || cliente.getTelefono() < 111111111 || cliente.getTelefono() > 999999999)
		{
			return -2;
		}
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente auxCliente = daoCliente.MostrarUno(cliente.getId());
		if(!auxCliente.getActivo() || auxCliente == null )
			return -2;
		return cliente.getId();
	}

	@Override
	public Integer eliminar(int idCliente) {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tCliente = daoCliente.MostrarUno(idCliente);
		//Hacer otro if con el caso de que esté simplemente desactivado según diga Antonio
		if(tCliente == null)
		{
			return -3;
		}
		return idCliente;
	}

	@Override
	public TCliente mostrarUno(int idCliente) {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tCliente = daoCliente.MostrarUno(idCliente);
		//Hacer otro if con el caso de que esté simplemente desactivado según diga Antonio

		if(tCliente == null)
			return null;
		//Ver que hacer en mensajes si no se consigue mostrar uno
		return daoCliente.MostrarUno(idCliente);
	}

	@Override
	public Collection<TCliente> mostrarTodos() {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		Collection<TCliente> clienteCollection;
		
		clienteCollection = daoCliente.MostrarTodos();
		return null;
	}

}
