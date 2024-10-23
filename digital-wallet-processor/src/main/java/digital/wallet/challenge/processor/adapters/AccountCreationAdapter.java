package digital.wallet.challenge.processor.adapters;

import digital.wallet.challenge.core.business.AccountCreationPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.core.persistence.AccountRepositoryPort;
import digital.wallet.challenge.core.persistence.ClientRepositoryPort;
import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.Client;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCreationAdapter implements AccountCreationPort {
    private final AccountRepositoryPort accountRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    @Autowired
    public AccountCreationAdapter(AccountRepositoryPort accountRepositoryPort, ClientRepositoryPort clientRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Account> process(Context context) {
        final Account data = context.getData(Account.class);
        data.setAccountNumber(RandomStringUtils.randomNumeric(9));
        final Client client = clientRepositoryPort.getByDocument(data.getClient().getDocument()).orElseThrow(
                () -> new RuntimeException("Client not found")
        );

        data.setClient(client);
        return Optional.ofNullable(accountRepositoryPort.save(data));
    }
}
