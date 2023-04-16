package Integracion.Departamentos;

import Negocio.Departamentos.TDepartamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAODepartamentosImp implements DAODepartamentos {

	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
    
	
	public Integer crear(TDepartamento tDepartamento) {
		int key = -1;
		
		try {
			
			
			String c = "INSERT INTO departamentos (nombre, activo) VALUES (?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, tDepartamento.getNombre());
			ps.setBoolean(2, tDepartamento.getActivado());
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
	
	
	public Integer borrar(Integer id) {
		int key = -1;

		try {
			
			String c = "UPDATE departamentos SET activo = ? WHERE Id = ?;";

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
	
	
	public Integer modificar(TDepartamento tDepartamento) {
		int ok = -1;
		try {
			
			String c = "UPDATE departamentos SET nombre = ?, activo = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setString(1, tDepartamento.getNombre());
			ps.setBoolean(2, tDepartamento.getActivado());
			ps.setInt(3, tDepartamento.getId());
						
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
	}
	
	
	public TDepartamento MostrarUno(Integer id) {
		
		TDepartamento tDepartamento = null;
		
		try {
			String c = "SELECT * FROM departamentos WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tDepartamento = new TDepartamento(Rs.getInt("Id"), Rs.getString("nombre"), Rs.getBoolean("activo"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tDepartamento;
	}
	
	
	public TDepartamento MostrarPorNombre(String nombre) {
		
		TDepartamento tDepartamento = null;
		
		try {
			String c = "SELECT * FROM departamentos WHERE nombre = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setString(1, nombre);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tDepartamento = new TDepartamento(Rs.getInt("Id"), Rs.getString("nombre"), Rs.getBoolean("activo"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tDepartamento;
	}


	public Collection<TDepartamento> MostrarTodos() {
		
		ArrayList<TDepartamento> lista = new ArrayList<TDepartamento>();
		
		try {
			String c = "SELECT * FROM departamentos;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TDepartamento(Rs.getInt("Id"), Rs.getString("nombre"), Rs.getBoolean("activo")));
				
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
