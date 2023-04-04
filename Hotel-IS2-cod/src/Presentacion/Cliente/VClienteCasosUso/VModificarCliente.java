package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VModificarCliente {
	private Controller ctrl;
	public VModificarCliente()
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
