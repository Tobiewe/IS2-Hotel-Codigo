package Presentacion.VFactory;

import Presentacion.Cliente.VCliente;
import Presentacion.Cliente.VClienteCasosUso.VBorrarCliente;
import Presentacion.Cliente.VClienteCasosUso.VCrearCliente;
import Presentacion.Cliente.VClienteCasosUso.VModificarCliente;
import Presentacion.Cliente.VClienteCasosUso.VMostrarTodosClientes;
import Presentacion.Cliente.VClienteCasosUso.VMostrarUnoCliente;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Departamento.VDepartamento;
import Presentacion.Departamento.VDepartamentoCasosUso.VCrearDepartamento;
import Presentacion.Departamento.VDepartamentoCasosUso.VEditarDepartamento;
import Presentacion.Departamento.VDepartamentoCasosUso.VEliminarDepartamento;
import Presentacion.Departamento.VDepartamentoCasosUso.VLeerTodosDepartamento;
import Presentacion.Departamento.VDepartamentoCasosUso.VLeerUnoDepartamento;
import Presentacion.Empleado.VEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VCrearEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VEliminarEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VLeerTodosEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VLeerUnoEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VModificarEmpleado;
import Presentacion.Empleado.VEmpleadoCasosUso.VMostrarPorDepartamento;
import Presentacion.Habitacion.VHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VAñadirHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VEliminarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VModificarHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarPorEmpleado;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasDisponiblesHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasHabitacion;
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarUnaHabitacion;
import Presentacion.Reserva.VReserva;
import Presentacion.Reserva.VReservaCasosUso.VAñadirReserva;
import Presentacion.Reserva.VReservaCasosUso.VModificarReserva;
import Presentacion.Reserva.VReservaCasosUso.VMostrarTodasReserva;
import Presentacion.Reserva.VReservaCasosUso.VMostrarUnaReserva;
import Presentacion.Reserva.VReservaCasosUso.VQuitarReserva;
import Presentacion.Tarea.VTarea;
import Presentacion.Tarea.VTareaCasosUso.VCrearTarea;
import Presentacion.Tarea.VTareaCasosUso.VDesvincularTarea;
import Presentacion.Tarea.VTareaCasosUso.VEliminarTarea;
import Presentacion.Tarea.VTareaCasosUso.VLeerTodasTareas;
import Presentacion.Tarea.VTareaCasosUso.VLeerUnaTarea;
import Presentacion.Tarea.VTareaCasosUso.VModificarTarea;
import Presentacion.Tarea.VTareaCasosUso.VVincularTarea;
import Presentacion.launcher.VPrincipal;

public class VFactoryImp extends VFactory {

	@Override
	public IGUI newView(int event, Object data) {
		switch(event)
		{
		case Events.VENTANA_PRINCIPAL_INSTANCE:
			return new VPrincipal();
			
		//CLIENTE
		case Events.CLIENTE_VISTA:
			return new VCliente();
		case Events.CLIENTE_CREAR_VISTA:
			return new VCrearCliente();
		case Events.CLIENTE_ELIMINAR_VISTA:
			return new VBorrarCliente();
		case Events.CLIENTE_MODIFICAR_VISTA:
			return new VModificarCliente();
		case Events.CLIENTE_MOSTRAR_UNO_VISTA:
			return new VMostrarTodosClientes();
		case Events.CLIENTE_MOSTRAR_TODOS_VISTA:
			return new VMostrarUnoCliente();
		case Events.CLIENTE_MOSTRAR_PARTICULAR:
			return new VMostrarPorDepartamento();
		case Events.CLIENTE_MOSTRAR_EMPRESA:
			
		
			//EMPLEADO
		case Events.EMPLEADO_VISTA:
			return new VEmpleado();
		case Events.EMPLEADO_CREAR_VISTA:
			return new VCrearEmpleado();
		case Events.EMPLEADO_ELIMINAR_VISTA:
			return new VEliminarEmpleado();
		case Events.EMPLEADO_MODIFICAR_VISTA:
			return new VModificarEmpleado();
		case Events.EMPLEADO_MOSTRAR_UNO_VISTA:
			return new VLeerUnoEmpleado();
		case Events.EMPLEADO_MOSTRAR_TODOS_VISTA:
			return new VLeerTodosEmpleado();
		case Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_VISTA:
			return new VMostrarPorDepartamento();
			
		//DEPARTAMENTO
		case Events.DEPARTAMENTO_VISTA:
			return new VDepartamento();
		case Events.DEPARTAMENTO_CREAR_VISTA:
			return new VCrearDepartamento();
		case Events.DEPARTAMENTO_ELIMINAR_VISTA:
			return new VEliminarDepartamento();
		case Events.DEPARTAMENTO_MODIFICAR_VISTA:
			return new VEditarDepartamento();
		case Events.DEPARTAMENTO_MOSTRAR_UNO_VISTA:
			return new VLeerUnoDepartamento();
		case Events.DEPARTAMENTO_MOSTRAR_TODOS_VISTA:
			return new VLeerTodosDepartamento();
		
		//TAREA
		case Events.TAREA_VISTA:
			return new VTarea();
		case Events.TAREA_CREAR_VISTA:
			return new VCrearTarea();
		case Events.TAREA_ELIMINAR_VISTA:
			return new VEliminarTarea();
		case Events.TAREA_MODIFICAR_VISTA:
			return new VModificarTarea();
		case Events.TAREA_MOSTRAR_UNA_VISTA:
			return new VLeerUnaTarea();
		case Events.TAREA_MOSTRAR_TODAS_VISTA:
			return new VLeerTodasTareas();
		case Events.TAREA_VINCULAR_VISTA:
			return new VVincularTarea();
		case Events.TAREA_DESVINCULAR_VISTA:
			return new VDesvincularTarea();
			
		//RESERVA
		case Events.RESERVA_VISTA:
			return new VReserva();
		case Events.RESERVA_CREAR_VISTA:
			return new VAñadirReserva();
		case Events.RESERVA_ELIMINAR_VISTA:
			return new VQuitarReserva();
		case Events.RESERVA_MODIFICAR_VISTA:
			return new VModificarReserva();
		case Events.RESERVA_MOSTRAR_UNA_VISTA:
			return new VMostrarUnaReserva();
		case Events.RESERVA_MOSTRAR_TODAS_VISTA:
			return new VMostrarTodasReserva();
			
		//HABITACION
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
