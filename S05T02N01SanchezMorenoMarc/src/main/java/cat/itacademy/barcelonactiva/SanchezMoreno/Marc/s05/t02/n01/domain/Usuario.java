package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain;


import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column
	private Double averageRate;

	@CreationTimestamp
	@Column(nullable = false, updatable = false, insertable = false)
	private Timestamp userDate;

	public Usuario() {

	}

	public Usuario(String name) {
		this.name = name;
		this.averageRate = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getUserDate() {
		return userDate;
	}

	public void setUserDate(Timestamp userDate) {
		this.userDate = userDate;
	}


}