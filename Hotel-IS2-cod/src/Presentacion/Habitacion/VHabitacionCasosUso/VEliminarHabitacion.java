package Presentacion.Habitacion.VHabitacionCasosUso;

import javax.swing.SwingUtilities;
import Presentacion.Controller.Events;

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
import javax.swing.UIManager;
import java.awt.FlowLayout;
import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

public class VEliminarHabitacion extends JFrame implements IGUI{
	private Controller ctrl;
	private Integer id;
	boolean eliminado =false;
	
	public VEliminarHabitacion(){
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				initGUI();
			}
		});
	}
	
	public void initGUI(){
		
		setTitle("Eliminar Habitación");
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(500, 100));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JPanel numPanel = new JPanel();
		
		numPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		numPanel.add(new JLabel("Numero de Habitacion: "));
		JSpinner numField = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		id = (Integer) numField.getValue();
		
		numField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				id=(Integer) numField.getValue();
			}
			
		});
		numPanel.add(numField);

		mainPanel.add(numPanel);
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(okButton(numField.getValue()));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);

		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	JButton okButton(Object object){
		
		JButton okButton=new JButton("Eliminar");
		 
		 
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrl.carryAction(Events.HABITACION_ELIMINAR, id);
			}
	
		});
		return okButton;
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
		if (event == Events.HABITACION_ELIMINAR_SUCCESS){
			JOptionPane.showMessageDialog(null, "La Habitacion de id " + (Integer) datos + " ha sido dada de baja");
			setVisible(false);
			ctrl.carryAction(Events.HABITACION_NUEVA_VISTA, null);
		}
		else if(event == Events.HABITACION_ELIMINAR_NOTFOUND)
			JOptionPane.showMessageDialog(this, "ERROR: El id " + (Integer) datos + " no esta registrado");
		
		
	}

}
