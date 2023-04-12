package Negocio.Tareas;

import java.util.ArrayList;
import java.util.Collection;

import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Tareas.DAOTareas;

public class SATareaIMP implements SATarea {

	
	public Integer crear(TTareas tTareas) {
		
		if(tTareas.getDescripcion().trim().equals("") || tTareas.getLugar().trim().equals("") || tTareas.getNombre().trim().equals("")){
			return -5;
		}
		
		DAOTareas daoTareas = FactoriaIntegracion.getInstance().newDAOTarea();
		
		if(tTareas.getId() != null){
			
			TTareas t = daoTareas.leerUno(tTareas.getId());
			
			if(t != null){
				if(t.getActiva()){
					return -2;
				}
				else{
					tTareas.setActiva(true);
					tTareas.setId(t.getId());
					if(daoTareas.modificar(tTareas) <= 0){
						return -1;
					}
					else{
						return tTareas.getId();
					}
				}
					
			}
		}
		
		return daoTareas.crear(tTareas);
		
	}

	
	public Integer eliminar(Integer id) {
		
		DAOTareas daoTareas = FactoriaIntegracion.getInstance().newDAOTarea();
		TTareas t = daoTareas.leerUno(id);
		
		if(t == null){
			return -2;
		}
		
		return daoTareas.eliminar(id);

	}

	
	public Integer modificar(TTareas tTareas) {
		
		DAOTareas daoTareas = FactoriaIntegracion.getInstance().newDAOTarea();
		TTareas t = daoTareas.leerUno(tTareas.getId());
		
		if(t == null){
			return -2;
		}
		
		return daoTareas.modificar(tTareas);
	}

	
	public TTareas leerUno(Integer id) {
		
		DAOTareas daoTareas = FactoriaIntegracion.getInstance().newDAOTarea();
		TTareas t = daoTareas.leerUno(id);
		
		if(t == null){
			return null;
		}
		
		return daoTareas.leerUno(id);
		
	}

	
	public Collection<TTareas> leerTodos() {
		
		DAOTareas daoTareas = FactoriaIntegracion.getInstance().newDAOTarea();
		Collection<TTareas> lista = daoTareas.leerTodos();
		Collection<TTareas> dev = new ArrayList<TTareas>();
		
		
		for(TTareas t : lista){
			TTareas tt = daoTareas.leerUno(t.getId());
			
			if(tt != null){
				dev.add(t);
			}
		}
		
		return dev;
	}

}
