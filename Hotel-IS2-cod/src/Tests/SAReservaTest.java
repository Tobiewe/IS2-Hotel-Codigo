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

import Negocio.NegocioFactory.SAFactory;
import Negocio.Reserva.TReserva;

public class SAReservaTest {

	@SuppressWarnings("reservarecation")
	@Test
	public void crearReservaCorrecto() {

		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);

		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeida.getId());
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

		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeida.getId());
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

		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());

		reserva.setActivo(false);
		reserva.setFecha_entrada(new Date(112, 3, 4));
		reserva.setNoches(3);
		reserva.setTotal((float) 500);

		Integer result = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result > 0);

		TReserva reservaLeidaMod = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeidaMod);
		assertEquals(reserva.getActivo(), reservaLeidaMod.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeidaMod.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeidaMod.getId());
		assertEquals(reserva.getId_cliente(), reservaLeidaMod.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeidaMod.getTotal());

	}

	@Test
	public void modificaRreservaIncorrecto() {
		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);

		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);

		assertTrue(dev > 0);

		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);

		assertNotNull(reservaLeida);
		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
		assertEquals(reserva.getId(), reservaLeida.getId());
		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
		assertEquals(reserva.getTotal(), reservaLeida.getTotal());
		
		reserva.setNoches(0);
		
		Integer result = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result < 0);
		
		reserva.setNoches(-5);
		
		Integer result1 = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result1 < 0);
		
		reserva.setNoches(1);
		reserva.setTotal((float)0);
		
		Integer result2 = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result2 < 0);
		
		reserva.setTotal((float)-6);
		
		Integer result3 = SAFactory.getInstance().newSAReserva().modificar(reserva);

		assertTrue(result3 < 0);

	}
//	@Test
//	public void añadirHabitacionCorrecto() {
//		TReserva reserva = new TReserva(null, (float) 6.0, new Date(120, 5, 3), 1, 5, true);
//
//		Integer dev = SAFactory.getInstance().newSAReserva().abrir(reserva);
//
//		assertTrue(dev > 0);
//
//		TReserva reservaLeida = SAFactory.getInstance().newSAReserva().MostrarUna(dev);
//
//		assertNotNull(reservaLeida);
//		assertEquals(reserva.getActivo(), reservaLeida.getActivo());
//		assertEquals(reserva.getFecha_entrada(), reservaLeida.getFecha_entrada());
//		assertEquals(reserva.getId(), reservaLeida.getId());
//		assertEquals(reserva.getId_cliente(), reservaLeida.getId_cliente());
//		assertEquals(reserva.getTotal(), reservaLeida.getTotal());
//		
//		
//
//	}
}
