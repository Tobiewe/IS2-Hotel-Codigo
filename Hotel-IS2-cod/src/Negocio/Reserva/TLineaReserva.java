package Negocio.Reserva;


public class TLineaReserva {
	
	private Integer id_reserva;
	private Integer id_cliente;
	private Integer id_habitacion;
	private Boolean activa;
	
	public TLineaReserva(Integer id_reserva, Integer id_cliente, Integer id_habitacion, Boolean activa){
		
		this.id_reserva = id_reserva;
		this.id_cliente = id_cliente;
		this.id_habitacion = id_habitacion;
		this.activa = activa;
		
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public Integer getId_habitacion() {
		return id_habitacion;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

}
