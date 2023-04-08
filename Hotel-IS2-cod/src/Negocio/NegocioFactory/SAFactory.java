package Negocio.NegocioFactory;
import Negocio.Clientes.SACliente;
import Negocio.Empleados.SAEmpleado;
import Negocio.FactoriaNegocio.FactoriaSA;
import Negocio.Reserva.SAReserva;
import Negocio.Tareas.SATarea;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
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
