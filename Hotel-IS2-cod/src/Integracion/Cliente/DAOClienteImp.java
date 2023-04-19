package Integracion.Cliente;

import Negocio.Clientes.TCliente;
import Negocio.Clientes.TEmpresa;
import Negocio.Clientes.TParticular;

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
				
			System.out.println(tCliente.getCIF());
			
			if(tCliente.getCIF() != null){
				System.out.println("llega al dao crearcliente empresa");
				c = "INSERT INTO cliente_empresa (CIF, cliente_Id) VALUES ( ?, ?);";

				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, key);
				ps.executeUpdate();

			}
			else{
				System.out.println("llega al dao crearcliente particular");
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
			
			
			if(tCliente.getCIF() != null){
				
				c = "UPDATE cliente_empresa SET CIF = ? WHERE cliente_Id = ?;";

				
				ps = Cnx.prepareStatement(c);

				ps.setString(1, tCliente.getCIF());
				ps.setInt(2, ok);
				ps.executeUpdate();

			}
			else if (tCliente.getNIF() != null){
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
			
			
			String c = "SELECT * FROM cliente JOIN cliente_particular ON cliente.Id = cliente_particular.cliente_Id WHERE Id = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
						Rs.getInt("telefono"), Rs.getString("nombre"),  null,  Rs.getString("apellidos") , Rs.getString("NIF"),  Rs.getBoolean("activo"));
				
			}
			else{
				
				c = "SELECT * FROM cliente JOIN cliente_empresa ON cliente.Id = cliente_empresa.cliente_Id WHERE Id = ?;";
				
				ps = Cnx.prepareStatement(c);

				ps.setInt(1, id);
				Rs = ps.executeQuery();
				
				if(Rs.next()){
					tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
							Rs.getInt("telefono"), Rs.getString("nombre"),  Rs.getString("CIF"), null, null,  Rs.getBoolean("activo"));
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


	
	public Collection<TParticular> MostrarParticular() {
		ArrayList<TParticular> lista = new ArrayList<TParticular>();
		
		try {
			String c = "SELECT * FROM cliente RIGHT JOIN cliente_particular ON cliente.Id = cliente_particular.cliente_Id;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				TCliente tCliente = MostrarUno(Rs.getInt("Id"));
				
				if(tCliente.getNIF() != null){
					
					lista.add(new TParticular(Rs.getInt("Id"), Rs.getString("correo"), Rs.getInt("telefono"), Rs.getString("nombre"), 
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


	
	public Collection<TEmpresa> MostrarEmpresa() {
		
		ArrayList<TEmpresa> lista = new ArrayList<TEmpresa>();
		
		try {
			String c = "SELECT * FROM cliente RIGHT JOIN cliente_empresa ON cliente.Id = cliente_empresa.cliente_Id;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				TCliente tCliente = MostrarUno(Rs.getInt("Id"));
				
				if(tCliente.getCIF() != null){
					
					lista.add(new TEmpresa(Rs.getInt("Id"), Rs.getString("correo"),
							Rs.getInt("telefono"),  Rs.getString("nombre"), tCliente.getCIF(), null ,null,  Rs.getBoolean("activo")));
					
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
