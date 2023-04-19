package Negocio.Clientes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Negocio.Empleados.TEmpleados;

public class SAClienteIMP implements SACliente{

	

	public Integer crear(TCliente entradaCliente) {
		
		String numero = Integer.toString(entradaCliente.getTelefono());
		
		if(numero.length() != 9 || entradaCliente.getNombre().trim().equals("")){
			return -5;
		}
		
		//Creamos el dao
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		
		if(entradaCliente.getId() != null){
			TCliente tCliente = daoCliente.MostrarUno(entradaCliente.getId());

			if(tCliente != null){
				daoCliente.modificar(entradaCliente);
						
				return tCliente.getActivo() ? -2 : entradaCliente.getId();	
			}
			
		}
		
		System.out.println("llega al sa");

		return daoCliente.crear(entradaCliente);
	}
	
	
	public Integer modificar(TCliente cliente) {
		
		String numero = Integer.toString(cliente.getTelefono());
		String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(patron);
		Matcher matcher = pattern.matcher(cliente.getCorreo());
		
		if(numero.length() != 9 || matcher.matches() || cliente.getNombre() == ""){
			return -5;
		}
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente auxCliente = daoCliente.MostrarUno(cliente.getId());
		
		if(auxCliente == null )
			return -2;
		
		return daoCliente.modificar(cliente);
	}

	
	public Integer eliminar(int idCliente) {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tCliente = daoCliente.MostrarUno(idCliente);
		
		if(tCliente == null){
			return -2;
		}
		
		return daoCliente.borrar(idCliente);
	}

	
	public TCliente mostrarUno(int idCliente) {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tCliente = daoCliente.MostrarUno(idCliente);

		if(tCliente == null)
			return null;
		
		return tCliente;
	}

	
	public Collection<TCliente> mostrarTodos() {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		Collection<TCliente> lista = daoCliente.MostrarTodos();
		Collection<TCliente> dev = new ArrayList<TCliente>();
		
		for(TCliente t : lista){
			
			if(daoCliente.MostrarUno(t.getId()) != null){
				dev.add(t);
			}
		}
		
		return dev;
	}


	
	public Collection<TParticular> MostrarParticular() {
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		Collection<TParticular> lista = daoCliente.MostrarParticular();
		Collection<TParticular> dev = new ArrayList<TParticular>();
		
		for(TCliente t : lista){
			
			if(daoCliente.MostrarUno(t.getId()) != null){
				dev.add((TParticular) t);
			}
		}
		
		return dev;
	}


	public Collection<TEmpresa> MostrarEmpresa() {
		
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		Collection<TEmpresa> lista = daoCliente.MostrarEmpresa();
		Collection<TEmpresa> dev = new ArrayList<TEmpresa>();
		
		for(TCliente t : lista){
			
			if(daoCliente.MostrarUno(t.getId()) != null){
				dev.add((TEmpresa) t);
			}
		}
		
		return dev;
	}

}
