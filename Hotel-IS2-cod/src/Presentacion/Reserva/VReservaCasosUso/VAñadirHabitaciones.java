package Presentacion.Reserva.VReservaCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VAñadirHabitaciones extends JFrame implements IGUI {

	private Controller ctrl;
	private String title = "Añadir Habitaciones";
	private Integer idHabitacion;
	private Integer[] listaHabitaciones;

	public VAñadirHabitaciones() {
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
		
		mainPanel.add(panelIdHabitacion());
		
		mainPanel.add(buttonsFirstPanel());
		
		JList<Integer> list = new JList<>();
		JScrollPane scrollPane = new JScrollPane(list);
		mainPanel.add(scrollPane);
		
		mainPanel.add(cerrarReservaButton());

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

//	public JScrollPane habitacionesListPanel() {
//		
//		return scrollPane;
//
//	}


	public JPanel panelIdHabitacion() {
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idEmpleadoLabel = new JLabel("Número de habitación: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 20));
		idHabitacion = (Integer) idEmpleadoSpinner.getValue();
		idEmpleadoSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				idHabitacion = (Integer) idEmpleadoSpinner.getValue();
			}

		});

		panelIdEmpleado.add(idEmpleadoLabel);
		panelIdEmpleado.add(idEmpleadoSpinner);

		return panelIdEmpleado;
	}
	public JPanel buttonsFirstPanel()
	{
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonsPanel.add(añadirHabitacionButton());
		buttonsPanel.add(eliminarHabitacionButton());
		
		return buttonsPanel;
	}
	public JButton añadirHabitacionButton() {
		JButton cerrarReservaButton = new JButton("Añadir");
		cerrarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return cerrarReservaButton;
	}
	public JButton eliminarHabitacionButton() {
		JButton cerrarReservaButton = new JButton("Eliminar");
		cerrarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_CERRAR, null);
			}
		});
		return cerrarReservaButton;
	}
	
	public JButton cerrarReservaButton() {
		JButton cerrarReservaButton = new JButton("Cerrar");
		cerrarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_CERRAR, null);
			}
		});
		return cerrarReservaButton;
	}
	@Override
	public void update(int event, Object datos) {

	}
}
