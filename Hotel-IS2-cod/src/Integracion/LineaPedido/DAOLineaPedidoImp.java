package Integracion.LineaPedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Reserva.TLineaPedido;

public class DAOLineaPedidoImp implements DAOLineaPedido {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	
	public Integer crear(TLineaPedido tLineaPedido) {
		int key = -1;
		
		try {
			
			String c = "INSERT INTO hotel-is2.linea_pedidos (id_Reserva, id_Cliente, id_Habitacion, activo) VALUES (?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tLineaPedido.getId_reserva());
			ps.setInt(2, tLineaPedido.getId_cliente());
			ps.setInt(3, tLineaPedido.getId_habitacion());
			ps.setBoolean(4, tLineaPedido.getActiva());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){ 		//devuelvo el id de la reserva u otra cosa??????
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

	
	
	public Integer eliminar(Integer idReserva, Integer idCliente) {
		
		int key = -1;

		try {
			
			String c = "UPDATE hotel-is2.linea_pedidos SET activo = ? WHERE id_Reserva = ? AND id_Cliente = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
			ps.setInt(2, idReserva);
			ps.setInt(3, idCliente);

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
		
	}



	@Override
	public Integer modificar(TLineaPedido tLineaPedido) {

		int key = -1;

		try {
			
			String c = "UPDATE hotel-is2.linea_pedidos SET id_Habitacion = ? WHERE id_Reserva = ? AND id_Cliente = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, tLineaPedido.getId_habitacion());
			ps.setInt(2, tLineaPedido.getId_reserva());
			ps.setInt(3, tLineaPedido.getId_cliente());

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;

	}


	@Override
	public Collection<TLineaPedido> Leertodos() {

		ArrayList<TLineaPedido> lista = new ArrayList<TLineaPedido>();
		
		try {
			String c = "SELECT * FROM hotel-is2.linea_pedidos;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TLineaPedido(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activa")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}




	
	public TLineaPedido LeerUno(Integer idReserva, Integer idCliente) {
		
		TLineaPedido tLineaPedido = null;
		
		try {
			String c = "SELECT * FROM hotel-is2.linea_pedidos WHERE id_Reserva = ? AND id_Cliente = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idReserva);
			ps.setInt(2, idCliente);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tLineaPedido = new TLineaPedido(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activa"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tLineaPedido;
	}




	@Override
	public Collection<TLineaPedido> LeerLineasPedidoPorReserva(Integer idReserva) {
		
		ArrayList<TLineaPedido> lista = new ArrayList<TLineaPedido>();
		
		try {
			String c = "SELECT * FROM hotel-is2.linea_pedidos WHERE id_Reserva = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idReserva);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TLineaPedido(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activa")));
				
			}
						
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
	}




	
	public Collection<TLineaPedido> LeerLineasPedidoPorHabitacion(Integer idHabitacion) {

		ArrayList<TLineaPedido> lista = new ArrayList<TLineaPedido>();
		
		try {
			String c = "SELECT * FROM hotel-is2.linea_pedidos WHERE id_Habitacion = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idHabitacion);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TLineaPedido(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activa")));
				
			}
						
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;

	}



}
