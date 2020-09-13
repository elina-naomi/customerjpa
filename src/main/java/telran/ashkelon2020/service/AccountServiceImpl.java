package telran.ashkelon2020.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.dao.AccountRepository;
import telran.ashkelon2020.dao.CustomerRepository;
import telran.ashkelon2020.dto.AccountDto;
import telran.ashkelon2020.dto.exceptions.AccountExistsException;
import telran.ashkelon2020.dto.exceptions.AccountNotFoundException;
import telran.ashkelon2020.dto.exceptions.CustomerNotFoundException;
import telran.ashkelon2020.model.Account;
import telran.ashkelon2020.model.Customer;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public AccountDto addAccount(Integer customerId, String accountName, String email) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException(customerId));
		if(accountRepository.existsById(accountName)) {
			throw new AccountExistsException(accountName);
		}
		Account account = new Account(accountName, customer, email);
		return modelMapper.map(accountRepository.save(account), AccountDto.class);
	}

	@Override
	public AccountDto getAccount(String accountName) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new AccountNotFoundException(accountName));
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	@Transactional
	public AccountDto updateAccount(String accountName, String email) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new AccountNotFoundException(accountName));
		account.setEmail(email);
		return modelMapper.map(accountRepository.save(account), AccountDto.class);
	}

	@Override
	@Transactional
	public AccountDto deleteAccount(String accountName) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new AccountNotFoundException(accountName));
		account.getSubscribers().stream().forEach(s -> s.getSubscriptions().remove(account));
		accountRepository.delete(account);
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<AccountDto> findAccountsByCreateDate(Integer customerId, LocalDate from, LocalDate to) {
		
		return accountRepository.findAccountByCustomerIdAndCreateDateBetween(customerId, from, to)
				.map(a -> modelMapper.map(a, AccountDto.class))
				.collect(Collectors.toList());
	}

}
