package Presentacion.VFactory;

import Presentacion.Cliente.VCliente;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Departamento.VDepartamento;
import Presentacion.Empleado.VEmpleado;
import Presentacion.Habitacion.VHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VAņadirHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VEliminarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VModificarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarPorEmpleado;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasDisponiblesHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarUnaHabitacion;
import Presentacion.Reserva.VReserva;
import Presentacion.Tarea.VTarea;
import Presentacion.Tarea.VTareaCasosUso.VCrearTarea;
import Presentacion.launcher.VPrincipal;

public class VFactoryImp extends VFactory {

	@Override
	public IGUI newView(int event, Object data) {
		switch(event)
		{
		case Events.VENTANA_PRINCIPAL_INSTANCE:
			return new VPrincipal();
		case Events.CLIENTE_VISTA:
			return new VCliente();
		case Events.EMPLEADO_VISTA:
			return new VEmpleado();
		case Events.DEPARTAMENTO_VISTA:
			return new VDepartamento();
		case Events.TAREA_VISTA:
			return new VTarea();
		case Events.RESERVA_VISTA:
			return new VReserva();
			
		case Events.HABITACION_VISTA:
			return new VHabitacion();
		case Events.HABITACION_CREAR_VISTA:
			return new VAņadirHabitacion();
		case Events.HABITACION_ELIMINAR_VISTA:
			return new VEliminarHabitacion();
		case Events.HABITACION_MODIFICAR_VISTA:
			return new VModificarHabitacion();
		case Events.HABITACION_MOSTRAR_DISPONIBLES_VISTA:
			return new VMostrarTodasDisponiblesHabitacion();
		case Events.HABITACION_MOSTRAR_POR_EMPLEADO_VISTA:
			return new VMostrarPorEmpleado();
		case Events.HABITACION_MOSTRAR_UNA_VISTA:
			return new VMostrarUnaHabitacion();
		case Events.HABITACION_MOSTRAR_TODAS_VISTA:
			return new VMostrarTodasHabitacion();
		
			
			
		}
	
			
		return null;
	}

}
