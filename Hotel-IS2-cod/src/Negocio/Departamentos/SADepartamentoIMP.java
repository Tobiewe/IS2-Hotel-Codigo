package Negocio.Departamentos;

import java.util.Collection;

import Integracion.Departamentos.DAODepartamentos;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;

public class SADepartamentoIMP implements SADepartamento {
	
	@Override
	public Integer crear(TDepartamento tdepartamento) {
		if(tdepartamento.getJefe().length() != 9 || tdepartamento.getNombre().trim().equals("")){
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
		
		tDep.setId(daoDep.crear(tdepartamento));
		
		return tDep.getId();
	}

	@Override
	public Integer modificar(TDepartamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminar(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TDepartamento mostrarUno(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TDepartamento> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TDepartamento MostrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
