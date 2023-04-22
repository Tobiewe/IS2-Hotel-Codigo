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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import Negocio.Reserva.TReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarTodasReserva extends JFrame implements IGUI {
	private Controller ctrl;
	private String title = "Mostrar todas las reserva";
	private reservaTableModel reservaTableModel;
	public VMostrarTodasReserva(){
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
		
		reservaTableModel = new reservaTableModel();
		mainPanel.add(reservaTableModel.transformTableToPanel());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancelButtonPanel);
		mainPanel.add(buttonPanel);
		
		
		Controller.getInstance().carryAction(Events.RESERVA_MOSTRAR_TODAS, null);

		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		
	}
	class reservaTableModel extends AbstractTableModel
	{
		String[] columnValues = {"Id", "Total", "Fecha de entrada", "Nombre","Cliente Id", "Noches", "Activa"};
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
	@Override
	public void update(int event, Object datos) {
		if(event == Events.RESERVA_MOSTRAR_TODAS_SUCCESS)
			reservaTableModel.setList((Collection<TReserva>) datos);
		else if(event == Events.RESERVA_MOSTRAR_TODAS_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No hay ninguna habitación por mostrar");
	}

}
