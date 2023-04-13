package Presentacion.Habitacion.VHabitacionCasosUso;

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
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;


public class VAñadirHabitacion  extends JFrame implements IGUI{
	private Controller ctrl;
	
	private Integer tamanyo;
	private Integer piso;
	private Integer idEmpleado;
	
	
	
	public VAñadirHabitacion(){
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
		setTitle("Añadir Habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField precioText = new JTextField("1000");
		
		mainPanel.add(panelPiso());
		mainPanel.add(tamanyoPanel());
		mainPanel.add(precioPanel(precioText));
		mainPanel.add(idEmpleadoPanel());
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(crearButton(precioText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setVisible(true);
	}

	public JPanel panelPiso()
	{
		JPanel panelPiso = new JPanel();
		panelPiso.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel pisoLabel = new JLabel("Piso: ");
		JSpinner pisoSpinner = new JSpinner(new SpinnerNumberModel(1,1,5,1));
		pisoSpinner.setPreferredSize(new Dimension(40, 15));
		piso = (Integer) pisoSpinner.getValue();
		pisoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				piso = (Integer) pisoSpinner.getValue();
			}
			
		});
		
		panelPiso.add(pisoLabel);
		panelPiso.add(pisoSpinner);
		
		return panelPiso;
	}
	
	public JPanel tamanyoPanel()
	{
		JPanel tamanyoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tamanyoLabel = new JLabel("Tamaño: ");
		JComboBox<Integer> tamanyoCombo = new JComboBox<Integer>();
		
		tamanyoCombo.addItem(1);
		tamanyoCombo.addItem(2);
		tamanyoCombo.addItem(3);
		tamanyoCombo.addItem(4);
		
		tamanyo = (Integer) tamanyoCombo.getSelectedItem();
		
		tamanyoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				tamanyo = (Integer) tamanyoCombo.getSelectedItem();
			}
			
		});
		
		tamanyoPanel.add(tamanyoLabel);
		tamanyoPanel.add(tamanyoCombo);
		
		return tamanyoPanel;
	}
	public JPanel precioPanel(JTextField precioText)
	{
		JPanel precioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel precioLabel = new JLabel("Precio: ");
		Dimension d = new Dimension(1000,1000);
		precioText.setSize(d);
		precioPanel.add(precioLabel);
		precioPanel.add(precioText);
		
		
		
		return precioPanel;
	}
	public JPanel idEmpleadoPanel()
	{
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idEmpleadoLabel = new JLabel("Id empleado: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 15));
		idEmpleado = (Integer) idEmpleadoSpinner.getValue();
		idEmpleadoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idEmpleado = (Integer) idEmpleadoSpinner.getValue();
			}
			
		});
		
		panelIdEmpleado.add(idEmpleadoLabel);
		panelIdEmpleado.add(idEmpleadoSpinner);
		
		return panelIdEmpleado;
	}
	public JButton crearButton(JTextField textField)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				THabitaciones tHabitacion = new THabitaciones(null,piso,tamanyo,Float.parseFloat(textField.getText()),false,idEmpleado);
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
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear la habitación");
		else if(event == Events.HABITACION_CREAR_REPEATED)
			JOptionPane.showMessageDialog(this, "ERROR: Ya existe una habitación con el id " + (Integer) datos);
		else if(event == Events.HABITACION_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Parámetros introducidos incorrectos");
		else if(event == Events.HABITACION_CREAR_SUCCESS)
			JOptionPane.showMessageDialog(this, "La habitación con id " +(Integer) datos +" se ha creado correctamente");
	}
}
