package Presentacion.Tarea.VTareaCasosUso;

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

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VVincularTarea extends JFrame implements IGUI {

	private Controller ctrl;
	private Integer idTarea;
	private Integer idEmpleado;
	
	public VVincularTarea(){
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
		
		setTitle("Eliminar Tarea");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		
		mainPanel.add(idTareaPanel());

		mainPanel.add(idEmpleadoPanel());
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(vincularButton());
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);

		pack();
		setVisible(true);
		
		
	}
	JPanel idTareaPanel()
	{
		JPanel idTareaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		idTareaPanel.add(new JLabel("Id de la tarea: "));

		JSpinner idTareaField = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idTareaField.setPreferredSize(new Dimension(50,20));

		idTarea = (Integer) idTareaField.getValue();
		
		idTareaField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idTarea = (Integer) idTareaField.getValue();
			}
			
		});
		
		idTareaPanel.add(idTareaField);
		
		return idTareaPanel;
	}
	JPanel idEmpleadoPanel()
	{
		JPanel idEmpleadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		idEmpleadoPanel.add(new JLabel("Id del empleado: "));
		JSpinner idEmpleadoField = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idEmpleadoField.setPreferredSize(new Dimension(50,20));
		idTarea = (Integer) idEmpleadoField.getValue();
		
		idEmpleadoField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idTarea = (Integer) idEmpleadoField.getValue();
			}
			
		});
		
		idEmpleadoPanel.add(idEmpleadoField);
		
		return idEmpleadoPanel;
	}
	JButton vincularButton(){
		
		JButton okButton = new JButton("Vincular");
		 
		 
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Pair<Integer, Integer> vincularPair = new Pair<>(idTarea, idEmpleado);
				ctrl.carryAction(Events.TAREA_VINCULAR, vincularPair);
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
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	

	@Override
	public void update(int event, Object datos) {
//		if (event == Events.TAREA_VINCULAR_SUCCESS) 
//			JOptionPane.showMessageDialog(null, "La Habitacion de id " + (Integer) datos + " ha sido dada de baja");
//		else if(event == Events.TAREA_VINCULAR_NOTFOUND)
//			JOptionPane.showMessageDialog(this, "ERROR: El id " + (Integer) datos + " no esta registrado");
		
		
	}

}
