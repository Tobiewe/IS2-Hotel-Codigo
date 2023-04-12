package Negocio.Reserva;

import java.util.Collection;

import Negocio.Reserva.TReserva;
import Negocio.Reserva.TLineaReserva;

public interface SAReserva {
	public Integer abrir(TReserva reserva);
	
	public Integer aniadirHabitacion(TLineaReserva pedido);
	
	public Integer eliminarHabitacion(TLineaReserva pedido);
	
	public Integer modificar(TReserva reserva);
	
	public Integer cerrar(TLineaReserva pedido);

	public Integer eliminar(Integer idReserva);

	public TReserva mostrarUno(Integer idReserva);
	
	public Collection<TReserva> mostrarTodos();
	
	public Collection<TReserva> mostrarPorCliente(Integer idCliente);
	
}
