package Negocio.Departamentos;

import java.util.Collection;

import Negocio.Departamentos.TDepartamento;

public interface SADepartamento {
	
	public Integer crear(TDepartamento departamento);
	
	public Integer modificar(TDepartamento departamento);

	public Integer eliminar(int id);

	public TDepartamento mostrarUno(int id);
	
	public Collection<TDepartamento> mostrarTodos();
}
