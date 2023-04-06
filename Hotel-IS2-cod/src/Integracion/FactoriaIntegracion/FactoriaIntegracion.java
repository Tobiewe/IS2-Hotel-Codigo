package Integracion.FactoriaIntegracion;

public  class FactoriaIntegracion {
		
	private static FactoriaIntegracion instance;
	
	public static FactoriaIntegracion getInstance()
	{
		if (instance == null)
			instance = new FactoriaIntegracionImp();
		return instance;
	}
}
