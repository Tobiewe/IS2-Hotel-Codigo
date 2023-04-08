package Integracion.Reserva;

import java.util.Collection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.Reserva.TReserva;

public class DAOReservaImp implements DAOReserva {

	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
    
	
	public Integer abrir(TReserva tReserva) {
		
		int key = -1;
		
		try {
			
			String c = "INSERT INTO hotel-is2.reserva (Id, total, Fecha_entrada, nombre, noches) VALUES (?, ?, ?, ?. ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tReserva.getId());
			ps.setFloat(2, tReserva.getTotal());
			ps.setDate(3, (Date) tReserva.getFecha_entrada());
			ps.setString(4, tReserva.getNombre());
			ps.setInt(5, tReserva.getNoches());
			ps.executeUpdate();

				
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return key;
		
	}
	
	
	public Integer añadir(TReserva tReserva) {
		
		int key = -1;

		try {
			
			String c = "UPDATE hotel-is2.reserva SET cliente_Id = ?, activo = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tReserva.getId_cliente());
			ps.setBoolean(2, true);
			ps.setInt(3, tReserva.getId());
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
	
	@Override
	public Integer quitar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer cerrar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Integer modificar(TReserva tReserva) {
		int key = -1;

		try {
			
			String c = "UPDATE hotel-is2.reserva SET Fecha_entrada = ?, nombre = ?, noches = ? WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setDate(1, (Date) tReserva.getFecha_entrada());
			ps.setString(2, tReserva.getNombre());
			ps.setInt(3, tReserva.getNoches());
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


	public TReserva MostrarUna(Integer id) {

		TReserva tReserva = null;
		
		try {
			String c = "SELECT * FROM hotel-is2.reserva WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tReserva = new TReserva(Rs.getInt("Id"), Rs.getFloat("total"),Rs.getDate("Fecha_entrada"), Rs.getString("nombre"), Rs.getInt("id_cliente"), 
						Rs.getInt("noches"), Rs.getBoolean("activo"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tReserva;
		
	}
	
	
	public Collection<TReserva> MostrarTodas() {

		ArrayList<TReserva> lista = new ArrayList<TReserva>();
		
		try {
			String c = "SELECT * FROM hotel-is2.departamento;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TReserva(Rs.getInt("Id"), Rs.getFloat("total"),Rs.getDate("Fecha_entrada"), Rs.getString("nombre"), Rs.getInt("id_cliente"), 
						Rs.getInt("noches"), Rs.getBoolean("activo")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}
	
	
	
	public Collection<TReserva> leerReservasPorCliente(int idCliente) {
		
		ArrayList<TReserva> lista = new ArrayList<TReserva>();
		
		try {
			String c = "SELECT * FROM hotel-is2.departamento WHERE cliente_Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idCliente);
			ps.executeUpdate();

			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				
				lista.add(new TReserva(rs.getInt("Id"), rs.getFloat("total"),rs.getDate("Fecha_entrada"), rs.getString("nombre"), rs.getInt("id_cliente"), 
						rs.getInt("noches"), rs.getBoolean("activo")));
				
			}
						
			Cnx.close();
			ps.close();
			rs.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
	}
    
	
}
