package com.alura.jdbc.controller;

import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.alura.jdbc.dao.HuespedDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huesped;

import views.Busqueda.TablaHuesped;
import views.Busqueda.TablaReserva;

public class HuespedController {

	private HuespedDao huespedDao;
	
	public HuespedController(){
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDao(factory.recuperaConexion());
	}
	
	public void cargarTablaHuespedes(TablaHuesped modeloH) {
		List<Huesped> Huespedes = null;
		try {
			Huespedes = huespedDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Huespedes.forEach(huesped -> modeloH.addRow(new Object[] {
				huesped.getId(),
				huesped.getNombre(),
				huesped.getApellido(),
				huesped.getfNacto(),
				huesped.getNacionalidad(),
				huesped.getTelefono(),
				huesped.getIdReserva()
		}));
	}
	
	public void filtrarHuesped(String filtro, TablaHuesped modeloH) {
		
		int filas=modeloH.getRowCount();
        for (int i = 0;filas>i; i++) {
            modeloH.removeRow(0);
        }
		
		List<Huesped> huespedes = null;
		try {
			huespedes = huespedDao.filtrar(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		huespedes.forEach(huesped -> modeloH.addRow(new Object[] {
				huesped.getId(),
				huesped.getNombre(),
				huesped.getApellido(),
				huesped.getfNacto(),
				huesped.getNacionalidad(),
				huesped.getTelefono(),
				huesped.getIdReserva()
		}));
	}
	
	public void eliminarHuesped(TablaHuesped modeloH, TablaReserva modelo, JTable tbHuespedes) {
		Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
		Integer idReserva = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());

		huespedDao.eliminar(id, idReserva);
		
		modeloH.removeRow(tbHuespedes.getSelectedRow());
		
		int filas=modelo.getRowCount();
        for (int i = 0;filas>i; i++) {
        	if(modelo.getValueAt(i, 0) == idReserva) {
        		modelo.removeRow(i);
        		break;
        	}
        }
	}
	
	public void editarHuesped(Integer fila, TablaHuesped modeloH) {
		try {
			String nombre = (String) modeloH.getValueAt(fila, 1);
			String apellido = (String) modeloH.getValueAt(fila, 2);
			Date fNacto = Date.valueOf(modeloH.getValueAt(fila, 3).toString());
			String nacionalidad = (String) modeloH.getValueAt(fila, 4);
			String telefono = (String) modeloH.getValueAt(fila, 5);
			
			Huesped huesped = new Huesped(nombre, apellido, fNacto, nacionalidad, telefono);
			Integer id = (Integer) modeloH.getValueAt(fila, 0);
			huespedDao.editar(huesped, id);
		}catch(IllegalArgumentException error) {
			JOptionPane.showMessageDialog(null, "La fecha de nacimiento ha sido escrita de forma incorrecta!");
		}
	}
	
}
