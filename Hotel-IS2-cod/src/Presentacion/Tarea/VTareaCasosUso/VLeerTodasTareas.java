package Presentacion.Tarea.VTareaCasosUso;

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

import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VLeerTodasTareas extends JFrame implements IGUI {
	private Controller ctrl;
	private String title = "Tareas";
	private tareaTableModel tableModel;
	
	public VLeerTodasTareas(){
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
		
		tableModel = new tareaTableModel();
		mainPanel.add(tableModel.transformTableToPanel());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancelButtonPanel);
		mainPanel.add(buttonPanel);
		
		
		Controller.getInstance().carryAction(Events.TAREA_MOSTRAR_TODOS, null);

		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		
	}
	class tareaTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Descripción", "Lugar","Nombre","Id del empleado","Activa"};
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
				return tarea.get(rowIndex).getId_empleado();
			else if(columnIndex == 5)
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
		
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.TAREA_MOSTRAR_TODAS_SUCCESS)
			tableModel.setList((Collection<TTareas>) datos);
		else if(event == Events.TAREA_MOSTRAR_TODAS_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No hay ningúna tarea por mostrar");
	}

}
