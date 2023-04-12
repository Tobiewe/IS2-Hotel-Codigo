package Negocio.Habitaciones;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.LineaPedido.DAOLineaPedido;
import Negocio.Reserva.TLineaPedido;

public class SAHabitacionIMP implements SAHabitacion {

	
	public Integer crear(THabitaciones habitacion) {
		
		if(habitacion.getPiso() < 0 || habitacion.getPrecio() <= 0 || habitacion.getTamaño() <= 0){
			return -5;
		}
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		if(habitacion.getNumero() != null){
			THabitaciones th = daoHab.MostrarUna(habitacion.getNumero());
			
			if(th != null){
				habitacion.setNumero(habitacion.getNumero());
				
				if(!habitacion.getOcupada()){
					daoHab.modificar(habitacion);
				}
				
				return th.getOcupada() ? -2 : habitacion.getNumero();
			}
		}
		
		habitacion.setNumero(daoHab.añadir(habitacion));
		return habitacion.getNumero();
	}

	
	public Integer modificar(THabitaciones habitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(habitacion.getNumero());
		
		if(th == null){
			return -2;
		}
		
		if(habitacion.getPiso() < 0 || habitacion.getPrecio() <= 0 || habitacion.getTamaño() <= 0){
			return -5;
		}	
		
		
		return daoHab.modificar(habitacion);
		
	}

	
	public Integer eliminar(int idHabitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(idHabitacion);
		
		if(th == null){
			return -2;		
		}
		
		DAOLineaPedido daolinea = FactoriaIntegracion.getInstance().newLineaPedido();
		Collection<TLineaPedido> lista = daolinea.LeerLineasPedidoPorHabitacion(idHabitacion);
		
		for(TLineaPedido tl : lista){
			if(tl.getActiva()){
				return -1; //que no pertenece a ninguna reserva
			}
		}
		
		return daoHab.borrar(idHabitacion);
	}

	
	public THabitaciones mostrarUno(int idHabitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(idHabitacion);
		
		if(th == null){
			return null;		
		}
		
		return daoHab.MostrarUna(idHabitacion);
		
	}

	
	public Collection<THabitaciones> mostrarTodos() {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.MostrarTodas();
		Collection<THabitaciones> dev = new ArrayList<THabitaciones>();
		
		for(THabitaciones th : lista){
			
			if(daoHab.MostrarUna(th.getNumero()) != null){
				dev.add(th);
			}
			
		}
		
		return dev;
	}

	
	public Collection<THabitaciones> mostrarPorEmpleado(Integer idEmpleado) {
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.leerHabitacionesPorEmpleado(idEmpleado);
		Collection<THabitaciones> dev = new ArrayList<THabitaciones>();
		
		for(THabitaciones th : lista){
			
			if(daoHab.MostrarUna(th.getNumero()) != null){
				dev.add(th);
			}
			
		}
		
		return dev;
	}


	
	public Collection<THabitaciones> MostrarTodasDisponibles() {
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.MostrarTodasDisponibles();
		Collection<THabitaciones> dev = new ArrayList<THabitaciones>();
		
		for(THabitaciones th : lista){
			
			if(daoHab.MostrarUna(th.getNumero()) != null && !th.getOcupada()){
				dev.add(th);
			}
			
		}
		return dev;
	}

}
