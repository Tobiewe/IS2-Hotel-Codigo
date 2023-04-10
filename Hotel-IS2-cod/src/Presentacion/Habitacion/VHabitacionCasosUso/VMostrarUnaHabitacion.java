package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
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
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		
		
		
		setVisible(true);
	}
	
	public JPanel idPanel()
	{
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("ID: ");
		
		JSpinner idSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 100, 1));
		
		idPanel.add(idLabel);
		idPanel.add(idSpinner);
		return idPanel;
		
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.HABITACION_MOSTRAR_UNA_SI_ID)
		{
			
		}
		else
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido encontrar el id " id);
			
		
	}

}
