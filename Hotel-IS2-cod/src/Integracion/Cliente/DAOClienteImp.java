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
			
			String c = "INSERT INTO cliente (telefono, Correo, activo, nombre, Tipo) VALUES (?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tCliente.getTelefono());
			ps.setString(2, tCliente.getCorreo());
			ps.setBoolean(3, tCliente.getActivo());
			ps.setString(4, tCliente.getNombre());
			ps.setString(5, tCliente.getTipo());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
				

			
			if(tCliente.getTipo() == "Empresa" || tCliente.getTipo() == "empresa"){
				c = "INSERT INTO cliente_empresa (CIF, cliente_Id) VALUES ( ?, ?);";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, key);
				ps.executeUpdate();

			}
			else{
				c = "INSERT INTO cliente_particular (apellidos, NIF, cliente_Id) VALUES (?, ?, ?);";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getApellidos());
				ps.setString(2, tCliente.getNIF());
				ps.setInt(3, key);;
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
			
			
			if(tCliente.getTipo() == "Empresa" || tCliente.getTipo() == "empresa"){
				
				c = "UPDATE cliente_empresa SET CIF = ? WHERE cliente_Id = ?;";

				
				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, ok);
				ps.executeUpdate();

			}
			else if (tCliente.getTipo() == "Particular" || tCliente.getTipo() == "particular"){
				c = "UPDATE cliente_particular SET apellidos = ?, NIF = ? WHERE cliente_Id = ?;";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getApellidos());
				ps.setString(2, tCliente.getNIF());
				ps.setInt(3, ok);;
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
			
			
			String c = "SELECT * FROM cliente WHERE Id = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);
			
			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				if(Rs.getString("Tipo") == "Empresa" || Rs.getString("Tipo") == "empresa"){
					
					c = "SELECT * FROM cliente_empresa WHERE cliente_Id = ?;";
					
					ps = Cnx.prepareStatement(c);
					
					ps.setInt(1, id);
					Rs = ps.executeQuery();
					
					CIF = Rs.getString("CIF");
					
					c = "SELECT * FROM cliente WHERE Id = ?;";
					
					ps = Cnx.prepareStatement(c);
					
					ps.setInt(1, id);
					Rs = ps.executeQuery();
					
					tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
							Rs.getInt("telefono"), Rs.getString("nombre"),  CIF,  null ,null ,  Rs.getBoolean("activo"), Rs.getString("Tipo"));
					
					System.out.println(CIF);
					
				}
				else{
					
					c = "SELECT * FROM cliente_particular WHERE cliente_Id = ?;";
					
					ps = Cnx.prepareStatement(c);
					
					ps.setInt(1, id);
					Rs = ps.executeQuery();
					
					NIF = (String) Rs.getString("NIF");
					apellidos = Rs.getString("apellidos");
					
					c = "SELECT * FROM cliente WHERE Id = ?;";
					
					ps = Cnx.prepareStatement(c);
					
					ps.setInt(1, id);
					Rs = ps.executeQuery();
					
					tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
							Rs.getInt("telefono"), Rs.getString("nombre"),  null,  apellidos ,NIF ,  Rs.getBoolean("activo"), Rs.getString("Tipo"));
				
					System.out.println(NIF);
					System.out.println(apellidos);

				}
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
							Rs.getInt("telefono"),  Rs.getString("nombre"), tCliente.getCIF(), null ,null,  Rs.getBoolean("activo"), Rs.getString("Tipo")));
					
				}
				else if(tCliente.getNIF() != null){
					
					lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("correo"), Rs.getInt("telefono"), Rs.getString("nombre"), 
							null, tCliente.getApellidos() ,tCliente.getNIF(),  Rs.getBoolean("activo"), Rs.getString("Tipo")));
					
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


	
	public Collection<TCliente> MostrarParticular() {
		ArrayList<TCliente> lista = new ArrayList<TCliente>();
		
		try {
			String c = "SELECT * FROM cliente;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				TCliente tCliente = MostrarUno(Rs.getInt("Id"));
				
				if(tCliente.getNIF() != null){
					
					lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("correo"), Rs.getInt("telefono"), Rs.getString("nombre"), 
							null, tCliente.getApellidos() ,tCliente.getNIF(),  Rs.getBoolean("activo"), Rs.getString("Tipo")));
					
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


	
	public Collection<TCliente> MostrarEmpresa() {
		
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
							Rs.getInt("telefono"),  Rs.getString("nombre"), tCliente.getCIF(), null ,null,  Rs.getBoolean("activo"), Rs.getString("Tipo")));
					
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
