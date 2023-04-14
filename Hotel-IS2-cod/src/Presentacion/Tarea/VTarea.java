package Presentacion.Tarea;

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
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		
		mainPanel.add(volverButton());
		mainPanel.add(crearTareaButton());
		mainPanel.add(modificarTareaButton());
		mainPanel.add(eliminarTareaButton());
		mainPanel.add(mostrarUnoTareaButton());
		mainPanel.add(mostrarTodosTareaButton());
		mainPanel.add(vincularTareaButton());
		mainPanel.add(desvincularTareaButton());
		
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
		public JButton crearTareaButton()
		{
			JButton crearTareaButton = new JButton("Crear");
			crearTareaButton.setSize(buttonDimension);
			crearTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_CREAR_VISTA, null);
					setVisible(false);
				}
			});
			return crearTareaButton;
		}
		//Modificar cliente
		public JButton modificarTareaButton()
		{
			JButton modificarTareaButton = new JButton("Modificar");
			modificarTareaButton.setSize(buttonDimension);
			modificarTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_MODIFICAR_VISTA, null);
					setVisible(false);
				}
			});
			return modificarTareaButton;
		}
		//Eliminar cliente
		public JButton eliminarTareaButton()
		{
			JButton eliminarTareaButton = new JButton("Eliminar");
			eliminarTareaButton.setSize(buttonDimension);
			eliminarTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_ELIMINAR_VISTA, null);
					setVisible(false);
				}
			});
			return eliminarTareaButton;
		}
		//Mostrar uno 
		public JButton mostrarUnoTareaButton()
		{
			JButton mostrarUnoTareaButton = new JButton("Mostrar Una");
			mostrarUnoTareaButton.setSize(buttonDimension);
			mostrarUnoTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_MOSTRAR_UNA_VISTA, null);
					setVisible(false);
				}
			});
			return mostrarUnoTareaButton;
		}
		public JButton mostrarTodosTareaButton()
		{
			JButton mostrarTodosTareaButton = new JButton("Mostrar Todas");
			mostrarTodosTareaButton.setSize(buttonDimension);
			mostrarTodosTareaButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_MOSTRAR_TODAS_VISTA, null);
					setVisible(false);
				}
			});
			return mostrarTodosTareaButton;
		}
		public JButton vincularTareaButton()
		{
			JButton mostrarPorDepartamentoButton = new JButton("Vincular");
			mostrarPorDepartamentoButton.setSize(buttonDimension);
			mostrarPorDepartamentoButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ctrl.carryAction(Events.TAREA_VINCULAR_VISTA, null);
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
					ctrl.carryAction(Events.TAREA_DESVINCULAR_VISTA, null);
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