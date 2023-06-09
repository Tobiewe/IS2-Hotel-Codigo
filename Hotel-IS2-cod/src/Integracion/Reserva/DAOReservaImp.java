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
			
			String c = "INSERT INTO reserva (total, Fecha_entrada, noches, cliente_Id, activo) VALUES ( ?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setFloat(1, tReserva.getTotal()); //pasarle 0 desde la vista
			java.util.Date fecha_entrada = tReserva.getFecha_entrada();
			java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());
			ps.setDate(2, sql_fecha_entrada);
			ps.setInt(3, tReserva.getNoches());
			ps.setInt(4, tReserva.getId_cliente());
			ps.setBoolean(5, tReserva.getActivo()); //false pasarlo desde la vista
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
	
	
	public Integer eliminar(Integer id) {

		int key = -1;

		try {
			
			String c = "UPDATE reserva SET activo = ? WHERE Id = ?;";

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
	
	
	public Integer modificar(TReserva tReserva) {
		int key = -1;
		
		Integer total = 0;
		
		try {
			
			String c = "SELECT SUM(precio) FROM habitacion JOIN linea_reserva ON habitacion.numero = linea_reserva.id_Habitacion WHERE id_Reserva = ?;";
			
			
			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);
			
			ps.setInt(1, tReserva.getId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				total = rs.getInt(1);
			}
			System.out.println(total);
			rs.close();
			
			c = "UPDATE reserva SET Fecha_entrada = ?, noches = ?, total = ?, activo = ? WHERE Id = ?;";

			ps = Cnx.prepareStatement(c);

			java.util.Date fecha_entrada = tReserva.getFecha_entrada();
			java.sql.Date sql_fecha_entrada = new java.sql.Date(fecha_entrada.getTime());
			ps.setDate(1, sql_fecha_entrada);;
			ps.setInt(2, tReserva.getNoches());
			ps.setInt(3, (total*tReserva.getNoches()));
			ps.setBoolean(4, tReserva.getActivo());
			ps.setInt(5, tReserva.getId());
			ps.executeUpdate();

			if(ps.executeUpdate()==1) key = tReserva.getId();
				
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
	}


	public TReserva MostrarUna(Integer id) {

		TReserva tReserva = null;
		
		try {
			String c = "SELECT * FROM reserva WHERE Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, id);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tReserva = new TReserva(Rs.getInt("Id"), Rs.getFloat("total"),Rs.getDate("Fecha_entrada"), Rs.getInt("cliente_Id"), 
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
			String c = "SELECT * FROM reserva;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new TReserva(Rs.getInt("Id"), Rs.getFloat("total"),Rs.getDate("Fecha_entrada"), Rs.getInt("cliente_Id"), 
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
	
	
	//Commit
	public Collection<TReserva> leerReservasPorCliente(Integer idCliente) {
		
		ArrayList<TReserva> lista = new ArrayList<TReserva>();
		
		try {
			String c = "SELECT * FROM reserva WHERE cliente_Id = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idCliente);

			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				
				lista.add(new TReserva(rs.getInt("Id"), rs.getFloat("Total"),rs.getDate("Fecha_entrada"), rs.getInt("cliente_Id"), 
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
