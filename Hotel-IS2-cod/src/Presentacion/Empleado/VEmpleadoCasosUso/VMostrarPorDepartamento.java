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
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Empleado.VEmpleadoCasosUso.VLeerTodosEmpleado.empleadoTableModel;

public class VMostrarPorDepartamento extends JFrame implements IGUI {

	Controller ctrl;
	private empleadoTableModel tableModel;
	
	private Integer idDepartamento;
	public VMostrarPorDepartamento(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar empleados por empleado");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		tableModel = new empleadoTableModel();
		mainPanel.add(idEmpleadoPanel());
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
	
	public JPanel idEmpleadoPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id del departamento: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idDepartamento = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idDepartamento = (Integer) idSpinner.getValue();
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
				ctrl.carryAction(Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO, idDepartamento);
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
	class empleadoTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Sueldo", "Nombre", "Apellidos","Activo", "Correo","Tel�fono", "Id Departamento"};
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
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Empleados por Departamento");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_ID)
		{
			tableModel.setList((Collection<TEmpleados>) datos);
		}
		else if(event == Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_NOID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: El empleado con id "+ (Integer) idDepartamento + " no tiene empleado registradas");
		}
	}

}
