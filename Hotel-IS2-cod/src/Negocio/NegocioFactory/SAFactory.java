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

	public abstract SAEmpleado generarSAEmpleado();

	public abstract SAFactura generarSAFactura();

	public abstract SAIngrediente generarSAIngrediente();

	public abstract SAMenu generarSAMenu();

	public abstract SAMesa generarSAMesa();

	public abstract SAProducto generarSAProducto();
}
