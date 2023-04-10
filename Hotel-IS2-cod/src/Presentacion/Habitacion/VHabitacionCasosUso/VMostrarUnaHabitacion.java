package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import Negocio.Habitaciones.THabitaciones;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VMostrarUnaHabitacion  extends JFrame implements IGUI{
	
	Controller ctrl;
	
	private Integer id;
	public VMostrarUnaHabitacion(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Mostrar una habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		mainPanel.add(idPanel());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(mostrarButton());
		buttonsPanel.add(cancelButton());
		
		mainPanel.add(buttonsPanel);
		
		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
	}
	
	public JPanel idPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 100, 1));
		
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
				ctrl.carryAction(Events.HABITACION_MOSTRAR_UNA, id);
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
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.HABITACION_MOSTRAR_UNA_SI_ID)
		{
			THabitaciones auxHabitacion = (THabitaciones) datos;
		}
		else if(event == Events.HABITACION_MOSTRAR_UNA_NO_ID)
		{
			JOptionPane.showMessageDialog(this, "ERROR: No se ha registrado el id " + id);
		}
			
			
		
	}

}
