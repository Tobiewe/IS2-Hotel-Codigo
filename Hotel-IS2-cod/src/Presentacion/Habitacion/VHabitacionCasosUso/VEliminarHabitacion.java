package Presentacion.Habitacion.VHabitacionCasosUso;

import javax.swing.SwingUtilities;
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
import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import Presentacion.Controller.Controller;

public class VEliminarHabitacion extends JFrame{
	private Controller ctrl;
	boolean eliminado =false;
	
	public VEliminarHabitacion(){
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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		setContentPane(mainPanel);

		JPanel numPanel = new JPanel();
		mainPanel.add(numPanel);
		numPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		numPanel.add(new JLabel("Numero de Habitacion: "));

		JTextField numField = new JTextField(10);
		numPanel.add(numField);

		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String numHabitacion = numField.getText();
		        // Verificar si la habitacion existe y eliminarla si es necesario
		        // Mostrar mensaje x pantalla
		    }
		});
		numPanel.add(buscarButton);
		
		JPanel okPanel = new JPanel();
		mainPanel.add(okPanel);
		okPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		okPanel.add(okButton(numField.getText()));
		
		
		
		
		
		
		
		
	}
	
	JButton okButton(String string){
		
		JButton okButton=new JButton("Buscar");
		 
		 
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!eliminado){
					JOptionPane.showMessageDialog(VEliminarHabitacion.this, "Numero de habitacion inexistente");
				}
				else{
					JOptionPane.showMessageDialog(VEliminarHabitacion.this, "Habitacion eliminada correctamente");
				}
			}
		});
		return okButton;
	}

}
