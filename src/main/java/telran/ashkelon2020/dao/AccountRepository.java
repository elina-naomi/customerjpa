package telran.ashkelon2020.dao;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	Stream<Account> findAccountByCustomerIdAndCreateDateBetween(Integer id, LocalDate from, LocalDate to);

}
