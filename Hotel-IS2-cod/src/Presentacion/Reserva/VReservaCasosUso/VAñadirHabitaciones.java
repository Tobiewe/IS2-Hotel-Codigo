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

public class VAņadirHabitaciones extends JFrame implements IGUI {

	private Controller ctrl;
	private String title = "Aņadir Habitaciones";
	private Integer idHabitacion;
    DefaultListModel<Integer> listaHabitaciones;

	public VAņadirHabitaciones() {
		ctrl = Controller.getInstance();
		listaHabitaciones  = new DefaultListModel<>();
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
		
		JList<Integer> list = new JList<>(listaHabitaciones);
		list.setName("Habitaciones");
		JScrollPane scrollPane = new JScrollPane(list);
		mainPanel.add(scrollPane);
		
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonsPanel.add(aņadirHabitacionesButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public JPanel panelIdHabitacion() {
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idEmpleadoLabel = new JLabel("Número de habitaciķn: ");
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
		
		buttonsPanel.add(aņadirHabitacionButton());
		buttonsPanel.add(eliminarHabitacionButton());
		
		return buttonsPanel;
	}
	public JButton aņadirHabitacionButton() {
		JButton aņadirHabitacionesButton = new JButton("Aņadir");
		aņadirHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listaHabitaciones.contains(idHabitacion))
					listaHabitaciones.addElement(idHabitacion);
			}
		});
		return aņadirHabitacionesButton;
	}
	public JButton eliminarHabitacionButton() {
		JButton aņadirHabitacionesButton = new JButton("Eliminar");
		aņadirHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaHabitaciones.removeElement(idHabitacion);
			}
		});
		return aņadirHabitacionesButton;
	}
	
	public JButton aņadirHabitacionesButton() {
		
		JButton aņadirHabitacionesButton = new JButton("Aņadir Habitaciones");
		aņadirHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ctrl.carryAction(Events.RESERVA_CREAR, null);
			}
		});
		return aņadirHabitacionesButton;
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

	}
}
