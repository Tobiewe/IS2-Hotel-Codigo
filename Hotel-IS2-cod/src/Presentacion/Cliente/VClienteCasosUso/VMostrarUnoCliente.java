package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VMostrarUnoCliente {
	private Controller ctrl;
	public VMostrarUnoCliente()
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
