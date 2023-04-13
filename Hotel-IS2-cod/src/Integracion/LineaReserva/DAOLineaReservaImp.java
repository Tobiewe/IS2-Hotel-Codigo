package Integracion.LineaReserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Reserva.TLineaReserva;

public class DAOLineaReservaImp implements DAOLineaReserva {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";

	
	public Integer crear(TLineaReserva tLineaPedido) {
		int key = -1;
		
		try {
			
			String c = "INSERT INTO linea_pedidos (id_Reserva, id_Cliente, id_Habitacion, activo) VALUES (?, ?, ?, ?);";

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

	
	
	public Integer eliminar(Integer idReserva, Integer idCliente, Integer idHabitacion) { // no funciona
		
		int key = -1;

		try {
			
			String c = "UPDATE linea_pedidos SET activo = ? WHERE id_Reserva = ? AND id_Cliente = ? AND id_Habitacion = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
			ps.setInt(2, idReserva);
			ps.setInt(3, idCliente);
			ps.setInt(4, idHabitacion);
			
			key = (ps.executeUpdate() == 1) ? idReserva: -1 ;

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
		
	}



	
	public Integer modificar(TLineaReserva tLineaPedido) {

		int key = -1;

		try {
			
			String c = "UPDATE linea_pedidos SET id_Habitacion = ? WHERE id_Reserva = ? AND id_Cliente = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);
			System.out.println( tLineaPedido.getId_habitacion());
			ps.setInt(1, tLineaPedido.getId_habitacion());
			ps.setInt(2, tLineaPedido.getId_reserva());
			ps.setInt(3, tLineaPedido.getId_cliente());
			
			if(ps.executeUpdate()==1) key = tLineaPedido.getId_reserva();

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;

	}


	
	public Collection<TLineaReserva> Leertodos() {

		ArrayList<TLineaReserva> lista = new ArrayList<TLineaReserva>();
		
		try {
			String c = "SELECT * FROM linea_pedidos;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TLineaReserva(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activo")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}




	
	public TLineaReserva LeerUno(Integer idReserva, Integer idCliente) {
		
		TLineaReserva tLineaPedido = null;
		
		try {
			String c = "SELECT * FROM linea_pedidos WHERE id_Reserva = ? AND id_Cliente = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idReserva);
			ps.setInt(2, idCliente);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tLineaPedido = new TLineaReserva(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activo"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tLineaPedido;
	}




	
	public Collection<TLineaReserva> LeerLineasPedidoPorReserva(Integer idReserva) {
		
		ArrayList<TLineaReserva> lista = new ArrayList<TLineaReserva>();
		
		try {
			String c = "SELECT * FROM linea_pedidos WHERE id_Reserva = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idReserva);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TLineaReserva(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activo")));
				
			}
						
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
	}




	
	public Collection<TLineaReserva> LeerLineasPedidoPorHabitacion(Integer idHabitacion) {

		ArrayList<TLineaReserva> lista = new ArrayList<TLineaReserva>();
		
		try {
			String c = "SELECT * FROM linea_pedidos WHERE id_Habitacion = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idHabitacion);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new TLineaReserva(Rs.getInt("id_reserva"), Rs.getInt("id_cliente"), Rs.getInt("id_habitacion"), Rs.getBoolean("activo")));
				
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
