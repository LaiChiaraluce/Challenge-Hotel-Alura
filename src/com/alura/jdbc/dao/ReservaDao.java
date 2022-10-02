package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.alura.jdbc.modelo.Reserva;

public class ReservaDao {
	final private Connection conexion;
	
	public ReservaDao(Connection conexion) {
		this.conexion = conexion;
	}
	
	public void guardar(Reserva reserva) {
		try {
			conexion.setAutoCommit(false);
			final PreparedStatement statement = conexion.prepareStatement("INSERT INTO RESERVAS (fechaEntrada, fechaSalida, valor, formaPago) "
																		+ "VALUES (?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setLong(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
						conexion.commit();
					}
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
	
	public List<Reserva> listar(){
		try {
			final PreparedStatement statement = conexion.prepareStatement("SELECT id, fechaEntrada, fechaSalida, valor, formaPago FROM RESERVAS");
			try(statement){
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				List<Reserva> listadoReservas = new ArrayList<Reserva>();
				
				while(resultSet.next()) {
					Reserva reserva = new Reserva(resultSet.getInt("id"),
												resultSet.getDate("fechaEntrada"),
												resultSet.getDate("fechaSalida"),
												resultSet.getLong("valor"),
												resultSet.getString("formaPago"));
					listadoReservas.add(reserva);			
				}
				return listadoReservas;
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
	public List<Reserva> filtrar(Integer id){
		try {
			final PreparedStatement statement = conexion.prepareStatement("SELECT id, fechaEntrada, fechaSalida, valor, formaPago FROM RESERVAS WHERE id = ?");
			try(statement){
				statement.setInt(1, id);
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				List<Reserva> listadoReservas = new ArrayList<Reserva>();
				
				while(resultSet.next()) {
					Reserva reserva = new Reserva(resultSet.getInt("id"),
												resultSet.getDate("fechaEntrada"),
												resultSet.getDate("fechaSalida"),
												resultSet.getLong("valor"),
												resultSet.getString("formaPago"));
					listadoReservas.add(reserva);			
				}
				return listadoReservas;
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
	public void eliminar(Integer id) {
		try {
			final PreparedStatement statement = conexion.prepareStatement("DELETE FROM HUESPEDES WHERE idReserva = ?");
			try (statement){
				statement.setInt(1, id);
				statement.execute();
				JOptionPane.showMessageDialog(null, "El huésped correspondiente a esta reserva ha sido eliminado!");
			}
			final PreparedStatement statementRes = conexion.prepareStatement("DELETE FROM RESERVAS WHERE id = ?");
			try (statement){
				statementRes.setInt(1, id);
				statementRes.execute();
				JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito!");
			}
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException();
		}
	}
	
	public void editar(Reserva reserva, Integer id) {
		try {
			conexion.setAutoCommit(false);
			final PreparedStatement statement = conexion.prepareStatement("UPDATE RESERVAS SET fechaEntrada = ?,"
																			+ "fechaSalida = ?, valor = ?, formaPago = ? WHERE id = ?");
			try(statement){
				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setLong(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());
				statement.setInt(5, id);
				
				statement.execute();
				conexion.commit();
				JOptionPane.showMessageDialog(null, "Carga de datos exitosa! La reserva ha sido editada!");
			}
		}catch(SQLException error){
			try {
				conexion.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
			throw new RuntimeException(error);
		}
	}
	
}
