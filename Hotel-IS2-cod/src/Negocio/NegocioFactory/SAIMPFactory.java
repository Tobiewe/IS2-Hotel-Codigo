package Negocio.NegocioFactory;

import Negocio.Clientes.SACliente;
import Negocio.Departamentos.SADepartamento;
import Negocio.Empleados.SAEmpleado;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Reserva.SAReserva;
import Negocio.Tareas.SATarea;

public class SAIMPFactory {
	public SAEmpleado generarSAEmpleado() {
		return new SAEmpleadoIMP();
	}

	public SAHabitacion generarSAFactura() {
		return new SAFacturaImp();
	}

	public SATarea generarSAIngrediente() {
		return new SAIngredienteImp();
	}

	public SAReserva generarSAMenu() {
		return new SAMenuImp();
	}

	public SADepartamento generarSAMesa() {
		return new SAMesaImp();
	}

	public SACliente generarSAProducto() {
		return new SAProductoImp();
	}
}
