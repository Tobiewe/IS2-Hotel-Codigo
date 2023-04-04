package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VBorrarCliente {
	private Controller ctrl;
	public VBorrarCliente()
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
