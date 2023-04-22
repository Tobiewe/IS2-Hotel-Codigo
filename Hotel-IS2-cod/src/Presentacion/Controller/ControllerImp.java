package Presentacion.Controller;

import Negocio.Empleados.SAEmpleado;
import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TTareasDelEmpleado;

import java.util.Collection;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Integracion.Departamentos.DAODepartamentos;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Negocio.Clientes.SACliente;
import Negocio.Clientes.TCliente;
import Negocio.Clientes.TEmpresa;
import Negocio.Clientes.TParticular;
import Negocio.Tareas.SATarea;
import Negocio.Tareas.TTareas;
import Negocio.Departamentos.TDepartamento;
import Presentacion.Reserva.VReservaCasosUso.VEliminarHabitaciones;
import Presentacion.Reserva.VReservaCasosUso.VMostrarHabitacionesReserva;
import Presentacion.Reserva.VReservaCasosUso.VMostrarReservaCliente;
import Presentacion.VFactory.VFactory;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Habitaciones.THabitaciones;
import Negocio.NegocioFactory.SAFactory;
import Negocio.Reserva.SAReserva;
import Negocio.Reserva.TLineaReserva;
import Negocio.Reserva.TReserva;

public class ControllerImp extends Controller {
	private IGUI cIGUI;
	
	
	private SAEmpleado saEmpleado;
	private SACliente saCliente;
	private SATarea saTarea;
	private SADepartamento saDepartamento;
	private SAHabitacion saHabitacion;
	private SAReserva saReserva;
	//private SATareasDelEmpleado saTareasDelEmpleado;
	private Integer saSolution;

	private THabitaciones tHabitacion;
	private TReserva tReserva;
	private TEmpleados tEmpleado;
	private TTareas tTarea;
	private TCliente tCliente;
	private TDepartamento tDepartamento;
	private TTareasDelEmpleado tTareasDelEmpleado;
	
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
			
		//DEPARTAMENTO
			//VISTAS
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
			
			//ACCIONES
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
			
		case Events.DEPARTAMENTO_MODIFICAR:
			tDepartamento = (TDepartamento)data;
			saSolution = saDepartamento.modificar(tDepartamento);
			if(saSolution == -2)
				cIGUI.update(Events.DEPARTAMENTO_MODIFICAR_NOTFOUND, tDepartamento.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.DEPARTAMENTO_MODIFICAR_WRONG_PARAMETERS, tDepartamento.getId());
			else if(saSolution == -3)
				cIGUI.update(Events.DEPARTAMENTO_MODIFICAR_NAMEREPEATED, tDepartamento.getNombre());
			else if(saSolution > 0)
				cIGUI.update(Events.DEPARTAMENTO_MODIFICAR_SUCCESS, tDepartamento.getId());
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
			
