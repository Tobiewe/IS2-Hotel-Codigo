package Presentacion.Controller;

import Negocio.Empleados.SAEmpleado;

import java.util.Collection;

import Negocio.Clientes.SACliente;
import Negocio.Tareas.SATarea;
import Presentacion.VFactory.VFactory;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Habitaciones.THabitaciones;
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
		
		case Events.VENTANA_PRINCIPAL:
			cIGUI = VFactory.getInstance().newView(Events.VENTANA_PRINCIPAL_INSTANCE, null);
			break;
		case Events.DEPARTAMENTO_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_VISTA, null);
		case Events.HABITACION_CREAR:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_CREAR, null);
			break;
		case Events.HABITACION_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_VISTA, null);
			break;
		case Events.HABITACION_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_CREAR_VISTA, null);
			break;
		case Events.HABITACION_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_MODIFICAR_VISTA, null);
			break;
		case Events.HABITACION_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_ELIMINAR_VISTA, null);
			break;
		case Events.HABITACION_MOSTRAR_UNA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_MOSTRAR_UNA_VISTA, null);
			break;
		case Events.HABITACION_MOSTRAR_TODAS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_MOSTRAR_TODAS_VISTA, null);
			break;
		case Events.HABITACION_MOSTRAR_DISPONIBLES_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_MOSTRAR_DISPONIBLES_VISTA, null);
			break;
		case Events.HABITACION_MOSTRAR_POR_EMPLEADO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.HABITACION_MOSTRAR_POR_EMPLEADO_VISTA, null);
			break;
		case Events.HABITACION_MOSTRAR_TODAS:
			Collection<THabitaciones> collectionHabTodas = saHabitacion.mostrarTodos();
			if(collectionHabTodas == null)
				cIGUI.update(Events.HABITACION_MOSTRAR_TODAS_ERROR, null);
			else
				cIGUI.update(Events.HABITACION_MOSTRAR_TODAS_SUCCESS, collectionHabTodas);
			break;
		case Events.HABITACION_MOSTRAR_DISPONIBLES:
			Collection<THabitaciones> collectionHabDisponibles = saHabitacion.MostrarTodasDisponibles();
			if(collectionHabDisponibles == null)
				cIGUI.update(Events.HABITACION_MOSTRAR_DISPONIBLES_ERROR, null);
			else
				cIGUI.update(Events.HABITACION_MOSTRAR_DISPONIBLES_SUCCESS, collectionHabDisponibles);
		break;

		}
		
	}

}
