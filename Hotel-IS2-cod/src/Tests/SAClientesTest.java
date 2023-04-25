package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Negocio.Clientes.TCliente;
import Negocio.Clientes.TEmpresa;
import Negocio.Clientes.TParticular;
import Negocio.Departamentos.TDepartamento;
import Negocio.NegocioFactory.SAFactory;

public class SAClientesTest {

	@Test
	public void crearEmpresaCorrecto() {

		TEmpresa empresa = new TEmpresa(null, "andetel@gmail.com", 789456123, "Andetel", "48675634G", null, null, true);

		Integer devEmpresa = SAFactory.getInstance().newSACliente().crear(empresa);

		assertTrue(devEmpresa > 0);

		TCliente empresaLeido = (TCliente) SAFactory.getInstance().newSACliente().mostrarUno(devEmpresa);

		assertNotNull(empresaLeido);
		assertEquals(empresa.getCorreo(), empresaLeido.getCorreo());
		assertEquals(empresa.getTelefono(), empresaLeido.getTelefono());
		assertEquals(empresa.getNombre(), empresaLeido.getNombre());
		assertEquals(empresa.getCIF(), empresaLeido.getCIF());
		assertEquals(empresa.getActivo(), empresaLeido.getActivo());
		assertNull(empresa.getApellidos());
		assertNull(empresa.getNIF());
	}

	@Test
	public void crearParticularCorrecto() {

		TParticular particular = new TParticular(null, "pedro@gmail.com", 123456789, "Pedrito", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);

		TCliente particularLeido = (TCliente) SAFactory.getInstance().newSACliente().mostrarUno(devParticular);

		assertNotNull(particularLeido);
		assertEquals(particular.getCorreo(), particularLeido.getCorreo());
		assertEquals(particular.getTelefono(), particularLeido.getTelefono());
		assertEquals(particular.getNombre(), particularLeido.getNombre());
		assertEquals(particular.getApellidos(), particularLeido.getApellidos());
		assertEquals(particular.getNIF(), particularLeido.getNIF());
		assertEquals(particular.getActivo(), particularLeido.getActivo());
		assertNull(particular.getCIF());
	}

	@Test
	public void crearEmpresaIncorrecto() {
		TParticular empresa1 = new TParticular(null, "andetelgmail.com", 789456123, "Andetel", "48675634G", null, null,
				true);

		Integer devEmpresa1 = SAFactory.getInstance().newSACliente().crear(empresa1);

		assertTrue(devEmpresa1 < 0);

		TEmpresa empresa2 = new TEmpresa(null, "andetel@gmail.com", 78945, "Andetel", "48675634G", null, null, true);

		Integer devEmpresa2 = SAFactory.getInstance().newSACliente().crear(empresa2);

		assertTrue(devEmpresa2 < 0);

		TEmpresa empresa3 = new TEmpresa(null, "andetel@gmail.com", 789456123, "", "48675634G", null, null, true);

		Integer devEmpresa3 = SAFactory.getInstance().newSACliente().crear(empresa3);

		assertTrue(devEmpresa3 < 0);

		TEmpresa empresa4 = new TEmpresa(null, "andetel@gmail.com", 789456123, "Andetel", "", null, null, true);

		Integer devEmpresa4 = SAFactory.getInstance().newSACliente().crear(empresa4);

		assertTrue(devEmpresa4 < 0);

		TEmpresa empresa5 = new TEmpresa(null, "andetel@gmail.com", 789456123, "Andetel", "48674G", null, null, true);

		Integer devEmpresa5 = SAFactory.getInstance().newSACliente().crear(empresa5);

		assertTrue(devEmpresa5 < 0);

		TEmpresa empresa6 = new TEmpresa(null, "andetel@gmail", 789456123, "Andetel", "48674489G", null, null, true);

		Integer devEmpresa6 = SAFactory.getInstance().newSACliente().crear(empresa6);

		assertTrue(devEmpresa6 < 0);

	}

	@Test
	public void crearParticularIncorrecto() {
		TParticular particular7 = new TParticular(null, "pedro", null, "Pedrito", null, "Pérez", "45236794K",
				true);

		Integer devParticular7 = SAFactory.getInstance().newSACliente().crear(particular7);

		assertTrue(devParticular7 < 0);

	}

