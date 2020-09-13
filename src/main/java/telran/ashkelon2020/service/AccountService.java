package telran.ashkelon2020.service;

import java.time.LocalDate;

import telran.ashkelon2020.dto.AccountDto;

public interface AccountService {
	
	AccountDto addAccount(Integer customerId, String accountName, String email);
	
	AccountDto getAccount(String accountName);
	
	AccountDto updateAccount(String accountName, String email);
	
	AccountDto deleteAccount(String accountName);
	
	Iterable<AccountDto> findAccountsByCreateDate(Integer customerId, LocalDate from, LocalDate to);


}
