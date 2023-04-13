package Presentacion.Departamento;

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

public class VDepartamento extends JFrame implements IGUI{
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VDepartamento()
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
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());
		
		mainPanel.add(volverButton());
		mainPanel.add(crearDepartamentoButton());
		mainPanel.add(modificarDepartamentoButton());
		mainPanel.add(eliminarDepartamentoButton());
		mainPanel.add(mostrarUnoDepartamentoButton());
		mainPanel.add(mostrarTodosDepartamentoButton());
		
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
	//Crear Departamento
			public JButton crearDepartamentoButton()
			{
				JButton crearDepartamentoButton = new JButton("Crear");
				crearDepartamentoButton.setSize(buttonDimension);
				crearDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_CREAR_VISTA, null);
						setVisible(false);
					}
				});
				return crearDepartamentoButton;
			}
			//Modificar Departamento
			public JButton modificarDepartamentoButton()
			{
				JButton modificarDepartamentoButton = new JButton("Modificar");
				modificarDepartamentoButton.setSize(buttonDimension);
				modificarDepartamentoButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ctrl.carryAction(Events.DEPARTAMENTO_MODIFICAR_VISTA, null);
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
						ctrl.carryAction(Events.DEPARTAMENTO_ELIMINAR_VISTA, null);
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
						ctrl.carryAction(Events.DEPARTAMENTO_MOSTRAR_UNO_VISTA, null);
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
						ctrl.carryAction(Events.DEPARTAMENTO_MOSTRAR_TODOS_VISTA, null);
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
