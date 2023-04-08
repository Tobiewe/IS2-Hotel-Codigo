package Presentacion.Reserva;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		
	}
	public JButton abrirReservaButton()
	{
		JButton crearReservaButton = new JButton("Abrir Reserva");
		crearReservaButton.setSize(buttonDimension);
		crearReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.EVENT_RESERVA_ABRIR, null);
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
				ctrl.carryAction(Events.EVENT_RESERVA_MODIFICAR, null);
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
				ctrl.carryAction(Events.EVENT_RESERVA_ELIMINAR, null);
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
				ctrl.carryAction(Events.EVENT_RESERVA_MOSTRAR_UNA, null);
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
				ctrl.carryAction(Events.EVENT_RESERVA_MOSTRAR_TODAS, null);
				setVisible(false);
			}
		});
		return mostrartodasReservaButton;
	}
	public JButton cerrarReservaButton()
	{
		JButton cerrarReservaButton = new JButton("Cerrar Reserva");
		cerrarReservaButton.setSize(buttonDimension);
		cerrarReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.EVENT_RESERVA_CERRAR, null);
				setVisible(false);
			}
		});
		return cerrarReservaButton;
	}
	public JButton quitarhabitacionesReservaButton()
	{
		JButton quitarhabitacionesReservaButton = new JButton("Eliminar Habitaciones");
		quitarhabitacionesReservaButton.setSize(buttonDimension);
		quitarhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.EVENT_RESERVA_QUITAR_HABITACIONES, null);
				setVisible(false);
			}
		});
		return quitarhabitacionesReservaButton;
	}
	public JButton annadirhabitacionesReservaButton()
	{
		JButton annadirhabitacionesReservaButton = new JButton("Annadir Habitaciones");
		annadirhabitacionesReservaButton.setSize(buttonDimension);
		annadirhabitacionesReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.EVENT_RESERVA_AÑADIR_HABITACIONES, null);
				setVisible(false);
			}
		});
		return annadirhabitacionesReservaButton;
	}
	public JButton mostrarporclienteReservaButton()
	{
		JButton mostrarporclienteReservaButton = new JButton("Mostrar Reserva Cliente");
		mostrarporclienteReservaButton.setSize(buttonDimension);
		mostrarporclienteReservaButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.EVENT_RESERVA_MOSTRAR_POR_CLIENTE, null);
				setVisible(false);
			}
		});
		return mostrarporclienteReservaButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}

}
