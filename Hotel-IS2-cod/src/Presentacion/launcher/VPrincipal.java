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
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
		
		mainPanel.add(reservaButton());
		mainPanel.add(habitacionButton());
		mainPanel.add(tareaButton());
		mainPanel.add(clienteButton());
		mainPanel.add(departamentoButton());
		mainPanel.add(empleadoButton());
		
		pack();
		setVisible(true);
	}
	
	public JButton reservaButton()
	{
		JButton reservaButton = new JButton("Reservar");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	public JButton habitacionButton()
	{
		JButton reservaButton = new JButton("Habitacion");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	
	public JButton clienteButton()
	{
		JButton reservaButton = new JButton("Cliente");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.CLIENTE_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	public JButton empleadoButton()
	{
		JButton reservaButton = new JButton("Empleado");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	
	public JButton tareaButton()
	{
		JButton reservaButton = new JButton("Tarea");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	public JButton departamentoButton()
	{
		JButton reservaButton = new JButton("Departamento");
		reservaButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
			}
			
		});
		return reservaButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
