package ejercicio12;

public class Ciudad implements CiudadI{

	private String nombre;
	private Integer poblacion;
	
	public Ciudad(String nombre, Integer poblacion) {
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public Double calculaPoblacionFinal() {
		return this.poblacion*0.8;
	}
	
	
}
