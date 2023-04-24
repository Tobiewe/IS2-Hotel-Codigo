package Presentacion.Reserva.VReservaCasosUso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import Negocio.Habitaciones.THabitaciones;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarHabitacionesReserva extends JFrame implements IGUI{

	Controller ctrl;
	private Integer idReserva;
	private habitacionesTableModel tableModel;
	
	public VMostrarHabitacionesReserva(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar habitaciones por reserva");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new habitacionesTableModel();
		mainPanel.add(idTareaPanel());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(mostrarButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		mainPanel.add(tableModel.transformTableToPanel());
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public JPanel idTareaPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id de la reserva: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idReserva = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idReserva = (Integer) idSpinner.getValue();
			}
			
		});
		
		idPanel.add(idLabel);
		idPanel.add(idSpinner);
		return idPanel;
		
	}
	public JButton mostrarButton()
	{
		JButton crearButton = new JButton("Mostrar");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_MOSTRAR_HABITACIONES, idReserva);
			}
			
			
		});
		return crearButton;
	}
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
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
			fireTableDataChanged();
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
				return habitaciones.get(rowIndex).gettamanyo();
			else if(columnIndex == 3)
				return habitaciones.get(rowIndex).getPrecio();
			else if(columnIndex == 4)
				return habitaciones.get(rowIndex).getId_empledo();
			else if(columnIndex == 5)
				return habitaciones.get(rowIndex).getOcupada();
			return null;
		}
		public JPanel transformTableToPanel()
		{
			JPanel tablaPanel = new JPanel(new BorderLayout());
			JTable hTable = new JTable(this); 
			
			tablaPanel.add(hTable);
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Habitaciones");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.RESERVA_MOSTRAR_HABITACIONES_SUCCESS)
		{
			tableModel.setList((Collection<THabitaciones>) datos);
		}
		else if(event == Events.RESERVA_MOSTRAR_HABITACIONES_FAILED)
		{
			JOptionPane.showMessageDialog(this, "ERROR: La reserva con id " + (Integer) datos + " no tiene habitaciones registradas");
			
		}
		setVisible(false);
		ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
	}

}
