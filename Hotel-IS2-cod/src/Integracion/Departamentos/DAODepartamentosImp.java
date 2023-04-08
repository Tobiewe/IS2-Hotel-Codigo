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
			
			String c = "INSERT INTO hotel-is2.departamentos (Id, jefe, nombre, activo) VALUES (?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tDepartamento.getId());
			ps.setString(2, tDepartamento.getJefe());
			ps.setString(3, tDepartamento.getNombre());
			ps.setBoolean(4, tDepartamento.getActivado());
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
			
			String c = "UPDATE hotel-is2.departamentos SET activo = ? WHERE Id = ?;";

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
			
			String c = "UPDATE hotel-is2.departamentos SET jefe = ?, nombre = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setString(1, tDepartamento.getJefe());
			ps.setString(2, tDepartamento.getNombre());
			ps.setInt(3, tDepartamento.getId());
			if(ps.executeUpdate()==1) ok= tDepartamento.getId();
			
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
			String c = "SELECT * FROM hotel-is2.departamentos WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tDepartamento = new TDepartamento(Rs.getInt("Id"), Rs.getString("jefe"),
						Rs.getString("nombre"), Rs.getBoolean("activo"));
				
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
			String c = "SELECT * FROM hotel-is2.departamentos;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TDepartamento(Rs.getInt("Id"), Rs.getString("jefe"),
						Rs.getString("nombre"), Rs.getBoolean("activo")));
				
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
