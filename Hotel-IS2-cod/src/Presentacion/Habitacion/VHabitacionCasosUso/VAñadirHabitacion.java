package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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


public class VAņadirHabitacion  extends JFrame implements IGUI{
	private Controller ctrl;
	
	private Integer tamanyo;
	private Integer piso;
	private float precio;
	
	public VAņadirHabitacion(){
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
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		
		
		
		pack();
		setLocationRelativeTo(getParent());
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
		
		JLabel tamanyoLabel = new JLabel("Tamaņo: ");
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
	
	public JButton CrearButton(JTextField textField)
	{
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener((e)->
		{
			THabitaciones tHabitacion = new THabitaciones(null,piso,tamanyo,Float.parseFloat(textField.getText()),false,null);
			ctrl.carryAction(Events.HABITACION_CREAR, tHabitacion);
			
		});
		return crearButton;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
