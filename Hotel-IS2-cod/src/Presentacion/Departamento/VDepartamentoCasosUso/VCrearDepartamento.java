package Presentacion.Departamento.VDepartamentoCasosUso;

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

import Negocio.Departamentos.TDepartamento;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Events;
import Presentacion.Controller.IGUI;

public class VCrearDepartamento extends JFrame implements IGUI {

	private Controller ctrl;

	private String nombre;

	public VCrearDepartamento() {
		ctrl = Controller.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initGUI();
			}
		});
	}

	public void initGUI() {
		setTitle("Crear Habitación");
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setPreferredSize(new Dimension(400, 200));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		setLocationRelativeTo(getParent());

		JTextField nombreText = new JTextField("Ingrese aqui el nombre del departamento");
		nombreText.setSize(1000, 50);
		mainPanel.add(nombrePanel(nombreText));
		

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonPanel.add(crearButton(nombreText));
		buttonPanel.add(cancelButton());

		mainPanel.add(buttonPanel);

		pack();
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JPanel nombrePanel(JTextField nombreText) {
		JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JLabel nombreLabel = new JLabel("Nombre: ");
		Dimension d = new Dimension(1000, 1000);
		nombreText.setSize(d);
		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreText);

		return nombrePanel;
	}


	public JButton crearButton(JTextField nombreTextField) {
		JButton crearButton = new JButton("Crear");
		crearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TDepartamento tDepartamento = new TDepartamento(null, (String)nombreTextField.getText(), true);
				ctrl.carryAction(Events.DEPARTAMENTO_CREAR, tDepartamento);
			}

		});
		return crearButton;
	}

	public JButton cancelButton() {
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
			}

		});
		return cancelButton;
	}

	@Override
	public void update(int event, Object datos) {
		if (event == Events.DEPARTAMENTO_CREAR_ERROR)
			JOptionPane.showMessageDialog(this, "ERROR: No se ha podido crear el departamento");
		else if (event == Events.DEPARTAMENTO_CREAR_REPEATED)
			JOptionPane.showMessageDialog(this, "ERROR: Ya existe un departamento con el nombre " + (String) datos);
		else if (event == Events.DEPARTAMENTO_CREAR_WRONG_PARAMETERS)
			JOptionPane.showMessageDialog(this, "ERROR: Parámetros introducidos incorrectos");
		else if (event == Events.DEPARTAMENTO_CREAR_SUCCESS){
			JOptionPane.showMessageDialog(this,"El departamento " + (String) datos + " ha sido creado correctamente");
			setVisible(false);
			ctrl.carryAction(Events.DEPARTAMENTO_NUEVA_VISTA, null);
		}

	}

}
