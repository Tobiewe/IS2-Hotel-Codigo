package Presentacion.Reserva.VReservaCasosUso;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import Negocio.Reserva.TReserva;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;
import Presentacion.Controller.IGUI;

public class VAbrirReserva extends JFrame implements IGUI {

	private Controller ctrl;
	private String title = "Abrir Reserva";
	private Integer idCliente;
    private DefaultListModel<Integer> listaHabitaciones;
    private JPanel añadirHabitacionesPanel;
	private Integer noches;
	private Date fecha;
	
	public VAbrirReserva(){
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

	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    buttonPanel.add(crearReservaButton());
	    buttonPanel.add(cancelButton());
	    

	    mainPanel.add(nochesPanel);
	    mainPanel.add(fechaPanel);
	    mainPanel.add(panelIdCliente());
	    mainPanel.add(buttonPanel);
	  
	    
	    mainPanel.add(añadirHabitacionesPanel);

	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
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
	
	public JPanel panelIdCliente() {
		JPanel panelIdEmpleado = new JPanel();
		panelIdEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel idEmpleadoLabel = new JLabel("Id del cliente: ");
		JSpinner idEmpleadoSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		idEmpleadoSpinner.setPreferredSize(new Dimension(40, 20));
		idCliente = (Integer) idEmpleadoSpinner.getValue();
		idEmpleadoSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				idCliente = (Integer) idEmpleadoSpinner.getValue();
			}

		});

		panelIdEmpleado.add(idEmpleadoLabel);
		panelIdEmpleado.add(idEmpleadoSpinner);

		return panelIdEmpleado;
	}
	//act
	public JButton crearReservaButton() {
		
		JButton crearReservaButton = new JButton("Cerrar");
		crearReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float total = (float) 0.0;
				TReserva tReserva = new TReserva(null, total, fecha,idCliente,noches,true);
				ctrl.carryAction(Events.RESERVA_CREAR, tReserva);
			}
		});
		return crearReservaButton;
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
		
		
	}

}
