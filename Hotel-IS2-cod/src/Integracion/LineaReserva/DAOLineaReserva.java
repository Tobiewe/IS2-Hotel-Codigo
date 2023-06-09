package Integracion.LineaReserva;

import Negocio.Habitaciones.THabitaciones;
import Negocio.Reserva.TLineaReserva;
import Negocio.Reserva.TReserva;

import java.util.Collection;


public interface DAOLineaReserva {
	
	public Integer aņadirHabitacion(TLineaReserva tLineaPedido);

	public Integer eliminarHabitacion(Integer idReserva, Integer idHabitacion);

	public Collection<THabitaciones> ListarHabitacionesPorReserva(Integer idReserva);
	
	public Collection<TReserva> ListarReservasPorHabitacion(Integer idHabitacion);
	
	public Collection<TLineaReserva> LeerLineasPedidoPorHabitacion(Integer idHabitacion);

}
