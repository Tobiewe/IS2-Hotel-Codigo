package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.Controller.Events;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
public class VCliente extends JFrame implements IGUI {
	
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VCliente()
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

	protected void initGUI() {
		setTitle("Cliente");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		
		mainPanel.add(volverButton());
		mainPanel.add(crearClienteButton());
		mainPanel.add(modificarClienteButton());
		mainPanel.add(eliminarClienteButton());
		mainPanel.add(mostrarUnoClienteButton());
		mainPanel.add(mostrarTodosClienteButton());
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
	//Crear cliente
	public JButton crearClienteButton()
	{
		JButton crearClienteButton = new JButton("Crear");
		crearClienteButton.setSize(buttonDimension);
		crearClienteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.CLIENTE_CREAR_VISTA, null);
				setVisible(false);
			}
		});
		return crearClienteButton;
	}
	//Modificar cliente
	public JButton modificarClienteButton()
	{
		JButton modificarClienteButton = new JButton("Modificar");
		modificarClienteButton.setSize(buttonDimension);
		modificarClienteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.CLIENTE_MODIFICAR_VISTA, null);
				setVisible(false);
			}
		});
		return modificarClienteButton;
	}
	//Eliminar cliente
	public JButton eliminarClienteButton()
	{
		JButton eliminarClienteButton = new JButton("Eliminar");
		eliminarClienteButton.setSize(buttonDimension);
		eliminarClienteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.CLIENTE_ELIMINAR_VISTA, null);
				setVisible(false);
			}
		});
		return eliminarClienteButton;
	}
	//Mostrar uno 
	public JButton mostrarUnoClienteButton()
	{
		JButton mostrarUnoClienteButton = new JButton("Mostrar Uno");
		mostrarUnoClienteButton.setSize(buttonDimension);
		mostrarUnoClienteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.CLIENTE_MOSTRAR_UNO_VISTA, null);
				setVisible(false);
			}
		});
		return mostrarUnoClienteButton;
	}
	//Mostrar todos
	public JButton mostrarTodosClienteButton()
	{
		JButton mostrarTodosClienteButton = new JButton("Mostrar Todo");
		mostrarTodosClienteButton.setSize(buttonDimension);
		mostrarTodosClienteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctrl.carryAction(Events.CLIENTE_MOSTRAR_TODOS_VISTA, null);
				setVisible(false);
			}
		});
		return mostrarTodosClienteButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}

