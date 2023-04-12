package Integracion.Empleados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Empleados.TEmpleados;

public class DAOEmpleadoImp implements DAOEmpleados {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	
	public Integer crear(TEmpleados tEmpleados) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO empleado (sueldo, nombre, apellidos, activo, correo, telefono) VALUES (?, ?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setFloat(1, tEmpleados.getSueldo());
			ps.setString(2, tEmpleados.getNombre());
			ps.setString(3, tEmpleados.getApellidos());
			ps.setBoolean(4, tEmpleados.getActivo());
			ps.setString(5, tEmpleados.getCorreo());
			ps.setInt(6, tEmpleados.getTelefono());
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
			
			String c = "UPDATE empleado SET activo = ? WHERE Id = ?;";

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

	
	public Integer modificar(TEmpleados tEmpleados) {
		
		int key = -1;
		
		try {
			
			String c = "UPDATE empleado SET sueldo = ?, nombre = ?, apellidos = ?, correo = ?, telefono = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setFloat(1, tEmpleados.getSueldo());
			ps.setString(2, tEmpleados.getNombre());
			ps.setString(3, tEmpleados.getApellidos());
			ps.setString(4, tEmpleados.getCorreo());
			ps.setInt(5, tEmpleados.getTelefono());
			ps.setInt(6, tEmpleados.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return key;
		
	}

	
	public TEmpleados MostrarUno(Integer id) {
		
		TEmpleados tEmpleados = null;
		
		try {
			String c = "SELECT * FROM empleado WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tEmpleados = new TEmpleados(Rs.getInt("Id"), Rs.getFloat("sueldo"), Rs.getString("nombre"), Rs.getString("apellidos"), Rs.getBoolean("activo") 
						 ,Rs.getString("correo"),  Rs.getInt("telefono"), Rs.getInt("id_Departamento"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tEmpleados;
	}

	
	public Collection<TEmpleados> MostrarTodos() {
		
		ArrayList<TEmpleados> lista = new ArrayList<TEmpleados>();
		
		try {
			String c = "SELECT * FROM empleado;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TEmpleados(Rs.getInt("Id"), Rs.getFloat("sueldo"), Rs.getString("nombre"), Rs.getString("apellidos"), Rs.getBoolean("activo") 
						 ,Rs.getString("correo"),  Rs.getInt("telefono"), Rs.getInt("id_Departamento")));
				
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
