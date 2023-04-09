package Presentacion.launcher;

import java.util.Collection;


import Integracion.TareasDelEmpleado.DAOTareasDelEmpleado;
import Integracion.TareasDelEmpleado.DAOTareasDelEmpleadoImp;
import Negocio.Empleados.TTareasDelEmpleado;


public class Main {
	public static void main(String[] args){
		
		TTareasDelEmpleado tTareasDelEmpleado = new TTareasDelEmpleado(69, 23);
		DAOTareasDelEmpleado dao = new DAOTareasDelEmpleadoImp();

		Collection<TTareasDelEmpleado> ta = dao.LeerLineasPedidoPorTareas(23);
		
		for (TTareasDelEmpleado t : ta) {
			
			System.out.println(t.getId_empleado());
			System.out.println(t.getId_tareas());

		}
		
		/*Collection<TTareas> ha = dao.leerHabitacionesPorEmpleado(23);
		
		
		for (THabitaciones h : ha) {
			
			System.out.println(h.getId_empledo());
			System.out.println(h.getNumero());
			System.out.println(h.getOcupada());
			System.out.println(h.getPiso());
			System.out.println(h.getTamaño());
			System.out.println(h.getPrecio());
		}*/
		

		
	}
}
