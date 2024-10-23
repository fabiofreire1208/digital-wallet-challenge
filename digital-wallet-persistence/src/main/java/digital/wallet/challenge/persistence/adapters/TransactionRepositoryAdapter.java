package digital.wallet.challenge.persistence.adapters;

import digital.wallet.challenge.core.persistence.TransactionRepositoryPort;
import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.persistence.mappers.PersistenceEntityMapper;
import digital.wallet.challenge.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {
    private final TransactionRepository transactionRepository;
    private final PersistenceEntityMapper mapper;

    @Autowired
    public TransactionRepositoryAdapter(TransactionRepository transactionRepository, PersistenceEntityMapper mapper) {
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
    }

    @Override
    public Transaction save(Transaction obj) {
        return mapper.from(transactionRepository.save(mapper.from(obj)));
    }

    @Override
    public Optional<Transaction> get(UUID id) {
        return Optional.empty();
    }

}
