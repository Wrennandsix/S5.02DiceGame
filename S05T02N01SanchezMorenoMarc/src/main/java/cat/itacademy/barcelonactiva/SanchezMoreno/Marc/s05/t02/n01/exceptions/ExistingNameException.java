package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ExistingNameException extends EntityNotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistingNameException(){
        super("The name is already in use.");
    }
}
