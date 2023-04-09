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

public class VFactoryImp extends VFactory {

	@Override
	public IGUI newView(int event, Object data) {
		switch(event)
		{
		case Events.HABITACION_PRINCIPAL:
			return new VHabitacion();
		case Events.HABITACION_CREAR:
			return new VAñadirHabitacion();
		case Events.HABITACION_ELIMINAR:
			return new VEliminarHabitacion();
		case Events.HABITACION_MODIFICAR:
			return new VModificarHabitacion();
		case Events.HABITACION_MOSTRAR_DISPONIBLES:
			return new VMostrarTodasDisponiblesHabitacion();
		case Events.HABITACION_MOSTRAR_POR_EMPLEADO:
			return new VMostrarPorEmpleado();
		case Events.HABITACION_MOSTRAR_UNA:
			return new VMostrarUnaHabitacion();
		case Events.HABITACION_MOSTRAR_TODAS:
			return new VMostrarTodasHabitacion();
			
			
		}
	
			
		return null;
	}

}
