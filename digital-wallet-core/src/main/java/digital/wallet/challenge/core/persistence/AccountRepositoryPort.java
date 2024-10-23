package digital.wallet.challenge.core.persistence;

import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.Client;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryPort {

    Account save(final Account obj);
    Optional<Account> get(final UUID id);

    Optional<Account> getByAccountNumber(final String accountNumber);
}
