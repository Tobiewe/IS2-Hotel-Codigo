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
		if(reserva.getNoches() <= 0 || reserva.getNombre().trim().equals("") || reserva.getTotal() != 0 || reserva.getActivo()){
			return -5;
		}
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
	
		return daoR.abrir(reserva);
	}

	
	public Integer modificar(TReserva reserva) {
		
		if(reserva.getNoches() <= 0 || reserva.getNombre().trim().equals("")){
			return -5;
		}
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(reserva.getId());
		
		if(tr == null){
			return -2;
		}
		
		return daoR.modificar(reserva);
		
	}

	
	public Integer eliminar(Integer idReserva) {
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		
		return daoR.eliminar(idReserva);
	}

	
	public TReserva MostrarUna(Integer idReserva) {
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(idReserva);
		
		if(tr == null){
			return null;
		}
		
		return tr;
	}

	
	public Collection<TReserva> MostrarTodas() {
		
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

	
	public Collection<TReserva> leerReservasPorCliente(Integer idCliente) {
		
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


	
	public Integer añadirHabitacion(TLineaReserva tLineaPedido) {
		
		DAOHabitaciones daoH = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoH.MostrarUna(tLineaPedido.getId_habitacion());

		if(th.getOcupada()){
			return -6; //habitacion ocupada
		}
		
		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoLR.añadirHabitacion(tLineaPedido); 
	}


	
	public Integer eliminarHabitacion(Integer idReserva, Integer idHabitacion) { 

		DAOHabitaciones daoH = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoH.MostrarUna(idHabitacion);

		if(th.getOcupada()){
			return -6; //habitacion ocupada
		}
		
		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoLR.eliminarHabitacion(idReserva, idHabitacion); 

	}


	
	public Collection<THabitaciones> ListarHabitacionesPorReserva(Integer idReserva) {

		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		Collection<THabitaciones> lista = daoLR.ListarHabitacionesPorReserva(idReserva);
		Collection<THabitaciones> dev = new ArrayList<THabitaciones>();
		
		for(THabitaciones t : lista){
			
			if(t != null){
				dev.add(t);
			}
		}
		
		return dev;

	}


	
	public Collection<TReserva> ListarReservasPorHabitacion(Integer idHabitacion) {

		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		Collection<TReserva> lista = daoLR.ListarReservasPorHabitacion(idHabitacion);
		Collection<TReserva> dev = new ArrayList<TReserva>();
		
		for(TReserva t : lista){
			
			if(t != null){
				dev.add(t);
			}
		}
		
		return dev;
		
	}

}
