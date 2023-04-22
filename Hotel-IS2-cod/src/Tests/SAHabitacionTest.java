package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Negocio.Habitaciones.THabitaciones;
import Negocio.NegocioFactory.SAFactory;

public class SAHabitacionTest {

	@Test
	public void testCrearHabitacion() {
		
		Float p = (float) 100.00;
		
		THabitaciones habi = new THabitaciones(2,3,4,p,false,1);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck.getId_empledo());
		assertEquals(habi.getNumero(), habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		
	}
	
	@Test
	public void crearDepIncorrecto() {
		
		Float p = (float) 100.00;
		
		THabitaciones habi = new THabitaciones(-1,3,4,p,false,1);
		Integer result = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( result <0);
		
		THabitaciones habi2 = new THabitaciones(1,-1,4,p,false,1);
		Integer result2 = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( result <0);
		
		THabitaciones habi3 = new THabitaciones(0,3,0,p,false,1);
		Integer result3 = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( result <0);
		
		p=(float) 0.00;
		THabitaciones habi4 = new THabitaciones(0,3,4,p,false,1);
		Integer result4 = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( result <0);
		
		p=(float) 100.00;
		
		
		
	}
	
	@Test
	public void eliminarHabiCorrect(){
		
		Float p = (float) 100.00;
		
		THabitaciones habi = new THabitaciones(2,3,4,p,false,1);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck.getId_empledo());
		assertEquals(habi.getNumero(), habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		Integer result = SAFactory.getInstance().newSAHabitaciones().eliminar(dev);
		assertTrue(result > 0);
		
	}
	
	
	@Test
	public void eliminarHabiIncorr(){
		
		Integer result = SAFactory.getInstance().newSAHabitaciones().eliminar(-7);
		
		assertTrue(result < 0);
	}
	
	@Test
	public void modificarHabiCorrecto() {

		Float p = (float) 100.00;
		
		THabitaciones habi = new THabitaciones(2,3,4,p,false,1);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck.getId_empledo());
		assertEquals(habi.getNumero(), habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		p=(float) 200.00;
		habi.setNumero(4);
		habi.setPiso(1);
		habi.setTamanyo(2);
		habi.setPrecio(p);
		habi.setIdEmp(2);
		
		Integer result = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result > 0);
		
		THabitaciones habicheck1=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck1.getId_empledo());
		assertEquals(habi.getNumero(), habicheck1.getNumero());
		assertEquals(habi.getOcupada(), habicheck1.getOcupada());
		assertEquals(habi.getPiso(), habicheck1.getPiso());
		assertEquals(habi.getPrecio(), habicheck1.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck1.gettamanyo());
		
		
		
		
	}
	
	@Test
	public void modificarHabiIncorrecto() {
		
Float p = (float) 100.00;
		
		THabitaciones habi = new THabitaciones(2,3,4,p,false,1);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck.getId_empledo());
		assertEquals(habi.getNumero(), habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		habi.setPiso(-1);
		Integer result = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result > 0);
		habi.setPiso(3);
		
		habi.setTamanyo(0);
		Integer result2 = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result2 > 0);
		habi.setTamanyo(4);
		
		p = (float)0.00;
		habi.setPrecio(p);
		Integer result3 = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result3 > 0);
		p=(float)100.00;
		habi.setPrecio(p);
		
		
	}
	

}
