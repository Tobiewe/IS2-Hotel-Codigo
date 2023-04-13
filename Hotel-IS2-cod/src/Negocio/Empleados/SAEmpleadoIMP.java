package Negocio.Empleados;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Negocio.Habitaciones.THabitaciones;

public class SAEmpleadoIMP implements SAEmpleado {

	
	public Integer crear(TEmpleados empleado) {
		
		String numero = Integer.toString(empleado.getTelefono());
		
		if(empleado.getApellidos().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getSueldo() > 0 || numero.length() == 9){
			return -5;
		}
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		if(empleado.getId() != null){
			TEmpleados te = daoEmpl.MostrarUno(empleado.getId());
			
			if(te != null){
				daoEmpl.modificar(empleado);
				
				return te.getActivo() ? -2 : empleado.getId();
			}
		}
		
		return daoEmpl.crear(empleado);
	}

	
	public Integer modificar(TEmpleados empleado) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		TEmpleados te = daoEmpl.MostrarUno(empleado.getId());
		
		if(te == null){
			return -2;
		}
		
		String numero = Integer.toString(empleado.getTelefono());
		
		if(empleado.getApellidos().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getSueldo() > 0 || numero.length() == 9){
			return -5;
		}
		
		return daoEmpl.modificar(empleado);
		
	}

	
	public Integer eliminar(int idEmpleado) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		TEmpleados te = daoEmpl.MostrarUno(idEmpleado);
		
		if(te == null){
			return -2;
		}
		
		return daoEmpl.borrar(idEmpleado);
		
	}

	
	public TEmpleados mostrarUno(int idEmpleado) {
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		TEmpleados te = daoEmpl.MostrarUno(idEmpleado);
		
		if(te == null){
			return null;
		}
		
		return te;
	}

	
	public Collection<TEmpleados> mostrarTodos() {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		Collection<TEmpleados> lista = daoEmpl.MostrarTodos();
		Collection<TEmpleados> dev = new ArrayList<TEmpleados>();
		
		for(TEmpleados te : lista){
			
			if(daoEmpl.MostrarUno(te.getId()) != null){
				dev.add(te);
			}
		}
		
		return dev;
	}

	
	public Collection<TEmpleados> mostrarPorDepartamento() {
		/*
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		Collection<TEmpleados> lista = daoEmpl.
		Collection<TEmpleados> dev = new ArrayList<TEmpleados>();
		
		for(TEmpleados te : lista){
			
			if(daoEmpl.MostrarUno(te.getId()) != null){
				dev.add(te);
			}
		}
		*/
		return null;
	}

}
