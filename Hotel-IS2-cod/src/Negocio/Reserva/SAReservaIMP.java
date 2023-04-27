package Negocio.Reserva;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.LineaReserva.DAOLineaReserva;
import Integracion.Reserva.DAOReserva;
import Negocio.Clientes.TCliente;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Tareas.TTareas;

public class SAReservaIMP implements SAReserva{

	
	public Integer abrir(TReserva reserva) {
		if(reserva.getNoches() <= 0){
			return -5;
		}
		
		DAOCliente daoc = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tc = daoc.MostrarUno(reserva.getId_cliente());
		
		if(tc == null){
			return -6; // el cliente no existe
		}
		else if(!tc.getActivo()){
			return -7; // el cliente no esta ativo
		}
		
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
	
		return daoR.abrir(reserva);
	}

	
	public Integer modificar(TReserva reserva) {
		
		if(reserva.getNoches() <= 0){
			return -5;
		}
		
		System.out.println(reserva.getId_cliente());
		
		DAOCliente daoc = FactoriaIntegracion.getInstance().newDAOCliente();
		TCliente tc = daoc.MostrarUno(reserva.getId_cliente());
		
		if(tc == null){
			return -6; // el cliente no existe
		}
		else if(!tc.getActivo()){
			return -7; // el cliente no esta ativo
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
		
		return lista;
		
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
		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(tLineaPedido.getId_reserva());
		
		if(tr == null){
			return -5;
		}
		if(th == null){
			return -7;
		}

		if(th.getOcupada()){
			return -6; //habitacion ocupada
		}
		
		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoLR.añadirHabitacion(tLineaPedido); 
	}


	
	public Integer eliminarHabitacion(Integer idReserva, Integer idHabitacion) { 

		DAOHabitaciones daoH = FactoriaIntegracion.getInstance().newDAOHabitaciones();
		THabitaciones th = daoH.MostrarUna(idHabitacion);

		DAOReserva daoR = FactoriaIntegracion.getInstance().newDAOReserva();
		TReserva tr = daoR.MostrarUna(idReserva);
		
		if(tr == null){
			return -5;
		}
		if(th == null){
			return -7;
		}
		
		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		
		return daoLR.eliminarHabitacion(idReserva, idHabitacion); 

	}


	
	public Collection<THabitaciones> ListarHabitacionesPorReserva(Integer idReserva) {

		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		Collection<THabitaciones> lista = daoLR.ListarHabitacionesPorReserva(idReserva);
		
		return lista;

	}


	
	public Collection<TReserva> ListarReservasPorHabitacion(Integer idHabitacion) {

		DAOLineaReserva daoLR = FactoriaIntegracion.getInstance().newLineaReserva();
		Collection<TReserva> lista = daoLR.ListarReservasPorHabitacion(idHabitacion);
		
		return lista;
		
	}

}
