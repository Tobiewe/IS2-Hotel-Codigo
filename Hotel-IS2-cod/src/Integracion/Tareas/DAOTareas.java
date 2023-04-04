package Integracion.Tareas;

import Negocio.Tareas.TTareas;

import java.util.Collection;


public interface DAOTareas {
	
	public Integer crear(TTareas tTareas);

	public Integer eliminar(Integer id);

	public Integer modificar(TTareas tTareas);

	public TTareas leerUno(Integer id);

	public Collection<TTareas> leerTodos();
	
}
