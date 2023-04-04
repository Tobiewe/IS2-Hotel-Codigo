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
    

	public Integer añadir(THabitaciones tHabitaciones) {
		int key = -1;
		
		try {
			
			String c = "INSERT INTO hotel-is2.habitacion (Numero, Precio, Piso, Tamano, Ocupada, id_empleado) VALUES (?, ?, ?, ?, ?, ?);";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tHabitaciones.getNumero());
			ps.setFloat(2, tHabitaciones.getPrecio());
			ps.setInt(3, tHabitaciones.getPiso());
			ps.setFloat(4, tHabitaciones.getTamaño());
			ps.setBoolean(5, tHabitaciones.getOcupada());
			ps.setInt(6, tHabitaciones.getId_empledo());
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
			
			String c = "UPDATE hotel-is2.habitacion SET activo = ? WHERE Numero = ?;";

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
			
			String c = "UPDATE hotel-is2.habitacion SET precio = ?, nombre = ?, piso= ?, tamano = ?, ocupada = ?, id_empleado = ? WHERE Numero = ?;";

			Connection Cnx = DriverManager.getConnection(url, usuario, clave);
			PreparedStatement ps = Cnx.prepareStatement(c);

			ps.setString(1, tDepartamento.getJefe());
			ps.setString(2, tDepartamento.getNombre());
			ps.setBoolean(3, tDepartamento.getActivado());
			ps.setInt(4, tDepartamento.getId());
			if(ps.executeUpdate()==1) ok= tDepartamento.getId();
			
			Cnx.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return ok;
		
	}

	@Override
	public THabitaciones MostrarUna(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<THabitaciones> MostrarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<THabitaciones> MostrarTodasDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<THabitaciones> leerHabitacionesPorEmpleado(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
