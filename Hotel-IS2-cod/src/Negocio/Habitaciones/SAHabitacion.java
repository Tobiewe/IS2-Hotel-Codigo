package Negocio.Habitaciones;

import java.util.Collection;

import Negocio.Habitaciones.THabitaciones;

public interface SAHabitacion {
	
	public Integer crear(THabitaciones habitacion);
	
	public Integer modificar(THabitaciones habitacion);

	public Integer eliminar(int id);

	public THabitaciones mostrarUno(int id);
	
	public Collection<THabitaciones> mostrarTodos();
	
	public Collection<THabitaciones> mostrarPorEmpleado();
}
