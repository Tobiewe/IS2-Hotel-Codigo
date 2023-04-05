package Presentacion.Empleado;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VEmpleado extends JFrame implement{
	private Controller ctrl;
	private static final Dimension buttonDimension = new Dimension(220,100);
	
	public VEmpleado()
	{
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

	protected void initGUI() {
		// TODO Auto-generated method stub
		
	}
}
