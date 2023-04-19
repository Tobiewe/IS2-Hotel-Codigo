package Integracion.Reserva;

import Negocio.Reserva.TReserva;

import java.util.Collection;


public interface DAOReserva {
	

	public Integer abrir(TReserva tReserva);
	
	public Integer eliminar(Integer id);

	public Integer modificar(TReserva tReserva);

	public TReserva MostrarUna(Integer id);
	
	public Collection<TReserva> MostrarTodas();
	
	public Collection<TReserva> leerReservasPorCliente(Integer idCliente);

}
