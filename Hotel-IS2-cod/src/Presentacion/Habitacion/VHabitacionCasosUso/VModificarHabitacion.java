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

public class VModificarHabitacion extends JFrame implements IGUI {
	Controller ctrl;
	private Integer tamanyo;
	private Integer piso;
	private float precio;
	private Integer id;
	private Integer id_empleado;
	private boolean ocupada;
	
	public VModificarHabitacion(){
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

		JTextField precioText = new JTextField("0");
		precioText.setPreferredSize(new Dimension(70, 25));
		
		mainPanel.add(panelId());
		mainPanel.add(panelPiso());
		mainPanel.add(tamanyoPanel());
		mainPanel.add(precioPanel(precioText));
		mainPanel.add(panelIdEmpleado());
		mainPanel.add(panelOcupada());
		
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(modificarButton(precioText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
//		Dimension d = new Dimension(600,400);
//		setPreferredSize(d);
//		mainPanel.setPreferredSize(d);
		pack();
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
	public JPanel panelOcupada()
	{
		JPanel panelOcupada = new JPanel();
		panelOcupada.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel ocupadaLabel = new JLabel("Ocupada: ");
		JComboBox<Boolean> ocupadaCombo = new JComboBox<Boolean>();
		
		ocupadaCombo.addItem(false);
		ocupadaCombo.addItem(true);
		
		ocupada = (boolean) ocupadaCombo.getSelectedItem();
		
		ocupadaCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				ocupada = (boolean) ocupadaCombo.getSelectedItem();
			}
			
		});		
		panelOcupada.add(ocupadaLabel);
		panelOcupada.add(ocupadaCombo);
		
		return panelOcupada;
	}
	public JPanel panelIdEmpleado()
	{
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idEmpleadoLabel = new JLabel("Id del Empleado: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 20));
		id = (Integer) idEmpleadoSpinner.getValue();
		idEmpleadoSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				id_empleado = (Integer) idEmpleadoSpinner.getValue();
			}
			
		});
		
		panelIdEmpleado.add(idEmpleadoLabel);
		panelIdEmpleado.add(idEmpleadoSpinner);
		
		return panelIdEmpleado;
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
		
		precioPanel.add(precioLabel);
		precioPanel.add(precioText);
		
		
		
		return precioPanel;
	}
	
	public JButton modificarButton(JTextField textField)
	{
		JButton crearButton = new JButton("Modificar");
		crearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				THabitaciones tHabitacion = new THabitaciones(id,piso,tamanyo,Float.parseFloat(textField.getText()),ocupada,id_empleado);
				ctrl.carryAction(Events.HABITACION_MODIFICAR, tHabitacion);
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
		if(event == Events.HABITACION_MODIFICAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Los parámetros introducidos son erróneos");
//		else if(event == Events.HABITACION_MODIFICAR_IDREPEATED) 
//			JOptionPane.showMessageDialog(this, "ERROR: La habitación con id " + (Integer)datos + "ya existe");
		else if(event == Events.HABITACION_MODIFICAR_NOTFOUND) 
			JOptionPane.showMessageDialog(this, "ERROR: La habitación con id " + (Integer)datos + " no se ha encontrado");
		else if(event == Events.HABITACION_MODIFICAR_SUCCESS) 
			JOptionPane.showMessageDialog(this, "La habitación con id " + (Integer)datos + "se ha modificado correctamente");

	}

}
