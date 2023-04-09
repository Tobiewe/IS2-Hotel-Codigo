package Presentacion.Controller;

import Negocio.Empleados.SAEmpleado;
import Negocio.Clientes.SACliente;
import Negocio.Tareas.SATarea;
import Presentacion.VFactory.VFactory;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.NegocioFactory.SAFactory;
import Negocio.Reserva.SAReserva;

public class ControllerImp extends Controller {
	private IGUI cIGUI;
	
	private SAEmpleado saEmpleado;
	private SACliente saCliente;
	private SATarea saTarea;
	private SADepartamento saDepartamento;
	private SAHabitacion saHabitacion;
	private SAReserva saReserva;
	
	public ControllerImp() {
		saEmpleado = SAFactory.getInstance().newSAEmpleado();
		saCliente = SAFactory.getInstance().newSACliente();
		saTarea = SAFactory.getInstance().newSATarea();
		saDepartamento = SAFactory.getInstance().newSADepartamento();
		saHabitacion = SAFactory.getInstance().newSAHabitaciones();
		saReserva = SAFactory.getInstance().newSAReserva();
	}
	@Override
	public void carryAction(int event, Object data) {
		
		
		switch(event)
		{
		case Events.HABITACION_CREAR:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_CREAR, null);
			break;
		case Events.VENTANA_PRINCIPAL:
			cIGUI = VFactory.getInstance().newView(Events.VENTANA_PRINCIPAL_INSTANCE, null);
		}
		
	}

}
