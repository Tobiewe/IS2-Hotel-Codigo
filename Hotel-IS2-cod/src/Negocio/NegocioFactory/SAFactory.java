package Negocio.NegocioFactory;

import Negocio.Empleados.SAEmpleado;
import Negocio.NegocioFactory.SAFactory;
import Negocio.NegocioFactory.SAIMPFactory;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Clientes.SACliente;
import Negocio.Reserva.SAReserva;
import Negocio.Tareas.SATarea;

public abstract class SAFactory {
	private static SAFactory instance;

	public static SAFactory getInstance() {
		if (instance == null) {
			instance = new SAIMPFactory();
		}
		return instance;
	}

	public abstract SAHabitacion newSAHabitaciones();
	
	public abstract SATarea newSATarea();
	
	public abstract SADepartamento newSADepartamento();
	
	public abstract SACliente newSACliente();
	
	public abstract SAReserva newSAReserva();
	
	public abstract SAEmpleado newSAEmpleado();
}
