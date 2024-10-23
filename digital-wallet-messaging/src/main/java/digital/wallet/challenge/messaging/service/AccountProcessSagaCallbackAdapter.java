package digital.wallet.challenge.messaging.service;

import digital.wallet.challenge.core.business.AccountProcessSagaCallbackPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.core.persistence.AccountRepositoryPort;
import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.domain.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountProcessSagaCallbackAdapter implements AccountProcessSagaCallbackPort {
    private final AccountRepositoryPort accountRepositoryPort;

    @Autowired
    public AccountProcessSagaCallbackAdapter(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<Transaction> process(Context context) {
        final Transaction transaction = context.getData(Transaction.class);

        if(TransactionStatus.CONFIRMED.equals(transaction.getStatus())) {

            accountRepositoryPort.save(transaction.getAccountFrom());
            accountRepositoryPort.save(transaction.getAccountTo());
        }

        return Optional.of(transaction);

    }

}
