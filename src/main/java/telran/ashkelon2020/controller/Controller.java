package telran.ashkelon2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.dto.AccountDto;
import telran.ashkelon2020.dto.AccountsByDateDto;
import telran.ashkelon2020.dto.AddAccountDto;
import telran.ashkelon2020.dto.AddCustomerDto;
import telran.ashkelon2020.dto.AddSubscriberDto;
import telran.ashkelon2020.dto.CustomerDto;
import telran.ashkelon2020.dto.SubscriberDto;
import telran.ashkelon2020.service.AccountService;
import telran.ashkelon2020.service.CustomerService;
import telran.ashkelon2020.service.SubscriberService;

@RestController
public class Controller {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	SubscriberService subscriberService;
	
	@PostMapping("/customer")
	public CustomerDto addCustomer(@RequestBody AddCustomerDto addCustomerDto) {
		return customerService.addCustomer(addCustomerDto.getId(), addCustomerDto.getName());
	}
	
	@GetMapping("/customer/{id}")
	public CustomerDto findCustomer(@PathVariable Integer id) {
		return customerService.findCustomer(id);
	}
	
	@PutMapping("/customer/{id}/name/{name}")
	public CustomerDto updateCustomer(@PathVariable Integer id, @PathVariable String name) {
		return customerService.updateCustomer(id, name);
	}
	
	@DeleteMapping("/customer/{id}")
	public CustomerDto deleteCustomer(@PathVariable Integer id) {
		return customerService.deleteCustomer(id);
	}
	
	@PostMapping("/customer/{customerId}/account/") 
	public AccountDto addAccount(@PathVariable Integer customerId, @RequestBody AddAccountDto addAccountDto) {
		return accountService.addAccount(customerId, addAccountDto.getAccountName(), addAccountDto.getEmail());
	}
	
	@GetMapping("/account/{accountName}")
	public AccountDto getAccount(@PathVariable String accountName) {
		return accountService.getAccount(accountName);
	}
	
	@PutMapping("/account/{accountName}/{email}")
	AccountDto updateAccount(@PathVariable String accountName, @PathVariable String email) {
		return accountService.updateAccount(accountName, email);
	}
	
	@DeleteMapping("/account/{accountName}")
	public AccountDto deleteAccount(@PathVariable String accountName) {
		return accountService.deleteAccount(accountName);
	}
	
	@PostMapping("/subscriber/")
	public SubscriberDto subscribe(@RequestBody AddSubscriberDto addSubscriberDto) {
		return subscriberService.addSubscriber(addSubscriberDto.getSubscriberName(), addSubscriberDto.getSex(), 
				addSubscriberDto.getBirthDate(), addSubscriberDto.getCountry(), addSubscriberDto.getEmail());
	}
	
	@PutMapping("/subscriber/{subscriberName}/subscribeto/{subscriptionName}")
	public SubscriberDto subscribe(@PathVariable String subscriberName, @PathVariable String subscriptionName) {
		return subscriberService.subscribe(subscriberName, subscriptionName);
	}
	
	@GetMapping("/subscriber/{subscriberName}")
	public SubscriberDto getSubscriber(@PathVariable String subscriberName) {
		return subscriberService.getSubscriber(subscriberName);
	}
	
	@PutMapping("/subscriber/{subscriberName}/email/{email}")
	public SubscriberDto updateSubscriber(@PathVariable String subscriberName, @PathVariable String email) {
		return subscriberService.updateSubscriber(subscriberName, email);
	}
	
	@DeleteMapping("/subscriber/{subscriberName}")
	public SubscriberDto removeSubscriber(@PathVariable String subscriberName) {
		return subscriberService.removeSubscriber(subscriberName);
	}
	
	@PutMapping("/accounts/period/customer/{customerId}")
	public Iterable<AccountDto> findAccountsByCreateDate(@RequestBody AccountsByDateDto accountByDateDto, @PathVariable Integer customerId) {
		return accountService.findAccountsByCreateDate(customerId, accountByDateDto.getFrom(), accountByDateDto.getTo());
	}
	
	@GetMapping("/subscribers/email/{email}")
	public Iterable<SubscriberDto> findSubscribersByEmail(@PathVariable String email) {
		return subscriberService.findSubscribersByEmail(email);
	}

}
