package telran.ashkelon2020.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AccountExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7374501480991934950L;
	
	public AccountExistsException(String accountName) {
		super("Account with name " + accountName + " exists");

	}
	

}
