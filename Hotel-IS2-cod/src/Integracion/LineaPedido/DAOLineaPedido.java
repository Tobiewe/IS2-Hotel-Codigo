package Integracion.LineaPedido;

import Negocio.LineaPedido.TLineaPedido;

import java.util.Collection;


public interface DAOLineaPedido {
	
	public Integer crear(TLineaPedido tLineaPedido);

	public Integer eliminar(Integer id);

	public Integer modificar(TLineaPedido tLineaPedido);

	public TLineaPedido LeerUno(Integer id);
	
	public Collection<TLineaPedido> Leertodos();

	public Collection<TLineaPedido> LeerLineasPedidoPorReserva(int idReserva);
	
	public Collection<TLineaPedido> LeerLineasPedidoPorHabitacion(int idHabitacion);

}
