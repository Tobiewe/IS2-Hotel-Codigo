package Presentacion.Cliente.VClienteCasosUso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JFrame;

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

public class VCrearCliente extends JFrame implements IGUI{
	private Controller ctrl;
	
	public VCrearCliente()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				initGUI();
			}
		});

		
	}
	void initGUI()
	{
		setTitle("Crear cliente");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		//Añadir ComboBox que pregunte empresa o particular
		DefaultComboBoxModel<String> especializacionModel = new DefaultComboBoxModel<String>();
		especializacionModel.addElement("Particular");
		especializacionModel.addElement("Empresa");
		JComboBox<String> comboEsp = new JComboBox<String>(especializacionModel);
		mainPanel.add(comboEsp);
		
		//Creation of back-end
		comboEsp.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int election = comboEsp.getSelectedIndex();
			}
		});
	}
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
