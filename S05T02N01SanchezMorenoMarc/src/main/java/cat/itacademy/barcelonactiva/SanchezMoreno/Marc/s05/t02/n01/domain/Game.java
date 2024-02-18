package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain;



import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "dice1", nullable = false)
	private int dice1;

	@Column(name = "dice2", nullable = false)
	private int dice2;

	@Column(name = "result", nullable = false)
	private String result;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false, insertable = false)
	private Timestamp gameDate;

	public Game(int usuario_id) {
		ResultCalculator calculateResult = (d1, d2) -> (d1 + d2 == 7) ? "Victory!" : "you lose";

		this.dice1 = (int) (Math.random() * 6 + 1);
		this.dice2 = (int) (Math.random() * 6 + 1);
		this.result = calculateResult.calculate(dice1, dice2);
		this.userId = usuario_id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getGameDate() {
		return gameDate;
	}

	public void setGameDate(Timestamp gameDate) {
		this.gameDate = gameDate;
	}

}
