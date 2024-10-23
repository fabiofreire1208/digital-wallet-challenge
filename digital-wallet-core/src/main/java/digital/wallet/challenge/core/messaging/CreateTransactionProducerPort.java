package digital.wallet.challenge.core.messaging;

import digital.wallet.challenge.domain.Transaction;

public interface CreateTransactionProducerPort {
    void send(final String transaction);
}
