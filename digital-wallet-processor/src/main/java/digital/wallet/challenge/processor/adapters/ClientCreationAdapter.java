package digital.wallet.challenge.processor.adapters;

import digital.wallet.challenge.core.business.ClientCreationPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.core.persistence.ClientRepositoryPort;
import digital.wallet.challenge.domain.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCreationAdapter implements ClientCreationPort {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientCreationAdapter(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> process(Context context) {
        final Client data = context.getData(Client.class);

        return Optional.ofNullable(clientRepositoryPort.save(data));
    }
}
