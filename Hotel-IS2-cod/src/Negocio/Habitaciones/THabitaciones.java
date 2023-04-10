package Negocio.Habitaciones;

public class THabitaciones {
	
	private Integer numero;
	private Integer piso;
	private Integer tamaño;
	private Float precio;
	private Boolean ocupada;
	private Integer id_empleado;
	
	public THabitaciones(Integer numero, Integer piso, Integer tamaño, Float precio, Boolean ocupada, Integer id_empleado){ //tamaño = numero personas
		
		this.numero = numero;
		this.piso = piso;
		this.tamaño = tamaño;
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

	public Integer getTamaño() {
		return tamaño;
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
