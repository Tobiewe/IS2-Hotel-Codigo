package Negocio.Departamentos;

import java.util.Collection;

public class SADepartamentoIMP implements SADepartamento {
	
	@Override
	public Integer crear(TDepartamento departamento) {
		if(departamento.getJefe().length() != 9 || departamento.getNombre().trim().equals(""))
		return -1;
		
		
		
		return departamento.getId();
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

}
