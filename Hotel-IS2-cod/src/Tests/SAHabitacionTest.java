package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Negocio.Departamentos.TDepartamento;
import Negocio.Empleados.TEmpleados;
import Negocio.Habitaciones.THabitaciones;
import Negocio.NegocioFactory.SAFactory;

public class SAHabitacionTest {

	@Test
	public void testCrearHabitacion() {
		
		TDepartamento depart = new TDepartamento(null, "Test crearhabitacion", true);
		
		Integer devDept = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(devDept > 0);
		
		TEmpleados empleado = new TEmpleados(null, 1500f,"crear","habitacion",true, "olaola@gmail.com",651687431, devDept);
		
		Integer devempl = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(devempl > 0);
				
		THabitaciones habi = new THabitaciones(null,3,4, 100f,false, devempl);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(devempl,habicheck.getId_empledo());
		assertEquals(dev, habicheck.getNumero());
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
		
		TDepartamento depart = new TDepartamento(null, "Test eliminarhabitacion", true);
		
		Integer devDept = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(devDept > 0);
		
		TEmpleados empleado = new TEmpleados(null, 1500f,"eliminar","habitacion",true, "olaola@gmail.com",651687431, devDept);
		
		Integer devempl = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(devempl > 0);
		
		THabitaciones habi = new THabitaciones(null,3,4, 200f,false, devempl);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);
		assertTrue( dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(devempl,habicheck.getId_empledo());
		assertEquals(dev, habicheck.getNumero());
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

TDepartamento depart = new TDepartamento(null, "Test modificarhabitacion", true);
		
		Integer devDept = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(devDept > 0);
		
		TEmpleados empleado = new TEmpleados(null, 1500f,"modificar","habitacion",true, "olaola@gmail.com",651687431, devDept);
		
		Integer devempl = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(devempl > 0);
		
		THabitaciones habi = new THabitaciones(null,3,4, 200f,false, devempl);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);

		assertTrue(dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(devempl,habicheck.getId_empledo());
		assertEquals(dev, habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		habi.setNumero(dev);
		habi.setPiso(1);
		habi.setTamanyo(2);
		habi.setPrecio(500f);
		
		Integer result = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result > 0);
		
		THabitaciones habicheck1=SAFactory.getInstance().newSAHabitaciones().mostrarUno(habi.getNumero());
		
		assertNotNull(habicheck);
		assertEquals(habi.getOcupada(), habicheck1.getOcupada());
		assertEquals(habi.getPrecio(), habicheck1.getPrecio());
	}
	
	@Test
	public void modificarHabiIncorrecto() {
		TDepartamento depart = new TDepartamento(null, "Test modificarhabitacionincorrecto", true);
		
		Integer devDept = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(devDept > 0);
		
		TEmpleados empleado = new TEmpleados(null, 1500f,"modificar","habitacionincorrecto",true, "olaola@gmail.com",651687431, devDept);
		
		Integer devempl = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(devempl > 0);
		
		THabitaciones habi = new THabitaciones(null,3,4, 200f,false, devempl);
		
		Integer dev = SAFactory.getInstance().newSAHabitaciones().crear(habi);

		assertTrue(dev > 0);
		
		THabitaciones habicheck=SAFactory.getInstance().newSAHabitaciones().mostrarUno(dev);
		
		assertNotNull(habicheck);
		assertEquals(habi.getId_empledo(),habicheck.getId_empledo());
		assertEquals(dev, habicheck.getNumero());
		assertEquals(habi.getOcupada(), habicheck.getOcupada());
		assertEquals(habi.getPiso(), habicheck.getPiso());
		assertEquals(habi.getPrecio(), habicheck.getPrecio());
		assertEquals(habi.gettamanyo(), habicheck.gettamanyo());
		
		habi.setPiso(-1);
		Integer result = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result < 0);
		habi.setPiso(3);
		
		habi.setTamanyo(0);
		Integer result2 = SAFactory.getInstance().newSAHabitaciones().modificar(habi);
		assertTrue(result2 < 0);
		habi.setTamanyo(4);	
		
	}
	

}
