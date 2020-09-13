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
public class AccountDto {
	String accountName;
	LocalDate createDate;
	String email;
	Set<SubscriberSubDto> subscribers;
}
