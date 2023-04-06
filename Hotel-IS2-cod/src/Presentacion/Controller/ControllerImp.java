package Presentacion.Controller;

import Negocio.Empleados.SAEmpleado;
import Negocio.Clientes.SACliente;
import Negocio.Tareas.SATarea;
import Negocio.Departamentos.SADepartamento;
import Negocio.Habitaciones.SAHabitacion;
import Negocio.Reserva.SAReserva;

public class ControllerImp extends Controller {
	private IGUI newIGUI;
	
	private SAEmpleado saEmpleado;
	private SACliente saCliente;
	private SATarea saTarea;
	private SADepartamento saDepartamento;
	private SAHabitacion saHabitacion;
	private SAReserva saReserva;
	
	public ControllerImp() {
		saIngrediente = FactoriaSA.getInstance().generarSAIngrediente();
		saProducto = FactoriaSA.getInstance().generarSAProducto();
		saMenu = FactoriaSA.getInstance().generarSAMenu();
		saMesa = FactoriaSA.getInstance().generarSAMesa();
		saEmpleado = FactoriaSA.getInstance().generarSAEmpleado();
		saFactura = FactoriaSA.getInstance().generarSAFactura();
	}
	@Override
	public void carryAction(int event, Object data) {
		// TODO Auto-generated method stub
		
	}

}
