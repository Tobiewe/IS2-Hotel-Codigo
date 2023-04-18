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

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Negocio.Empleados.TTareasDelEmpleado;
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
		
		setTitle("Vincular Tarea");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setPreferredSize(new Dimension(400, 200));
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
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		idEmpleado = (Integer) idEmpleadoField.getValue();
		
		idEmpleadoField.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idEmpleado = (Integer) idEmpleadoField.getValue();
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
				TTareasDelEmpleado tTareasDelEmpleadoVincular = new TTareasDelEmpleado(idTarea,idEmpleado);
				ctrl.carryAction(Events.EMPLEADO_VINCULAR, tTareasDelEmpleadoVincular);
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
		if(event == Events.EMPLEADO_VINCULAR_NOID)
			JOptionPane.showMessageDialog(this, "ERROR: Por lo menos uno de los ids introducidos no está registrado");
		else if(event == Events.EMPLEADO_VINCULAR_TAREA_NO_ACTIVA)
			JOptionPane.showMessageDialog(this, "ERROR: Tarea no disponible");
		else if(event == Events.EMPLEADO_VINCULAR_EMPLEADO_NO_ACTIVO)
			JOptionPane.showMessageDialog(this, "ERROR: Empleado no disponible");
		else if(event == Events.EMPLEADO_VINCULAR_SUCCESS)
			JOptionPane.showMessageDialog(this, "La tarea y el empleado se han vinculado con éxito");
	}

}