	@Test
	public void EliminarClienteCorrecto() {

		TCliente cliente = new TCliente(null, "andetel@gmail.com", 789456123, "Andetel", "48675634G", null, null, true);

		Integer dev = SAFactory.getInstance().newSACliente().crear(cliente);

		assertTrue(dev > 0);

		TCliente clienteLeido = SAFactory.getInstance().newSACliente().mostrarUno(dev);

		assertNotNull(clienteLeido);
		assertEquals(cliente.getCorreo(), clienteLeido.getCorreo());
		assertEquals(cliente.getTelefono(), clienteLeido.getTelefono());
		assertEquals(cliente.getNombre(), clienteLeido.getNombre());
		assertEquals(cliente.getApellidos(), clienteLeido.getApellidos());
		assertEquals(cliente.getNIF(), clienteLeido.getNIF());
		assertEquals(cliente.getActivo(), clienteLeido.getActivo());
		assertEquals(cliente.getCIF(), clienteLeido.getCIF());

		Integer result = SAFactory.getInstance().newSACliente().eliminar(dev);

		assertTrue(result > 0);
	}

	@Test
	public void EliminarClienteIncorrecto() {

		Integer result = SAFactory.getInstance().newSACliente().eliminar(-7);

		assertTrue(result < 0);

	}

	@Test
	public void modificarEmpresaCorrecto() {

		TEmpresa empresa = new TEmpresa(null, "andetel@gmail.com", 789456123, "Andetel", "48675634G", null, null, true);

		Integer devEmpresa = SAFactory.getInstance().newSACliente().crear(empresa);
				
		assertTrue(devEmpresa > 0);

		TCliente empresaLeido = (TCliente) SAFactory.getInstance().newSACliente().mostrarUno(devEmpresa);

		assertNotNull(empresaLeido);
		assertEquals(empresa.getCorreo(), empresaLeido.getCorreo());
		assertEquals(empresa.getTelefono(), empresaLeido.getTelefono());
		assertEquals(empresa.getNombre(), empresaLeido.getNombre());
		assertEquals(empresa.getCIF(), empresaLeido.getCIF());
		assertEquals(empresa.getActivo(), empresaLeido.getActivo());
		assertNull(empresa.getApellidos());
		assertNull(empresa.getNIF());

		empresa.setActivo(false);
		empresa.setCIF("78923467A");
		empresa.setCorreo("hola@gmail.com");
		empresa.setNombre("Hola");
		empresa.setTelefono(673819100);
		empresa.setId(devEmpresa);
		
		Integer result = SAFactory.getInstance().newSACliente().modificar(empresa);

		assertTrue(result > 0);

		TCliente empresaLeidoMod = (TCliente)SAFactory.getInstance().newSACliente().mostrarUno(devEmpresa);

		assertNotNull(empresaLeidoMod);
		assertNotNull(empresaLeido);
		assertEquals(empresa.getCorreo(), empresaLeidoMod.getCorreo());
		assertEquals(empresa.getTelefono(), empresaLeidoMod.getTelefono());
		assertEquals(empresa.getNombre(), empresaLeidoMod.getNombre());
		assertEquals(empresa.getCIF(), empresaLeidoMod.getCIF());
		assertEquals(empresa.getActivo(), empresaLeidoMod.getActivo());
		assertNull(empresa.getApellidos());
		assertNull(empresa.getNIF());

	}
	public void modificarParticularCorrecto() {

		TParticular particular = new TParticular(null, "pedro@gmail.com", 123456789, "Pedrito", null, "Pérez",
				"45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);

		TParticular particularLeido = (TParticular) SAFactory.getInstance().newSACliente().mostrarUno(devParticular);

		assertNotNull(particularLeido);
		assertEquals(particular.getCorreo(), particularLeido.getCorreo());
		assertEquals(particular.getTelefono(), particularLeido.getTelefono());
		assertEquals(particular.getNombre(), particularLeido.getNombre());
		assertEquals(particular.getApellidos(), particularLeido.getApellidos());
		assertEquals(particular.getNIF(), particularLeido.getNIF());
		assertEquals(particular.getActivo(), particularLeido.getActivo());
		assertNull(particular.getCIF());

		particular.setActivo(false);
		particular.setCorreo("hola@gmail.com");
		particular.setNombre("Hola");
		particular.setTelefono(673819100);
		particular.setApellidos("Martinez");
		particular.setNIF("47561890H");

		Integer result = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result > 0);

		TParticular particularLeidoMod = (TParticular)SAFactory.getInstance().newSACliente().mostrarUno(devParticular);
		
		assertNotNull(particularLeidoMod);
		assertEquals(particular.getCorreo(), particularLeidoMod.getCorreo());
		assertEquals(particular.getTelefono(), particularLeidoMod.getTelefono());
		assertEquals(particular.getNombre(), particularLeidoMod.getNombre());
		assertEquals(particular.getApellidos(), particularLeidoMod.getApellidos());
		assertEquals(particular.getNIF(), particularLeidoMod.getNIF());
		assertEquals(particular.getActivo(), particularLeidoMod.getActivo());
		assertNull(particular.getCIF());
	}

