package Presentacion.launcher;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

import Presentacion.Controller.Events;

public class VPrincipal extends JFrame implements IGUI{

	
	private Controller ctrl;
	
	public VPrincipal()
	{
		ctrl = Controller.getInstance();
		initGUI();	
	}
	
	public void initGUI()
	{
		setTitle("UHotel");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(600,400);
		mainPanel.setPreferredSize(d);
		setContentPane(mainPanel);
		
		mainPanel.add(reservaButton());
		
		pack();
		setVisible(true);
	}
	
	public JButton  reservaButton()
	{
		JButton reservaButton = new JButton("Reservar");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
