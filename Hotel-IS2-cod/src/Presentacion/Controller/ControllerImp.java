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
		case Events.DEPARTAMENTO_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_CREAR_VISTA, null);
			break;
		case Events.DEPARTAMENTO_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_MODIFICAR_VISTA, null);

			break;
		case Events.DEPARTAMENTO_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_ELIMINAR_VISTA, null);

			break;
			
		case Events.DEPARTAMENTO_MOSTRAR_UNO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_MOSTRAR_UNO_VISTA, null);

			break;
		case Events.DEPARTAMENTO_MOSTRAR_TODOS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.DEPARTAMENTO_MOSTRAR_TODOS_VISTA, null);
			break;
		case Events.DEPARTAMENTO_CREAR:
			tDepartamento = (TDepartamento) data;
			saSolution = saDepartamento.crear(tDepartamento);
			if(saSolution == -2)
				cIGUI.update(Events.DEPARTAMENTO_CREAR_REPEATED, tDepartamento.getNombre());
			else if(saSolution == -5)
				cIGUI.update(Events.DEPARTAMENTO_CREAR_WRONG_PARAMETERS, null);
			else if(saSolution > 0)
				cIGUI.update(Events.DEPARTAMENTO_CREAR_SUCCESS, tDepartamento.getNombre());
			break;
		case Events.DEPARTAMENTO_ELIMINAR:
			saSolution = saDepartamento.eliminar((Integer) data);
			if(saSolution == -2)
				cIGUI.update(Events.DEPARTAMENTO_ELIMINAR_NOTFOUND, data);
			else
				cIGUI.update(Events.DEPARTAMENTO_ELIMINAR_SUCCESS, data);
			break;
		case Events.DEPARTAMENTO_MOSTRAR_UNO:
			tDepartamento = saDepartamento.mostrarUno((Integer) data);
			
			if(tDepartamento == null)
				cIGUI.update(Events.DEPARTAMENTO_MOSTRAR_UNO_NO_ID, null);
			else
				cIGUI.update(Events.DEPARTAMENTO_MOSTRAR_UNO_SI_ID, tDepartamento);
			break;
		case Events.DEPARTAMENTO_MOSTRAR_TODOS:
			Collection<TDepartamento> collectionDep= saDepartamento.mostrarTodos();
			if(collectionDep.isEmpty())
				cIGUI.update(Events.DEPARTAMENTO_MOSTRAR_TODOS_ERROR, null);
			else
				cIGUI.update(Events.DEPARTAMENTO_MOSTRAR_TODOS_SUCCESS, collectionDep);
			break;
		case Events.EMPLEADO_MOSTRAR_UNO:
			tEmpleado = saEmpleado.mostrarUno((Integer) data);
			
			if(tEmpleado== null)
				cIGUI.update(Events.EMPLEADO_MOSTRAR_UNO_NO_ID, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_UNO_SI_ID, tEmpleado);
			break;
		case Events.EMPLEADO_MOSTRAR_TODOS:
			Collection<TEmpleados> collectionEmpleado = saEmpleado.mostrarTodos();
			if(collectionEmpleado.isEmpty())
				cIGUI.update(Events.EMPLEADO_MOSTRAR_TODOS_ERROR, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_TODOS_SUCCESS, collectionEmpleado);
			break;
		case Events.RESERVA_MOSTRAR_UNA:
			tReserva = saReserva.mostrarUno((Integer) data);
			if(tReserva == null)
				cIGUI.update(Events.RESERVA_MOSTRAR_UNA_NO_ID, null);
			else
				cIGUI.update(Events.RESERVA_MOSTRAR_UNA_SI_ID, tReserva);
			break;
		case Events.RESERVA_MOSTRAR_TODAS:
			Collection<TReserva> collectionReserva = saReserva.mostrarTodos();
			if(collectionReserva.isEmpty())
				cIGUI.update(Events.RESERVA_MOSTRAR_TODAS_ERROR, null);
			else
				cIGUI.update(Events.RESERVA_MOSTRAR_TODAS_SUCCESS, collectionReserva);
			break;
		case Events.TAREA_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_CREAR_VISTA, null);
			break;
		case Events.TAREA_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_MODIFICAR_VISTA, null);
			break;
		case Events.TAREA_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_ELIMINAR_VISTA, null);
			break;
		case Events.TAREA_MOSTRAR_UNA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_MOSTRAR_UNA_VISTA, null);
			break;
		case Events.TAREA_MOSTRAR_TODAS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_MOSTRAR_TODAS_VISTA, null);
			break;
		case Events.TAREA_VINCULAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_VINCULAR_VISTA, null);
			break;
		case Events.TAREA_DESVINCULAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.TAREA_DESVINCULAR_VISTA, null);
			break;
		case Events.TAREA_MOSTRAR_TODOS:
			Collection<TTareas> collectionTarea= saTarea.leerTodos();
			if(collectionTarea.isEmpty())
				cIGUI.update(Events.TAREA_MOSTRAR_TODAS_ERROR, null);
			else
				cIGUI.update(Events.TAREA_MOSTRAR_TODAS_SUCCESS, collectionTarea);
			break;
			
		case Events.TAREA_MOSTRAR_UNO:
			tTarea = saTarea.leerUno((Integer) data);
			
			if(tTarea == null)
				cIGUI.update(Events.TAREA_MOSTRAR_UNA_NO_ID, null);
			else
				cIGUI.update(Events.TAREA_MOSTRAR_UNA_SI_ID, tTarea);
			break;
			
		case Events.CLIENTE_MOSTRAR_TODOS:
			Collection<TCliente> collectionCliente = saCliente.mostrarTodos();
			if(collectionCliente.isEmpty())
				cIGUI.update(Events.CLIENTE_MOSTRAR_TODOS_ERROR, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_TODOS_SUCCESS, collectionCliente);
			break;
		case Events.CLIENTE_MOSTRAR_UNO:
			tCliente = saCliente.mostrarUno((Integer) data);
			
			if(tCliente == null)
				cIGUI.update(Events.CLIENTE_MOSTRAR_UNO_NO_ID, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_UNO_SI_ID, tCliente);
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
			
		case Events.HABITACION_MODIFICAR:
			tHabitacion = (THabitaciones)data;
			saSolution = saHabitacion.modificar(tHabitacion);
			if(saSolution == -2)
				cIGUI.update(Events.HABITACION_MODIFICAR_NOTFOUND, tHabitacion.getNumero());
			else if(saSolution == -5)
				cIGUI.update(Events.HABITACION_MODIFICAR_WRONG_PARAMETERS, tHabitacion.getNumero());
			else if(saSolution > 0)
				cIGUI.update(Events.HABITACION_MODIFICAR_SUCCESS, tHabitacion.getNumero());
			
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
			if(collectionHabTodas.isEmpty())
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
		case Events.HABITACION_ELIMINAR:
			saSolution = saHabitacion.eliminar((Integer) data);
			
			if(saSolution == -2)
				cIGUI.update(Events.HABITACION_ELIMINAR_NOTFOUND, data);
			else
				cIGUI.update(Events.HABITACION_ELIMINAR_SUCCESS, data);
			break;

			
		case Events.HABITACION_MOSTRAR_UNA:
			tHabitacion = saHabitacion.mostrarUno((Integer) data);
			
			if(tHabitacion== null)
				cIGUI.update(Events.HABITACION_MOSTRAR_UNA_NO_ID, null);
			else
				cIGUI.update(Events.HABITACION_MOSTRAR_UNA_SI_ID, tHabitacion);
			break;
		case Events.HABITACION_MOSTRAR_POR_EMPLEADO:
			Collection<THabitaciones> collectionHabPorEmpleado = saHabitacion.mostrarPorEmpleado((Integer)data);
			if(collectionHabPorEmpleado.isEmpty())
				cIGUI.update(Events.HABITACION_MOSTRAR_POR_EMPLEADO_NOID, (Integer) data);
			else
				cIGUI.update(Events.HABITACION_MOSTRAR_POR_EMPLEADO_ID, collectionHabPorEmpleado);
			break;

		}
		
		//j
		
	}
}


