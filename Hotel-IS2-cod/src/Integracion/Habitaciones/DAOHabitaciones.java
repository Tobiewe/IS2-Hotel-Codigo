package Integracion.Habitaciones;

import Negocio.Habitaciones.THabitaciones;

import java.util.Collection;

public interface DAOHabitaciones {

	public Integer añadir(THabitaciones tHabitaciones);

	public Integer borrar(Integer numero);

	public Integer modificar(THabitaciones tHabitaciones);

	public THabitaciones MostrarUna(Integer numero);
	
	public Collection<THabitaciones> MostrarTodas();

	public Collection<THabitaciones> MostrarTodasDisponibles();
	
	public Collection<THabitaciones> leerHabitacionesPorEmpleado(Integer idEmpleado);

	
}
