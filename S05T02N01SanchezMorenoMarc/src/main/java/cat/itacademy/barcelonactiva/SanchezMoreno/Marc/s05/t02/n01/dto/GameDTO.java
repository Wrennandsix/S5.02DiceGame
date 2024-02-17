package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.dto;



public class GameDTO {
	
	
    private int dice1;
    private int dice2;
    private String result;

    public GameDTO(int dice1, int dice2) {
    	
        this.dice1 = dice1;
        this.dice2 = dice2;
        if(dice1 + dice2 == 7){
            this.result = "You win!!!";
        }
        else {
            this.result = "You Lose!!";
        }
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

}