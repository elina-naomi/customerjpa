package telran.ashkelon2020.service;

import telran.ashkelon2020.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto addCustomer(Integer id, String name);
	
	CustomerDto findCustomer(Integer id);
	
	CustomerDto updateCustomer(Integer id, String name);
	
	CustomerDto deleteCustomer(Integer id);

}
