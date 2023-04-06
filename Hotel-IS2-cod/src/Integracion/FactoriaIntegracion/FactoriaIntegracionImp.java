package Integracion.FactoriaIntegracion;


import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.DAOClienteImp;
import Integracion.Departamentos.DAODepartamentos;
import Integracion.Departamentos.DAODepartamentosImp;
import Integracion.Habitaciones.DAOHabitaciones;
import Integracion.Habitaciones.DAOHabitacionesImp;
import Integracion.Tareas.DAOTareas;
import Integracion.Tareas.DAOTareasImp;
public class FactoriaIntegracionImp  extends FactoriaIntegracion{
	
	public DAOHabitaciones newDAOEmpleado()
	{
		return new DAOHabitacionesImp();
	}
	
	public DAOTareas newDAOTareas()
	{
		return new DAOTareasImp();
	}
	
	public DAODepartamentos newDAODepartamentos()
	{
		return new DAODepartamentosImp();
	}
	
	public DAOCliente newDAOClientes()
	{
		return new DAClienteImp();
	}
		
}
