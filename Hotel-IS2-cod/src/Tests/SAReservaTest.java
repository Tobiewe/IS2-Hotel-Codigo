package Tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import Integracion.Cliente.DAOCliente;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Negocio.Clientes.TCliente;
import Negocio.Clientes.TEmpresa;
import Negocio.Clientes.TParticular;
import Negocio.Departamentos.TDepartamento;
import Negocio.Empleados.TEmpleados;
import Negocio.Habitaciones.THabitaciones;
import Negocio.NegocioFactory.SAFactory;
import Negocio.Reserva.TLineaReserva;
import Negocio.Reserva.TReserva;

public class SAReservaTest {

	@SuppressWarnings("reservarecation")
	@Test
	public void crearReservaCorrecto() {
		
		TParticular particular = new TParticular(null, "pepejjj@gmail.com", 123456789, "Testreservacrear", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);
		
		java.util.Date fecha_entrada = new Date(116, 5 ,3);
		java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());

		TReserva reserva = new TReserva(null, 0f, sql_fecha_entrada, devParticular, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);

		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(dev, reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());

	}

	@Test
	public void crearReservaIncorrecto() {

		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev < 0);

		TReserva reserva1 = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 0, true);

		Integer dev1 = SAFactory.getInstance().newSAReserva().abrir(reserva1);

		assertTrue(dev1 < 0);
		TReserva reserva2 = new TReserva(null, (float) 0.0, null, 1, -6, true);

		Integer dev2 = SAFactory.getInstance().newSAReserva().abrir(reserva2);

		assertTrue(dev2 < 0);
		TReserva reserva3 = new TReserva(null, (float) 6.0, new Date(120, 5, 3), -1, 5, true);

		Integer dev3 = SAFactory.getInstance().newSAReserva().abrir(reserva3);

		assertTrue(dev3 < 0);
		TReserva reserva4 = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 0, true);

		Integer dev4 = SAFactory.getInstance().newSAReserva().abrir(reserva4);

		assertTrue(dev4 < 0);

	}
	//

	@Test
	public void EliminarReservaCorrecto() {

		TParticular particular = new TParticular(null, "pepejjj@gmail.com", 123456789, "Testreservaeliminar", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);
		
		java.util.Date fecha_entrada = new Date(116, 5 ,3);
		java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());

		TReserva reserva = new TReserva(null, 0f, sql_fecha_entrada, devParticular, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(dev, reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());

		Integer result = SAFactory.getInstance().newSAReserva().eliminar(dev);

		assertTrue(result > 0);
	}

	@Test
	public void EliminarReservaIncorrecto() {

		Integer result = SAFactory.getInstance().newSAReserva().eliminar(-7);

		assertTrue(result < 0);

	}

	@Test
	public void modificarReservaCorrecto() {

		TParticular particular = new TParticular(null, "pepejjj@gmail.com", 123456789, "Testreservamodificarcorecto", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);
		
		java.util.Date fecha_entrada = new Date(116, 5 ,3);
		java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());

		TReserva reserva = new TReserva(null, 0f, sql_fecha_entrada, devParticular, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(dev, reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());

		reserva.setId(dev);
		reserva.setActivo(false);
		java.util.Date fecha_entrada2 = new Date(112, 3, 4);
		java.sql.Date sql_fecha_entrada2 = new java.sql.Date(fecha_entrada2.getTime());
		reserva.setFecha_entrada(sql_fecha_entrada2);
		reserva.setNoches(3);
		reserva.setTotal(500f);

		Integer result = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result > 0);

		TReserva reservaLeidaMod = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeidaMod);
		assertEquals(reserva.getActivo(), reservaLeidaMod.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeidaMod.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeidaMod.getId());
		assertEquals(reserva.getId_cliente(), reservaLeidaMod.getId_cliente());

	}

	@Test
	public void modificaRreservaIncorrecto() {
		TParticular particular = new TParticular(null, "pepejjj@gmail.com", 123456789, "Testreservamodificarinc", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);
		
		java.util.Date fecha_entrada = new Date(116, 5 ,3);
		java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());

		TReserva reserva = new TReserva(null, 0f, sql_fecha_entrada, devParticular, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(dev, reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());
		
		reserva.setNoches(0);
		
		Integer result = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result < 0);
		
		reserva.setNoches(-5);
		
		Integer result1 = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result1 < 0);

	}

	@Test
	public void AñadirHabitacionyEliminar() {
		TParticular particular = new TParticular(null, "pepejjj@gmail.com", 123456789, "Testreservaañadiryeliminar", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);
		
		java.util.Date fecha_entrada = new Date(116, 5 ,3);
		java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());

		TReserva reserva = new TReserva(null, 0f, sql_fecha_entrada, devParticular, 5, true);

		Integer devreserva = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(devreserva > 0);//------------------------------------------------------------------------------------

		TDepartamento depart = new TDepartamento(null, "Test AÑADIRYELIMINARHABITACION", true);
		
		Integer devDept = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(devDept > 0);
		
		TEmpleados empleado = new TEmpleados(null, 1500f,"añadiryeliminar","habitacion",true, "olaola@gmail.com",651687431, devDept);
		
		Integer devempl = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(devempl > 0);
				
		THabitaciones habi = new THabitaciones(null,3,4, 100f,false, devempl);
		
		Integer devhabi = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( devhabi > 0);// ------------------------------------------------------------------------------------
		
		TLineaReserva tLineaPedido = new TLineaReserva(devreserva, devhabi, true);
		Integer dev = SAFactory.getInstance().newSAReserva().añadirHabitacion(tLineaPedido);
		
		assertTrue(dev > 0);
		
		Integer deve = SAFactory.getInstance().newSAReserva().eliminarHabitacion(devreserva, devhabi);
		
		assertTrue(deve > 0);

	}
}
