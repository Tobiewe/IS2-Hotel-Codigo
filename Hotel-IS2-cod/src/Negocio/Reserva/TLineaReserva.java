package Negocio.Reserva;


public class TLineaReserva {
	
	private Integer id_reserva;
	private Integer id_habitacion;
	
	public TLineaReserva(Integer id_reserva, Integer id_habitacion){
		
		this.id_reserva = id_reserva;
		this.id_habitacion = id_habitacion;
		
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public Integer getId_habitacion() {
		return id_habitacion;
	}


}
