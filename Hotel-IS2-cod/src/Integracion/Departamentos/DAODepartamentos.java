package Integracion.Departamentos;

import Negocio.Departamentos.TDepartamento;

import java.util.Collection;

public interface DAODepartamentos {

	public Integer crear(TDepartamento tDepartamento);

	public Integer borrar(Integer id);

	public Integer modificar(TDepartamento tDepartamento);

	public TDepartamento MostrarUno(Integer id);
	
	public TDepartamento MostrarPorNombre(String nombre);

	public Collection<TDepartamento> MostrarTodos();
	
}
