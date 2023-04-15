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
import Presentacion.Habitacion.VHabitacionCasosUso.VMostrarUnaHabitacion.habitacionesTableModel;

public class VMostrarPorEmpleado extends JFrame implements IGUI{


	Controller ctrl;
	private habitacionesTableModel tableModel;
	
	private Integer idEmpleado;
	public VMostrarPorEmpleado(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar por empleado");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new habitacionesTableModel();
		mainPanel.add(idEmpleadoPanel());
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
	
	public JPanel idEmpleadoPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id del empleado: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idEmpleado = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idEmpleado = (Integer) idSpinner.getValue();
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
				ctrl.carryAction(Events.HABITACION_MOSTRAR_POR_EMPLEADO, idEmpleado);
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
		String[] columnValues = {"Id", "Piso", "Tamaño", "Precio","Ocupada", "Empleado Id"};
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
				return habitaciones.get(rowIndex).getOcupada();
			else if(columnIndex == 5)
				return habitaciones.get(rowIndex).getId_empledo();
			return null;
		}
		public JPanel transformTableToPanel()
		{
			JPanel tablaPanel = new JPanel(new BorderLayout());
			JTable hTable = new JTable(this); 
			
			tablaPanel.add(hTable);
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Habitaciones por empleado");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.HABITACION_MOSTRAR_POR_EMPLEADO_ID)
		{
			tableModel.setList((Collection<THabitaciones>)datos);
		}
		else if(event == Events.HABITACION_MOSTRAR_POR_EMPLEADO_NOID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: El empleado con id "+ (Integer) idEmpleado + " no tiene habitaciones registradas");
		}
	}
	
}
