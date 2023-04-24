package Integracion.TareasDelEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TTareasDelEmpleado;
import Negocio.Tareas.TTareas;

public class DAOTareasDelEmpleadoImp implements DAOTareasDelEmpleado {

	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
	
	public Integer crear(TTareasDelEmpleado tTareasDelEmpleado) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO tareas_empleado (id_tareas, id_empleado) VALUES (?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tTareasDelEmpleado.getId_tareas());
			ps.setInt(2, tTareasDelEmpleado.getId_empleado());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){ 		//devuelvo el id del empleado creo
				key = rs.getInt(1);
			}
				
			Cnx.close();
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return key;
		
	}

	
	public Integer eliminar(TTareasDelEmpleado tTareasDelEmpleado) {

		int key = -1;

		try {
			
			String c = "DELETE FROM tareas_empleado WHERE id_tareas = ? AND id_empleado = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tTareasDelEmpleado.getId_tareas());
			ps.setInt(2, tTareasDelEmpleado.getId_empleado());
			
			if(ps.executeUpdate()==1) key = tTareasDelEmpleado.getId_empleado();

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
		
	}

	
	public Collection<TTareas> LeerLineasPedidoPorTareas(Integer idTareas) {

		ArrayList<TTareas> lista = new ArrayList<TTareas>();
		
		try {
			String c = "SELECT * FROM tareas JOIN tareas_empleado ON tareas.Id = tareas_empleado.id_tareas WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idTareas);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TTareas(Rs.getInt("Id"), Rs.getString("Descripcion"),
						Rs.getString("Lugar"), Rs.getString("Nombre"), Rs.getBoolean("activa")));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;

	}

	
	public Collection<TEmpleados> LeerLineasPedidoPorEmpleado(Integer idEmpleado) {

		ArrayList<TEmpleados> lista = new ArrayList<TEmpleados>();
		
		try {
			String c = "SELECT * FROM empleado JOIN tareas_empleado ON empleado.Id = tareas_empleado.id_empleado WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idEmpleado);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TEmpleados(Rs.getInt("Id"), Rs.getFloat("sueldo"), Rs.getString("nombre"), Rs.getString("apellidos"), Rs.getBoolean("activo") 
						 ,Rs.getString("correo"),  Rs.getInt("telefono"), Rs.getInt("iddepartamento")));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}



}
