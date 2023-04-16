package Presentacion.Tarea.VTareaCasosUso;

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

import Negocio.Clientes.TCliente;
import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VModificarTarea extends JFrame implements IGUI {


	private Controller ctrl;
	
	private Integer id;
	private String descripcion;
	private String lugar;
	private String nombre;
	private Integer idEmpleado;
	private boolean activa;
	
	
	public VModificarTarea(){
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
		setTitle("Modificar Tarea");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField descripcionText = new JTextField("");
		JTextField lugarText = new JTextField("");
		JTextField nombreText = new JTextField("");

		descripcionText.setPreferredSize(new Dimension(150, 20));
		lugarText.setPreferredSize(new Dimension(150, 20));
		nombreText.setPreferredSize(new Dimension(150, 20));

		mainPanel.add(panelId());
		mainPanel.add(panelDescripcion(descripcionText));
		mainPanel.add(panelLugar(lugarText));
		mainPanel.add(panelNombre(nombreText));
		mainPanel.add(idEmpleadoPanel());
		mainPanel.add(panelActivo());
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(crearButton(descripcionText, lugarText, nombreText));
		buttonPanel.add(cancelButton());
		
		mainPanel.add(buttonPanel);
		
		
		pack();
		setVisible(true);
	}
	public JPanel panelId()
	{
		JPanel panelId= new JPanel();
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
	public JPanel panelDescripcion(JTextField descripcionText)
	{
		JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel descripcionLabel = new JLabel("Descripción: ");
		
		descripcionPanel.add(descripcionLabel);
		descripcionPanel.add(descripcionText);
		
		
		
		return descripcionPanel;
	}
	public JPanel panelLugar(JTextField lugarText)
	{
		JPanel lugarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lugarLabel = new JLabel("Lugar: ");
		
		lugarPanel.add(lugarLabel);
		lugarPanel.add(lugarText);
		
		return lugarPanel;
	}
	public JPanel panelNombre(JTextField nombreText)
	{
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nombreLabel = new JLabel("Nombre: ");

		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);
		
		return nombrePanel;
	}
	public JPanel idEmpleadoPanel()
	{
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel idEmpleadoLabel = new JLabel("Id empleado: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 20));
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
	public JPanel panelActivo()
	{
		JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tamanyoLabel = new JLabel("Activa: ");
		JComboBox<Boolean> tipoCombo = new JComboBox<Boolean>();
		
		tipoCombo.addItem(true);
		tipoCombo.addItem(false);
		
		activa = (Boolean) tipoCombo.getSelectedItem();
		
		tipoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				activa = (Boolean) tipoCombo.getSelectedItem();
			}
			
		});
		
		panelTipo.add(tamanyoLabel);
		panelTipo.add(tipoCombo);
		
		return panelTipo;
	}
	public JButton crearButton(JTextField descripcionText,JTextField lugarText,JTextField nombreText)
	{
		JButton crearButton = new JButton("Modificar");
		crearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				TTareas tTarea = new TTareas(id,descripcionText.getText(),lugarText.getText(),nombreText.getText(),activa,idEmpleado);
				ctrl.carryAction(Events.TAREA_MODIFICAR, tTarea);
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
				ctrl.carryAction(Events.TAREA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.TAREA_MODIFICAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Los parámetros introducidos son erróneos");
//		else if(event == Events.HABITACION_MODIFICAR_IDREPEATED) 
//			JOptionPane.showMessageDialog(this, "ERROR: La habitación con id " + (Integer)datos + "ya existe");
		else if(event == Events.TAREA_MODIFICAR_NOTFOUND) 
			JOptionPane.showMessageDialog(this, "ERROR: La tarea con id " + (Integer)datos + " no se ha encontrado");
		else if(event == Events.TAREA_MODIFICAR_SUCCESS) 
			JOptionPane.showMessageDialog(this, "La tarea con id " + (Integer)datos + "se ha modificado correctamente");
			
	}
}
