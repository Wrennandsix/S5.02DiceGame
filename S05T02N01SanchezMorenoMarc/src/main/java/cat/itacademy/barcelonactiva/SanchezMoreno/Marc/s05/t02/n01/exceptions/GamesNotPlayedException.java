package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions;

import java.util.NoSuchElementException;

public class GamesNotPlayedException extends NoSuchElementException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamesNotPlayedException(){
        super("Any game recorded in our data base");
    }
}