package Integracion.FactoriaIntegracion;


import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.DAOClienteImp;
import Integracion.Departamentos.DAODepartamentos;
import Integracion.Departamentos.DAODepartamentosImp;
import Integracion.Empleados.DAOEmpleadoImp;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.Habitaciones.DAOHabitacionesImp;
import Integracion.LineaPedido.DAOLineaPedido;
import Integracion.LineaPedido.DAOLineaPedidoImp;
import Integracion.Reserva.DAOReserva;
import Integracion.Reserva.DAOReservaImp;
import Integracion.Tareas.DAOTareas;
import Integracion.Tareas.DAOTareasImp;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleadoImp;
public class FactoriaIntegracionImp  extends FactoriaIntegracion{
	

	
	public DAOHabitaciones newDAOHabitaciones() {
		return new DAOHabitacionesImp();
	}

	
	public DAOTareas newDAOTarea() {
		return new DAOTareasImp();
	}

	
	public DAODepartamentos newDAODepartamento() {
		return new DAODepartamentosImp();
	}

	
	public DAOCliente newDAOCliente() {
		return new DAOClienteImp();
	}

	
	public DAOLineaPedido newLineaPedido() {
		return new DAOLineaPedidoImp();
	}

	
	public DAOTareasDelEmpleado newDAOTareasDelEmpleado() {
		return new DAOTareasDelEmpleadoImp();
	}

	
	public DAOReserva newDAOReserva() {
		return new DAOReservaImp();
	}

	
	public DAOEmpleados newDAOEmpleado() {
		return new DAOEmpleadoImp();
	}
		
}
