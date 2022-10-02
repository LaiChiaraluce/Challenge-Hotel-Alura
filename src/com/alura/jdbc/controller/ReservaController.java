package com.alura.jdbc.controller;

import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.alura.jdbc.dao.HuespedDao;
import com.alura.jdbc.dao.ReservaDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Reserva;

import views.Busqueda.TablaHuesped;
import views.Busqueda.TablaReserva;

public class ReservaController {

	private ReservaDao reservaDao;
	
	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDao(factory.recuperaConexion());
	}
	
	public void cargarTablaReservas(TablaReserva modelo) {
		
		List<Reserva> reservas = null;
		try {
			reservas = reservaDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reservas.forEach(reserva -> modelo.addRow(new Object[] {
				reserva.getId(),
				reserva.getFechaEntrada(),
				reserva.getFechaSalida(),
				reserva.getValor(),
				reserva.getFormaPago()
		}));
	}
	
	public void filtrarReserva(Integer filtro, TablaReserva modelo) {
		
		int filas=modelo.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
		
		List<Reserva> reservas = null;
		try {
			reservas = reservaDao.filtrar(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		reservas.forEach(reserva -> modelo.addRow(new Object[] {
				reserva.getId(),
				reserva.getFechaEntrada(),
				reserva.getFechaSalida(),
				reserva.getValor(),
				reserva.getFormaPago()
		}));
	}
	
	public void eliminarReserva(TablaHuesped modeloH, TablaReserva modelo, JTable tbReservas) {
		Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
		reservaDao.eliminar(id);
		
		modelo.removeRow(tbReservas.getSelectedRow());
		
		int filas=modeloH.getRowCount();
        for (int i = 0;filas>i; i++) {
            if(modeloH.getValueAt(i, 6) == id) {
            	modeloH.removeRow(i);
            	break;
            }
        }
	}
	
	public void editarReserva(Integer fila, TablaReserva modelo) {
		try {
			Date fecEntrada = Date.valueOf(modelo.getValueAt(fila, 1).toString());
			Date fecSalida = Date.valueOf(modelo.getValueAt(fila, 2).toString());
			String formaPago = (String) modelo.getValueAt(fila, 4);
			
		    long diasDesde = (long) Math.floor(fecEntrada.getTime() / (1000*60*60*24)); 
		    long diasHasta = (long) Math.floor(fecSalida.getTime() / (1000*60*60*24)); 
		    long dias = diasHasta - diasDesde;
			
			if(dias < 0) {
				JOptionPane.showMessageDialog(null, "La fecha de entrada debe ser anterior a la de salida!");
			}
			else if((!formaPago.equals("Tarjeta de Crédito")) && (!formaPago.equals("Tarjeta de Débito")) && (!formaPago.equals("Dinero en efectivo"))) {
				JOptionPane.showMessageDialog(null, "Las formas de pago pueden ser: Tarjeta de Credito - Tarjeta de Debito - Dinero en efectivo");
			}
			else {
				Long valor = dias * 1000;
				Reserva reserva = new Reserva(fecEntrada,fecSalida,valor,formaPago);
				Integer id = (Integer) modelo.getValueAt(fila, 0);
				reservaDao.editar(reserva, id);
				modelo.setValueAt(valor, fila, 3);
			}
		}catch(IllegalArgumentException error) {
			JOptionPane.showMessageDialog(null, "Alguna de las fechas ingresadas ha sido escrita de forma incorrecta!");
		}
	}
	
}
