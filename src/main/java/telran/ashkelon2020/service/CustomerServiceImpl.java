package telran.ashkelon2020.service;

import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.dao.CustomerRepository;
import telran.ashkelon2020.dto.CustomerDto;
import telran.ashkelon2020.dto.exceptions.CustomerExistsException;
import telran.ashkelon2020.dto.exceptions.CustomerNotFoundException;
import telran.ashkelon2020.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountService AccountService;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public CustomerDto addCustomer(Integer id, String name) {
		if(customerRepository.existsById(id)) {
			throw new CustomerExistsException(id);
		}
		Customer customer = new Customer(id, name);
		customerRepository.save(customer);
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public CustomerDto findCustomer(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	@Transactional
	public CustomerDto updateCustomer(Integer id, String name) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
		customer.setName(name);
		return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
	}

	@Override
	@Transactional
	public CustomerDto deleteCustomer(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
		customer.getAccounts().stream().forEach(a -> AccountService.deleteAccount(a.getAccountName()));
		customerRepository.deleteById(id);
		return modelMapper.map(customer, CustomerDto.class);
	}
	

}
