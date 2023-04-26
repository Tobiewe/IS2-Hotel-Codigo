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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Reserva.TLineaReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VAñadirHabitaciones extends JFrame implements IGUI {

	private Controller ctrl;
	private String title = "Añadir Habitaciones";
	private Integer idHabitacion;
	private Integer idReserva;

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
		mainPanel.setPreferredSize(new Dimension(300, 150));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setTitle(title);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(añadirHabitacionesButton());
		buttonPanel.add(cancelButton());

		mainPanel.add(panelIdHabitacion());
		mainPanel.add(panelIdReserva());
		mainPanel.add(buttonPanel);
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public JPanel panelIdHabitacion() {
		JPanel panelIdHabitacion = new JPanel();
		panelIdHabitacion.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idHabitacionLabel = new JLabel("Número de habitación: ");
		JSpinner idHabitacionSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idHabitacionSpinner.setPreferredSize(new Dimension(40, 20));
		idHabitacion = (Integer) idHabitacionSpinner.getValue();
		idHabitacionSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				idHabitacion = (Integer) idHabitacionSpinner.getValue();
			}

		});

		panelIdHabitacion.add(idHabitacionLabel);
		panelIdHabitacion.add(idHabitacionSpinner);

		return panelIdHabitacion;
	}
	public JPanel panelIdReserva() {
		JPanel panelIdReserva = new JPanel();
		panelIdReserva.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idReservaLabel = new JLabel("Id de la reserva: ");
		JSpinner idReservaSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idReservaSpinner.setPreferredSize(new Dimension(40, 20));
		idReserva = (Integer) idReservaSpinner.getValue();
		idReservaSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				idReserva = (Integer) idReservaSpinner.getValue();
			}

		});

		panelIdReserva.add(idReservaLabel);
		panelIdReserva.add(idReservaSpinner);

		return panelIdReserva;
	}
	
	public JButton añadirHabitacionesButton() {
		
		JButton añadirHabitacionesButton = new JButton("Añadir Habitaciones");
		añadirHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TLineaReserva tLineaReserva = new TLineaReserva(idReserva, idHabitacion);
				ctrl.carryAction(Events.RESERVA_AÑADIR_HABITACIONES, tLineaReserva);
			}
		});
		return añadirHabitacionesButton;
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
		if(event == Events.RESERVA_AÑADIR_HABITACIONES_NO_RESERVA)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha encontrado la reserva " + (Integer) datos);
		else if(event == Events.RESERVA_AÑADIR_HABITACIONES_OCUPADA)
			JOptionPane.showMessageDialog(this, "ERROR: La habitación "+ (Integer) datos + " está ocupada");
		else if(event == Events.RESERVA_AÑADIR_HABITACIONES_NO_HABITACION)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha encontrado la habitación "+ (Integer) datos );
		else if(event == Events.RESERVA_AÑADIR_HABITACIONES_SUCCESS){
			JOptionPane.showMessageDialog(this, "La habitación ha sido añadida a la reserva correctamente");
			setVisible(false);
			ctrl.carryAction(Events.RESERVA_AÑADIR_HABITACIONES_VISTA, null);
		}
		else if(event == Events.RESERVA_AÑADIR_HABITACIONES_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error en la operación");
		//Una vez añadida una habitacion, se sigue abriendo la vista de añadir habitaciones por si se desea añadir mas.
			
	}
}
