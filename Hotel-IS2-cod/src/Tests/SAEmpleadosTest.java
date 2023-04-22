package Tests;

import static org.junit.Assert.*;
import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TTareasDelEmpleado;
import Negocio.NegocioFactory.SAFactory;
import org.junit.Test;

public class SAEmpleadosTest {

	@Test
	public void crearEmplleadoCorrecto() {
		Float s=(float) 415.25;
		
		
		TEmpleados empleado = new TEmpleados(3,s,"hugo","Aguilera",true, "olaola@gmail.com",651687431,1);
		
		Integer dev = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev > 0);
		
		TEmpleados emplcheck = SAFactory.getInstance().newSAEmpleado().mostrarUno(dev);
		
		assertNotNull(emplcheck);
		assertEquals(empleado.getId(), emplcheck.getId());
		assertEquals(empleado.getSueldo(), emplcheck.getSueldo());
		assertEquals(empleado.getNombre(), emplcheck.getNombre());
		assertEquals(empleado.getApellidos(), emplcheck.getApellidos());
		assertEquals(empleado.getActivo(), emplcheck.getActivo());
		assertEquals(empleado.getCorreo(), emplcheck.getCorreo());
		assertEquals(empleado.getTelefono(), emplcheck.getTelefono());
		assertEquals(empleado.getId_Departamento(), emplcheck.getId_Departamento());
		
	}
	
	@Test
	
	public void crearempIncorrecto(){
		Float m = (float)39.0;
		TEmpleados empleado= new TEmpleados(1,m,"uksk","",true,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev < 0);
		
		TEmpleados empleado1= new TEmpleados(2,m,"","sasd",true,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev1 = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev1 < 0);
		
		TEmpleados empleado2= new TEmpleados(3,m,"uksk","dfsdd",true,"hdhdhdhgmail.com",651687431,1);
		
		Integer dev2 = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev2 < 0);
		
		TEmpleados empleado3= new TEmpleados(4,m,"uksk","fdfd",true,"hdhdhdh@gmail.com",65133743,1);
		
		Integer dev3 = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev3 < 0);
		TEmpleados empleado4= new TEmpleados(5,m,"uksk","fsfsf",true,"hdhdhdh@gmail.com",651687431,null);
		
		Integer dev4 = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev4 < 0);
		TEmpleados empleado5= new TEmpleados(6,m,"uksk","",false,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev5 = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		
		assertTrue(dev5 < 0);
		
		
		
		
	}
	
	@Test
	public void eliminarEmpleadoCorrecto(){
		
		
		
		Float m = (float)39.0;
		TEmpleados empleado= new TEmpleados(1,m,"uksk","aaas",true,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		assertTrue(dev > 0);
		
		TEmpleados emplcheck = SAFactory.getInstance().newSAEmpleado().mostrarUno(dev);
		
		assertNotNull(emplcheck);
		assertEquals(empleado.getId(), emplcheck.getId());
		assertEquals(empleado.getSueldo(), emplcheck.getSueldo());
		assertEquals(empleado.getNombre(), emplcheck.getNombre());
		assertEquals(empleado.getApellidos(), emplcheck.getApellidos());
		assertEquals(empleado.getActivo(), emplcheck.getActivo());
		assertEquals(empleado.getCorreo(), emplcheck.getCorreo());
		assertEquals(empleado.getTelefono(), emplcheck.getTelefono());
		assertEquals(empleado.getId_Departamento(), emplcheck.getId_Departamento());
		
		Integer result = SAFactory.getInstance().newSAEmpleado().eliminar(dev);
		
		assertTrue(result > 0);
		
		
		
	}
	
	
	@Test
	public void EliminarEmplIncorrecto() {
		
		
		Integer result = SAFactory.getInstance().newSAEmpleado().eliminar(-7);
		assertTrue(result < 0);
		
	}
	
	@Test
	public void modificarDepCorrecto() {
		
		Float m = (float)39.0;
		Float s = (float)89.0;
		TEmpleados empleado= new TEmpleados(1,m,"uksk","aaas",true,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		assertTrue(dev > 0);

		TEmpleados emplcheck = SAFactory.getInstance().newSAEmpleado().mostrarUno(dev);
		
		assertNotNull(emplcheck);
		assertEquals(empleado.getId(), emplcheck.getId());
		assertEquals(empleado.getSueldo(), emplcheck.getSueldo());
		assertEquals(empleado.getNombre(), emplcheck.getNombre());
		assertEquals(empleado.getApellidos(), emplcheck.getApellidos());
		assertEquals(empleado.getActivo(), emplcheck.getActivo());
		assertEquals(empleado.getCorreo(), emplcheck.getCorreo());
		assertEquals(empleado.getTelefono(), emplcheck.getTelefono());
		assertEquals(empleado.getId_Departamento(), emplcheck.getId_Departamento());
		
		
		empleado.setNombre("Willy");
		empleado.setId_Departamento(3);
		empleado.setActivo(false);
		empleado.setApellidos("Hortega");
		empleado.setSueldo(s);
		empleado.setCorreo("WilliWonka@gmail.com");
		empleado.setTelefono(911911911);
		
		Integer result = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result > 0);
		
		TEmpleados emplmod= SAFactory.getInstance().newSAEmpleado().mostrarUno(dev);
		
		assertNotNull(emplmod);
		assertEquals(empleado.getId(), emplmod.getId());
		assertEquals(empleado.getSueldo(), emplmod.getSueldo());
		assertEquals(empleado.getNombre(), emplmod.getNombre());
		assertEquals(empleado.getApellidos(), emplmod.getApellidos());
		assertEquals(empleado.getActivo(), emplmod.getActivo());
		assertEquals(empleado.getCorreo(), emplmod.getCorreo());
		assertEquals(empleado.getTelefono(), emplmod.getTelefono());
		assertEquals(empleado.getId_Departamento(), emplmod.getId_Departamento());
		
	}
	
	@Test
	public void modificarDepIncorrecto() {
		
		Float m = (float)39.0;
		Float s = (float)89.0;
		TEmpleados empleado= new TEmpleados(1,m,"uksk","aaas",true,"hdhdhdh@gmail.com",651687431,1);
		
		Integer dev = SAFactory.getInstance().newSAEmpleado().crear(empleado);
		assertTrue(dev > 0);

		TEmpleados emplcheck = SAFactory.getInstance().newSAEmpleado().mostrarUno(dev);
		
		assertNotNull(emplcheck);
		assertEquals(empleado.getId(), emplcheck.getId());
		assertEquals(empleado.getSueldo(), emplcheck.getSueldo());
		assertEquals(empleado.getNombre(), emplcheck.getNombre());
		assertEquals(empleado.getApellidos(), emplcheck.getApellidos());
		assertEquals(empleado.getActivo(), emplcheck.getActivo());
		assertEquals(empleado.getCorreo(), emplcheck.getCorreo());
		assertEquals(empleado.getTelefono(), emplcheck.getTelefono());
		assertEquals(empleado.getId_Departamento(), emplcheck.getId_Departamento());
		
		empleado.setApellidos("");
		Integer result = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result < 0);
		empleado.setApellidos("aaas");
		
		empleado.setCorreo("manolito.com");
		Integer result2 = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result < 0);
		empleado.setCorreo("hdhdhdh@gmail.com");
		
		empleado.setId_Departamento(-1);
		Integer result3 = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result < 0);
		empleado.setId_Departamento(1);
		
		empleado.setNombre("");
		Integer result4 = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result < 0);
		empleado.setNombre("uksk");
		
		
		
		empleado.setTelefono(99922);
		Integer result5 = SAFactory.getInstance().newSAEmpleado().modificar(empleado);
		assertTrue(result < 0);
		empleado.setTelefono(651687431);
		
		
		
		
	}
	
	

}
