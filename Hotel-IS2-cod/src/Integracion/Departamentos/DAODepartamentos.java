package Integracion.Departamentos;

import Negocio.Departamento.TDepartamentos;

import java.util.Collection;

public interface DAODepartamentos {

	public Integer crear(TDepartamentos tDepartamento);

	public Integer borrar(Integer id);

	public Integer modificar(TDepartamentos tDepartamento);

	public TDepartamentos MostrarUno(Integer id);

	public Collection<TDepartamentos> MostrarTodos();
	
}
