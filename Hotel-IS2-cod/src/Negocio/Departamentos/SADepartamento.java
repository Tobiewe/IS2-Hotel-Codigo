package Negocio.Departamentos;

import java.util.Collection;

import Negocio.Departamentos.TDepartamento;

public interface SADepartamento {
	
	public Integer crear(TDepartamento tdepartamento);
	
	public Integer modificar(TDepartamento tdepartamento);

	public Integer eliminar(int idDepartamento);

	public TDepartamento mostrarUno(int idDepartamento);
	
	public TDepartamento MostrarPorNombre(String nombre);
	
	public Collection<TDepartamento> mostrarTodos();
}
