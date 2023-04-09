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
			
			String c = "INSERT INTO cliente (Id, telefono, Correo, activo) VALUES (?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tCliente.getId());
			ps.setInt(2, tCliente.getTelefono());
			ps.setString(3, tCliente.getCorreo());
			ps.setBoolean(4, tCliente.getActivo());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
				
			Cnx.close();
			ps.close();
			rs.close();
			
			if(tCliente.getCIF() != null){
				String cE = "INSERT INTO cliente_empresa (nombre, CIF, cliente_id) VALUES (?, ?, ?);";

				Connection CnxE = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psE = CnxE.prepareStatement(cE);

				psE.setString(1, tCliente.getNombre());
				psE.setString(2, tCliente.getCIF());
				psE.setInt(3, tCliente.getId());
				psE.executeUpdate();

				CnxE.close();
				psE.close();
			}
			else{
				String cP = "INSERT INTO cliente_particular (nombre, apellidos, NIF, cliente_id) VALUES (?, ?, ?, ?);";

				Connection CnxP = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psP = CnxP.prepareStatement(cP);

				psP.setString(1, tCliente.getNombre());
				psP.setString(2, tCliente.getApellidos());
				psP.setString(3, tCliente.getNIF());
				psP.setInt(4, tCliente.getId());;
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
			
			String c = "UPDATE cliente SET telefono = ?, Correo = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tCliente.getTelefono());
			ps.setString(2, tCliente.getCorreo());
			ps.setInt(3, tCliente.getId());
			
			if(ps.executeUpdate()==1) ok= tCliente.getId();
			
			Cnx.close();
			ps.close();
			
			if(tCliente.getCIF() != null){
				
				String cE = "UPDATE cliente_empresa SET Nombre = ?, CIF = ? WHERE cliente_id = ?;";

				Connection CnxE = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psE = CnxE.prepareStatement(cE);

				psE.setString(1, tCliente.getNombre());
				psE.setString(2, tCliente.getCIF());
				psE.setInt(3, tCliente.getId());
				psE.executeUpdate();

				CnxE.close();
				psE.close();
			}
			else if (tCliente.getNIF() != null){
				String cP = "UPDATE cliente_particular SET nombre = ?, apellidos = ?, NIF = ? WHERE cliente_id = ?;";

				Connection CnxP = DriverManager.getConnection(url, usuario, clave);
				PreparedStatement psP = CnxP.prepareStatement(cP);

				psP.setString(1, tCliente.getNombre());
				psP.setString(2, tCliente.getApellidos());
				psP.setString(3, tCliente.getNIF());
				psP.setInt(4, tCliente.getId());;
				
				psP.executeUpdate();
					
				CnxP.close();
				psP.close();
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	
	public TCliente MostrarUno(Integer id) { //pendiente de revision
		
		TCliente tCliente = null;
		
		try {
			String c = "SELECT * FROM cliente WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				
				tCliente = new TCliente(Rs.getInt("Id"), Rs.getString("correo"),
						Rs.getInt("telefono"), Rs.getString("nombre"),  Rs.getString("CIF"),  Rs.getString("apellidos")
						,Rs.getString("NIF"),  Rs.getBoolean("activo"));
				
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
							Rs.getInt("telefono"), tCliente.getNombre(), tCliente.getCIF(), null ,null,  Rs.getBoolean("activo")));
					
				}
				else if(tCliente.getNIF() != null){
					
					lista.add(new TCliente(Rs.getInt("Id"), Rs.getString("correo"), Rs.getInt("telefono"), tCliente.getNombre(), 
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
