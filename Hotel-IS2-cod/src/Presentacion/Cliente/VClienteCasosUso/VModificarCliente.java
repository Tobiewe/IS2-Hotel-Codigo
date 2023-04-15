package Presentacion.Cliente.VClienteCasosUso;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.Controller.IGUI;

public class VModificarCliente extends JFrame implements IGUI{
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
	@Override
	public void update(int event, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
