package telran.ashkelon2020.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"subscriberName"})
@Entity
public class Subscriber implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8570756589457743021L;
	@Id
	String subscriberName;
	String sex;
	LocalDate birthDate;
	String country;
	String email;

	@ManyToMany
	@JoinTable(
			name = "SUBSCRIBER_ACCOUNTS",
					joinColumns = @JoinColumn(name = "SUBSCRIBER_SUBSCRIBERNAME"),
					inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTIONS_ACCOUNTNAME")
			)
	Set<Account> subscriptions = new HashSet<>(); //подписки

	public Subscriber(String subscriberName, String sex, LocalDate birthDate, String country, String email) {
		this.subscriberName = subscriberName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.country = country;
		this.email = email;
	}
	
	

	
	
	
	
	
	
	
	
	

}
