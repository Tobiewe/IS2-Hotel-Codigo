package Presentacion.Empleado;

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
		setTitle("Empleado");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(500,150);
		mainPanel.setPreferredSize(d);
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		
		mainPanel.add(volverButton(), BorderLayout.CENTER);
		mainPanel.add(crearEmpleadoButton(), BorderLayout.CENTER);
		mainPanel.add(modificarEmpleadoButton(), BorderLayout.CENTER);
		mainPanel.add(eliminarEmpleadoButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarUnoEmpleadoButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarTodosEmpleadoButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarPorDepartamentoButton(), BorderLayout.CENTER);
		mainPanel.add(vincularTareaButton(), BorderLayout.CENTER);
		mainPanel.add(desvincularTareaButton(), BorderLayout.CENTER);
		mainPanel.add(mostrarTodoButton(),  BorderLayout.CENTER);
		
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
		public JButton crearEmpleadoButton()
		{
			JButton crearEmpleadoButton = new JButton("Crear");
			crearEmpleadoButton.setSize(buttonDimension);
			crearEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EMPLEADO_CREAR_VISTA, null);
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
					ctrl.carryAction(Events.EMPLEADO_MODIFICAR_VISTA, null);
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
					ctrl.carryAction(Events.EMPLEADO_ELIMINAR_VISTA, null);
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
					ctrl.carryAction(Events.EMPLEADO_MOSTRAR_UNO_VISTA, null);
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
					ctrl.carryAction(Events.EMPLEADO_MOSTRAR_TODOS_VISTA, null);
					setVisible(false);
				}
			});
			return mostrarTodosEmpleadoButton;
		}
		public JButton mostrarPorDepartamentoButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Mostrar por Departamento");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_VISTA, null);
					setVisible(false);
				}
			});
			return mostrarPorDepartamentoButton;
		}
		public JButton mostrarTodoButton()
		{
			JButton crearEmpleadoButton = new JButton("Mostrar Empleados y Tareas");
			crearEmpleadoButton.setSize(buttonDimension);
			crearEmpleadoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EMPLEADO_MOSTRAR_EMPYTAR_VISTA, null);
					setVisible(false);
				}
			});
			return crearEmpleadoButton;
		}
		public JButton vincularTareaButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Vincular");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EMPLEADO_VINCULAR_VISTA, null);
					setVisible(false);
				}
			});
			return mostrarPorDepartamentoButton;
		}
		
		public JButton desvincularTareaButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Desvincular");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EMPLEADO_DESVINCULAR_VISTA, null);
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
