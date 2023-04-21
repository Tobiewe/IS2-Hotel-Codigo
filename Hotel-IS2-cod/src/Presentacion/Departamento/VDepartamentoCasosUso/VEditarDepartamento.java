package Presentacion.Departamento.VDepartamentoCasosUso;

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

import Negocio.Departamentos.TDepartamento;
import Negocio.Habitaciones.THabitaciones;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VEditarDepartamento extends JFrame implements IGUI {

	Controller ctrl;
	private String nombre;
	private Integer id;
	private boolean activado;
	
	public VEditarDepartamento(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Modificar Departamento");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setPreferredSize(new Dimension(400, 200));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField nombreText = new JTextField("");
		nombreText.setPreferredSize(new Dimension(200,20));
		
		mainPanel.add(panelId());
		mainPanel.add(nombrePanel(nombreText));
		mainPanel.add(panelActivado());
		
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(modificarButton(nombreText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);

		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public JPanel panelId()
	{
		JPanel panelId = new JPanel();
		panelId.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idLabel = new JLabel("Id: ");
		JSpinner idSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idSpinner.setPreferredSize(new Dimension(40, 20));
		id = (Integer) idSpinner.getValue();
		idSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				id = (Integer) idSpinner.getValue();
			}
			
		});
		
		panelId.add(idLabel);
		panelId.add(idSpinner);
		
		return panelId;
	}
	public JPanel panelActivado()
	{
		JPanel panelActivado = new JPanel();
		panelActivado.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel activadoLabel = new JLabel("Activado: ");
		JComboBox<Boolean> activadoCombo = new JComboBox<Boolean>();
		
		activadoCombo.addItem(true);
		activadoCombo.addItem(false);
		
		activado = (boolean) activadoCombo.getSelectedItem();
		
		activadoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				activado = (boolean) activadoCombo.getSelectedItem();
			}
			
		});		
		panelActivado.add(activadoLabel);
		panelActivado.add(activadoCombo);
		
		return panelActivado;
	}
	
	public JPanel nombrePanel(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		
		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		return nombrePanel;
	}
	
	public JButton modificarButton(JTextField nombreText)
	{
		JButton crearButton = new JButton("Modificar");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				TDepartamento tDepartamento = new TDepartamento(id,(String)nombreText.getText(),activado);
				ctrl.carryAction(Events.DEPARTAMENTO_MODIFICAR, tDepartamento);
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
				ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.DEPARTAMENTO_MODIFICAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Los parámetros introducidos son erróneos");
//		else if(event == Events.HABITACION_MODIFICAR_IDREPEATED) 
//			JOptionPane.showMessageDialog(this, "ERROR: El departamento con id " + (Integer)datos + "ya existe");
		else if(event == Events.DEPARTAMENTO_MODIFICAR_NOTFOUND) 
			JOptionPane.showMessageDialog(this, "ERROR: El departamento con id " + (Integer)datos + " no se ha encontrado");
		else if(event == Events.DEPARTAMENTO_MODIFICAR_SUCCESS) {
			JOptionPane.showMessageDialog(this, "El departamento con id " + (Integer)datos + " se ha modificado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
		}

	}
}
