package Presentacion.Habitacion.VHabitacionCasosUso;

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
import javax.swing.JTextField;
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
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarTodasHabitacion.habitacionesTableModel;

public class VMostrarUnaHabitacion  extends JFrame implements IGUI{
	
	Controller ctrl;
	private habitacionesTableModel tableModel;
	
	private Integer id;
	public VMostrarUnaHabitacion(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar una habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new habitacionesTableModel();
		mainPanel.add(idPanel());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(mostrarButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		//Commit
		mainPanel.add(tableModel.transformTableToPanel());
		
		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
	}
	
	public JPanel idPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		id = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				id = (Integer) idSpinner.getValue();
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
				ctrl.carryAction(Events.HABITACION_MOSTRAR_UNA, id);
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
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
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
		public void addElement(THabitaciones element)
		{
			habitaciones.add(element);
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
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Habitación");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.HABITACION_MOSTRAR_UNA_SI_ID)
		{
			tableModel.addElement((THabitaciones)datos);
		}
		else if(event == Events.HABITACION_MOSTRAR_UNA_NO_ID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: No se ha registrado el id " + id);
		}
	}
}
