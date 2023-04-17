package Presentacion.Cliente.VClienteCasosUso;

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

import Negocio.Clientes.TCliente;
import Presentacion.Cliente.VClienteCasosUso.VMostrarClienteEmpresa.clienteTableModel;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarClienteParticular extends JFrame implements IGUI{


	private Controller ctrl;
	private String title = "Mostrar Clientes Particular";
	private clienteTableModel tableModel;
	public VMostrarClienteParticular(){
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
	
		
		tableModel = new clienteTableModel();
		mainPanel.add(tableModel.transformTableToPanel());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancelButtonPanel);
		mainPanel.add(buttonPanel);
		

		Controller.getInstance().carryAction(Events.CLIENTE_MOSTRAR_TODOS, null);

		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		
		
		
		
		
	}
	
	class clienteTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Teléfono", "Correo", "Activo"};
		List<TCliente> clientes;
		
		public clienteTableModel()
		{
			clientes =  new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			return clientes.size();
		}
		public void setList(Collection<TCliente> collection)
		{
			clientes = new ArrayList<>(collection);
			fireTableDataChanged();
		}
		public void addElement(TCliente element)
		{
			clientes.add(element);
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
				return clientes.get(rowIndex).getId();
			else if(columnIndex == 1)
				return clientes.get(rowIndex).getCorreo();
			else if(columnIndex == 2)
				return clientes.get(rowIndex).getTelefono();
			else if(columnIndex == 3)
				return clientes.get(rowIndex).getNombre();
			else if(columnIndex == 4)
				return clientes.get(rowIndex).getCIF();
			else if(columnIndex == 5)
				return clientes.get(rowIndex).getApellidos();
			else if(columnIndex == 6)
				return clientes.get(rowIndex).getNIF();
			else if(columnIndex == 7)
				return clientes.get(rowIndex).getActivo();
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
	
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.CLIENTE_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.CLIENTE_MOSTRAR_TODOS_SUCCESS)
			tableModel.setList((Collection<TCliente>) datos);
		else if(event == Events.CLIENTE_MOSTRAR_TODOS_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No hay ninguna habitación por mostrar");
	}

}


