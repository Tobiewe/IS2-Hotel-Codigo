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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import Presentacion.Controller.Controller;;

public class VCrearEmpleado extends JFrame {
	private Controller ctrl;
	private String tipoEmpleado="Limpieza", nombre, apellidos,email,tlf;
	

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
		
		
		
		//casilla sueldo
		JPanel sueldoPanel = new JPanel();
		mainPanel.add(sueldoPanel);
		sueldoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		sueldoPanel.add(new JLabel("Sueldo: "));
		//sueldoPanel.add(sueldoField());
		
		/*comprobar si empleado esta activo para poner la casilla sueldo
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
		*/
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
					else if (tipoEmpleado.equals("Limpieza")){
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
	
	JTextField nombreField(){
		JTextField nombreField=new JTextField(10);
		nombre=new String();
		
		nombreField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e){
				nombre = nombreField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				nombre=nombreField.getText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				nombre=nombreField.getText();
				
			}
			
		});
		return nombreField;
	}
	JTextField apellidosField(){
		JTextField apellidosField=new JTextField(20);
		apellidos=new String();
		
		apellidosField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e){
				apellidos = apellidosField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				apellidos=apellidosField.getText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				apellidos=apellidosField.getText();
				
			}
			
		});
		return apellidosField;
	}
	JTextField emailField(){
		JTextField emailField=new JTextField(20);
		email=new String();
		
		emailField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e){
				email = emailField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				email=emailField.getText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				email=emailField.getText();
				
			}
			
		});
		return emailField;
	}
	JTextField tlfField(){
		JTextField tlfField=new JTextField(9);
		tlf=new String();
		
		tlfField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e){
				tlf = tlfField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				tlf=tlfField.getText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				tlf=tlfField.getText();
				
			}
			
		});
		return tlfField;
	}
	JTextField sueldoField(){
		JTextField sueldoField=new JTextField(5);
		nombre=new String();
		
		apellidosField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e){
				nombre = sueldoField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				nombre=apellidosField.getText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				nombre=apellidosField.getText();
				
			}
			
		});
		return apellidosField;
	}

	
}
