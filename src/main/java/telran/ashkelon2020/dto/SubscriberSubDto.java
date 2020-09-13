package telran.ashkelon2020.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriberSubDto {
	String subscriberName;
	String sex;
	LocalDate birthDate;
	String country;
	String email;

}
