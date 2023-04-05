package Presentacion.Empleado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VEmpleado extends JFrame implements IGUI{
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VEmpleado()
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
		
	}
	
	//Crear cliente
		public JButton crearEmpleadoButton()
		{
			JButton crearEmpleadoButton = new JButton("Crear");
			crearEmpleadoButton.setSize(buttonDimension);
			crearEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_CREAR, null);
					setVisible(false);
				}
			});
			return crearEmpleadoButton;
		}
		//Modificar cliente
		public JButton modificarEmpleadoButton()
		{
			JButton modificarEmpleadoButton = new JButton("Modificar");
			modificarEmpleadoButton.setSize(buttonDimension);
			modificarEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_MODIFICAR, null);
					setVisible(false);
				}
			});
			return modificarEmpleadoButton;
		}
		//Eliminar cliente
		public JButton eliminarEmpleadoButton()
		{
			JButton eliminarEmpleadoButton = new JButton("Eliminar");
			eliminarEmpleadoButton.setSize(buttonDimension);
			eliminarEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_ELIMINAR, null);
					setVisible(false);
				}
			});
			return eliminarEmpleadoButton;
		}
		//Mostrar uno 
		public JButton mostrarUnoEmpleadoButton()
		{
			JButton mostrarUnoEmpleadoButton = new JButton("Mostrar Uno");
			mostrarUnoEmpleadoButton.setSize(buttonDimension);
			mostrarUnoEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_MOSTRAR_UNO, null);
					setVisible(false);
				}
			});
			return mostrarUnoEmpleadoButton;
		}
		//Mostrar todos
		public JButton mostrarTodosEmpleadoButton()
		{
			JButton mostrarTodosEmpleadoButton = new JButton("Mostrar Todo");
			mostrarTodosEmpleadoButton.setSize(buttonDimension);
			mostrarTodosEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_MOSTRAR_TODOS, null);
					setVisible(false);
				}
			});
			return mostrarTodosEmpleadoButton;
		}
		public JButton mostrarPorDepartamentoButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Mostrar Todo");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_EMPLEADO_MOSTRAR_POR_DEPARTAMENTO, null);
					setVisible(false);
				}
			});
			return mostrarPorDepartamentoButton;
		}

	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
