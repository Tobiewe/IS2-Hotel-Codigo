package Integracion.LineaReserva;

import Negocio.Reserva.TLineaPedido;

import java.util.Collection;


public interface DAOLineaReserva {
	
	public Integer crear(TLineaPedido tLineaPedido);

	public Integer eliminar(Integer idReserva, Integer idCliente, Integer idHabitacion);

	public Integer modificar(TLineaPedido tLineaPedido);

	public TLineaPedido LeerUno(Integer idReserva, Integer idCliente);
	
	public Collection<TLineaPedido> Leertodos();

	public Collection<TLineaPedido> LeerLineasPedidoPorReserva(Integer idReserva);
	
	public Collection<TLineaPedido> LeerLineasPedidoPorHabitacion(Integer idHabitacion);

}
