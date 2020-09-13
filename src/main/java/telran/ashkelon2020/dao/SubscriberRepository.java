package telran.ashkelon2020.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.ashkelon2020.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
	
	@Query("SELECT s FROM Subscriber s WHERE s.email LIKE CONCAT('%',:email,'%')")
	Stream<Subscriber> findByEmailLike(@Param("email") String email);

}
