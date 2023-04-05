package Integracion.Cliente;

import Negocio.Clientes.TCliente;
import Negocio.Departamentos.TDepartamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOClienteImp implements DAOCliente {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	public Integer crear(TCliente tCliente) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO hotel-is2.cliente (Id, telefeono, Correo) VALUES (?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tCliente.getId());
			ps.setInt(2, tCliente.getTelefono());
			ps.setString(3, tCliente.getCorreo());
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
			
			String c = "UPDATE hotel-is2.cliente SET activo = ? WHERE Id = ?;";

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

	
	public Integer modificar(TCliente tCliente) {
		
		int ok = -1;
		try {
			
			String c = "UPDATE hotel-is2.cliente SET telefono = ?, Correo = ?, activo = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tCliente.getTelefono());
			ps.setString(2, tCliente.getCorreo());
			ps.setBoolean(3, tCliente.getActivo());
			ps.setInt(4, tCliente.getId());
			if(ps.executeUpdate()==1) ok= tCliente.getId();
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	
	public TCliente MostrarUno(Integer id) {
		
		TCliente tCliente = null;
		
		try {
			String c = "SELECT * FROM hotel-is2.cliente WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				//tCliente = new TCliente(Rs.getInt("Id"), Rs.getInt("telefono"),
					//	Rs.getString("correo"), Rs.getBoolean("activo"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tCliente;
		
	}

	
	public Collection<TCliente> MostrarTodos() {
		
		ArrayList<TCliente> lista = new ArrayList<TCliente>();
		
		try {
			String c = "SELECT * FROM hotel-is2.cliente;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				//lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("jefe"),
					//	Rs.getString("nombre"), Rs.getBoolean("activo")));
				
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
