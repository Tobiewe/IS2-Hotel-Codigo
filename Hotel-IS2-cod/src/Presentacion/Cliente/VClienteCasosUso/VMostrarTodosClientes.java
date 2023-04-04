package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class VMostrarTodosClientes {
	private Controller ctrl;
	public VMostrarTodosClientes()
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
