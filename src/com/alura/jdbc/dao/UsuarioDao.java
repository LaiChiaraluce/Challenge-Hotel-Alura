package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
public class UsuarioDao {
	final private Connection conexion;
	
	public UsuarioDao(Connection conexion) {
		this.conexion = conexion;
	}
	
	public boolean loguear(String nombre, JPasswordField contra) {
		String nombreBase = "";
		String contraBase = "";
		
		String contraString = new String (contra.getPassword());
		boolean banderaUser = false;
		
		try{
			final java.sql.PreparedStatement statement = conexion.prepareStatement("SELECT NOMBRE, PASSWORD FROM USER");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next()) {
					nombreBase = resultSet.getString("nombre");
					contraBase = resultSet.getString("password");
					if(nombre.equals(nombreBase) && contraString.equals(contraBase)){
						banderaUser = true;
					}
				}if(banderaUser == false) {
					return false;
				}else {
					return true;
				}
			}
		}catch(SQLException error) {
			throw new RuntimeException(error);
		}
	}
}
