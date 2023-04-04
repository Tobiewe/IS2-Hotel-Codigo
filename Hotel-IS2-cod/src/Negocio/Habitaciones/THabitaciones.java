package Negocio.Habitaciones;

public class THabitaciones {
	
	private Integer numero;
	private Integer piso;
	private Float tamaño;
	private Float precio;
	private Boolean ocupada;
	private Integer id_empleado;
	
	//this.numero = numero;
	//this.piso = piso;
	//this.tamaño = tamaño;
	//this.precio = precio;
	//this.ocupada = ocupada;
	//this.id_empleado = id_empleado;
	
	public THabitaciones(Integer numero, Integer piso, Float tamaño, Float precio, Boolean ocupada, Integer id_empleado){
		
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

	public Float getTamaño() {
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

	
	
}
