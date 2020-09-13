package telran.ashkelon2020.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
