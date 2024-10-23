package digital.wallet.challenge.persistence.adapters;

import digital.wallet.challenge.core.persistence.ClientRepositoryPort;
import digital.wallet.challenge.domain.Client;
import digital.wallet.challenge.persistence.mappers.PersistenceEntityMapper;
import digital.wallet.challenge.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final ClientRepository clientRepository;
    private final PersistenceEntityMapper mapper;

    @Autowired
    public ClientRepositoryAdapter(ClientRepository clientRepository, PersistenceEntityMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public Client save(Client obj) {
        return mapper.from(clientRepository.save(mapper.from(obj)));
    }

    @Override
    public Optional<Client> get(UUID id) {
        Client client = clientRepository.findById(id)
                .map(mapper::from)
                .orElse(null);
        return Objects.nonNull(client) ? Optional.of(client) : Optional.empty();
    }

    @Override
    public Optional<Client> getByDocument(String document) {
        Client client = clientRepository.findByDocument(document)
                .map(mapper::from)
                .orElse(null);
        return Objects.nonNull(client) ? Optional.of(client) : Optional.empty();
    }
}
