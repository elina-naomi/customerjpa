package telran.ashkelon2020.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CustomerExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5116675705802337724L;
	
	public CustomerExistsException(Integer id) {
		super("Customer with id " + id +" exists");

	}

}
