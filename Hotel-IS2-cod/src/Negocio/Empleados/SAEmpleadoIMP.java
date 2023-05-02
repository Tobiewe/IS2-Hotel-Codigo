package Negocio.Empleados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Integracion.Departamentos.DAODepartamentos;
import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.Tareas.DAOTareas;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Negocio.Departamentos.TDepartamento;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Tareas.TTareas;

public class SAEmpleadoIMP implements SAEmpleado {

	
	public Integer crear(TEmpleados empleado) {
		
		String numero = Integer.toString(empleado.getTelefono());
		
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(empleado.getCorreo());
		
		
		if(empleado.getApellidos().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getSueldo() == 0){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		else if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		else if(!mather.find()){
			return -7; //correo no valido
		}
		
		DAODepartamentos DAOdep =  FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento td = DAOdep.MostrarUno(empleado.getId_Departamento());
		
		if(td == null){
			return -8; //el departamento no existe
		}
		else if(!td.getActivado()){
			return -9; //el departamento no esta activo
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
		
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(empleado.getCorreo());
		
		
		if(empleado.getApellidos().trim().equals("") || empleado.getCorreo().trim().equals("") || empleado.getNombre().trim().equals("") || empleado.getSueldo() == 0){
			return -5; // los datos introducidos estan vacios porfavor complete los campos
		}
		else if(numero.length() != 9){
			return -6; // numero de longuitdud mayor
		}
		else if(!mather.find()){
			return -7; //correo no valido
		}
		
		DAODepartamentos DAOdep =  FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento td = DAOdep.MostrarUno(empleado.getId_Departamento());
		
		if(td == null){
			return -8; //el departamento no existe
		}
		else if(!td.getActivado()){
			return -9; //el departamento no esta activo
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

		
		return lista;
	}

	
	public Collection<TEmpleados> mostrarPorDepartamento(Integer idDepartamento) {
		
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();
		Collection<TEmpleados> lista = daoEmpl.mostrarPorDepartamento(idDepartamento);

		
		return lista;
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


	
	public Collection<TEmpleados> LeerLineasPedidoPorTareas(Integer idTareas) {
		
		//DAOTareas daoTarea = FactoriaIntegracion.getInstance().newDAOTarea();
		DAOEmpleados daoEmpl =  FactoriaIntegracion.getInstance().newDAOEmpleado();

		
		DAOTareasDelEmpleado daote = FactoriaIntegracion.getInstance().newDAOTareasDelEmpleado();
		Collection<TEmpleados> lista = daote.LeerLineasPedidoPorTareas(idTareas);
		Collection<TEmpleados> dev = new ArrayList<TEmpleados>();
		
		for(TEmpleados t : lista){
			
			TEmpleados tta = daoEmpl.MostrarUno(idTareas);
			
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
