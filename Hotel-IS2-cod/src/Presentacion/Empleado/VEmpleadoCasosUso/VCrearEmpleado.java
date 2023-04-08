package Presentacion.Empleado.VEmpleadoCasosUso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import Presentacion.Controller.Controller;;

public class VCrearEmpleado extends JFrame {
	private Controller ctrl;
	private String tipoEmpleado="Limpieza";

	public VCrearEmpleado(){
		
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
		
		//casida Nombre
		JPanel nombrePanel = new JPanel();
		mainPanel.add(nombrePanel);
		nombrePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		nombrePanel.add(new JLabel("Nombre: "));
		//nombrePanel.add(nombrefield());
		
		//casilla Apellidos
		JPanel apellidosPanel= new JPanel();
		mainPanel.add(apellidosPanel);
		apellidosPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		apellidosPanel.add(new JLabel("Apellidos: "));
		//apellidosPanel.add(apellidosField());
		
		//casilla ID 
		JPanel idPanel = new JPanel();
		mainPanel.add(idPanel);
		idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idPanel.add(new JLabel("ID: "));
		idPanel.add(idField());
		
		// casilla email
		JPanel emailPanel = new JPanel();
		mainPanel.add(emailPanel);
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new JLabel("Email: "));
		//emailPanel.add(emailField());
		
		// casilla TLF
		JPanel tlfPanel = new JPanel();
		mainPanel.add(tlfPanel);
		tlfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlfPanel.add(new JLabel("Telefono: "));
		//tlfPanel.add(tlfField());
		
		// casilla activo
		JPanel activoPanel = new JPanel();
		mainPanel.add(activoPanel);
		activoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JCheckBox activoBox = new JCheckBox("En Activo");
		activoPanel.add(activoBox);
		
		//casilla sueldo
		JPanel sueldoPanel = new JPanel();
		sueldoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		sueldoPanel.add(new JLabel("Sueldo: "));
		//sueldoPanel.add(sueldoField());
		
		//comprobar si empleado esta activo para poner la casilla sueldo
		activoBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (activoBox.isSelected()) {
		            mainPanel.add(sueldoPanel);
		        } else {
		            mainPanel.remove(sueldoPanel);
		        }
		        mainPanel.revalidate();
		        mainPanel.repaint();
		    }
		});
		
		//casilla Lugar y Especialidad
		JPanel lugarPanel= new JPanel();
		JPanel especialidadPanel= new JPanel();
		
		//casilla tipo
		JPanel tipoPanel = new JPanel();
		mainPanel.add(tipoPanel);
		tipoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tipoPanel.add(new JLabel("Tipo: "));
		JComboBox<String> combTipo = new JComboBox<String>();
		combTipo.addItem("Mantenimiento");
		combTipo.addItem("Limpieza");
		tipoPanel.add(combTipo);
		
		combTipo.addItemListener(new ItemListener(){
			
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange()== ItemEvent.SELECTED){
					tipoEmpleado=(String) e.getItem();
					
					if(tipoEmpleado.equals("Mantenimiento")){
						mainPanel.add(lugarPanel);
						mainPanel.remove(especialidadPanel);
					}
					else{
						mainPanel.remove(lugarPanel);
						mainPanel.add(especialidadPanel);
					}
					mainPanel.revalidate();
				    mainPanel.repaint();
				}
			}
		});
		
		lugarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lugarPanel.add(new JLabel("Lugar: "));
		//lugarPanel.add(lugarField())
		
		especialidadPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		especialidadPanel.add(new JLabel("Especialidad: "));
		//especialidadPanel.add(especialidadField())
				
		
	}
	
	JTextField idField(){
		JTextField idField = new JTextField();
		
		return idField;
	}

	
}
