package Presentacion.VFactory;

import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Habitacion.VHabitacionCasosUso.VA�adirHabitacion;
import Presentacion.Tarea.VTareaCasosUso.VCrearTarea;

public class VFactoryImp extends VFactory {

	@Override
	public IGUI newView(int event, Object data) {
		switch(event)
		{
		case Events.TAREA_CREAR:
			return new VA�adirHabitacion();
		}
			
		return null;
	}

}
