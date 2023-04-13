package Integracion.FactoriaIntegracion;

import Integracion.Cliente.DAOCliente;
import Integracion.Departamentos.DAODepartamentos;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.LineaReserva.DAOLineaReserva;
import Integracion.Reserva.DAOReserva;
import Integracion.Tareas.DAOTareas;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;

public abstract  class FactoriaIntegracion {
		
	private static FactoriaIntegracion instance;
	
	public static FactoriaIntegracion getInstance()
	{
		if (instance == null)
			instance = new FactoriaIntegracionImp();
		return instance;
	}
	public abstract DAOHabitaciones newDAOHabitaciones();
	
	public abstract DAOTareas newDAOTarea();
	
	public abstract DAODepartamentos newDAODepartamento();
	
	public abstract DAOCliente newDAOCliente();
	
	public abstract DAOLineaReserva newLineaReserva();
	
	public abstract DAOTareasDelEmpleado newDAOTareasDelEmpleado();
	
	public abstract DAOReserva newDAOReserva();
	
	public abstract DAOEmpleados newDAOEmpleado();
	
	
}
