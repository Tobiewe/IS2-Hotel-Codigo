package Integracion.FactoriaIntegracion;


import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.DAOClienteImp;
import Integracion.Departamentos.DAODepartamentos;
import Integracion.Departamentos.DAODepartamentosImp;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.Habitaciones.DAOHabitacionesImp;
import Integracion.LineaPedido.DAOLineaPedido;
import Integracion.Reserva.DAOReserva;
import Integracion.Tareas.DAOTareas;
import Integracion.Tareas.DAOTareasImp;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
public class FactoriaIntegracionImp  extends FactoriaIntegracion{
	

	@Override
	public DAOHabitaciones newDAOHabitaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOTareas newDAOTarea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAODepartamentos newDAODepartamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOCliente newDAOCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOLineaPedido newLineaPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOTareasDelEmpleado newDAOTareasDelEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOReserva newDAOReserva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOEmpleados newDAOEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
