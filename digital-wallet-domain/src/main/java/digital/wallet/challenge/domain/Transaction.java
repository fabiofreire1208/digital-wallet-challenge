package digital.wallet.challenge.domain;

import digital.wallet.challenge.domain.enums.TransactionStatus;
import digital.wallet.challenge.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {
    private UUID id;
    private Account accountFrom;
    private Account accountTo;
    private Double amount;
    private TransactionType transactionType;
    private TransactionStatus status;
    private LocalDateTime transactionCreationDate;
    private LocalDateTime transactionUpdateDate;
}
