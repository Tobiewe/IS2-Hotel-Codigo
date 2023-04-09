package Negocio.Departamentos;

import java.util.Collection;

import Negocio.Departamentos.TDepartamento;

public interface SADepartamento {
	
	public Integer crear(TDepartamento departamento);
	
	public Integer modificar(TDepartamento departamento);

	public Integer eliminar(int idDepartamento);

	public TDepartamento mostrarUno(int idDepartamento);
	
	public TDepartamento MostrarPorNombre(String nombre);
	
	public Collection<TDepartamento> mostrarTodos();
}
