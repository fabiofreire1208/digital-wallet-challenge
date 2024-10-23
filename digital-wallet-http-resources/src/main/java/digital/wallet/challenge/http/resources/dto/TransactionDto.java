package digital.wallet.challenge.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import digital.wallet.challenge.domain.enums.TransactionStatus;
import digital.wallet.challenge.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {
    private AccountDto accountFrom;
    private AccountDto accountTo;
    private Double amount;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
}
