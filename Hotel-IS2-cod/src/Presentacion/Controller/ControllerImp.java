package Presentacion.Controller;

import Negocio.Empleados.SAEmpleado;
import Negocio.Empleados.TEmpleados;

import java.util.Collection;

import Negocio.Clientes.SACliente;
import Negocio.Clientes.TCliente;
import Negocio.Tareas.SATarea;
import Negocio.Tareas.TTareas;
import Negocio.Departamentos.TDepartamento;
import Presentacion.VFactory.VFactory;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Mesa.TMesa;
import Negocio.NegocioFactory.SAFactory;
import Negocio.Reserva.SAReserva;
import Negocio.Reserva.TReserva;

public class ControllerImp extends Controller {
	private IGUI cIGUI;
	
	
	private SAEmpleado saEmpleado;
	private SACliente saCliente;
	private SATarea saTarea;
	private SADepartamento saDepartamento;
	private SAHabitacion saHabitacion;
	private SAReserva saReserva;
	private Integer saSolution;

	private THabitaciones tHabitacion;
	private TReserva tReserva;
	private TEmpleados tEmpleado;
	private TTareas tTarea;
	private TCliente tCliente;
	private TDepartamento tDepartamento;
	
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
			break;
		case Events.TAREA_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_VISTA, null);
			break;
		case Events.CLIENTE_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_VISTA, null);
			break;
		case Events.EMPLEADO_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_VISTA, null);
			break;
		case Events.RESERVA_NUEVA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_VISTA, null);
			break;
		case Events.HABITACION_CREAR:
			tHabitacion = (THabitaciones)data;
			saSolution = saHabitacion.crear(tHabitacion);
			if(saSolution == -1)
				cIGUI.update(Events.HABITACION_CREAR_ERROR, null);
			else if(saSolution == -2)
				cIGUI.update(Events.HABITACION_CREAR_REPEATED,  tHabitacion.getNumero());
			else if(saSolution == -5)
				cIGUI.update(Events.HABITACION_CREAR_WRONG_PARAMETERS, saSolution);
			else if(saSolution > 0)
				cIGUI.update(Events.HABITACION_CREAR_SUCCESS, tHabitacion.getNumero());
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
