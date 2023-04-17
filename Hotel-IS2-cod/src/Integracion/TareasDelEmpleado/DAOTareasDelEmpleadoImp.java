package Integracion.TareasDelEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Empleados.TTareasDelEmpleado;

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

	
	public Integer modificar(TTareasDelEmpleado tTareasDelEmpleado) {

		int key = -1;

		try {
			
			String c = "UPDATE tareas_empleado SET id_tareas = ? WHERE id_empleado = ?;";

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

	
	public Collection<TTareasDelEmpleado> Leertodos() {
		
		ArrayList<TTareasDelEmpleado> lista = new ArrayList<TTareasDelEmpleado>();
		
		try {
			String c = "SELECT * FROM tareas_empleado;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TTareasDelEmpleado(Rs.getInt("id_tareas"), Rs.getInt("id_empleado")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
	}

	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorTareas(Integer idTareas) {

		ArrayList<TTareasDelEmpleado> lista = new ArrayList<TTareasDelEmpleado>();
		
		try {
			String c = "SELECT * FROM tareas_empleado WHERE id_tareas = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idTareas);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TTareasDelEmpleado(Rs.getInt("id_tareas"), Rs.getInt("id_empleado")));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;

	}

	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorEmpleado(Integer idEmpleado) {

		ArrayList<TTareasDelEmpleado> lista = new ArrayList<TTareasDelEmpleado>();
		
		try {
			String c = "SELECT * FROM tareas_empleado WHERE id_empleado = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idEmpleado);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TTareasDelEmpleado(Rs.getInt("id_tareas"), Rs.getInt("id_empleado")));
				
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
