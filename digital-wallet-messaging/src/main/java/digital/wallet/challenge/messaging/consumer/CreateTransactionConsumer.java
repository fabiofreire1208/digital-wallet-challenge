package digital.wallet.challenge.messaging.consumer;

import digital.wallet.challenge.core.business.AccountProcessSagaCallbackPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.core.persistence.AccountRepositoryPort;
import digital.wallet.challenge.core.persistence.TransactionRepositoryPort;
import digital.wallet.challenge.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CreateTransactionConsumer {
    private final JsonUtil jsonUtil;
    private final TransactionRepositoryPort transactionRepositoryPort;
    private final AccountProcessSagaCallbackPort processSagaCallbackPort;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.notify-ending}"
    )

    public void consumeTransactionEvent(String payload) {
        log.info("Receiving event {} from notify-ending topic", payload);
        var event = jsonUtil.toEvent(payload);
        transactionRepositoryPort.save(event);

        final Context context = new Context();
        context.setData(event);

        processSagaCallbackPort.process(context);
    }
}
