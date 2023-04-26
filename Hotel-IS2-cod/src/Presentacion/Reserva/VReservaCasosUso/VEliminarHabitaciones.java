package Presentacion.Reserva.VReservaCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Negocio.Reserva.TLineaReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VEliminarHabitaciones extends JFrame implements IGUI {
	private Controller ctrl;
	private String title = "Quitar Habitaciones";
	private Integer idHabitacion;
	private Integer idReserva;

	public VEliminarHabitaciones() {
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
		
		buttonPanel.add(eliminarHabitacionesButton());
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
	
	public JButton eliminarHabitacionesButton() {
		
		JButton eliminarHabitacionesButton = new JButton("Quitar Habitaciones");
		eliminarHabitacionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TLineaReserva tLineaReserva = new TLineaReserva(idReserva, idHabitacion);
				ctrl.carryAction(Events.RESERVA_QUITAR_HABITACIONES,tLineaReserva);
			}
		});
		return eliminarHabitacionesButton;
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
		else if(event == Events.RESERVA_AÑADIR_HABITACIONES_NO_HABITACION)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha encontrado la habitación "+ (Integer) datos );
		else if(event == Events.RESERVA_QUITAR_HABITACIONES_SUCCESS){
			JOptionPane.showMessageDialog(this, "La habitación ha sido eliminada de la reserva con éxito");
			setVisible(false);
			ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
		}
		
	}
}
