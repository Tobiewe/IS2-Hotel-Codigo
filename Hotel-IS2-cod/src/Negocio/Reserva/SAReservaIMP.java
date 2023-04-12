package Negocio.Reserva;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.LineaReserva.DAOLineaReserva;
import Integracion.Reserva.DAOReserva;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Tareas.TTareas;

public class SAReservaIMP implements SAReserva{

	
	public Integer abrir(TReserva reserva) {
		if(reserva.getNoches() <= 0 || reserva.getNombre().trim().equals("")){
			return -5;
		}
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
	
		return daoR.abrir(reserva);
	}

	
	public Integer aniadirHabitacion(TLineaReserva pedido) {
		
		DAOHabitaciones daoH = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoH.MostrarUna(pedido.getId_habitacion());
		
		if(th.getOcupada() == true){
			return -2;
		}
		
		DAOLineaReserva daoR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoR.crear(pedido);
		
	}

	
	public Integer eliminarHabitacion(TLineaReserva pedido) {		
		DAOLineaReserva daoR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoR.eliminar(pedido.getId_reserva(), pedido.getId_cliente(), pedido.getId_habitacion());
	}

	
	public Integer modificar(TReserva reserva) {
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(reserva.getId());
		
		if(tr == null){
			return -2;
		}
		
		return daoR.modificar(reserva);
		
	}

	
	public Integer cerrar(TLineaReserva pedido) {
		DAOLineaReserva daoR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return 0; //hay que mirarlo
	}

	
	public Integer eliminar(Integer idReserva) {
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		
		return daoR.eliminar(idReserva);
	}

	
	public TReserva mostrarUno(Integer idReserva) {
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(idReserva);
		
		if(tr == null){
			return null;
		}
		
		return tr;
	}

	
	public Collection<TReserva> mostrarTodos() {
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		Collection<TReserva> lista = daoR.MostrarTodas();
		Collection<TReserva> dev = new ArrayList<TReserva>();
		
		for(TReserva t : lista){
			TReserva tr = daoR.MostrarUna(t.getId());
			if(tr != null){
				dev.add(t);
			}
		}
		
		return dev;
		
	}

	
	public Collection<TReserva> mostrarPorCliente(Integer idCliente) {
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		Collection<TReserva> lista = daoR.leerReservasPorCliente(idCliente);
		Collection<TReserva> dev = new ArrayList<TReserva>();
		
		for(TReserva t : lista){
			TReserva tr = daoR.MostrarUna(t.getId());
			if(tr != null){
				dev.add(t);
			}
		}
		
		return dev;
		
	}

}
