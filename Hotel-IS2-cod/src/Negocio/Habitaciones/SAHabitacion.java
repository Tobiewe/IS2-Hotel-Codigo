package Negocio.Habitaciones;

import java.util.Collection;

import Negocio.Habitaciones.THabitaciones;

public interface SAHabitacion {
	
	public Integer crear(THabitaciones habitacion);
	
	public Integer modificar(THabitaciones habitacion);

	public Integer eliminar(int idHabitacion);

	public THabitaciones mostrarUno(int idHabitacion);
	
	public Collection<THabitaciones> mostrarTodos();
	
	public Collection<THabitaciones> mostrarPorEmpleado(Integer idEmpleado);
	
	public Collection<THabitaciones> MostrarTodasDisponibles();
}
