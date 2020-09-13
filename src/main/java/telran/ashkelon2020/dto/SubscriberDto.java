package telran.ashkelon2020.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriberDto {
	
	String subscriberName;
	String sex;
	LocalDate birthDate;
	String country;
	String email;
	Set<AccountSubDto> subscriptions;

}
