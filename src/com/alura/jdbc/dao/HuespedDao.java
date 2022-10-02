package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.alura.jdbc.modelo.Huesped;
import com.alura.jdbc.modelo.Reserva;

public class HuespedDao {
	final private Connection conexion;
	
	public HuespedDao(Connection conexion) {
		this.conexion = conexion;
	}
	
	public void guardar(Huesped huesped){
		try {
			conexion.setAutoCommit(false);
			final PreparedStatement statement = conexion.prepareStatement("INSERT INTO HUESPEDES (nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva) "
																		+ "VALUES (?, ?, ?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getfNacto());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdReserva());
			
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
						conexion.commit();
					}
					JOptionPane.showMessageDialog(null, "Carga de datos exitosa!");
				}
			}
		}catch(SQLException error) {
			try {
				conexion.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException(error);
		}
	}
	
	public void editar(Huesped huesped, Integer id){
		try {
			conexion.setAutoCommit(false);
			final PreparedStatement statement = conexion.prepareStatement("UPDATE HUESPEDES SET nombre = ?, apellido = ?, "
																		+ "fechaNacimiento = ?, nacionalidad = ?, telefono = ? WHERE id = ?");
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getfNacto());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, id);
				
				statement.execute();
				conexion.commit();
				JOptionPane.showMessageDialog(null, "Carga de datos exitosa! Los datos del huésped han sido editados");
			}
		}catch(SQLException error) {
			try {
				conexion.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException(error);
		}
	}
	
	public List<Huesped> listar(){
		try {
			final PreparedStatement statement = conexion.prepareStatement("SELECT id, nombre, apellido, fechaNacimiento,"
																			+ "nacionalidad, telefono, idReserva FROM HUESPEDES");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				List<Huesped> listadoHuespedes = new ArrayList<Huesped>();
				
				while(resultSet.next()) {
					Huesped huesped = new Huesped(resultSet.getInt("id"),
												resultSet.getString("nombre"),
												resultSet.getString("apellido"),
												resultSet.getDate("fechaNacimiento"),
												resultSet.getString("nacionalidad"),
												resultSet.getString("telefono"),
												resultSet.getInt("idReserva"));
					
					listadoHuespedes.add(huesped);			
				}
				return listadoHuespedes;
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
	public List<Huesped> filtrar(String apellido){
		try {
			final PreparedStatement statement = conexion.prepareStatement("SELECT id, nombre, apellido, fechaNacimiento, "
																			+ "nacionalidad, telefono, idReserva FROM HUESPEDES WHERE apellido = ?");
			try(statement){
				statement.setString(1, apellido);
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				List<Huesped> listadoHuespedes = new ArrayList<Huesped>();
				
				while(resultSet.next()) {
					Huesped huesped = new Huesped(resultSet.getInt("id"),
												resultSet.getString("nombre"),
												resultSet.getString("apellido"),
												resultSet.getDate("fechaNacimiento"),
												resultSet.getString("nacionalidad"),
												resultSet.getString("telefono"),
												resultSet.getInt("idReserva"));
					
					listadoHuespedes.add(huesped);			
				}
				return listadoHuespedes;
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
	public void eliminar(Integer id, Integer idReserva) {
		try {
			final PreparedStatement statement = conexion.prepareStatement("DELETE FROM HUESPEDES WHERE id = ?");
			try (statement){
				statement.setInt(1, id);
				statement.execute();
				JOptionPane.showMessageDialog(null, "Huésped eliminado con éxito!");
			}
			final PreparedStatement statementRes = conexion.prepareStatement("DELETE FROM RESERVAS WHERE id = ?");
			try (statementRes){
				statementRes.setInt(1, idReserva);
				statementRes.execute();
				JOptionPane.showMessageDialog(null, "Reserva del huésped eliminada con éxito!");
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
}
