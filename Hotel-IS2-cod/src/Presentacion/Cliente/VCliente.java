package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
		JPanel mainPanel = new JPanel(new BorderLayout());
		Dimension mainDimension = new Dimension(700,300);
		setPreferredSize(mainDimension);
		setTitle("Cliente");
		setContentPane(mainPanel);
		
		
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
				ctrl.carryAction(Events.EVENT_EMPLEADO_CREAR, null);
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
				ctrl.carryAction(Events.EVENT_EMPLEADO_MODIFICAR, null);
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
				ctrl.carryAction(Events.EVENT_EMPLEADO_ELIMINAR, null);
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
				ctrl.carryAction(Events.EVENT_EMPLEADO_MOSTRAR_UNO, null);
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
				ctrl.carryAction(Events.EVENT_EMPLEADO_MOSTRAR_TODOS, null);
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

