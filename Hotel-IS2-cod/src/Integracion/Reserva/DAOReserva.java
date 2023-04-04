package Integracion.Reserva;

import Negocio.Reserva.TReserva;

import java.util.Collection;


public interface DAOReserva {
	

	public Integer abrir(TReserva tReserva);
	
	public Integer añadir(TReserva tReserva);

	public Integer quitar(Integer id);
	
	public Integer cerrar(Integer id);

	public Integer modificar(THabitaciones tReserva);

	public TReserva MostrarUna(Integer id);
	
	public Collection<TReserva> MostrarTodas();
	
	public Collection<THabitaciones> readReservaPorEmpleado(int idEmpleado);

}
