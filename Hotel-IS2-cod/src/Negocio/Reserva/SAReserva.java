package Negocio.Reserva;

import java.util.Collection;

import Negocio.Reserva.TReserva;
import Negocio.Reserva.TLineaReserva;

public interface SAReserva {
	public Integer abrir(TReserva tReserva);
	
	public Integer eliminar(Integer id);

	public Integer modificar(TReserva tReserva);

	public TReserva MostrarUna(Integer id);
	
	public Collection<TReserva> MostrarTodas();
	
	public Collection<TReserva> leerReservasPorCliente(Integer idCliente);
	
}
