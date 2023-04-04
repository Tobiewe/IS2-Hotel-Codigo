package Integracion.Habitaciones;

import Negocio.Habitaciones.THabitaciones;

import java.util.Collection;

public interface DAOHabitaciones {

	public Integer a�adir(THabitaciones tHabitaciones);

	public Integer borrar(Integer id);

	public Integer modificar(THabitaciones tHabitaciones);

	public THabitaciones MostrarUna(Integer id);
	
	public Collection<THabitaciones> MostrarTodas();

	public Collection<THabitaciones> MostrarTodasDisponibles();
	
	public Collection<THabitaciones> leerHabitacionesPorEmpleado(int idCliente);

	
}
