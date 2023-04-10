package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import Negocio.Habitaciones.THabitaciones;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarTodasHabitacion extends JFrame implements IGUI{
	Controller ctrl;
	
	public VMostrarTodasHabitacion(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	protected void initGUI() {
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		
		
		JPanel cancelButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cancelButtonPanel.add(cancelButton());
		
		mainPanel.add(cancelButtonPanel);
		
		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		
	}
	class habitacionesTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Piso", "Tamaño", "Precio","Empleado Id", "Ocupada"};
		List<THabitaciones> habitaciones;
		
		public habitacionesTableModel()
		{
			habitaciones =  new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			return habitaciones.size();
		}
		public void setList(Collection<THabitaciones> collection)
		{
			habitaciones = new ArrayList<>(collection);
		}
		@Override
		public int getColumnCount() {
			return columnValues.length;
		}
		@Override 
		public String getColumnName(int columnIndex) 
		{
			return columnValues[columnIndex];
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if(columnIndex == 0)
				return habitaciones.get(rowIndex).getNumero();
			else if(columnIndex == 1)
				return habitaciones.get(rowIndex).getPiso();
			else if(columnIndex == 2)
				return habitaciones.get(rowIndex).getTamaño();
			else if(columnIndex == 3)
				return habitaciones.get(rowIndex).getPrecio();
			else if(columnIndex == 4)
				return habitaciones.get(rowIndex).getId_empledo();
			else if(columnIndex == 5)
				return habitaciones.get(rowIndex).getOcupada();
			return null;
		}
		
	}
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
