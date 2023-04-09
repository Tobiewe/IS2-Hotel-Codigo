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
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;


public class Main {
	public static void main(String[] args){
		Controller.getInstance().carryAction(Events.VENTANA_PRINCIPAL, null);
		
		
	}
}
