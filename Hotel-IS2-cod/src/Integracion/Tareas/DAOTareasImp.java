package Integracion.Tareas;

import Negocio.Tareas.TTareas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOTareasImp implements DAOTareas{
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	
	public Integer crear(TTareas tTareas) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO tareas (Descripcion, Lugar, Nombre, empleado_Id, activa) VALUES (?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, tTareas.getDescripcion());
			ps.setString(2, tTareas.getLugar());
			ps.setString(3, tTareas.getNombre());
			ps.setInt(4, tTareas.getId_empleado());
			ps.setBoolean(5, tTareas.getActiva());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
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

	
	public Integer eliminar(Integer id) {
		
		int key = -1;

		try {
			
			String c = "UPDATE tareas SET activa = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
			ps.setInt(2, id);

			key = (ps.executeUpdate() == 1) ? id : -1;
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
		
	}

	
	public Integer modificar(TTareas tTareas) {
		
		int ok = -1;
		try {
			
			String c = "UPDATE tareas SET Descripcion = ?, Lugar = ?, Nombre = ?, empleado_Id = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setString(1, tTareas.getDescripcion());
			ps.setString(2, tTareas.getLugar());
			ps.setString(3, tTareas.getNombre());
			ps.setInt(4, tTareas.getId_empleado());
			ps.setInt(5, tTareas.getId());
			
			if(ps.executeUpdate()==1) ok= tTareas.getId();
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	
	public TTareas leerUno(Integer id) {
		
		
		TTareas tTareas = null;
		
		try {
			String c = "SELECT * FROM tareas WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tTareas = new TTareas(Rs.getInt("Id"), Rs.getString("Descripcion"),
						Rs.getString("Lugar"), Rs.getString("Nombre"), Rs.getBoolean("activa"), Rs.getInt("empleado_Id"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tTareas;
		
	}

	
	public Collection<TTareas> leerTodos() {
		
		ArrayList<TTareas> lista = new ArrayList<TTareas>();
		
		try {
			String c = "SELECT * FROM tareas;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TTareas(Rs.getInt("Id"), Rs.getString("Descripcion"),
						Rs.getString("Lugar"), Rs.getString("Nombre"), Rs.getBoolean("activa"), Rs.getInt("empleado_Id")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}

}
