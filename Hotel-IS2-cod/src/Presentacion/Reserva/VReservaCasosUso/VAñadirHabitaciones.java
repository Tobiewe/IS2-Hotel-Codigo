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

import Negocio.Reserva.TLineaReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VAņadirHabitaciones extends JFrame implements IGUI {

	private Controller ctrl;
	private String title = "Aņadir Habitaciones";
	private Integer idHabitacion;
	private Integer idReserva;

	public VAņadirHabitaciones() {
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
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(aņadirHabitacionesButton());
		buttonPanel.add(cancelButton());

		mainPanel.add(panelIdHabitacion());
		mainPanel.add(panelIdReserva());
		mainPanel.add(buttonPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public JPanel panelIdHabitacion() {
		JPanel panelIdHabitacion = new JPanel();
		panelIdHabitacion.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idHabitacionLabel = new JLabel("Número de habitaciķn: ");
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
	
	public JButton aņadirHabitacionesButton() {
		
		JButton aņadirHabitacionesButton = new JButton("Aņadir Habitaciones");
		aņadirHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TLineaReserva tLineaReserva = new TLineaReserva(idHabitacion,idReserva,null,true);
				ctrl.carryAction(Events.RESERVA_AŅADIR_HABITACIONES, tLineaReserva);
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
