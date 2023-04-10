package Presentacion.Habitacion;

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

public class VHabitacion extends JFrame implements IGUI {
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VHabitacion()
	{
		super("Habitacion");
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
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		
		mainPanel.add(crearHabitacionButton());
		mainPanel.add(modificarHabitacionButton());
		mainPanel.add(eliminarHabitacionButton());
		mainPanel.add(mostrarUnaHabitacionButton());
		mainPanel.add(mostrarTodasHabitacionesButton());
		mainPanel.add(mostrarDisponiblesButton());
		mainPanel.add(mostrarPorEmpleadoButton());
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//Crear Departamento
			public JButton crearHabitacionButton()
			{
				JButton crearHabitacionButton = new JButton("Crear");
				crearHabitacionButton.setSize(buttonDimension);
				crearHabitacionButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_CREAR_VISTA, null);
						setVisible(false);
					}
				});
				return crearHabitacionButton;
			}
			//Modificar Departamento
			public JButton modificarHabitacionButton()
			{
				JButton modificarDepartamentoButton = new JButton("Modificar");
				modificarDepartamentoButton.setSize(buttonDimension);
				modificarDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_MODIFICAR_VISTA, null);
						setVisible(false);
					}
				});
				return modificarDepartamentoButton;
			}
			//Eliminar Departamento
			public JButton eliminarHabitacionButton()
			{
				JButton eliminarDepartamentoButton = new JButton("Eliminar");
				eliminarDepartamentoButton.setSize(buttonDimension);
				eliminarDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_ELIMINAR_VISTA, null);
						setVisible(false);
					}
				});
				return eliminarDepartamentoButton;
			}
			//Mostrar uno Departamento 
			public JButton mostrarUnaHabitacionButton()
			{
				JButton mostrarUnoDepartamentoButton = new JButton("Mostrar Uno");
				mostrarUnoDepartamentoButton.setSize(buttonDimension);
				mostrarUnoDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_MOSTRAR_UNA_VISTA, null);
						setVisible(false);
					}
				});
				return mostrarUnoDepartamentoButton;
			}
			//Mostrar todos Departamento
			public JButton mostrarTodasHabitacionesButton()
			{
				JButton mostrarTodosDepartamentoButton = new JButton("Mostrar Todas");
				mostrarTodosDepartamentoButton.setSize(buttonDimension);
				mostrarTodosDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_MOSTRAR_TODAS_VISTA , null);
						setVisible(false);
					}
				});
				return mostrarTodosDepartamentoButton;
			}
			public JButton mostrarDisponiblesButton()
			{
				JButton mostrarUnoDepartamentoButton = new JButton("Mostrar Disponibles");
				mostrarUnoDepartamentoButton.setSize(buttonDimension);
				mostrarUnoDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_MOSTRAR_DISPONIBLES_VISTA, null);
						setVisible(false);
					}
				});
				return mostrarUnoDepartamentoButton;
			}
			public JButton mostrarPorEmpleadoButton()
			{
				JButton mostrarUnoDepartamentoButton = new JButton("Mostrar Por Empleado");
				mostrarUnoDepartamentoButton.setSize(buttonDimension);
				mostrarUnoDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.HABITACION_MOSTRAR_POR_EMPLEADO_VISTA, null);
						setVisible(false);
					}
				});
				return mostrarUnoDepartamentoButton;
			}

			@Override
			public void update(int event, Object datos) {
				// TODO Auto-generated method stub
				
			}
}
