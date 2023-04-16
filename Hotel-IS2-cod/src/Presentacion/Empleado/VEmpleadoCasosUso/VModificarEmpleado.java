package Presentacion.Empleado.VEmpleadoCasosUso;

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

import Negocio.Empleados.TEmpleados;
import Negocio.Habitaciones.THabitaciones;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VModificarEmpleado extends JFrame implements IGUI {

	Controller ctrl;
	
	private Integer id;
	private float sueldo;
	private String nombre;
	private String apellido;
	private boolean activo;
	private String correo;
	private Integer telefono;
	Integer idDepartamento;
	
	public VModificarEmpleado(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	public void initGUI() {
		setTitle("Modificar Habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(500, 250));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField sueldoText = new JTextField("1000");
		sueldoText.setPreferredSize(new Dimension(70, 25));
		JTextField nombreText = new JTextField("");
		nombreText.setPreferredSize(new Dimension(70, 25));
		JTextField apellidoText = new JTextField("");
		apellidoText.setPreferredSize(new Dimension(70, 25));
		JTextField correoText = new JTextField("");
		correoText.setPreferredSize(new Dimension(70, 25));
		
		mainPanel.add(panelId());
		mainPanel.add(panelSueldo(sueldoText));
		mainPanel.add(panelNombre(nombreText));
		mainPanel.add(panelApellido(apellidoText));
		mainPanel.add(panelActivo());
		mainPanel.add(panelCorreo(correoText));
		mainPanel.add(panelTelefono());
		mainPanel.add(panelIdDepartamento());
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(modificarButton(sueldoText,nombreText,apellidoText,correoText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);

		mainPanel.setPreferredSize(new Dimension(600,400));
		pack();
		setVisible(true);
		
	}
	//Area del ID
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
	//Area del sueldo
	public JPanel panelSueldo(JTextField sueldoText)
	{
		JPanel sueldoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel sueldoLabel = new JLabel("Sueldo: ");
		
		sueldoPanel.add(sueldoLabel);
		sueldoPanel.add(sueldoText);
		
		
		
		return sueldoPanel;
	}
	//Area del nombre
	public JPanel panelNombre(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		
		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		
		
		
		return nombrePanel;
	}
	//Area del apellido
	public JPanel panelApellido(JTextField apellidoText)
	{
	JPanel apellidoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	JLabel apellidoLabel = new JLabel("Apellido: ");
	
	apellidoPanel.add(apellidoLabel);
	apellidoPanel.add(apellidoText);
	
	return apellidoPanel;
	}
	
	public JPanel panelActivo()
	{
		JPanel tamanyoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tamanyoLabel = new JLabel("Activo: ");
		JComboBox<Boolean> tamanyoCombo = new JComboBox<Boolean>();
		
		tamanyoCombo.addItem(true);
		tamanyoCombo.addItem(false);
		
		activo = (Boolean) tamanyoCombo.getSelectedItem();
		
		tamanyoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				activo = (Boolean) tamanyoCombo.getSelectedItem();
			}
			
		});
		
		tamanyoPanel.add(tamanyoLabel);
		tamanyoPanel.add(tamanyoCombo);
		
		return tamanyoPanel;
	}
	public JPanel panelCorreo(JTextField correoText)
	{
		JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel correoLabel = new JLabel("Correo: ");
		
		correoPanel.add(correoLabel);
		correoPanel.add(correoText);
		
		
		
		return correoPanel;
	}
	
	public JPanel panelTelefono()
	{
		JPanel panelTelefono = new JPanel();
		panelTelefono .setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel telefonoLabel = new JLabel("Teléfono: ");
		JSpinner telefonoSpinner = new JSpinner(new SpinnerNumberModel(111111111,111111111,999999999,1));
		telefonoSpinner.setPreferredSize(new Dimension(100, 20));
		telefono = (Integer) telefonoSpinner.getValue();
		telefonoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				telefono = (Integer) telefonoSpinner.getValue();
			}
			
		});
		
		panelTelefono .add(telefonoLabel);
		panelTelefono .add(telefonoSpinner);
		
		return panelTelefono;
	}
	
	public JPanel panelIdDepartamento()
	{
		JPanel panelTelefono = new JPanel();
		panelTelefono .setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel telefonoLabel = new JLabel("Id Departamento: ");
		JSpinner telefonoSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		telefonoSpinner.setPreferredSize(new Dimension(100, 20));
		idDepartamento = (Integer) telefonoSpinner.getValue();
		telefonoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idDepartamento = (Integer) telefonoSpinner.getValue();
			}
			
		});
		
		panelTelefono .add(telefonoLabel);
		panelTelefono .add(telefonoSpinner);
		
		return panelTelefono;
	}
	
	public JButton modificarButton(JTextField sueldoText,JTextField nombreText,JTextField apellidoText,JTextField correoText)
	{
		JButton crearButton = new JButton("Modificar");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {

				TEmpleados tEmpleado = new TEmpleados(id, Float.parseFloat(sueldoText.getText().trim()), nombreText.getText().trim(), apellidoText.getText().trim(),activo,correoText.getText().trim(), telefono, idDepartamento);
				ctrl.carryAction(Events.EMPLEADO_MODIFICAR, tEmpleado);
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
				ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	@Override
	public void update(int event, Object datos) {
		if(event == Events.EMPLEADO_MODIFICAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Los parámetros introducidos son erróneos");
//		else if(event == Events.HABITACION_MODIFICAR_IDREPEATED) 
//			JOptionPane.showMessageDialog(this, "ERROR: La habitación con id " + (Integer)datos + "ya existe");
		else if(event == Events.EMPLEADO_MODIFICAR_NOTFOUND) 
			JOptionPane.showMessageDialog(this, "ERROR: El empleado con id " + (Integer)datos + " no se ha encontrado");
		else if(event == Events.EMPLEADO_MODIFICAR_SUCCESS) 
			JOptionPane.showMessageDialog(this, "El empleado con id " + (Integer)datos + "se ha modificado correctamente");

	}
}
