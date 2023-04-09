package Presentacion.Habitacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VHabitacion extends JFrame implements IGUI {
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VHabitacion()
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
	
	//Crear Departamento
			public JButton crearHabitacionButton()
			{
				JButton crearHabitacionButton = new JButton("Crear");
				crearHabitacionButton.setSize(buttonDimension);
				crearHabitacionButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_CREAR, null);
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
						ctrl.carryAction(Events.DEPARTAMENTO_MODIFICAR, null);
						setVisible(false);
					}
				});
				return modificarDepartamentoButton;
			}
			//Eliminar Departamento
			public JButton eliminarDepartamentoButton()
			{
				JButton eliminarDepartamentoButton = new JButton("Eliminar");
				eliminarDepartamentoButton.setSize(buttonDimension);
				eliminarDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_ELIMINAR, null);
						setVisible(false);
					}
				});
				return eliminarDepartamentoButton;
			}
			//Mostrar uno Departamento 
			public JButton mostrarUnoDepartamentoButton()
			{
				JButton mostrarUnoDepartamentoButton = new JButton("Mostrar Uno");
				mostrarUnoDepartamentoButton.setSize(buttonDimension);
				mostrarUnoDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_MOSTRAR_UNO, null);
						setVisible(false);
					}
				});
				return mostrarUnoDepartamentoButton;
			}
			//Mostrar todos Departamento
			public JButton mostrarTodosDepartamentoButton()
			{
				JButton mostrarTodosDepartamentoButton = new JButton("Mostrar Todo");
				mostrarTodosDepartamentoButton.setSize(buttonDimension);
				mostrarTodosDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_MOSTRAR_TODOS, null);
						setVisible(false);
					}
				});
				return mostrarTodosDepartamentoButton;
			}

			@Override
			public void update(int event, Object datos) {
				// TODO Auto-generated method stub
				
			}
}
