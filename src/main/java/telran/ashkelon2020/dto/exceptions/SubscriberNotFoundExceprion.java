package telran.ashkelon2020.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class SubscriberNotFoundExceprion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075182600903092854L;
	
	public SubscriberNotFoundExceprion(String name) {
		super("Subscriber with name " + name + " not found");

	}

}
