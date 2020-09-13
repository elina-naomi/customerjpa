package telran.ashkelon2020.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8075537925779092592L;
	
	public AccountNotFoundException(String accountName) {
		super("Account with name " + accountName + " not found");
	}

}
