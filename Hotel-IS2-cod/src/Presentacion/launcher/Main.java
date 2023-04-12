package Presentacion.launcher;

import java.util.Collection;
import java.sql.Date;

import Integracion.Departamentos.DAODepartamentos;
import Integracion.Departamentos.DAODepartamentosImp;
import Integracion.LineaReserva.DAOLineaReservaImp;
import Integracion.LineaReserva.DAOLineaReserva;
import Integracion.Reserva.DAOReserva;
import Integracion.Reserva.DAOReservaImp;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleadoImp;
import Negocio.Departamentos.TDepartamento;
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
