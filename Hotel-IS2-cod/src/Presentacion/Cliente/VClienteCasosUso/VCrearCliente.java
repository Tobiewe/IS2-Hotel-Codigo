package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VCrearCliente {
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
		
	}
}
