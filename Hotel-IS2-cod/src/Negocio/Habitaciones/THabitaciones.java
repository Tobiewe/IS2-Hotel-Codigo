package Negocio.Habitaciones;

public class THabitaciones {
	
	private Integer numero;
	private Integer piso;
	private Integer tama�o;
	private Float precio;
	private Boolean ocupada;
	private Integer id_empleado;
	
	public THabitaciones(Integer numero, Integer piso, Integer tama�o, Float precio, Boolean ocupada, Integer id_empleado){ //tama�o = numero personas
		
		this.numero = numero;
		this.piso = piso;
		this.tama�o = tama�o;
		this.precio = precio;
		this.ocupada = ocupada;
		this.id_empleado = id_empleado;
		
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getPiso() {
		return piso;
	}

	public Integer getTama�o() {
		return tama�o;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	public Integer getId_empledo() {
		return id_empleado;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
