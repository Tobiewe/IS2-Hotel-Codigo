package Negocio.Departamentos;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.Departamentos.DAODepartamentos;
import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;

public class SADepartamentoIMP implements SADepartamento {
	
	
	@SuppressWarnings("null")
	public Integer crear(TDepartamento tdepartamento) {
		if(tdepartamento.getNombre().trim().equals("")){
			return -5;
		}
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento tDep = daoDep.MostrarPorNombre(tdepartamento.getNombre());
		
		if(tDep != null){
			tdepartamento.setId(tDep.getId());
			tdepartamento.setActivado(true);
			
			if(!tDep.getActivado()){
				daoDep.modificar(tdepartamento);
			}
			
			return tDep.getActivado() ? -2 : tDep.getId();
		}
		
		
		return daoDep.crear(tdepartamento);
	}

	
	public Integer modificar(TDepartamento tdepartamento) {
		if( tdepartamento.getNombre().trim().equals("")){
			return -5;
		}
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento tDep = daoDep.MostrarUno(tdepartamento.getId());
		
		if(tDep == null){
			return -2;
		}
		if (!tDep.getNombre().equals(tdepartamento.getNombre())){
			return -2;
		}
		
		return daoDep.modificar(tdepartamento);
		
	}

	
	public Integer eliminar(int idDepartamento) {
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento tDep = daoDep.MostrarUno(idDepartamento);
		
		if(tDep == null || !tDep.getActivado()){
			return -2;
		}
		
		return daoDep.borrar(idDepartamento);
		
	}

	
	public TDepartamento mostrarUno(int idDepartamento) {
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento tDep = daoDep.MostrarUno(idDepartamento);
		
		if(tDep == null && !tDep.getActivado()){
			return null;
		}
		
		return daoDep.MostrarUno(idDepartamento);
	}

	
	public Collection<TDepartamento> mostrarTodos() {
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		Collection<TDepartamento> dep = daoDep.MostrarTodos();

		return dep;
	}

	
	public TDepartamento MostrarPorNombre(String nombre) {
		
		DAODepartamentos daoDep = FactoriaIntegracion.getInstance().newDAODepartamento();
		TDepartamento tDep = daoDep.MostrarPorNombre(nombre);
		
		if(tDep == null){
			return null;
		}
		
		return daoDep.MostrarPorNombre(nombre);
		
	}

}
