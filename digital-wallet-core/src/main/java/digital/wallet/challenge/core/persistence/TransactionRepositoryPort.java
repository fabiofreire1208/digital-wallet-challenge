package digital.wallet.challenge.core.persistence;

import digital.wallet.challenge.domain.Transaction;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepositoryPort {

    Transaction save(final Transaction obj);

    Optional<Transaction> get(final UUID id);
}
