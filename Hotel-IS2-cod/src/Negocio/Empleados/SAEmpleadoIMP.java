package Negocio.Empleados;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.Tareas.DAOTareas;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Tareas.TTareas;

public class SAEmpleadoIMP implements SAEmpleado {

	
	public Integer crear(TEmpleados empleado) {
		
		String numero = Integer.toString(empleado.getTelefono());
		
		if(empleado.getApellidos().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getSueldo() < 0 || numero.length() != 9){
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
		
		if(empleado.getApellidos().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getSueldo() < 0 || numero.length() != 9){
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

	
	public Collection<TEmpleados> mostrarPorDepartamento(Integer idDepartamento) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		Collection<TEmpleados> lista = daoEmpl.mostrarPorDepartamento(idDepartamento);
		Collection<TEmpleados> dev = new ArrayList<TEmpleados>();
		
		for(TEmpleados te : lista){
			
			if(daoEmpl.MostrarUno(te.getId()) != null){
				dev.add(te);
			}
		}
		
		return dev;
	}


	
	public Integer vincular(TTareasDelEmpleado tTareasDelEmpleado) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		TEmpleados tem = daoEmpl.MostrarUno(tTareasDelEmpleado.getId_empleado());
		TTareas tta = daoTarea.leerUno(tTareasDelEmpleado.getId_tareas());
		
		if(tem == null || tta == null){
			return -5; // el id no existe
		}
		if(!tta.getActiva()){
			return -6; // no esta activo la tarea 
		}
		if(!tem.getActivo()){
			return -7; // no esta ativo el empelado
		}
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		
		return daote.crear(tTareasDelEmpleado);
	}


	
	public Integer desvincular(TTareasDelEmpleado tTareasDelEmpleado) { // seria como un modificar
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		TEmpleados tem = daoEmpl.MostrarUno(tTareasDelEmpleado.getId_empleado());
		TTareas tta = daoTarea.leerUno(tTareasDelEmpleado.getId_tareas());
		
		if(tem == null || tta == null){
			return -5; // el id no existe
		}
		if(!tta.getActiva()){
			return -6; // no esta activo la tarea 
		}
		if(!tem.getActivo()){
			return -7; // no esta ativo el empelado
		}
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		
		return daote.modificar(tTareasDelEmpleado);
	}


	
	public Collection<TTareasDelEmpleado> Leertodos() {

		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TTareasDelEmpleado> lista = daote.Leertodos();
		Collection<TTareasDelEmpleado> dev = new ArrayList<TTareasDelEmpleado>();
		
		for(TTareasDelEmpleado t : lista){
			
			TEmpleados tem = daoEmpl.MostrarUno(t.getId_empleado());
			TTareas tta = daoTarea.leerUno(t.getId_tareas());
			
			if(tem != null || tta != null){
				dev.add(t);
			}
			
		}
		
		return dev;
	}


	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorTareas(Integer idTareas) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TTareasDelEmpleado> lista = daote.LeerLineasPedidoPorTareas(idTareas);
		Collection<TTareasDelEmpleado> dev = new ArrayList<TTareasDelEmpleado>();
		
		for(TTareasDelEmpleado t : lista){
			
			TEmpleados tem = daoEmpl.MostrarUno(t.getId_empleado());
			TTareas tta = daoTarea.leerUno(t.getId_tareas());
			
			if(tem != null || tta != null){
				dev.add(t);
			}
			
		}
		
		return dev;
	}


	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorEmpleado(Integer idEmpleado) {
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TTareasDelEmpleado> lista = daote.LeerLineasPedidoPorEmpleado(idEmpleado);
		Collection<TTareasDelEmpleado> dev = new ArrayList<TTareasDelEmpleado>();
		
		for(TTareasDelEmpleado t : lista){
			
			TEmpleados tem = daoEmpl.MostrarUno(t.getId_empleado());
			TTareas tta = daoTarea.leerUno(t.getId_tareas());
			
			if(tem != null || tta != null){
				dev.add(t);
			}
			
		}
		
		return dev;
	}

}
