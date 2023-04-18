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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import Negocio.Empleados.TEmpleados;
import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarTareasYEmpleados extends JFrame implements IGUI{

	private Controller ctrl;
	private String title = "Mostrar Tareas y Empleados";
	private tareaTableModel tareaTableModel;
	private empleadoTableModel empleadoTableModel;
	
	public VMostrarTareasYEmpleados(){
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
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setTitle(title);
		
		
		JPanel cancelButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cancelButtonPanel.add(cancelButton());
		
		tareaTableModel = new tareaTableModel();
		mainPanel.add(tareaTableModel.transformTableToPanel());
		empleadoTableModel = new empleadoTableModel();
		mainPanel.add(empleadoTableModel.transformTableToPanel());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancelButtonPanel);
		mainPanel.add(buttonPanel);
		
		
		Controller.getInstance().carryAction(Events.EMPLEADO_MOSTRAR_EMPYTAR, null);

		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		
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
	class empleadoTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Sueldo", "Nombre", "Apellidos","Activo", "Correo","Teléfono", "Id Departamento"};
		List<TEmpleados> empleados;
		
		public empleadoTableModel()
		{
			empleados =  new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			return empleados.size();
		}
		public void setList(Collection<TEmpleados> collection)
		{
			empleados = new ArrayList<>(collection);
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
				return empleados.get(rowIndex).getId();
			else if(columnIndex == 1)
				return empleados.get(rowIndex).getSueldo();
			else if(columnIndex == 2)
				return empleados.get(rowIndex).getNombre();
			else if(columnIndex == 3)
				return empleados.get(rowIndex).getApellidos();
			else if(columnIndex == 4)
				return empleados.get(rowIndex).getActivo();
			else if(columnIndex == 5)
				return empleados.get(rowIndex).getCorreo();
			else if(columnIndex == 6)
				return empleados.get(rowIndex).getTelefono();
			else if(columnIndex == 7)
				return empleados.get(rowIndex).getId_Departamento();
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
	@Override
	public void update(int event, Object datos) {
		if(event == Events.TAREA_MOSTRAR_TODAS_SUCCESS)
			empleadoTableModel.setList((Collection<TEmpleados>) datos);
			tareaTableModel.setList((Collection<TTareas>) datos);
		else if(event == Events.TAREA_MOSTRAR_TODAS_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No hay tareas ni empleados en la base de datos");
	}


}
