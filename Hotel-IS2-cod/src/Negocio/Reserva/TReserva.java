package Negocio.Reserva;

import java.util.Date;

public class TReserva {
	
	private Integer id;
	private Float total;
	private Date fecha_entrada;
	private String nombre;
	private Integer id_cliente;
	private Integer noches;
	private Boolean activo;
	

	
	public TReserva(Integer id, Float total, Date fecha_entrada, String nombre, Integer id_cliente, Integer noches, Boolean activo){
		
		this.id = id;
		this.total = total;
		this.fecha_entrada = fecha_entrada;
		this.nombre = nombre;
		this.id_cliente = id_cliente;
		this.noches = noches;
		this.activo = activo;
		
	}



	public Integer getId() {
		return id;
	}

	
	public Float getTotal() {
		return total;
	}



	public void setTotal(Float total) {
		this.total = total;
	}



	public Date getFecha_entrada() {
		return fecha_entrada;
	}



	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getId_cliente() {
		return id_cliente;
	}



	public Integer getNoches() {
		return noches;
	}



	public void setNoches(Integer noches) {
		this.noches = noches;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


}
