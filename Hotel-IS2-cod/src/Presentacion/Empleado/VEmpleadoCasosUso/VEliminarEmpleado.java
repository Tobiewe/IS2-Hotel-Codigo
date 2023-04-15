package Presentacion.Empleado.VEmpleadoCasosUso;

import java.awt.Dimension;
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

public class VEliminarEmpleado extends JFrame implements IGUI{
	private Controller ctrl;
	private Integer id;
	
	public VEliminarEmpleado(){
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
		
		setTitle("Eliminar Empleado");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JPanel idPanel = new JPanel();
		
		idPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		idPanel.add(new JLabel("Id del empleado: "));
		JSpinner idField = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		id = (Integer) idField.getValue();
		
		idField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				id=(Integer) idField.getValue();
			}
			
		});
		idPanel.add(idField);

		mainPanel.add(idPanel);
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(okButton(idField.getValue()));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);

		pack();
		setVisible(true);
		
		
	}
	
	JButton okButton(Object object){
		
		JButton okButton=new JButton("Eliminar");
		 
		 
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrl.carryAction(Events.EMPLEADO_ELIMINAR, id);
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
				ctrl.carryAction(Events.EMPLEADO_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	

	@Override
	public void update(int event, Object datos) {
		if (event == Events.EMPLEADO_ELIMINAR_SUCCESS) 
			JOptionPane.showMessageDialog(null, "El empleado con id " + (Integer) datos + " ha sido dada de baja");
		else if(event == Events.EMPLEADO_ELIMINAR_NOTFOUND)
			JOptionPane.showMessageDialog(this, "ERROR: El id " + (Integer) datos + " no esta registrado");
		
		
	}

}
