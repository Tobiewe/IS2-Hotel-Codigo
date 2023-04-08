package Presentacion.Tarea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VTarea extends JFrame implements IGUI{
	
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VTarea(){
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
		public JButton crearTareaButton()
		{
			JButton crearTAREAButton = new JButton("Crear");
			crearTAREAButton.setSize(buttonDimension);
			crearTAREAButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_CREAR, null);
					setVisible(false);
				}
			});
			return crearTAREAButton;
		}
		//Modificar cliente
		public JButton modificarTAREAButton()
		{
			JButton modificarTAREAButton = new JButton("Modificar");
			modificarTAREAButton.setSize(buttonDimension);
			modificarTAREAButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MODIFICAR, null);
					setVisible(false);
				}
			});
			return modificarTAREAButton;
		}
		//Eliminar cliente
		public JButton eliminarTAREAButton()
		{
			JButton eliminarTAREAButton = new JButton("Eliminar");
			eliminarTAREAButton.setSize(buttonDimension);
			eliminarTAREAButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_ELIMINAR, null);
					setVisible(false);
				}
			});
			return eliminarTAREAButton;
		}
		//Mostrar uno 
		public JButton mostrarUnoTAREAButton()
		{
			JButton mostrarUnoTAREAButton = new JButton("Mostrar Uno");
			mostrarUnoTAREAButton.setSize(buttonDimension);
			mostrarUnoTAREAButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MOSTRAR_UNO, null);
					setVisible(false);
				}
			});
			return mostrarUnoTAREAButton;
		}
		public static final int EVENT_TAREA_DESVINCULAR = 560;
		public static final int EVENT_TAREA_VINCULAR = 570;
		//Mostrar todos
		public JButton mostrarTodosTAREAButton()
		{
			JButton mostrarTodosTAREAButton = new JButton("Mostrar Todo");
			mostrarTodosTAREAButton.setSize(buttonDimension);
			mostrarTodosTAREAButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MOSTRAR_TODOS, null);
					setVisible(false);
				}
			});
			return mostrarTodosTAREAButton;
		}
		public JButton mostrarPorDepartamentoButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Mostrar Todo");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//ctrl.carryAction(Events.EVENT_TAREA_MOSTRAR_POR_DEPARTAMENTO, null);
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