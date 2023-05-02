package Presentacion.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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
		Dimension d = new Dimension(700,150);
		mainPanel.setPreferredSize(d);
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
		
		mainPanel.add(BotonReserva(), BorderLayout.CENTER);
		mainPanel.add(habitacionButton(), BorderLayout.CENTER);
		mainPanel.add(tareaButton(), BorderLayout.CENTER);
		mainPanel.add(clienteButton(), BorderLayout.CENTER);
		mainPanel.add(departamentoButton(), BorderLayout.CENTER);
		mainPanel.add(empleadoButton(), BorderLayout.CENTER);
		
		
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 350,Toolkit.getDefaultToolkit().getScreenSize().height/2 - 100);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public JButton BotonReserva()
	{
		JButton Botongeneral = new JButton("Reservar");
		Botongeneral.setPreferredSize(new Dimension(100, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	public JButton habitacionButton()
	{
		JButton Botongeneral = new JButton("Habitacion");
		Botongeneral.setPreferredSize(new Dimension(100, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	
	public JButton clienteButton()
	{
		JButton Botongeneral = new JButton("Cliente");
		Botongeneral.setPreferredSize(new Dimension(100, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.CLIENTE_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	public JButton empleadoButton()
	{
		JButton Botongeneral = new JButton("Empleado");
		Botongeneral.setPreferredSize(new Dimension(100, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	
	public JButton tareaButton()
	{
		JButton Botongeneral = new JButton("Tarea");
		Botongeneral.setPreferredSize(new Dimension(100, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	public JButton departamentoButton()
	{
		JButton Botongeneral = new JButton("Departamento");
		Botongeneral.setPreferredSize(new Dimension(150, 50));
		Botongeneral.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
				setVisible(false);
			}
			
		});
		return Botongeneral;
	}
	
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
