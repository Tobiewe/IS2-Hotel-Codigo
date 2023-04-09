package Presentacion.launcher;

import java.util.Collection;
import java.sql.Date;

import Integracion.LineaPedido.DAOLineaPedido;
import Integracion.LineaPedido.DAOLineaPedidoImp;
import Integracion.Reserva.DAOReserva;
import Integracion.Reserva.DAOReservaImp;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleadoImp;
import Negocio.Empleados.TTareasDelEmpleado;
import Negocio.Reserva.TLineaPedido;
import Negocio.Reserva.TReserva;


public class Main {
	public static void main(String[] args){
		
		Date fecha = new Date(15/10/21);
		
		TReserva tReserva = new TReserva(1, 1030f, fecha, "fiesta", 3, 5, true);
		DAOReserva dao = new DAOReservaImp();

		dao.modificar(tReserva);
		
		
		/*Collection<TTareas> ha = dao.leerHabitacionesPorEmpleado(23);
		
		
		for (THabitaciones h : ha) {
			
			System.out.println(h.getId_empledo());
			System.out.println(h.getNumero());
			System.out.println(h.getOcupada());
			System.out.println(h.getPiso());
			System.out.println(h.getTamaño());
			System.out.println(h.getPrecio());
		}*/
		

		
	}
}
