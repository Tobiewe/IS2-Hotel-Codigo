package Negocio.Tareas;

import java.util.Collection;

public interface SATarea {

	public Integer crear(TTareas tTareas);

	public Integer eliminar(Integer id);

	public Integer modificar(TTareas tTareas);

	public TTareas leerUno(Integer id);

	public Collection<TTareas> leerTodos();
	
}
