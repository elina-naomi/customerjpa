package telran.ashkelon2020.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"accountName"})
@Entity
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6588655220739257478L;
	@Id
	String accountName;
	@ManyToOne
	Customer customer;
	LocalDate createDate = LocalDate.now();
	String email;
	@ManyToMany(mappedBy = "subscriptions")
	Set<Subscriber> subscribers = new HashSet<>(); //подписчики
	
	public Account(String accountName, Customer customer, String email) {
		this.accountName = accountName;
		this.customer = customer;
		this.email = email;
	}
	
}
