package telran.ashkelon2020.service;

import java.time.LocalDate;

import telran.ashkelon2020.dto.SubscriberDto;

public interface SubscriberService {
	
	SubscriberDto addSubscriber(String accountSubscriberName, String sex, LocalDate birthDate, String country,String email);
	
	SubscriberDto subscribe(String subscriberName, String subscriptionName);
	
	SubscriberDto getSubscriber(String accountSubscriberName);
	
	SubscriberDto updateSubscriber(String subscriberName, String email);
	
	SubscriberDto removeSubscriber(String accountSubscriberName);
	
	Iterable<SubscriberDto> findSubscribersByEmail(String email);

}
