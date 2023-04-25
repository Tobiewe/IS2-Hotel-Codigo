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
		
		if(entradaCliente.getTelefono() == null){
			return -5;
		}
		
		String numero = Integer.toString(entradaCliente.getTelefono());
		// Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(entradaCliente.getCorreo());
		
		
		if(entradaCliente.getCorreo().trim().equals("")  || entradaCliente.getNombre().trim().equals("")){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		if(entradaCliente.getApellidos() != null){
			if(entradaCliente.getApellidos().trim().equals("")){
				return -5;
			}
		}
		if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		if(!mather.find()){
			return -7; //correo no valido
		}
		if(entradaCliente.getCIF() != null ){
			if(!CIFValido(entradaCliente.getCIF())){
				return -8; // cif invalido
			}
		}
		if(entradaCliente.getNIF() != null){
			if(!NIFValido(entradaCliente.getNIF())){
				return -9; // nif invalido
			}
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
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(cliente.getCorreo());
		
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente auxCliente = daoCliente.MostrarUno(cliente.getId());
		
		if(auxCliente == null)
			return -2;
		
		if(cliente.getCorreo().trim().equals("") || cliente.getNombre().trim().equals("")){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		if(cliente.getApellidos() != null){
			if(cliente.getApellidos().trim().equals("")){
				return -5;
			}
		}
		if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		if(!mather.find()){
			return -7; //correo no valido
		}
		if(cliente.getCIF() != null ){
			System.out.println(cliente.getNIF());
			if(!CIFValido(cliente.getCIF())){
				return -8; // cif invalido
			}
		}
		if(cliente.getNIF() != null){
			System.out.println(cliente.getNIF());
			if(!NIFValido(cliente.getNIF())){
				return -9; // nif invalido
			}
		}
		
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
	
	
    public static boolean NIFValido(String doc) {
        boolean valido = false;
        if(doc.matches("\\d{8}[A-Z]")) {
            if(doc.length() == 9) {
                valido = true;
            }
        }
        return valido;
    }
    
    public static boolean CIFValido(String doc) {
        boolean valido = false;
        if(doc.matches("\\d{8}[A-Z]")) {
            if(doc.length() == 9) {
                valido = true;
            }
        }
        return valido;
    }

}
