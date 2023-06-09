package Negocio.Habitaciones;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.LineaReserva.DAOLineaReserva;
import Negocio.Empleados.TEmpleados;
import Negocio.Reserva.TLineaReserva;

public class SAHabitacionIMP implements SAHabitacion {

	
	public Integer crear(THabitaciones habitacion) {
		
		if(habitacion.getPiso() < 0 || habitacion.getPrecio() <= 0 || habitacion.gettamanyo() <= 0){
			return -5; // los parametros deben ser mayor de 0
		}
		
		DAOEmpleados daoEmp = FactoriaIntegracion.getInstance().newDAOEmpleado();
		TEmpleados te = daoEmp.MostrarUno(habitacion.getId_empledo());
		
		if(te == null){
			return -6; //el empleado no existe
		}
		if(!te.getActivo()){
			return -7; //el empleado no esta activo
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
		
		habitacion.setNumero(daoHab.a�adir(habitacion));
		return habitacion.getNumero();
	}

	
	public Integer modificar(THabitaciones habitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(habitacion.getNumero());
		
		if(th == null){
			return -2;
		}
		
		if(habitacion.getPiso() < 0 || habitacion.getPrecio() <= 0 || habitacion.gettamanyo() <= 0){
			return -5;
		}	
		
		
		return daoHab.modificar(habitacion);
		
	}

	
	public Integer eliminar(Integer idHabitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(idHabitacion);
		
		if(th == null){
			return -2;		
		}
		
		DAOLineaReserva daolinea = FactoriaIntegracion.getInstance().newLineaReserva();
		Collection<TLineaReserva> lista = daolinea.LeerLineasPedidoPorHabitacion(idHabitacion);
		
		for(TLineaReserva tl : lista){
			if(tl == null){
				return -2;
			}
		}
		
		return daoHab.borrar(idHabitacion);
	}

	
	public THabitaciones mostrarUno(Integer idHabitacion) {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoHab.MostrarUna(idHabitacion);
		
		if(th == null){
			return null;		
		}
		
		
		return th;
		
	}

	
	public Collection<THabitaciones> mostrarTodos() {
		
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.MostrarTodas();
		
		return lista;
	}

	
	public Collection<THabitaciones> mostrarPorEmpleado(Integer idEmpleado) {
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.leerHabitacionesPorEmpleado(idEmpleado);
		
		return lista;
	}


	
	public Collection<THabitaciones> MostrarTodasDisponibles() {
		DAOHabitaciones daoHab = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		Collection<THabitaciones> lista = daoHab.MostrarTodasDisponibles();
		
		
		return lista;
	}

}
