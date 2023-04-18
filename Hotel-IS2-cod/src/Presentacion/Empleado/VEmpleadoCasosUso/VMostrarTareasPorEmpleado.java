package Presentacion.Empleado.VEmpleadoCasosUso;

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
import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Empleado.VEmpleadoCasosUso.VMostrarEmpleadosPorTarea.empleadoTableModel;

public class VMostrarTareasPorEmpleado extends JFrame implements IGUI{

	Controller ctrl;
	private Integer idEmpleado;
	private tareaTableModel tableModel;
	private String title = "Mostrar tareas por empleado";
	
	public VMostrarTareasPorEmpleado(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar empleados por tarea");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new tareaTableModel();
		mainPanel.add(idTareaPanel());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(mostrarButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		//Commit
		mainPanel.add(tableModel.transformTableToPanel());
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public JPanel idTareaPanel()
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
				ctrl.carryAction(Events.EMPLEADO_MOSTRAR_POR_EMPLEADO, idEmpleado);
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
				ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	class tareaTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Descripción", "Lugar","Nombre", "Activa"};
		List<TTareas> tarea;
		
		public tareaTableModel()
		{
			tarea =  new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			return tarea.size();
		}
		public void setList(Collection<TTareas> collection)
		{
			tarea = new ArrayList<>(collection);
			fireTableDataChanged();
		}
		public void addElement(TTareas element)
		{
			tarea.add(element);
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
				return tarea.get(rowIndex).getId();
			else if(columnIndex == 1)
				return tarea.get(rowIndex).getDescripcion();
			else if(columnIndex == 2)
				return tarea.get(rowIndex).getLugar();
			else if(columnIndex == 3)
				return tarea.get(rowIndex).getNombre();
			else if(columnIndex == 4)
				return tarea.get(rowIndex).getActiva();
			return null;
		}
		public JPanel transformTableToPanel()
		{
			JPanel tablaPanel = new JPanel(new BorderLayout());
			JTable hTable = new JTable(this); 
			
			tablaPanel.add(hTable);
			TitledBorder titleBorder = BorderFactory.createTitledBorder(title);
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_ID)
		{
			tableModel.setList((Collection<TTareas>) datos);
		}
		else if(event == Events.EMPLEADO_MOSTRAR_POR_EMPLEADO_NOID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: La tarea con id " + (Integer) datos + " no tiene empleados registradas");
		}
	}

}
