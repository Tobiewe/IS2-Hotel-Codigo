package Presentacion.Empleado.VEmpleadoCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Negocio.Clientes.TCliente;
import Negocio.Empleados.TEmpleados;
import Negocio.Habitaciones.THabitaciones;

import javax.swing.UIManager;
import java.awt.FlowLayout;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;;

public class VCrearEmpleado extends JFrame implements IGUI {
private Controller ctrl;
	
	private Integer telefono;
	private Integer sueldo;
	private String correo;
	private String nombre;
	private String apellido;
	private Integer idDepartamento;
	
	
	public VCrearEmpleado(){
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
		setTitle("Crear Empleado");
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 300));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		//Text Feilds
		JTextField sueldoText = new JTextField("1000");
		JTextField nombreText = new JTextField("");
		JTextField apellidoText = new JTextField("");
		JTextField correoText = new JTextField("");
		
		sueldoText.setPreferredSize(new Dimension(150, 20));
		correoText.setPreferredSize(new Dimension(150, 20));
		apellidoText.setPreferredSize(new Dimension(150, 20));
		nombreText.setPreferredSize(new Dimension(150, 20));
		
		
		mainPanel.add(panelSueldo(sueldoText));
		mainPanel.add(panelNombre(nombreText));
		mainPanel.add(panelApellido(apellidoText));
		mainPanel.add(panelCorreo(correoText));
		mainPanel.add(panelTelefono());
		mainPanel.add(panelIdDepartamento());
		
	
		
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonPanel.add(crearButton(sueldoText,nombreText,apellidoText,correoText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public JPanel panelSueldo(JTextField sueldoText)
	{
		JPanel sueldoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel sueldoLabel = new JLabel("Sueldo: ");
		
		sueldoPanel.add(sueldoLabel);
		sueldoPanel.add(sueldoText);
		
		return sueldoPanel;
	}
	public JPanel panelNombre(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		
		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		
		
		
		return nombrePanel;
	}
	public JPanel panelApellido(JTextField apellidoText)
	{
		JPanel apellidoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		
		apellidoPanel.add(apellidoLabel);
		apellidoPanel.add(apellidoText);
		
		
		
		return apellidoPanel;
	}
	public JPanel panelTelefono()
	{
		JPanel panelTelefono = new JPanel();
		panelTelefono.setLayout(new FlowLayout(FlowLayout.CENTER));
		
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
		
		panelTelefono.add(telefonoLabel);
		panelTelefono.add(telefonoSpinner);
		
		return panelTelefono;
	}
	
	public JPanel panelCorreo(JTextField correoText)
	{
		JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel correoLabel = new JLabel("Correo: ");
		
		correoPanel.add(correoLabel);
		correoPanel.add(correoText);
		
		
		
		return correoPanel;
	}
	
	public JPanel panelIdDepartamento()
	{
		JPanel panelIdDepartamento= new JPanel();
		panelIdDepartamento.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idDepartamentoLabel = new JLabel("Id del departamento: ");
		JSpinner idDepartamentoSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idDepartamentoSpinner.setPreferredSize(new Dimension(100, 20));
		idDepartamento = (Integer) idDepartamentoSpinner.getValue();
		idDepartamentoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idDepartamento = (Integer) idDepartamentoSpinner.getValue();
			}
			
		});
		
		panelIdDepartamento.add(idDepartamentoLabel);
		panelIdDepartamento.add(idDepartamentoSpinner);
		
		return panelIdDepartamento;
	}


	public JButton crearButton(JTextField sueldoText, JTextField nombreText,JTextField apellidoText, JTextField correoText)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener()
		{


			@Override
			public void actionPerformed(ActionEvent e) {
				TEmpleados tEmpleado = null;
				System.out.println(sueldoText.getText());
				if(!sueldoText.getText().trim().equals("")){
					tEmpleado= new TEmpleados(null,Float.parseFloat(sueldoText.getText()),nombreText.getText(), apellidoText.getText(),true, correoText.getText(),telefono,idDepartamento);
				}
				else{
					tEmpleado= new TEmpleados(null,0f,nombreText.getText(), apellidoText.getText(),true, correoText.getText(),telefono,idDepartamento);
				}
				ctrl.carryAction(Events.EMPLEADO_CREAR, tEmpleado);
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
		if(event == Events.EMPLEADO_CREAR_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear el empleado");
		else if(event == Events.EMPLEADO_CREAR_REPEATED)
			JOptionPane.showMessageDialog(this, "ERROR: El empleado con id " + (Integer) datos + " ya existe");
		else if(event == Events.EMPLEADO_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Parámetros introducidos incorrectos");
		else if(event == Events.EMPLEADO_CREAR_SUCCESS){
			JOptionPane.showMessageDialog(this, "El empleado con id " +(Integer) datos +" se ha creado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
		}
			
	}
}
