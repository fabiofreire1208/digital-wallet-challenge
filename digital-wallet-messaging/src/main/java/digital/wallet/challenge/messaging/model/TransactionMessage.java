package digital.wallet.challenge.messaging.model;

import digital.wallet.challenge.domain.enums.TransactionStatus;
import digital.wallet.challenge.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionMessage {
    private UUID accountFromId;
    private UUID accountToId;
    private Double amount;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
}
