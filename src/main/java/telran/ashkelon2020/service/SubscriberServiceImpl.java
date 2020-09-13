package telran.ashkelon2020.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.dao.AccountRepository;
import telran.ashkelon2020.dao.CustomerRepository;
import telran.ashkelon2020.dao.SubscriberRepository;
import telran.ashkelon2020.dto.SubscriberDto;
import telran.ashkelon2020.dto.exceptions.AccountNotFoundException;
import telran.ashkelon2020.dto.exceptions.SubsciberExistsException;
import telran.ashkelon2020.dto.exceptions.SubscriberNotFoundExceprion;
import telran.ashkelon2020.model.Account;
import telran.ashkelon2020.model.Subscriber;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public SubscriberDto addSubscriber(String accountSubscriberName, String sex, LocalDate birthDate, String country, String email) {
		if(subscriberRepository.existsById(accountSubscriberName)) {
			throw new SubsciberExistsException(accountSubscriberName);
		}
		Subscriber subscriber = new Subscriber(accountSubscriberName, sex, birthDate, country, email);

		return modelMapper.map(subscriberRepository.save(subscriber), SubscriberDto.class);
	}

	@Override
	@Transactional
	public SubscriberDto subscribe(String subscriberName, String subscriptionName) {
		Subscriber subscriber = subscriberRepository.findById(subscriberName).orElseThrow(()->new SubscriberNotFoundExceprion(subscriberName));
		Account account = accountRepository.findById(subscriptionName).orElseThrow(()-> new AccountNotFoundException(subscriptionName));
		subscriber.getSubscriptions().add(account);
		account.getSubscribers().add(subscriber);
		accountRepository.save(account);
		
		return modelMapper.map(subscriberRepository.save(subscriber), SubscriberDto.class);
	}

	@Override
	public SubscriberDto getSubscriber(String accountSubscriberName) {
		Subscriber subscriber = subscriberRepository.findById(accountSubscriberName).orElseThrow(()->new SubscriberNotFoundExceprion(accountSubscriberName));
		return modelMapper.map(subscriber, SubscriberDto.class);
	}

	@Override
	@Transactional
	public SubscriberDto updateSubscriber(String subscriberName, String email) {
		Subscriber subscriber = subscriberRepository.findById(subscriberName).orElseThrow(()->new SubscriberNotFoundExceprion(subscriberName));
		subscriber.setEmail(email);
		return modelMapper.map(subscriberRepository.save(subscriber), SubscriberDto.class);
	}

	@Override
	@Transactional
	public SubscriberDto removeSubscriber(String accountSubscriberName) {
		Subscriber subscriber = subscriberRepository.findById(accountSubscriberName).orElseThrow(()->new SubscriberNotFoundExceprion(accountSubscriberName));
		subscriberRepository.deleteById(accountSubscriberName);
		return modelMapper.map(subscriber, SubscriberDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<SubscriberDto> findSubscribersByEmail(String email) {
		return subscriberRepository.findByEmailLike(email)
				.map(s -> modelMapper.map(s, SubscriberDto.class))
				.collect(Collectors.toList());
	}


	
}
