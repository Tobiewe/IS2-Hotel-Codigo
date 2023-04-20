package Presentacion.Tarea.VTareaCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Habitaciones.THabitaciones;
import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VCrearTarea extends JFrame implements IGUI {

	private Controller ctrl;
	
	
	public VCrearTarea(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}

	public void initGUI() 
	{
		setTitle("Crear Tarea");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setPreferredSize(new Dimension(400, 200));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField descripcionText = new JTextField("");
		JTextField lugarText = new JTextField("");
		JTextField nombreText = new JTextField("");

		descripcionText.setPreferredSize(new Dimension(150, 20));
		lugarText.setPreferredSize(new Dimension(150, 20));
		nombreText.setPreferredSize(new Dimension(150, 20));

		
		mainPanel.add(panelDescripcion(descripcionText));
		mainPanel.add(panelLugar(lugarText));
		mainPanel.add(panelNombre(nombreText));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(crearButton(descripcionText, lugarText, nombreText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public JPanel panelDescripcion(JTextField descripcionText)
	{
		JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel descripcionLabel = new JLabel("Descripción: ");
		
		descripcionPanel.add(descripcionLabel);
		descripcionPanel.add(descripcionText);
		
		
		
		return descripcionPanel;
	}
	public JPanel panelLugar(JTextField lugarText)
	{
		JPanel lugarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lugarLabel = new JLabel("Lugar: ");
		
		lugarPanel.add(lugarLabel);
		lugarPanel.add(lugarText);
		
		return lugarPanel;
	}
	public JPanel panelNombre(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");

		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		
		return nombrePanel;
	}

	public JButton crearButton(JTextField descripcionText,JTextField lugarText,JTextField nombreText)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				TTareas tTarea = new TTareas(null,descripcionText.getText(),lugarText.getText(),nombreText.getText(),true);
				ctrl.carryAction(Events.TAREA_CREAR, tTarea);
			}
			
			
		});
		return crearButton;
	}
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.TAREA_CREAR_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear la Tarea");
		else if(event == Events.TAREA_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Parámetros introducidos incorrectos");
		else if(event == Events.TAREA_CREAR_SUCCESS)
		{
			JOptionPane.showMessageDialog(this, "La tarea se ha creado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
		}
	}
}
