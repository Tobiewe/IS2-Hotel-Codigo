package Presentacion.Departamento.VDepartamentoCasosUso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VEliminarDepartamento extends JFrame implements IGUI {
	private Controller ctrl;
	private Integer id;
	boolean eliminado = false;
	
	public VEliminarDepartamento(){
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
		
		setTitle("Eliminar Departamento");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JPanel numPanel = new JPanel();
		
		numPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		numPanel.add(new JLabel("Id del departamento: "));
		JSpinner numField = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		id = (Integer) numField.getValue();
		
		numField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				id = (Integer) numField.getValue();
			}
			
		});
		numPanel.add(numField);

		mainPanel.add(numPanel);
		
		
		JPanel okPanel = new JPanel();
		okPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		okPanel.add(okButton(numField.getValue()));
		mainPanel.add(okPanel);

		pack();
		setVisible(true);
		
		
	}
	
	JButton okButton(Object object){
		
		JButton okButton=new JButton("Eliminar");
		 
		 
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.carryAction(Events.DEPARTAMENTO_ELIMINAR, id);
			}
	
		});
		return okButton;
	}
	

	@Override
	public void update(int event, Object datos) {
		if (event == Events.DEPARTAMENTO_ELIMINAR_SUCCESS) 
			JOptionPane.showMessageDialog(null, "El departamento " + (String) datos + " se ha eliminado");
		else if(event == Events.DEPARTAMENTO_ELIMINAR_NOTFOUND)
			JOptionPane.showMessageDialog(this, "ERROR: El id " + (Integer) datos + " de departamento no está registrado");
		
		
	}

}