		//EMPLEADO
			//VISTAS
		case Events.EMPLEADO_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_CREAR_VISTA, null);
			break;
		case Events.EMPLEADO_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MODIFICAR_VISTA, null);
			break;
		case Events.EMPLEADO_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_ELIMINAR_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_UNO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_UNO_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_TODOS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_TODOS_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_VISTA, null);
			break;
		case Events.EMPLEADO_VINCULAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_VINCULAR_VISTA, null);
			break;
		case Events.EMPLEADO_DESVINCULAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_DESVINCULAR_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_EMPYTAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_EMPYTAR_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_POR_TAREA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_POR_TAREA_VISTA, null);
			break;
		case Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_VISTA, null);
			break;
			
			//ACCIONES
		case Events.EMPLEADO_CREAR:
			tEmpleado = (TEmpleados)data;
			saSolution = saEmpleado.crear(tEmpleado);
			if(saSolution == -2)
				cIGUI.update(Events.EMPLEADO_CREAR_REPEATED,  tEmpleado.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.EMPLEADO_CREAR_WRONG_PARAMETERS, null);
			else if(saSolution == -6)
				cIGUI.update(Events.EMPLEADO_CREAR_WRONG_NUMBER, null);
			else if(saSolution == -7)
				cIGUI.update(Events.EMPLEADO_CREAR_WRONG_MAIL, null);
			else if(saSolution == -8)
				cIGUI.update(Events.EMPLEADO_CREAR_NO_DEPARTAMENT, null);
			else if(saSolution == -9)
				cIGUI.update(Events.EMPLEADO_CREAR_DEPARTAMENT_INACTIVE, null);
			else if(saSolution > 0)
				cIGUI.update(Events.EMPLEADO_CREAR_SUCCESS, saSolution);
			break;
			
		case Events.EMPLEADO_MODIFICAR:
			tEmpleado = (TEmpleados)data;
			saSolution = saEmpleado.modificar(tEmpleado);
			if(saSolution == -2)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_NOTFOUND, tEmpleado.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_WRONG_PARAMETERS, null);
			else if(saSolution == -6)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_WRONG_NUMBER, null);
			else if(saSolution == -7)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_WRONG_MAIL, null);
			else if(saSolution == -8)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_NO_DEPARTAMENT, null);
			else if(saSolution == -9)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_DEPARTAMENT_INACTIVE, null);
			else if(saSolution > 0)
				cIGUI.update(Events.EMPLEADO_MODIFICAR_SUCCESS, tEmpleado.getId());
			break;
			
		case Events.EMPLEADO_ELIMINAR:
			saSolution = saEmpleado.eliminar((Integer) data);
			
			if(saSolution == -2)
				cIGUI.update(Events.EMPLEADO_ELIMINAR_NOTFOUND, (Integer) data);
			else
				cIGUI.update(Events.EMPLEADO_ELIMINAR_SUCCESS, (Integer) data);
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
			
		case Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO:
			Collection<TEmpleados> collectionEmpleadoPorDep = saEmpleado.mostrarPorDepartamento((Integer) data);
			if(collectionEmpleadoPorDep.isEmpty())
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_NOID, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_ID, collectionEmpleadoPorDep);
			break;
			//ccomit
			
		case Events.EMPLEADO_VINCULAR:
			saSolution = saEmpleado.vincular((TTareasDelEmpleado) data);
			if(saSolution == -5)
				cIGUI.update(Events.EMPLEADO_VINCULAR_NOID, null);
			else if(saSolution == -6)
				cIGUI.update(Events.EMPLEADO_VINCULAR_TAREA_NO_ACTIVA, null);
			else if(saSolution == -7)
				cIGUI.update(Events.EMPLEADO_VINCULAR_EMPLEADO_NO_ACTIVO, null);
			else
				cIGUI.update(Events.EMPLEADO_VINCULAR_SUCCESS, null);
			break;
			
		case Events.EMPLEADO_DESVINCULAR:
			saSolution = saEmpleado.desvincular((TTareasDelEmpleado) data);
			if(saSolution == -5)
				cIGUI.update(Events.EMPLEADO_DESVINCULAR_NOID, null);
			else if(saSolution == -6)
				cIGUI.update(Events.EMPLEADO_DESVINCULAR_TAREA_NO_ACTIVA, null);
			else if(saSolution == -7)
				cIGUI.update(Events.EMPLEADO_DESVINCULAR_EMPLEADO_NO_ACTIVO, null);
			else 
				cIGUI.update(Events.EMPLEADO_DESVINCULAR_SUCCESS, null);
			break;
			
		case Events.EMPLEADO_MOSTRAR_EMPYTAR:
			Pair<Collection<TEmpleados>, Collection<TTareas>> collectionTodos = saEmpleado.LeertodosDeTareasEmpleado();
			if(collectionTodos == null)
				cIGUI.update(Events.EMPLEADO_MOSTRAR_EMPYTAR_NOID, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_EMPYTAR_ID, null);
			break;
			
		case Events.EMPLEADO_MOSTRAR_POR_TAREA:
			Collection<TEmpleados> collectionEmpleadosPorTarea = saEmpleado.LeerLineasPedidoPorEmpleado((Integer) data);
			if(collectionEmpleadosPorTarea == null)
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_TAREA_ID, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_TAREA_NOID, null);
			break;

		case Events.EMPLEADO_MOSTRAR_POR_EMPLEADO:
			Collection<TTareas> collectionTareasPorEmpleado = saEmpleado.LeerLineasPedidoPorTareas((Integer) data);
			if(collectionTareasPorEmpleado == null)
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_ID, null);
			else
				cIGUI.update(Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_NOID, null);
			break;		
			
			//RESERVA
		case Events.RESERVA_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_CREAR_VISTA, null);
			break;
		case Events.RESERVA_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MODIFICAR_VISTA, null);
			break;
		case Events.RESERVA_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_ELIMINAR_VISTA, null);
			break;
		case Events.RESERVA_MOSTRAR_UNA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MOSTRAR_UNA_VISTA, null);
			break;
		case Events.RESERVA_MOSTRAR_TODAS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MOSTRAR_TODAS_VISTA, null);
			break;
		case Events.RESERVA_AÑADIR_HABITACIONES_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_AÑADIR_HABITACIONES_VISTA, null);
			break;
		case Events.RESERVA_QUITAR_HABITACIONES_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_QUITAR_HABITACIONES_VISTA, null);
			break;
		case Events.RESERVA_MOSTRAR_POR_CLIENTE_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MOSTRAR_POR_CLIENTE_VISTA, null);
			break;
		case Events.RESERVA_MOSTRAR_HABITACIONES_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MOSTRAR_HABITACIONES_VISTA, null);
			break;
		
		case Events.RESERVA_CREAR:
			tReserva = (TReserva)data;
			saSolution = saReserva.abrir(tReserva);
			if(saSolution == -1)
				cIGUI.update(Events.RESERVA_CREAR_ERROR, null);
			else if(saSolution == -2)
				cIGUI.update(Events.RESERVA_CREAR_REPEATED,  tReserva.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.RESERVA_CREAR_WRONG_PARAMETERS, saSolution);
			else if(saSolution > 0)
				cIGUI.update(Events.RESERVA_CREAR_SUCCESS, null);
			break;
			
		case Events.RESERVA_MODIFICAR:
			tReserva = (TReserva)data;
			saSolution = saReserva.modificar(tReserva);
			if(saSolution == -2)
				cIGUI.update(Events.RESERVA_MODIFICAR_NOTFOUND, tReserva.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.RESERVA_MODIFICAR_WRONG_PARAMETERS, tReserva.getId());
			else if(saSolution > 0)
				cIGUI.update(Events.RESERVA_MODIFICAR_SUCCESS, tReserva.getId());
			break;
			
		case Events.RESERVA_ELIMINAR:
			saSolution= saReserva.eliminar((Integer)data);
			
			if(saSolution == -1)
				cIGUI.update(Events.RESERVA_ELIMINAR_ERROR, data);
			
			else
				cIGUI.update(Events.RESERVA_ELIMINAR_SUCCESS, data);
			break;
			
		case Events.RESERVA_MOSTRAR_UNA:
			tReserva = saReserva.MostrarUna((Integer) data);
			if(tReserva == null)
				cIGUI.update(Events.RESERVA_MOSTRAR_UNA_NO_ID, null);
			else
				cIGUI.update(Events.RESERVA_MOSTRAR_UNA_SI_ID, tReserva);
			break;
			
		case Events.RESERVA_MOSTRAR_TODAS:
			Collection<TReserva> collectionReserva = saReserva.MostrarTodas();
			if(collectionReserva.isEmpty())
				cIGUI.update(Events.RESERVA_MOSTRAR_TODAS_ERROR, null);
			else
				cIGUI.update(Events.RESERVA_MOSTRAR_TODAS_SUCCESS, collectionReserva);
			break;
			
		case Events.RESERVA_MOSTRAR_POR_CLIENTE:
			Collection<TReserva> collectionReservaPorCliente = saReserva.leerReservasPorCliente((Integer) data);
			if(collectionReservaPorCliente.isEmpty())
				cIGUI.update(Events.RESERVA_MOSTRAR_POR_CLIENTE_FAILED, null);
			else
				cIGUI.update(Events.RESERVA_MOSTRAR_POR_CLIENTE_SUCCESS, collectionReservaPorCliente);
			break;
			
		case Events.RESERVA_AÑADIR_HABITACIONES:
			Integer auxIdReserva, auxIdHabitacion;
			//auxIdReserva = (Pair<Integer,Integer>
			//saSolution = saReserva.eliminarHabitacion( )
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_AÑADIR_HABITACIONES_VISTA, null);
			break;
			
		case Events.RESERVA_QUITAR_HABITACIONES:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_QUITAR_HABITACIONES_VISTA, null);
			break;
		case Events.RESERVA_MOSTRAR_HABITACIONES:
			cIGUI = VFactory.getInstance().newView(Events.RESERVA_MOSTRAR_HABITACIONES_VISTA, null);
			break;
			
			//TAREA
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
			
			//ACCIONES
		case Events.TAREA_CREAR:
			tTarea = (TTareas)data;
			saSolution = saTarea.crear(tTarea);
			if(saSolution == -1)
				cIGUI.update(Events.TAREA_CREAR_ERROR, null);
			else if(saSolution == -2)
				cIGUI.update(Events.TAREA_CREAR_REPEATED,  tTarea.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.TAREA_CREAR_WRONG_PARAMETERS, saSolution);
			else if(saSolution > 0)
				cIGUI.update(Events.TAREA_CREAR_SUCCESS, saSolution);
			break;
			
		case Events.TAREA_MODIFICAR:
			tTarea = (TTareas)data;
			saSolution = saTarea.modificar(tTarea);
			if(saSolution == -2)
				cIGUI.update(Events.TAREA_MODIFICAR_NOTFOUND, tTarea.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.TAREA_MODIFICAR_WRONG_PARAMETERS, tTarea.getId());
			else if(saSolution > 0)
				cIGUI.update(Events.TAREA_MODIFICAR_SUCCESS, tTarea.getId());
			break;
		case Events.TAREA_ELIMINAR:
			saSolution = saTarea.eliminar((Integer) data);
			
			if(saSolution == -2)
				cIGUI.update(Events.TAREA_ELIMINAR_NOTFOUND, data);
			else
				cIGUI.update(Events.TAREA_ELIMINAR_SUCCESS, data);
			break;
			
		case Events.TAREA_MOSTRAR_UNO:
			tTarea = saTarea.leerUno((Integer) data);
			
			if(tTarea == null)
				cIGUI.update(Events.TAREA_MOSTRAR_UNA_NO_ID, null);
			else
				cIGUI.update(Events.TAREA_MOSTRAR_UNA_SI_ID, tTarea);
			break;

		case Events.TAREA_MOSTRAR_TODOS:
			Collection<TTareas> collectionTarea= saTarea.leerTodos();
			if(collectionTarea.isEmpty())
				cIGUI.update(Events.TAREA_MOSTRAR_TODAS_ERROR, null);
			else
				cIGUI.update(Events.TAREA_MOSTRAR_TODAS_SUCCESS, collectionTarea);
			break;
		
			
		//CLIENTE
			//VISTAS
		case Events.CLIENTE_CREAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_CREAR_VISTA, null);
			break;
		case Events.CLIENTE_MODIFICAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_MODIFICAR_VISTA, null);
			break;
		case Events.CLIENTE_ELIMINAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_ELIMINAR_VISTA, null);
			break;
		case Events.CLIENTE_MOSTRAR_UNO_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_MOSTRAR_UNO_VISTA, null);
			break;
		case Events.CLIENTE_MOSTRAR_TODOS_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_MOSTRAR_TODOS_VISTA, null);
			break;
		case Events.CLIENTE_MOSTRAR_PARTICULAR_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_MOSTRAR_PARTICULAR_VISTA, null);
			break;
		case Events.CLIENTE_MOSTRAR_EMPRESA_VISTA:
			cIGUI = VFactory.getInstance().newView(Events.CLIENTE_MOSTRAR_EMPRESA_VISTA, null);
			break;
			
			//ACCIONES
		case Events.CLIENTE_CREAR:
			tCliente = (TCliente)data;
			saSolution = saCliente.crear(tCliente);
			System.out.println(tCliente.getCIF());
			
			if(saSolution == -2)
				cIGUI.update(Events.CLIENTE_CREAR_REPEATED,  saSolution);
			else if(saSolution == -5)
				cIGUI.update(Events.CLIENTE_CREAR_EMPTY, saSolution);
			else if(saSolution == -6)
				cIGUI.update(Events.CLIENTE_CREAR_NUM_OVERFLOW,saSolution);
			else if(saSolution == -7)
				cIGUI.update(Events.CLIENTE_CREAR_EMAIL_WRONG, saSolution);
			else if ( saSolution == -8)
				cIGUI.update(Events.CLIENTE_CREAR_CIF_WRONG, saSolution);
			else if (saSolution == -9)
				cIGUI.update(Events.CLIENTE_CREAR_NIF_WRONG, saSolution);
			else 
				cIGUI.update(Events.CLIENTE_CREAR_SUCCESS, saSolution);
			
			break;
			
		case Events.CLIENTE_MODIFICAR:
			tCliente = (TCliente)data;
			saSolution = saCliente.modificar(tCliente);
			if(saSolution == -2)
				cIGUI.update(Events.CLIENTE_MODIFICAR_NOTFOUND, tCliente.getId());
			else if(saSolution == -5)
				cIGUI.update(Events.CLIENTE_MODIFICAR_EMPTY, tCliente.getId());
			else if(saSolution == -6)
				cIGUI.update(Events.CLIENTE_MODIFICAR_NUM_OVERFLOW, tCliente.getId());
			else if(saSolution == -7)
				cIGUI.update(Events.CLIENTE_MODIFICAR_EMAIL_WRONG, tCliente.getId());
			else if(saSolution == -8)
				cIGUI.update(Events.CLIENTE_MODIFICAR_CIF_WRONG, tCliente.getId());
			else if(saSolution == -9)
				cIGUI.update(Events.CLIENTE_MODIFICAR_NIF_WRONG, tCliente.getId());
			else if(saSolution > 0)
				cIGUI.update(Events.CLIENTE_MODIFICAR_SUCCESS, tCliente.getId());
			break;
			
		case Events.CLIENTE_ELIMINAR:
			saSolution = saCliente.eliminar((Integer) data);

			if(saSolution == -2)
				cIGUI.update(Events.CLIENTE_ELIMINAR_NOTFOUND, data);
			else
				cIGUI.update(Events.CLIENTE_ELIMINAR_SUCCESS, data);
			break;
			
		case Events.CLIENTE_MOSTRAR_UNO:
			tCliente = saCliente.mostrarUno((Integer) data);
			
			if(tCliente == null)
				cIGUI.update(Events.CLIENTE_MOSTRAR_UNO_NO_ID, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_UNO_SI_ID, tCliente);
			break;
			
		case Events.CLIENTE_MOSTRAR_TODOS:
			Collection<TCliente> collectionCliente = saCliente.mostrarTodos();
			if(collectionCliente.isEmpty())
				cIGUI.update(Events.CLIENTE_MOSTRAR_TODOS_ERROR, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_TODOS_SUCCESS, collectionCliente);
			break;
			
		case Events.CLIENTE_MOSTRAR_PARTICULAR:
			Collection<TParticular> collectionParticular = saCliente.MostrarParticular();
			if(collectionParticular.isEmpty())
				cIGUI.update(Events.CLIENTE_MOSTRAR_PARTICULAR_ERROR, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_PARTICULAR_SUCCESS, collectionParticular);
			break;
			
			
		case Events.CLIENTE_MOSTRAR_EMPRESA:
			Collection<TEmpresa> collectionEmpresa = saCliente.MostrarEmpresa();
			if(collectionEmpresa.isEmpty())
				cIGUI.update(Events.CLIENTE_MOSTRAR_EMPRESA_ERROR, null);
			else
				cIGUI.update(Events.CLIENTE_MOSTRAR_EMPRESA_SUCCESS, collectionEmpresa);
			break;
			
			
		
			
		//HABITACIONES
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
			
		case Events.HABITACION_MOSTRAR_POR_EMPLEADO:
			Collection<THabitaciones> collectionHabPorEmpleado = saHabitacion.mostrarPorEmpleado((Integer)data);
			if(collectionHabPorEmpleado.isEmpty())
				cIGUI.update(Events.HABITACION_MOSTRAR_POR_EMPLEADO_NOID, (Integer) data);
			else
				cIGUI.update(Events.HABITACION_MOSTRAR_POR_EMPLEADO_ID, collectionHabPorEmpleado);
			break;
		

		}		
		
	}
}