	@Test
	public void modificarEmpresaIncorrecto() {

		TEmpresa empresa = new TEmpresa(null, "andetel@gmail.com", 789456123, "Andetel", "48675634G", null, null, true);

		Integer devEmpresa = SAFactory.getInstance().newSACliente().crear(empresa);

		assertTrue(devEmpresa > 0);

		TCliente empresaLeido = (TCliente) SAFactory.getInstance().newSACliente().mostrarUno(devEmpresa);

		assertNotNull(empresaLeido);
		assertEquals(empresa.getCorreo(), empresaLeido.getCorreo());
		assertEquals(empresa.getTelefono(), empresaLeido.getTelefono());
		assertEquals(empresa.getNombre(), empresaLeido.getNombre());
		assertEquals(empresa.getCIF(), empresaLeido.getCIF());
		assertEquals(empresa.getActivo(), empresaLeido.getActivo());
		assertNull(empresa.getApellidos());
		assertNull(empresa.getNIF());

		empresa.setCorreo("holgmail.com");
		empresa.setId(devEmpresa);
		
		Integer result = SAFactory.getInstance().newSACliente().modificar(empresa);

		assertTrue(result < 0);
		
		empresa.setCorreo("hol@gmail.com");
		empresa.setNombre("");

		Integer result2 = SAFactory.getInstance().newSACliente().modificar(empresa);

		assertTrue(result2 < 0);
		
		empresa.setNombre("a");
		empresa.setCIF("789222");

		Integer result3 = SAFactory.getInstance().newSACliente().modificar(empresa);

		assertTrue(result3 < 0);

		empresa.setCIF("78922234A");
		empresa.setTelefono(7391010);

		Integer result4 = SAFactory.getInstance().newSACliente().modificar(empresa);

		assertTrue(result4 < 0);

	}
	public void modificarParticularIncorrecto() {

		TParticular particular = new TParticular(null, "pedro@gmail.com", 123456789, "Pedrito", null, "Pérez","45236794K", true);

		Integer devParticular = SAFactory.getInstance().newSACliente().crear(particular);

		assertTrue(devParticular > 0);

		TParticular particularLeido = (TParticular) SAFactory.getInstance().newSACliente().mostrarUno(devParticular);

		assertNotNull(particularLeido);
		assertEquals(particular.getCorreo(), particularLeido.getCorreo());
		assertEquals(particular.getTelefono(), particularLeido.getTelefono());
		assertEquals(particular.getNombre(), particularLeido.getNombre());
		assertEquals(particular.getApellidos(), particularLeido.getApellidos());
		assertEquals(particular.getNIF(), particularLeido.getNIF());
		assertEquals(particular.getActivo(), particularLeido.getActivo());
		assertNull(particular.getCIF());

		particular.setApellidos("");

		Integer result = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result < 0);
		
		particular.setCorreo("holail.com");
		
		Integer result1 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result1 < 0);
		
		particular.setCorreo("correo@gmail.com");
		particular.setApellidos("");
		
		Integer result2 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result2 < 0);
		
		particular.setApellidos("a");
		particular.setTelefono(67381);
		
		Integer result3 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result3 < 0);
		
		particular.setTelefono(123456789);
		particular.setNombre("");
		
		Integer result4 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result4 < 0);
		
		particular.setNombre("aa");
		particular.setNIF("475618H");
		
		Integer result5 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result5 < 0);
		
		particular.setNIF("47561856H");
		particular.setCorreo("");
		
		Integer result6 = SAFactory.getInstance().newSACliente().modificar(particular);

		assertTrue(result6 < 0);
	}

}
