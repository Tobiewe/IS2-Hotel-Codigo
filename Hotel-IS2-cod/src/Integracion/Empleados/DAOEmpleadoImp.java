package Integracion.Empleados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Clientes.TCliente;
import Negocio.Empleados.TEmpleados;

public class DAOEmpleadoImp implements DAOEmpleados {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	
	public Integer crear(TEmpleados tEmpleados) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO hotel-is2.empleado (Id, sueldo, nombre, apellidos, activo, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tEmpleados.getId());
			ps.setFloat(2, tEmpleados.getSueldo());
			ps.setString(3, tEmpleados.getNombre());
			ps.setString(4, tEmpleados.getApellidos());
			ps.setBoolean(5, tEmpleados.getActivo());
			ps.setString(6, tEmpleados.getCorreo());
			ps.setInt(7, tEmpleados.getTelefono());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
				
			Cnx.close();
			ps.close();
			rs.close();
			
			if(tEmpleados.getEspecialidad() != null){
				String cE = "INSERT INTO hotel-is2.empleado_mantenimiento (especialidad, id_empleado) VALUES (?, ?);";

				Connection CnxE = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psE = CnxE.prepareStatement(cE);

				psE.setString(1, tEmpleados.getEspecialidad());
				psE.setInt(2, tEmpleados.getId());
				psE.executeUpdate();

				CnxE.close();
				psE.close();
			}
			else{
				String cP = "INSERT INTO hotel-is2.empleado_limpieza (lugar, id_empleado) VALUES (?, ?);";

				Connection CnxP = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psP = CnxP.prepareStatement(cP);

				psP.setString(1, tEmpleados.getLugar());
				psP.setInt(2, tEmpleados.getId());;
				psP.executeUpdate();
					
				CnxP.close();
				psP.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return key;

	}

	
	public Integer borrar(Integer id) {
		
		int key = -1;

		try {
			
			String c = "UPDATE hotel-is2.empleado SET activo = ? WHERE Id = ?;";

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
			
			String c = "UPDATE hotel-is2.empleado SET sueldo = ?, nombre = ?, apellidos = ?, correo = ?, telefono = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setFloat(1, tEmpleados.getSueldo());
			ps.setString(2, tEmpleados.getNombre());
			ps.setString(3, tEmpleados.getApellidos());
			ps.setString(4, tEmpleados.getCorreo());
			ps.setInt(5, tEmpleados.getTelefono());
			ps.setInt(6, tEmpleados.getId());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
				
			Cnx.close();
			ps.close();
			rs.close();
			
			if(tEmpleados.getEspecialidad() != null){
				String cE = "UPDATE hotel-is2.empleado_mantenimiento set especialidad = ? WHERE id_empleado = ?;";

				Connection CnxE = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psE = CnxE.prepareStatement(cE);

				psE.setString(1, tEmpleados.getEspecialidad());
				psE.setInt(2, tEmpleados.getId());
				psE.executeUpdate();

				CnxE.close();
				psE.close();
			}
			else{
				String cP = "UPDATE hotel-is2.empleado_limpieza SET lugar = ? WHERE id_empleado = ?;";

				Connection CnxP = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psP = CnxP.prepareStatement(cP);

				psP.setString(1, tEmpleados.getLugar());
				psP.setInt(2, tEmpleados.getId());;
				psP.executeUpdate();
					
				CnxP.close();
				psP.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return key;
		
	}

	
	public TEmpleados MostrarUno(Integer id) {
		
		TEmpleados tEmpleados = null;
		
		try {
			String c = "SELECT * FROM hotel-is2.empleado WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tEmpleados = new TEmpleados(Rs.getInt("Id"), Rs.getFloat("sueldo"), Rs.getString("nombre"), Rs.getString("apellidos"), Rs.getBoolean("activo") 
						 ,Rs.getString("correo"),  Rs.getInt("telefono"),  Rs.getString("lugar"), Rs.getString("especialidad"), Rs.getInt("id_Departamento"));
				
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
			String c = "SELECT * FROM hotel-is2.empleado;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TEmpleados(Rs.getInt("Id"), Rs.getFloat("sueldo"), Rs.getString("nombre"), Rs.getString("apellidos"), Rs.getBoolean("activo") 
						 ,Rs.getString("correo"),  Rs.getInt("telefono"),  Rs.getString("lugar"), Rs.getString("especialidad"), Rs.getInt("id_Departamento")));
				
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
