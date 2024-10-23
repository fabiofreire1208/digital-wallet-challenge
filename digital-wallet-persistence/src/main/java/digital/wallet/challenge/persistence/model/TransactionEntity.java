package digital.wallet.challenge.persistence.model;

import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.enums.TransactionStatus;
import digital.wallet.challenge.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_from_id", referencedColumnName = "id")
    private AccountEntity accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to_id", referencedColumnName = "id")
    private AccountEntity accountTo;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private TransactionStatus status;

    private LocalDateTime transactionCreationDate = LocalDateTime.now();

    private LocalDateTime transactionUpdateDate;
}
