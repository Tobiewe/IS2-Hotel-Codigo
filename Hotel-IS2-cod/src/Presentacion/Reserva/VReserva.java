package Presentacion.Reserva;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VReserva extends JFrame implements IGUI {
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VReserva()
	{
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				initGUI();
			}
		});
	}
	protected void initGUI(){
		setTitle("Reserva");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(500,150);
		mainPanel.setPreferredSize(d);
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		mainPanel.add(volverButton());

		mainPanel.add(crearReservaButton(), BorderLayout.CENTER);
		mainPanel.add(modificarReservaButton(), BorderLayout.CENTER);
		mainPanel.add(eliminarReservaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarunaReservaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrartodasReservaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarporclienteReservaButton(), BorderLayout.CENTER);
		mainPanel.add(añadirhabitacionesReservaButton(), BorderLayout.CENTER);
		mainPanel.add(eliminarHabitacionesReservaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarHabitacionesReservaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarReservaHabitacionButton(), BorderLayout.CENTER);
		
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public JButton volverButton()
	{
		JButton volverButton = new JButton("Volver");
		volverButton.setSize(buttonDimension);
		volverButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.VENTANA_PRINCIPAL, null);
				setVisible(false);
			}
		});
		return volverButton;
	}
	public JButton crearReservaButton()
	{
		JButton crearReservaButton = new JButton("Abrir Reserva");
		crearReservaButton.setSize(buttonDimension);
		crearReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_CREAR_VISTA, null);
				setVisible(false);
			}
		});
		return crearReservaButton;
	}
	
	//Mostrar uno Departamento 
	public JButton modificarReservaButton()
	{
		JButton modificarReservaButton = new JButton("Modificar");
		modificarReservaButton.setSize(buttonDimension);
		modificarReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MODIFICAR_VISTA, null);
				setVisible(false);
			}
		});
		return modificarReservaButton;
	}
	public JButton eliminarReservaButton()
	{
		JButton eliminarReservaButton = new JButton("Eliminar");
		eliminarReservaButton.setSize(buttonDimension);
		eliminarReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_ELIMINAR_VISTA, null);
				setVisible(false);
			}
		});
		return eliminarReservaButton;
	}
	public JButton mostrarunaReservaButton()
	{
		JButton mostrarunaReservaButton = new JButton("Mostrar Una");
		mostrarunaReservaButton.setSize(buttonDimension);
		mostrarunaReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MOSTRAR_UNA_VISTA, null);
				setVisible(false);
			}
		});
		return mostrarunaReservaButton;
	}
	public JButton mostrartodasReservaButton()
	{
		JButton mostrartodasReservaButton = new JButton("Mostrar Todas");
		mostrartodasReservaButton.setSize(buttonDimension);
		mostrartodasReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MOSTRAR_TODAS_VISTA, null);
				setVisible(false);
			}
		});
		return mostrartodasReservaButton;
	}
	public JButton mostrarporclienteReservaButton()
	{
		JButton mostrarporclienteReservaButton = new JButton("Mostrar Reserva Cliente");
		mostrarporclienteReservaButton.setSize(buttonDimension);
		mostrarporclienteReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MOSTRAR_POR_CLIENTE_VISTA, null);
				setVisible(false);
			}
		});
		return mostrarporclienteReservaButton;
	}
	public JButton añadirhabitacionesReservaButton()
	{
		JButton annadirhabitacionesReservaButton = new JButton("Añadir Habitaciones");
		annadirhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_AÑADIR_HABITACIONES_VISTA, null);
				setVisible(false);
			}
		});
		return annadirhabitacionesReservaButton;
	}
	public JButton eliminarHabitacionesReservaButton()
	{
		JButton annadirhabitacionesReservaButton = new JButton("Quitar Habitaciones");
		annadirhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_QUITAR_HABITACIONES_VISTA, null);
				setVisible(false);
			}
		});
		return annadirhabitacionesReservaButton;
	}
	public JButton mostrarHabitacionesReservaButton()
	{
		JButton annadirhabitacionesReservaButton = new JButton("Mostrar Habitaciones por Reserva");
		annadirhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MOSTRAR_HABITACIONES_VISTA, null);
				setVisible(false);
			}
		});
		return annadirhabitacionesReservaButton;
	}
	public JButton mostrarReservaHabitacionButton()
	{
		JButton annadirhabitacionesReservaButton = new JButton("Mostrar Reservas por Habitación");
		annadirhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.RESERVA_MOSTRAR_RESERVA_VISTA, null);
				setVisible(false);
			}
		});
		return annadirhabitacionesReservaButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
