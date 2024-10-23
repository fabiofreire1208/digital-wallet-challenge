package digital.wallet.challenge.persistence.adapters;

import digital.wallet.challenge.core.persistence.AccountRepositoryPort;
import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.persistence.mappers.PersistenceEntityMapper;
import digital.wallet.challenge.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepositoryAdapter implements AccountRepositoryPort {
    private final AccountRepository accountRepository;
    private final PersistenceEntityMapper mapper;

    @Autowired
    public AccountRepositoryAdapter(AccountRepository accountRepository, PersistenceEntityMapper mapper) {
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    public Account save(Account obj) {
        return mapper.from(accountRepository.save(mapper.from(obj)));
    }

    @Override
    public Optional<Account> get(UUID id) {
        Account account = accountRepository.findById(id)
                .map(mapper::from)
                .orElse(null);
        return Objects.nonNull(account) ? Optional.of(account) : Optional.empty();
    }

    @Override
    public Optional<Account> getByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByaccountNumber(accountNumber)
                .map(mapper::from)
                .orElse(null);
        return Objects.nonNull(account) ? Optional.of(account) : Optional.empty();
    }
}
