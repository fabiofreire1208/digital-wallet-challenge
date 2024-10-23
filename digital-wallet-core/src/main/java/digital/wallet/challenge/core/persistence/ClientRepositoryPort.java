package digital.wallet.challenge.core.persistence;

import digital.wallet.challenge.domain.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {

    Client save(final Client obj);
    Optional<Client> get(final UUID id);
    Optional<Client> getByDocument(final String document);
}
