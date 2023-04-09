package Presentacion.VFactory;

import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Habitacion.VHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VAñadirHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VEliminarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VModificarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarPorEmpleado;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasDisponiblesHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarUnaHabitacion;
import Presentacion.Tarea.VTareaCasosUso.VCrearTarea;
import Presentacion.launcher.VPrincipal;

public class VFactoryImp extends VFactory {

	@Override
	public IGUI newView(int event, Object data) {
		switch(event)
		{
		case Events.VENTANA_PRINCIPAL_INSTANCE:
			return new VPrincipal();
			
		case Events.HABITACION_VISTA:
			return new VHabitacion();
		case Events.HABITACION_CREAR_VISTA:
			return new VAñadirHabitacion();
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
