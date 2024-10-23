package digital.wallet.challenge.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private String accountNumber;
    @JsonAlias(value = "client_info")
    private ClientDto clientInfo;
    private Double balance;
}
