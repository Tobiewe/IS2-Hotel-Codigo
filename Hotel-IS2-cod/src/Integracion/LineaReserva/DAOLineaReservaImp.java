package Integracion.LineaReserva;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.Habitaciones.THabitaciones;
import Negocio.Reserva.TLineaReserva;
import Negocio.Reserva.TReserva;

public class DAOLineaReservaImp implements DAOLineaReserva {
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
    


	public Integer añadirHabitacion(TLineaReserva tLineaPedido) {
		
		int key = -1;
		
		Integer total = 0, noches = 0;
		
		try {
		
		String c = "INSERT INTO linea_reserva (id_Reserva, id_Habitacion, activo) VALUES (?, ?, ?);";

		Connection Cnx = DriverManager.getConnection(url, usuario, clave);
		PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

		ps.setInt(1, tLineaPedido.getId_reserva());
		ps.setInt(2, tLineaPedido.getId_habitacion());
		ps.setBoolean(3, tLineaPedido.getActiva());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()){ 		
			key = rs.getInt(1);
		}
		
		c = "SELECT SUM(precio) FROM habitacion JOIN linea_reserva ON habitacion.numero = linea_reserva.id_Habitacion WHERE id_Reserva = ?;";
		
		ps = Cnx.prepareStatement(c);
		
		ps.setInt(1, tLineaPedido.getId_reserva());
		rs = ps.executeQuery();
		
		if(rs.next()){
			
			total = rs.getInt(1);
		}
		
		c = "SELECT noches FROM reserva JOIN linea_reserva ON reserva.Id = linea_reserva.id_Reserva WHERE id_Reserva = ?;";
		
		ps = Cnx.prepareStatement(c);
		
		ps.setInt(1, tLineaPedido.getId_reserva());
		rs = ps.executeQuery();
		
		if(rs.next()){
			
			noches = rs.getInt(1);
		}
		
		c = "UPDATE reserva SET total = ?, activo = ? WHERE Id = ?;";

		ps = Cnx.prepareStatement(c);

		total = total * noches;
		ps.setInt(1, total);
		ps.setBoolean(2, true);
		ps.setInt(3, tLineaPedido.getId_reserva());
		ps.executeUpdate();
			
		Cnx.close();
		ps.close();
		rs.close();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return key;
		
	}
	
	
	public Integer eliminarHabitacion(Integer idReserva, Integer idHabitacion) {
		
		int key = -1;

		try {
			
			String c = "UPDATE linea_pedidos SET activo = ? WHERE id_Reserva = ? AND id_Habitacion = ?;";
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
			ps.setInt(2, idReserva);
			ps.setInt(3, idHabitacion);
			
			key = (ps.executeUpdate() == 1) ? idReserva: -1 ;

			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;

	}

	
	
	public Collection<THabitaciones> ListarHabitacionesPorReserva(Integer idReserva) {
		
		ArrayList<THabitaciones> lista = new ArrayList<THabitaciones>();
		
		try {
			String c = "SELECT * FROM habitacion JOIN linea_reserva ON habitacion.numero = linea_reserva.id_Habitacion WHERE id_Reserva = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idReserva);
			ResultSet Rs = ps.executeQuery();

			while (Rs.next()){
				
				lista.add(new THabitaciones( Rs.getInt("numero"), Rs.getInt("piso"), Rs.getInt("tamanyo"), Rs.getFloat("precio"), 
						Rs.getBoolean("ocupada"), Rs.getInt("id_empleado")));
				
			}
						
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
	}


	
	public Collection<TReserva> ListarReservasPorHabitacion(Integer idHabitacion) {

		ArrayList<TReserva> lista = new ArrayList<TReserva>();
		
		try {
			String c = "SELECT * FROM reserva JOIN linea_reserva ON reserva.Id = linea_reserva.id_Reserva WHERE id_Habitacion = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idHabitacion);
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
