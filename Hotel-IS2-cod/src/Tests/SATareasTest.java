package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Negocio.NegocioFactory.SAFactory;
import Negocio.Tareas.TTareas;

public class SATareasTest {

	@Test
	public void crearTareaTest() {
		
		//creamos el t a la fuerza
		TTareas tarea = new TTareas(null, "Arreglo luz", "Pasillo derecho Planta 5", "Reparacion", true);
		
		//llamamos a la funcion del sa que vamos a comprobar que vamos a comprobar
		Integer dev = SAFactory.getInstance().newSATarea().crear(tarea);
		
		//comrpobamos que es mayor que 0, esto indica que se ha creado con exito
		assertTrue(dev > 0);
		
		//comprobamos que los datos introcucidos son iguales
		TTareas leertarea = SAFactory.getInstance().newSATarea().leerUno(dev);
		
		assertNotNull(leertarea);
		assertEquals(tarea.getDescripcion(), leertarea.getDescripcion());
		assertEquals(tarea.getLugar(), leertarea.getLugar());
		assertEquals(tarea.getNombre(), leertarea.getNombre());
		assertEquals(tarea.getActiva(), leertarea.getActiva());
	}
	
	@Test
	public void crearTareaTestInvalido() {
		
		//creamos el t a la fuerza
		TTareas tarea = new TTareas(null, "", "", "", true);
		
		//llamamos a la funcion del sa que vamos a comprobar que vamos a comprobar
		Integer dev = SAFactory.getInstance().newSATarea().crear(tarea);
		
		//comrpobamos que es menor que 0, esto indica que no se ha creado
		assertTrue(dev < 0);
	}
	
	@Test
	public void modificarTareaTest() {
		
		//creamos el t a la fuerza
		TTareas tarea = new TTareas(null, "Puerta rota", "Planta 5 Habitacion 34", "Reparacion", true);
		
		//llamamos a la funcion del sa que vamos a comprobar que vamos a comprobar
		Integer dev = SAFactory.getInstance().newSATarea().crear(tarea);
		
		//comrpobamos que es mayor que 0, esto indica que se ha creado con exito
		assertTrue(dev > 0);
		
		//comprobamos que los datos introcucidos son iguales
		TTareas leertarea = SAFactory.getInstance().newSATarea().leerUno(dev);
		
		assertNotNull(leertarea);
		assertEquals(tarea.getDescripcion(), leertarea.getDescripcion());
		assertEquals(tarea.getLugar(), leertarea.getLugar());
		assertEquals(tarea.getNombre(), leertarea.getNombre());
		assertEquals(tarea.getActiva(), leertarea.getActiva());
		
		
		tarea.setActiva(false);
		tarea.setDescripcion("Ventana descolgada");
		tarea.setLugar("Recepcion del hotel");
		tarea.setNombre("Urgecia");
		tarea.setId(dev);
		
		Integer result = SAFactory.getInstance().newSATarea().modificar(tarea);
		
		assertTrue(result > 0);
		
		TTareas leertareamodificada = SAFactory.getInstance().newSATarea().leerUno(result);
		
		assertNotNull(leertarea);
		assertEquals(tarea.getDescripcion(), leertareamodificada.getDescripcion());
		assertEquals(tarea.getLugar(), leertareamodificada.getLugar());
		assertEquals(tarea.getNombre(), leertareamodificada.getNombre());
		assertEquals(tarea.getActiva(), leertareamodificada.getActiva());
		
	}
	
	@Test
	public void modificarTareaTestInvalido() {
		
		//creamos el t a la fuerza
		TTareas tarea = new TTareas(null, "Puerta rota", "Planta 5 Habitacion 34", "Reparacion", true);
		
		//llamamos a la funcion del sa que vamos a comprobar que vamos a comprobar
		Integer dev = SAFactory.getInstance().newSATarea().crear(tarea);
		
		//comrpobamos que es mayor que 0, esto indica que se ha creado con exito
		assertTrue(dev > 0);
		
		//comprobamos que los datos introcucidos son iguales
		TTareas leertarea = SAFactory.getInstance().newSATarea().leerUno(dev);
		
		assertNotNull(leertarea);
		assertEquals(tarea.getDescripcion(), leertarea.getDescripcion());
		assertEquals(tarea.getLugar(), leertarea.getLugar());
		assertEquals(tarea.getNombre(), leertarea.getNombre());
		assertEquals(tarea.getActiva(), leertarea.getActiva());
		
		
		tarea.setActiva(false);
		tarea.setDescripcion("Ventana descolgada");
		tarea.setLugar("Recepcion del hotel");
		tarea.setNombre("Urgecia");
		tarea.setId(-1);
		
		Integer result = SAFactory.getInstance().newSATarea().modificar(tarea);
		
		assertTrue(result < 0);
		
	}
	
	@Test
	public void eliminarTareaTest() {
		
		//creamos el t a la fuerza
		TTareas tarea = new TTareas(null, "Pisicina rota", "Exteriores", "Reparacion", true);
		
		//llamamos a la funcion del sa que vamos a comprobar que vamos a comprobar
		Integer dev = SAFactory.getInstance().newSATarea().crear(tarea);
		
		//comrpobamos que es mayor que 0, esto indica que se ha creado con exito
		assertTrue(dev > 0);
		
		//comprobamos que los datos introcucidos son iguales
		TTareas leertarea = SAFactory.getInstance().newSATarea().leerUno(dev);
		
		assertNotNull(leertarea);
		assertEquals(tarea.getDescripcion(), leertarea.getDescripcion());
		assertEquals(tarea.getLugar(), leertarea.getLugar());
		assertEquals(tarea.getNombre(), leertarea.getNombre());
		assertEquals(tarea.getActiva(), leertarea.getActiva());
		
		Integer result = SAFactory.getInstance().newSATarea().eliminar(dev);
		
		assertTrue(result > 0);
		
	}
	
	
	@Test
	public void eliminarTareaTestInvalido() {
		
		Integer result = SAFactory.getInstance().newSATarea().eliminar(-3);
		
		assertTrue(result < 0);
		
	}
	

}
