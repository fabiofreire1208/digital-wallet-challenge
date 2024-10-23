package digital.wallet.challenge.processor.adapters;

import digital.wallet.challenge.core.business.CreateTransactionPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.core.messaging.CreateTransactionProducerPort;
import digital.wallet.challenge.core.persistence.AccountRepositoryPort;
import digital.wallet.challenge.core.persistence.TransactionRepositoryPort;
import digital.wallet.challenge.core.utils.JsonUtil;
import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.Client;
import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.domain.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CreateTransactionAdapter implements CreateTransactionPort {
    private final TransactionRepositoryPort transactionRepositoryPort;
    private final CreateTransactionProducerPort createTransactionProducerPort;
    private final AccountRepositoryPort accountRepositoryPort;
    private final JsonUtil jsonUtil;

    @Autowired
    public CreateTransactionAdapter(TransactionRepositoryPort transactionRepositoryPort, CreateTransactionProducerPort createTransactionProducerPort, AccountRepositoryPort accountRepositoryPort, JsonUtil jsonUtil) {
        this.transactionRepositoryPort = transactionRepositoryPort;
        this.createTransactionProducerPort = createTransactionProducerPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.jsonUtil = jsonUtil;
    }

    @Override
    public Optional<Transaction> process(Context context) {
        final Transaction data = context.getData(Transaction.class);
        data.setStatus(TransactionStatus.PENDING);

        final Account accountFrom = accountRepositoryPort.getByAccountNumber(data.getAccountFrom().getAccountNumber()).orElseThrow(
                () -> new RuntimeException("Client not found")
        );

        final Account accountTo = accountRepositoryPort.getByAccountNumber(data.getAccountTo().getAccountNumber()).orElseThrow(
                () -> new RuntimeException("Client not found")
        );
        data.setAccountFrom(accountFrom);
        data.setAccountTo(accountTo);
        data.setTransactionCreationDate(LocalDateTime.now());

        createTransactionProducerPort.send(jsonUtil.toJson(transactionRepositoryPort.save(data)));

        return Optional.of(data);
    }

}
