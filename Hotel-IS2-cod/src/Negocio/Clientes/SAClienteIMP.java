package Negocio.Clientes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Negocio.Empleados.TEmpleados;

public class SAClienteIMP implements SACliente{

	private final static String letras = "TRWAGMYFPDXBNJZSQVHLCKE";	

	public Integer crear(TCliente entradaCliente) {
		
		String numero = Integer.toString(entradaCliente.getTelefono());
		// Patr�n para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(entradaCliente.getCorreo());
		
		
		if(entradaCliente.getApellidos().trim().equals("") || entradaCliente.getCIF().trim().equals("") || entradaCliente.getCorreo().trim().equals("") || entradaCliente.getNIF().trim().equals("") || entradaCliente.getNombre().trim().equals("")){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		else if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		else if(!mather.find()){
			return -7; //correo no valido
		}
		else if(!NIFCIFValido(entradaCliente.getCIF())){
			return -8; // cif invalido
		}
		else if(!NIFCIFValido(entradaCliente.getNIF())){
			return -9; // nif invalido
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
		// Patr�n para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(cliente.getCorreo());
		
		
		if(cliente.getApellidos().trim().equals("") || cliente.getCIF().trim().equals("") || cliente.getCorreo().trim().equals("") || cliente.getNIF().trim().equals("") || cliente.getNombre().trim().equals("")){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		else if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		else if(!mather.find()){
			return -7; //correo no valido
		}
		else if(!NIFCIFValido(cliente.getCIF())){
			return -8; // cif invalido
		}
		else if(!NIFCIFValido(cliente.getNIF())){
			return -9; // nif invalido
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
	
	
    public static boolean NIFCIFValido(String doc) {
        boolean valido = false;
        if(doc.matches("\\d{8}[A-Z]")) {
            if(doc.length() == 9) {
                valido = true;
            }
        }
        return valido;
    }

}
