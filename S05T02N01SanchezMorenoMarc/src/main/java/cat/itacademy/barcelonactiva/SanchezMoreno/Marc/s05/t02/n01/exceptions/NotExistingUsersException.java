package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NotExistingUsersException extends EntityNotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotExistingUsersException(){
        super("Our users database is empty");
    }
}
