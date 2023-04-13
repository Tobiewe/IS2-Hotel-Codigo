package Integracion.LineaReserva;

import Negocio.Reserva.TLineaReserva;

import java.util.Collection;


public interface DAOLineaReserva {
	
	public Integer crear(TLineaReserva tLineaPedido);

	public Integer eliminar(Integer idReserva, Integer idCliente, Integer idHabitacion);

	public Integer modificar(TLineaReserva tLineaPedido);

	public TLineaReserva LeerUno(Integer idReserva, Integer idCliente);
	
	public Collection<TLineaReserva> Leertodos();

	public Collection<TLineaReserva> LeerLineasPedidoPorReserva(Integer idReserva);
	
	public Collection<TLineaReserva> LeerLineasPedidoPorHabitacion(Integer idHabitacion);

}
