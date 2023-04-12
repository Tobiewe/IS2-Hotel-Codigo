package Negocio.Habitaciones;

import java.util.Collection;

import Negocio.Habitaciones.THabitaciones;

public interface SAHabitacion {
	
	public Integer crear(THabitaciones habitacion);
	
	public Integer modificar(THabitaciones habitacion);

	public Integer eliminar(Integer idHabitacion);

	public THabitaciones mostrarUno(Integer idHabitacion);
	
	public Collection<THabitaciones> mostrarTodos();
	
	public Collection<THabitaciones> mostrarPorEmpleado(Integer idEmpleado);
	
	public Collection<THabitaciones> MostrarTodasDisponibles();
}
