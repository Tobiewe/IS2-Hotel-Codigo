package Integracion.Habitaciones;

import Negocio.Habitaciones.THabitaciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOHabitacionesImp implements DAOHabitaciones{
	
	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
    

	public Integer a�adir(THabitaciones tHabitaciones) {
		int key = -1;
		
		try {
			
			String c = "INSERT INTO habitacion (piso, tamanyo, precio, ocupada, id_empleado) VALUES (?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tHabitaciones.getPiso());
			ps.setFloat(2, tHabitaciones.gettamanyo());
			ps.setFloat(3, tHabitaciones.getPrecio());
			ps.setBoolean(4, tHabitaciones.getOcupada());
			ps.setInt(5, tHabitaciones.getId_empledo());
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

	
	public Integer borrar(Integer numero) {
		int key = -1;

		try {
			
			String c = "UPDATE habitacion SET ocupada = ? WHERE Numero = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
			ps.setInt(2, numero);

			key = (ps.executeUpdate() == 1) ? numero : -1;
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return key;
	}

	
	public Integer modificar(THabitaciones tHabitaciones) {
		
		int ok = -1;
		try {
			
			String c = "UPDATE habitacion SET precio = ?, ocupada = ?, id_empleado = ?, tamanyo = ? WHERE Numero = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setFloat(1, tHabitaciones.getPrecio());
			ps.setBoolean(2, tHabitaciones.getOcupada());
			ps.setInt(3, tHabitaciones.getId_empledo());
			ps.setInt(4, tHabitaciones.gettamanyo());
			ps.setInt(5, tHabitaciones.getNumero());
			
			if(ps.executeUpdate()==1) ok= tHabitaciones.getNumero();
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	
	public THabitaciones MostrarUna(Integer numero) {

		THabitaciones tHabitaciones = null;
		
		try {
			String c = "SELECT * FROM habitacion WHERE numero = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, numero);
			ResultSet Rs = ps.executeQuery();

			if (Rs.next()){
				
				tHabitaciones = new THabitaciones( Rs.getInt("numero"), Rs.getInt("piso"), Rs.getInt("tamanyo"), Rs.getFloat("precio"), 
						Rs.getBoolean("ocupada"), Rs.getInt("id_empleado"));
				
			}
	
			Cnx.close();
			ps.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return tHabitaciones;
		
	}

	
	public Collection<THabitaciones> MostrarTodas() {
		
		ArrayList<THabitaciones> lista = new ArrayList<THabitaciones>();
		
		try {
			String c = "SELECT * FROM habitacion;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			Statement St = Cnx.createStatement();
			ResultSet Rs = St.executeQuery(c);

			while (Rs.next()){
				
				lista.add(new THabitaciones( Rs.getInt("numero"), Rs.getInt("piso"), Rs.getInt("tamanyo"), Rs.getFloat("precio"), 
						Rs.getBoolean("ocupada"), Rs.getInt("id_empleado")));
				
			}
						
			Cnx.close();
			St.close();
			Rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}


	
	public Collection<THabitaciones> MostrarTodasDisponibles() {
		ArrayList<THabitaciones> lista = new ArrayList<THabitaciones>();
		
		try {
			String c = "SELECT * FROM habitacion WHERE ocupada = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setBoolean(1, false);
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

	
	public Collection<THabitaciones> leerHabitacionesPorEmpleado(Integer idEmpleado) {
		
		ArrayList<THabitaciones> lista = new ArrayList<THabitaciones>();
		
		try {
			String c = "SELECT * FROM habitacion WHERE id_empleado = ?";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setInt(1, idEmpleado);
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

}
