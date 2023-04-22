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
import Negocio.Reserva.TReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarUnaReserva extends JFrame implements IGUI{


	Controller ctrl;
	private reservaTableModel reservaTableModel;
	
	private Integer id;
	public VMostrarUnaReserva(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar una reserva");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		reservaTableModel = new reservaTableModel();
		mainPanel.add(idPanel());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(mostrarButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		//Commit
		mainPanel.add(reservaTableModel.transformTableToPanel());
		
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
				ctrl.carryAction(Events.RESERVA_MOSTRAR_UNA, id);
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
			reservas =  new ArrayList<>();
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
			TitledBorder titleBorder = BorderFactory.createTitledBorder("Reserva");
			tablaPanel.setBorder(titleBorder);
			
			JScrollPane sPanel = new JScrollPane(hTable);
			tablaPanel.add(sPanel, BorderLayout.CENTER);
			return tablaPanel;
		}
		
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.RESERVA_MOSTRAR_UNA_SI_ID)
		{
			reservaTableModel.addElement((TReserva)datos);
		}
		else if(event == Events.RESERVA_MOSTRAR_UNA_NO_ID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: No se ha registrado el id " + id);
		}
	}

}
