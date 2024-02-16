package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.dto;


public class UsuarioDTO {
	
	

	private String name;

	private Double averageRate;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String name, Double averageRate) {

	    this.name = name;
		this.averageRate = averageRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(Double averageRate) {
		this.averageRate = averageRate;
	}



}