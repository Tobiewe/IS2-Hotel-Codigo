package Presentacion.Habitacion.VHabitacionCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
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

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;


public class VAñadirHabitacion  extends JFrame implements IGUI{
	private Controller ctrl;
	
	private Integer tamanyo;
	private Integer piso;
	private float precio;
	
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
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		
		
		
		
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
	public JPanel precioPanel()
	{
		JPanel precioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel precioLabel = new JLabel("Precio: ");
		JTextField precioText = new JTextField();
		
		precioPanel.add(precioLabel);
		precioPanel.add(precioText);
		
		
		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
		return precioPanel;
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
