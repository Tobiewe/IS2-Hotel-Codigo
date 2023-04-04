package Integracion.Departamentos;

import Negocio.Departamentos.TDepartamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAODepartamentosImp implements DAODepartamentos {

	String url = "jdbc:mysql://localhost:3306/hotel-is2";
    String usuario = "root";
    String clave = "";
    
	@Override
	public Integer crear(TDepartamento tDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer borrar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer modificar(TDepartamento tDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TDepartamento MostrarUno(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<TDepartamento> MostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
