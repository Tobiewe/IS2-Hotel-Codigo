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

import Negocio.Empleados.TEmpleados;
import Negocio.Habitaciones.THabitaciones;
import Negocio.Reserva.TReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Reserva.VReservaCasosUso.VMostrarHabitacionesReserva.habitacionesTableModel;

public class VMostrarReservaHabitaciones extends JFrame implements IGUI {

	Controller ctrl;
	private Integer idHabitacion;
	private reservaTableModel tableModel;
	
	public VMostrarReservaHabitaciones(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar Reservas por Habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new reservaTableModel();
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
		
		JLabel idLabel = new JLabel("Número de la habitación: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idHabitacion = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idHabitacion = (Integer) idSpinner.getValue();
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
				ctrl.carryAction(Events.RESERVA_MOSTRAR_RESERVA, idHabitacion);
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
	class reservaTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Total", "Fecha de entrada","Cliente Id", "Noches", "Activa"};
		List<TReserva> reservas;
		
		public reservaTableModel()
		{
			reservas =  new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			return reservas.size();
		}
		public void setList(Collection<TReserva> collection)
		{
			reservas = new ArrayList<>(collection);
			fireTableDataChanged();
		}
		public void addElement(TReserva element)
		{
			reservas.add(element);
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
				return reservas.get(rowIndex).getId();
			else if(columnIndex == 1)
				return reservas.get(rowIndex).getTotal();
			else if(columnIndex == 2)
				return reservas.get(rowIndex).getFecha_entrada();
			else if(columnIndex == 3)
				return reservas.get(rowIndex).getId_cliente();
			else if(columnIndex == 4)
				return reservas.get(rowIndex).getNoches();
			else if(columnIndex == 5)
				return reservas.get(rowIndex).getActivo();
			return null;
		}
		public JPanel transformTableToPanel()
		{
			JPanel tablaPanel = new JPanel(new BorderLayout());
			JTable hTable = new JTable(this); 
			
			tablaPanel.add(hTable);
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Reservas");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.RESERVA_MOSTRAR_RESERVA_SUCCESS)
		{
			tableModel.setList((Collection<TReserva>) datos);
		}
		else if(event == Events.RESERVA_MOSTRAR_RESERVA_FAILED)
		{
			JOptionPane.showMessageDialog(this, "ERROR: La habitación con número " + (Integer) datos + " no tiene reservas registradas");
		}
	}
	
}
