package Integracion.Cliente;

import Negocio.Clientes.TCliente;

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
			
			String c = "INSERT INTO cliente (telefono, Correo, activo, nombre) VALUES (?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tCliente.getTelefono());
			ps.setString(2, tCliente.getCorreo());
			ps.setBoolean(3, tCliente.getActivo());
			ps.setString(4, tCliente.getNombre());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
				

			
			if(tCliente.getCIF() != null){
				c = "INSERT INTO cliente_empresa ( CIF, cliente_id) VALUES ( ?, ?);";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, tCliente.getId());
				ps.executeUpdate();

			}
			else{
				c = "INSERT INTO cliente_particular (apellidos, NIF, cliente_id) VALUES (?, ?, ?);";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getApellidos());
				ps.setString(2, tCliente.getNIF());
				ps.setInt(3, tCliente.getId());;
				ps.executeUpdate();
					
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
			
			String c = "UPDATE cliente SET activo = ? WHERE Id = ?;";

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
			
			String c = "UPDATE cliente SET telefono = ?, Correo = ?, nombre = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tCliente.getTelefono());
			ps.setString(2, tCliente.getCorreo());
			ps.setString(3, tCliente.getNombre());
			ps.setInt(4, tCliente.getId());
			
			if(ps.executeUpdate()==1) ok= tCliente.getId();
			
			
			if(tCliente.getCIF() != null){
				
				c = "UPDATE cliente_empresa SET CIF = ? WHERE cliente_id = ?;";

				
				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, tCliente.getId());
				ps.executeUpdate();

			}
			else if (tCliente.getNIF() != null){
				c = "UPDATE cliente_particular SET apellidos = ?, NIF = ? WHERE cliente_id = ?;";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getApellidos());
				ps.setString(2, tCliente.getNIF());
				ps.setInt(3, tCliente.getId());;
				ps.executeUpdate();
			}
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	
	public TCliente MostrarUno(Integer id) { 
		
		TCliente tCliente = null;
		String CIF = null, apellidos = null, NIF = null;
		
		try {
			
			
			String cE = "SELECT * FROM cliente_empresa WHERE Id = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(cE);
			
			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();
			
			if(Rs.getString("CIF") != null){
				CIF = Rs.getString("CIF");
			}
			
			else{
				String cP = "SELECT * FROM cliente_particular WHERE Id = ?;";
				 Cnx.prepareStatement(cP);
				
				 ps.setInt(1, id);
				 Rs = ps.executeQuery();
				 apellidos = Rs.getString("apellidos");
				 NIF = Rs.getString("NIF");
			}
			
			
			String c = "SELECT * FROM cliente WHERE Id = ?;";

			Cnx.prepareStatement(c);

			ps.setInt(1, id);
			Rs = ps.executeQuery();

			if (Rs.next()){
				
				
				tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
						Rs.getInt("telefono"), Rs.getString("nombre"),  CIF,  apellidos ,NIF ,  Rs.getBoolean("activo"));
				
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
			String c = "SELECT * FROM cliente;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				TCliente tCliente = MostrarUno(Rs.getInt("Id"));
				
				if(tCliente.getCIF() != null){
					
					lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
							Rs.getInt("telefono"),  Rs.getString("nombre"), tCliente.getCIF(), null ,null,  Rs.getBoolean("activo")));
					
				}
				else if(tCliente.getNIF() != null){
					
					lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("correo"), Rs.getInt("telefono"), Rs.getString("nombre"), 
							null, tCliente.getApellidos() ,tCliente.getNIF(),  Rs.getBoolean("activo")));
					
				}
				
				tCliente = null;
				
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
