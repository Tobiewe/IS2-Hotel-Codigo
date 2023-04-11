package Negocio.NegocioFactory;

import Negocio.Clientes.SACliente;
import Negocio.Clientes.SAClienteIMP;
import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADepartamentoIMP;
import Negocio.Empleados.SAEmpleado;
import Negocio.Empleados.SAEmpleadoIMP;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Habitaciones.SAHabitacionIMP;
import Negocio.Reserva.SAReserva;
import Negocio.Reserva.SAReservaIMP;
import Negocio.Tareas.SATarea;
import Negocio.Tareas.SATareaIMP;

public class SAIMPFactory extends SAFactory {

	@Override
	public SAHabitacion newSAHabitaciones() {
		return new SAHabitacionIMP();
	}

	@Override
	public SATarea newSATarea() {
		return new SATareaIMP();
	}

	@Override
	public SADepartamento newSADepartamento() {
		return new SADepartamentoIMP();
	}

	@Override
	public SACliente newSACliente() {
		return new SAClienteIMP();
	}

	@Override
	public SAReserva newSAReserva() {
		return new SAReservaIMP();
	}

	@Override
	public SAEmpleado newSAEmpleado() {
		return new SAEmpleadoIMP();
	}
	
}
