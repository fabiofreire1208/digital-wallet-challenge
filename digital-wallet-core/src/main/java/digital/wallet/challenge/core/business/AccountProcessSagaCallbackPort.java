package digital.wallet.challenge.core.business;

import digital.wallet.challenge.core.command.Command;
import digital.wallet.challenge.domain.Transaction;

import java.util.Optional;

public interface AccountProcessSagaCallbackPort extends Command<Optional<Transaction>> {
}
