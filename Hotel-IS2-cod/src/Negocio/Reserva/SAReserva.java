package Negocio.Reserva;

import java.util.Collection;

import Negocio.Reserva.TReserva;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Reserva.TLineaReserva;

public interface SAReserva {
	public Integer abrir(TReserva tReserva);
	
	public Integer eliminar(Integer id);

	public Integer modificar(TReserva tReserva);

	public TReserva MostrarUna(Integer id);
	
	public Collection<TReserva> MostrarTodas();
	
	public Collection<TReserva> leerReservasPorCliente(Integer idCliente);
	
	public Integer añadirHabitacion(TLineaReserva tLineaPedido);

	public Integer eliminarHabitacion(Integer idReserva, Integer idHabitacion);

	public Collection<THabitaciones> ListarHabitacionesPorReserva(Integer idReserva);
	
	public Collection<TReserva> ListarReservasPorHabitacion(Integer idHabitacion);
	
}
