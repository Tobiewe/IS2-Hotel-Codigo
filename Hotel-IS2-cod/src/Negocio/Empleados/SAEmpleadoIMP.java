package Negocio.Empleados;

import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

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
		
		return daote.eliminar(tTareasDelEmpleado);
	}


	
	public  Pair<Collection<TEmpleados>,Collection<TTareas>> LeertodosDeTareasEmpleado() {

		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Pair<Collection<TEmpleados>,Collection<TTareas>> lista = daote.Leertodos();
		ArrayList<TTareas> listatareas = new ArrayList<TTareas>();
		ArrayList<TEmpleados> listaempleados = new ArrayList<TEmpleados>();
		
		for(TEmpleados t : lista.left){
			
			TEmpleados tem = daoEmpl.MostrarUno(t.getId());
			
			if(tem != null){
				listaempleados.add(t);
			}
			
		}
		
		for(TTareas t : lista.right){
			
			TTareas tta = daoTarea.leerUno(t.getId());
			
			if(tta != null){
				listatareas.add(t);
			}
			
		}
		
		 Pair<Collection<TEmpleados>,Collection<TTareas>> dev = new  Pair<>(listaempleados, listatareas);
		return dev;
	}


	
	public Collection<TTareas> LeerLineasPedidoPorTareas(Integer idTareas) {
		
		DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TTareas> lista = daote.LeerLineasPedidoPorTareas(idTareas);
		Collection<TTareas> dev = new ArrayList<TTareas>();
		
		for(TTareas t : lista){
			
			TTareas tta = daoTarea.leerUno(idTareas);
			
			if(tta != null){
				dev.add(t);
			}
			
		}
		
		return dev;
	}


	
	public Collection<TEmpleados> LeerLineasPedidoPorEmpleado(Integer idEmpleado) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TEmpleados> lista = daote.LeerLineasPedidoPorEmpleado(idEmpleado);
		Collection<TEmpleados> dev = new ArrayList<TEmpleados>();
		
		for(TEmpleados t : lista){
			
			TEmpleados tem = daoEmpl.MostrarUno(idEmpleado);
			
			if(tem != null){
				dev.add(t);
			}
			
		}
		
		return dev;
	}

}
