package Presentacion.VFactory;

import Presentacion.Controller.IGUI;


public abstract class VFactory {
	private static VFactory instance;

	public static VFactory getInstance() {
		if (instance == null) {
			instance = new VFactoryImp();
		}
		return instance;
	}

	public abstract IGUI newView(int event, Object data);
}
