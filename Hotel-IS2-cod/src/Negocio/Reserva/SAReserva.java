package Negocio.Reserva;

import java.util.Collection;

import Negocio.Reserva.TReserva;
import Negocio.Reserva.TLineaPedido;

public interface SAReserva {
	public Integer abrir(TReserva reserva);
	
	public Integer aniadirHabitacion(TLineaPedido pedido);
	
	public Integer eliminarHabitacion(TLineaPedido pedido);
	
	public Integer modificar(TReserva reserva);
	
	public Integer cerrar(TLineaPedido pedido);

	public Integer eliminar(int idReserva);

	public TReserva mostrarUno(int idReserva);
	
	public Collection<TReserva> mostrarTodos();
	
	public Collection<TReserva> mostrarPorCliente();
	
}
