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

import Negocio.Clientes.TCliente;
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
		mainPanel.setPreferredSize(new Dimension(400, 300));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		//Text Feilds
		JTextField correoText = new JTextField("                 ");
		JTextField nombreText = new JTextField("                ");
		JTextField apellidoText = new JTextField("                 ");
		JTextField nifText = new JTextField("                  ");
		JTextField cifText = new JTextField("                   ");
		
		correoText.setPreferredSize(new Dimension(70, 25));
		apellidoText.setPreferredSize(new Dimension(70, 25));
		nifText.setPreferredSize(new Dimension(70, 25));
		cifText.setPreferredSize(new Dimension(70, 25));
		
		//ComboBox tipo
		JComboBox<String> tipoCombo = new JComboBox<String>();
		JPanel particularPanel = particularPanel(apellidoText,nifText);
		JPanel empresaPanel = empresaPanel(cifText);
		
		mainPanel.add(panelTelefono());
		mainPanel.add(panelCorreo(correoText));
		mainPanel.add(panelNombre(nombreText));
		mainPanel.add(panelActivo());
		mainPanel.add(panelTipo(tipoCombo, particularPanel, empresaPanel));
		mainPanel.add(particularPanel);
		mainPanel.add(empresaPanel);
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonPanel.add(crearButton(tipo,correoText,nombreText,apellidoText,nifText,cifText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setVisible(true);
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
	
	public JPanel panelNombre(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		
		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		
		
		
		return nombrePanel;
	}
	public JPanel panelTipo(JComboBox<String> tipoCombo, JPanel particularPanel, JPanel empresaPanel)
	{
		JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tipoLabel = new JLabel("Tipo: ");
		
		tipoCombo.addItem("Particular");
		tipoCombo.addItem("Empresa");
		
		tipo = (String) tipoCombo.getSelectedItem();
		if(tipo.equals("Particular"))
		{
			empresaPanel.setVisible(false);
			particularPanel.setVisible(true);
		}
		else if(tipo.equals("Empresa"))
		{
			particularPanel.setVisible(false);
			empresaPanel.setVisible(true);
		}
		
		tipoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				tipo = (String) tipoCombo.getSelectedItem();
				if(tipo.equals("Particular"))
				{
					empresaPanel.setVisible(false);
					particularPanel.setVisible(true);
				}
				else if(tipo.equals("Empresa"))
				{
					particularPanel.setVisible(false);
					empresaPanel.setVisible(true);
				}
			}
			
		});
		
		panelTipo.add(tipoLabel);
		panelTipo.add(tipoCombo);
		
		return panelTipo;
	}
	public JPanel empresaPanel(JTextField cifText)
	{
		JPanel empresaPanel = new JPanel();
		empresaPanel.setLayout(new BoxLayout(empresaPanel, BoxLayout.Y_AXIS));
		
		JPanel cifPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel cifLabel = new JLabel("CIF: ");
		
		cifPanel.add(cifLabel);
		cifPanel.add(cifText);
		
		empresaPanel.add(cifPanel);
		return empresaPanel;

	}
	public JPanel particularPanel(JTextField apellidoText, JTextField nifText)
	{
		JPanel particularPanel = new JPanel();
		particularPanel.setLayout(new BoxLayout(particularPanel, BoxLayout.Y_AXIS));
		
		JPanel apellidoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel nifPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		JLabel nifLabel = new JLabel("NIF: ");
		
		apellidoPanel.add(apellidoLabel);
		apellidoPanel.add(apellidoText);
		
		nifPanel.add(nifLabel);
		nifPanel.add(nifText);
		
		particularPanel.add(apellidoPanel);
		
		particularPanel.add(nifPanel);
		
		return particularPanel;

	}
	public JButton crearButton(String tipo, JTextField correoText,JTextField nombreText,JTextField apellidoText,JTextField niftext,JTextField cifText)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener()
		{
			//public TCliente(Integer id, String correo, Integer telefono, String nombre, String CIF, String apellidos,  String NIF, Boolean activo){
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tipo.equals("Particular"))
				{
					TCliente tCliente = new TCliente(null,correoText.getText(),telefono, nombreText.getText(),null, apellidoText.getText(),niftext.getText(),true);
					ctrl.carryAction(Events.CLIENTE_CREAR, tCliente);
				}
				else if (tipo.equals("Empresa"))
				{
					TCliente tCliente = new TCliente(null,correoText.getText(),telefono, nombreText.getText(),cifText.getText(), null,null,true);
					ctrl.carryAction(Events.CLIENTE_CREAR, tCliente);
				}
				else
				{
					ctrl.carryAction(Events.CLIENTE_CREAR, null);
				} 
				
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
				ctrl.carryAction(Events.CLIENTE_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.CLIENTE_CREAR_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear el cliente");
		else if(event == Events.CLIENTE_CREAR_REPEATED)
			JOptionPane.showMessageDialog(this, "ERROR: El cliente con id " + (Integer) datos + " ya existe");
		else if(event == Events.CLIENTE_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Parámetros introducidos incorrectos");
		else if(event == Events.CLIENTE_CREAR_SUCCESS)
		{
			JOptionPane.showMessageDialog(this, "El cliente con id " +(Integer) datos +" se ha creado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.CLIENTE_NUEVA_VISTA, null);
		}
			
	}
}
