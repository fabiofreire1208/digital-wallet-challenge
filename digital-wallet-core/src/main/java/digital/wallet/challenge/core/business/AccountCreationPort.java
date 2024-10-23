package digital.wallet.challenge.core.business;

import digital.wallet.challenge.core.command.Command;
import digital.wallet.challenge.domain.Account;

import java.util.Optional;

public interface AccountCreationPort extends Command<Optional<Account>> {
}
