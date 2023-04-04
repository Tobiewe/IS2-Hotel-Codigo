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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer modificar(TDepartamento tDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TDepartamento MostrarUno(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<TDepartamento> MostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
