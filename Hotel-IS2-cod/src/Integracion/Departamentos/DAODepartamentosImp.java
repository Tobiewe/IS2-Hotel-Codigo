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
			String consulta = "INSERT INTO hotel-is2.departamento (Id, jefe, nombre, activo) VALUES (?, ?, ?, ?);";

			Connection miConexion = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = miConexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tDepartamento.getId());
			ps.setString(2, tDepartamento.getJefe());
			ps.setString(3, tDepartamento.getNombre());
			ps.setBoolean(4, tDepartamento.getActivado());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				key = rs.getInt(1);
			miConexion.close();
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
			String consulta = "UPDATE hotel-is2.departamento SET activo = ? WHERE Id = ?;";

			Connection miConexion = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = miConexion.prepareStatement(consulta);

			ps.setBoolean(1, false);
			ps.setInt(2, id);

			key = (ps.executeUpdate() == 1) ? id : -1;
			
			miConexion.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return key;
	}
	
	
	public Integer modificar(TDepartamento tDepartamento) {
		int ok = -1;
		try {
			String consulta = "UPDATE hotel-is2.departamento SET jefe = ?, nombre = ?, activo= ? WHERE Id = ?;";

			Connection miConexion = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = miConexion.prepareStatement(consulta);

			ps.setString(1, tDepartamento.getJefe());
			ps.setString(2, tDepartamento.getNombre());
			ps.setBoolean(3, tDepartamento.getActivado());
			ps.setInt(4, tDepartamento.getId());
			if(ps.executeUpdate()==1) ok= tDepartamento.getId();
			
			miConexion.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ok;
	}
	
	
	public TDepartamento MostrarUno(Integer id) {
		TDepartamento tDepartamento = null;
		try {
			String consulta = "SELECT * FROM hotel-is2.departamento WHERE Id = ?;";

			Connection miConexion = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = miConexion.prepareStatement(consulta);

			ps.setInt(1, id);
			ResultSet miResult = ps.executeQuery();

			if (miResult.next()){
				tDepartamento = new TDepartamento(miResult.getInt("Id"), miResult.getString("jefe"),
						miResult.getString("nombre"), miResult.getBoolean("activo"));
			}
	
			miConexion.close();
			ps.close();
			miResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tDepartamento;
	}


	public Collection<TDepartamento> MostrarTodos() {
		
		ArrayList<TDepartamento> lista = new ArrayList<TDepartamento>();
		try {
			String consulta = "SELECT * FROM hotel-is2.departamento";

			Connection miConexion = DriverManager.getConnection(url, usuario, clave);
			Statement miStatement = miConexion.createStatement();
			ResultSet miResult = miStatement.executeQuery(consulta);

			while (miResult.next())
				lista.add(new TDepartamento(miResult.getInt("Id"), miResult.getString("jefe"),
						miResult.getString("nombre"), miResult.getBoolean("activo")));
			miConexion.close();
			miStatement.close();
			miResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	

}
