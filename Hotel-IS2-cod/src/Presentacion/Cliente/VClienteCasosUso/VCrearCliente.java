package Presentacion.Cliente.VClienteCasosUso;

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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Habitaciones.THabitaciones;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VCrearCliente extends JFrame implements IGUI{
	private Controller ctrl;
	
	private Integer telefono;
	private String correo;
	private boolean activo;
	private String tipo;
	private String nombre;
	private String apellido;
	private String CIF;
	private String NIF;
	
	
	public VCrearCliente(){
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
		setTitle("Crear Cliente");
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 200));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField correoText = new JTextField("                 ");
		correoText.setPreferredSize(new Dimension(70, 25));
		
		mainPanel.add(panelTelefono());
		mainPanel.add(panelCorreo(correoText));
		mainPanel.add(panelActivo());
		mainPanel.add(panelTipo());
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(crearButton(correoText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setVisible(true);
	}

	public JPanel panelTelefono()
	{
		JPanel panelTelefono = new JPanel();
		panelTelefono.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel telefonoLabel = new JLabel("Tel�fono: ");
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
	
	public JPanel panelActivo()
	{
		JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tamanyoLabel = new JLabel("Activo: ");
		JComboBox<Boolean> tipoCombo = new JComboBox<Boolean>();
		
		tipoCombo.addItem(true);
		tipoCombo.addItem(false);
		
		activo = (Boolean) tipoCombo.getSelectedItem();
		
		tipoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				activo = (Boolean) tipoCombo.getSelectedItem();
			}
			
		});
		
		panelTipo.add(tamanyoLabel);
		panelTipo.add(tipoCombo);
		
		return panelTipo;
	}
	public JPanel panelTipo()
	{
		JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tamanyoLabel = new JLabel("Tama�o: ");
		JComboBox<String> tipoCombo = new JComboBox<String>();
		
		tipoCombo.addItem("Particular");
		tipoCombo.addItem("Empresa");
		
		tipo = (String) tipoCombo.getSelectedItem();
		
		tipoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				tipo = (String) tipoCombo.getSelectedItem();
			}
			
		});
		
		panelTipo.add(tamanyoLabel);
		panelTipo.add(tipoCombo);
		
		return panelTipo;
	}
	public JPanel empresaPanel()
	{
		
	}
	public JPanel particularPanel()
	{
		
	}
	public JButton crearButton(JTextField textField)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				THabitaciones tHabitacion = new THabitaciones(null,id,tamanyo,Float.parseFloat(textField.getText()),false,idEmpleado);
				ctrl.carryAction(Events.HABITACION_CREAR, tHabitacion);
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
				ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.HABITACION_CREAR_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear la habitaci�n");
		else if(event == Events.HABITACION_CREAR_REPEATED)
			JOptionPane.showMessageDialog(this, "ERROR: Ya existe una habitaci�n con el id " + (Integer) datos);
		else if(event == Events.HABITACION_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Par�metros introducidos incorrectos");
		else if(event == Events.HABITACION_CREAR_SUCCESS)
		{
			JOptionPane.showMessageDialog(this, "La habitaci�n con id " +(Integer) datos +" se ha creado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
		}
			
	}
}
