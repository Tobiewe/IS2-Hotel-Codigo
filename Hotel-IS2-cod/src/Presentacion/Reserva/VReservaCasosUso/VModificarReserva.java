package Presentacion.Reserva.VReservaCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Habitaciones.THabitaciones;
import Negocio.Reserva.TReserva;
import Negocio.Tareas.TTareas;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VModificarReserva extends JFrame implements IGUI {
	private Controller ctrl;
	private String title = "Modificar Reserva";
	private Integer idHabitacion;
	private Integer id;
	private Integer idCliente;
    private DefaultListModel<Integer> listaHabitaciones;
    private JPanel añadirHabitacionesPanel;
    private boolean activa;
	private Integer noches;
	private Date fecha;
	
	public VModificarReserva(){
		ctrl = Controller.getInstance();
		listaHabitaciones  = new DefaultListModel<>();
		añadirHabitacionesPanel = new JPanel();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}
	
	protected void initGUI() {
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		añadirHabitacionesPanel.setLayout(new BoxLayout(añadirHabitacionesPanel, BoxLayout.Y_AXIS));

	    setContentPane(mainPanel);
	    setTitle(title);

	    JPanel nochesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    nochesPanel.add(new JLabel("Noches: "));
	    nochesPanel.add(nochesSpinner());

	    JPanel fechaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    fechaPanel.add(new JLabel("Fecha: "));
	    fechaPanel.add(fechaSpinner());
//
//	    JPanel cancelButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//	    cancelButtonPanel.add(cancelButton());
	   // cancelButtonPanel.add(añadirHabitacionesReservaButton());
	    
	    JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    idPanel.add(new JLabel("Id: "));
	    idPanel.add(idSpinner());	    
	    
	    JPanel idClientePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    idClientePanel.add(new JLabel("Id del Cliente: "));
	    idClientePanel.add(idSpinner());	
	    
//	    JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//	    nombrePanel.add(new JLabel("Nombre: "));
//	    nombrePanel.add(idSpinner());	
	    
	    mainPanel.add(idPanel);
	    mainPanel.add(idClientePanel);
	    mainPanel.add(panelActivo());
	    mainPanel.add(nochesPanel);
	    mainPanel.add(fechaPanel);
	   
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    
	    buttonPanel.add(modificarReservaButton());
	    buttonPanel.add(cancelButton());
	    
	    mainPanel.add(buttonPanel);
	    

	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public JSpinner idSpinner(){
		JSpinner idSpin = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idSpin.setPreferredSize(new Dimension(40, 15));
		id = (Integer) idSpin.getValue();
		idSpin.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				id = (Integer) idSpin.getValue();
			}
			
		});
		
		return idSpin;
		
	}
	public JSpinner idClienteSpinner(){
		JSpinner idSpin = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		idSpin.setPreferredSize(new Dimension(40, 15));
		idCliente = (Integer) idSpin.getValue();
		idSpin.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				idCliente = (Integer) idSpin.getValue();
			}
			
		});
		
		return idSpin;
		
	}
	public JPanel panelActivo()
	{
		JPanel panelActivo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel activoLabel = new JLabel("Activa: ");
		JComboBox<Boolean> activoCombo = new JComboBox<Boolean>();
		
		activoCombo.addItem(true);
		activoCombo.addItem(false);
		
		activa = (Boolean) activoCombo.getSelectedItem();
		
		activoCombo.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				activa = (Boolean) activoCombo.getSelectedItem();
			}
			
		});
		
		panelActivo.add(activoLabel);
		panelActivo.add(activoCombo);
		
		return panelActivo;
	}
	public JSpinner nochesSpinner(){
		JSpinner nochesSpin = new JSpinner(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
		nochesSpin.setPreferredSize(new Dimension(40, 15));
		noches = (Integer) nochesSpin.getValue();
		nochesSpin.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				noches = (Integer) nochesSpin.getValue();
			}
			
		});
		
		return nochesSpin;
		
	}
	public JSpinner fechaSpinner() {
	    JSpinner fechaSpin = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
	    fechaSpin.setEditor(new JSpinner.DateEditor(fechaSpin, "dd/MM/yyyy"));
	    fechaSpin.setPreferredSize(new Dimension(100, 20));
	    fecha = (Date) fechaSpin.getValue();
	    fechaSpin.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            fecha = (Date) fechaSpin.getValue();
	        }
	    });

	    return fechaSpin;
	}
	

	public JPanel panelIdHabitacion() {
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idEmpleadoLabel = new JLabel("Número de habitación: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 20));
		idHabitacion = (Integer) idEmpleadoSpinner.getValue();
		idEmpleadoSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				idHabitacion = (Integer) idEmpleadoSpinner.getValue();
			}

		});

		panelIdEmpleado.add(idEmpleadoLabel);
		panelIdEmpleado.add(idEmpleadoSpinner);

		return panelIdEmpleado;
	}
	
	public JButton modificarReservaButton() {
		
		JButton modificarReservaButton = new JButton("Modificar");
		modificarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TReserva tReserva = new TReserva(id, null, fecha, idCliente, noches,activa);
				ctrl.carryAction(Events.RESERVA_MODIFICAR, tReserva);
			}
		});
		
		return modificarReservaButton;
	}
	public JButton cancelButton()
	{
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
			}
		
		});
		return cancelButton;
	}
	
	@Override
	public void update(int event, Object datos) {
		if(event == Events.RESERVA_MODIFICAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Los parámetros introducidos son erróneos");
//		else if(event == Events.HABITACION_MODIFICAR_IDREPEATED) 
//			JOptionPane.showMessageDialog(this, "ERROR: La habitación con id " + (Integer)datos + "ya existe");
		else if(event == Events.RESERVA_MODIFICAR_NOTFOUND) 
			JOptionPane.showMessageDialog(this, "ERROR: La reserva con id " + (Integer)datos + " no se ha encontrado");
		else if(event == Events.RESERVA_MODIFICAR_SUCCESS){
			JOptionPane.showMessageDialog(this, "La reserva con id " + (Integer)datos + " se ha modificado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.RESERVA_NUEVA_VISTA, null);
		}

	}
}
