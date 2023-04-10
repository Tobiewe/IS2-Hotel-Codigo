package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

public class VMostrarUnaHabitacion  extends JFrame implements IGUI{
	
	Controller ctrl;
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
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		
		
		
		setVisible(true);
	}
	
	public JPanel idPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("ID: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 100, 1));
		return idPanel;
		
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
