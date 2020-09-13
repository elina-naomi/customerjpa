package telran.ashkelon2020.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1999728297391451943L;
	@Id
	Integer id;
	String name;
	@OneToMany(mappedBy = "customer")
	Set<Account> accounts = new HashSet<>();
	
	public Customer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
	
	
	

}
