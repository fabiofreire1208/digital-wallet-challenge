package digital.wallet.challenge.core.business;

import digital.wallet.challenge.core.command.Command;
import digital.wallet.challenge.domain.Client;

import java.util.Optional;

public interface ClientCreationPort extends Command<Optional<Client>> {

}
