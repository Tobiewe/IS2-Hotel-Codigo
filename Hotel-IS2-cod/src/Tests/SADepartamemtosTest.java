package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Negocio.Departamentos.TDepartamento;
import Negocio.NegocioFactory.SAFactory;

public class SADepartamemtosTest {

	@Test
	public void crearDepCorrecto() {

		TDepartamento depart = new TDepartamento(null, "Recursos Humanos", true);
		
		Integer dev = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(dev > 0);

		TDepartamento departleido = SAFactory.getInstance().newSADepartamento().mostrarUno(dev);
		
		 assertNotNull(departleido);
	     assertEquals(depart.getNombre(), departleido.getNombre());
	     assertEquals(depart.getActivado(), departleido.getActivado());

	}

	@Test
	public void crearDepIncorrecto() {

		TDepartamento depart = new TDepartamento(null, "", true);
		
		Integer dev = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(dev < 0);

	}
	
	
	@Test
	public void EliminarDepCorrecto() {

		TDepartamento depart = new TDepartamento(null, "Oficina", true);
		
		Integer dev = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(dev > 0);

		TDepartamento departleido = SAFactory.getInstance().newSADepartamento().mostrarUno(dev);
		
		assertNotNull(departleido);
	    assertEquals(depart.getNombre(), departleido.getNombre());
	    assertEquals(depart.getActivado(), departleido.getActivado());
	     
	    Integer result = SAFactory.getInstance().newSADepartamento().eliminar(dev);
			
		assertTrue(result > 0);

	}
	
	@Test
	public void EliminarDepIncorrecto() {
	     
	    Integer result = SAFactory.getInstance().newSADepartamento().eliminar(-7);
			
		assertTrue(result < 0);

	}
	
	@Test
	public void modificarDepCorrecto() {

		TDepartamento depart = new TDepartamento(null, "Aplicacion web", true);
		
		Integer dev = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(dev > 0);

		TDepartamento departleido = SAFactory.getInstance().newSADepartamento().mostrarUno(dev);
		
		assertNotNull(departleido);
	    assertEquals(depart.getNombre(), departleido.getNombre());
	    assertEquals(depart.getActivado(), departleido.getActivado());
	     
	    depart.setActivado(false);
	    depart.setNombre("Gestion Empresa");
	    depart.setId(dev);

	    Integer result = SAFactory.getInstance().newSADepartamento().modificar(depart);
	    
	    assertTrue(result > 0);
	    
	    
	    TDepartamento departleidomodif = SAFactory.getInstance().newSADepartamento().mostrarUno(dev);
		
		assertNotNull(departleidomodif);
	    assertEquals(depart.getNombre(), departleidomodif.getNombre());
	    assertEquals(depart.getActivado(), departleidomodif.getActivado());
	    
	}
	
	
	@Test
	public void modificarDepIncorrecto() {

		TDepartamento depart = new TDepartamento(null, "Gestion web", true);
		
		Integer dev = SAFactory.getInstance().newSADepartamento().crear(depart);
		
		assertTrue(dev > 0);

		TDepartamento departleido = SAFactory.getInstance().newSADepartamento().mostrarUno(dev);
		
		assertNotNull(departleido);
	    assertEquals(depart.getNombre(), departleido.getNombre());
	    assertEquals(depart.getActivado(), departleido.getActivado());
	     
	    depart.setActivado(false);
	    depart.setNombre("");
	    depart.setId(dev);

	    Integer result = SAFactory.getInstance().newSADepartamento().modificar(depart);
	    
	    assertTrue(result < 0);
	    
	    
	}
	
}
