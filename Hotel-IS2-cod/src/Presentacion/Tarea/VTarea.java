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
		
		public VTarea()
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
		public JButton crearTareaButton()
		{
			JButton crearTareaButton = new JButton("Crear");
			crearTareaButton.setSize(buttonDimension);
			crearTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_CREAR, null);
					setVisible(false);
				}
			});
			return crearTareaButton;
		}
		public JButton modificarTareaButton()
		{
			JButton modificarTareaButton = new JButton("Modificar");
			modificarTareaButton.setSize(buttonDimension);
			modificarTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MODIFICAR, null);
					setVisible(false);
				}
			});
			return modificarTareaButton;
		}
		public JButton eliminarTareaButton()
		{
			JButton eliminarTareaButton = new JButton("Eliminar");
			eliminarTareaButton.setSize(buttonDimension);
			eliminarTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_ELIMINAR, null);
					setVisible(false);
				}
			});
			return eliminarTareaButton;
		}
		public JButton mostrarunoTareaButton()
		{
			JButton mostrarunoTareaButton = new JButton("Mostrar Uno");
			mostrarunoTareaButton.setSize(buttonDimension);
			mostrarunoTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MOSTRAR_UNO, null);
					setVisible(false);
				}
			});
			return mostrarunoTareaButton;
		}
		public JButton mostrartodosTareaButton()
		{
			JButton mostrartodosTareaButton = new JButton("Mostrar Todos");
			mostrartodosTareaButton.setSize(buttonDimension);
			mostrartodosTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_MOSTRAR_TODOS, null);
					setVisible(false);
				}
			});
			return mostrartodosTareaButton;
		}
		public JButton vincularTareaButton()
		{
			JButton vincularTareaButton = new JButton("Vincular");
			vincularTareaButton.setSize(buttonDimension);
			vincularTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_VINCULAR, null);
					setVisible(false);
				}
			});
			return vincularTareaButton;
		}
		public JButton desvincularTareaButton()
		{
			JButton desvincularTareaButton = new JButton("Desvincular");
			desvincularTareaButton.setSize(buttonDimension);
			desvincularTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.EVENT_TAREA_DESVINCULAR, null);
					setVisible(false);
				}
			});
			return desvincularTareaButton;
		}
		@Override
		public void update(int event, Object datos) {
			// TODO Auto-generated method stub
			
		}

}


