package digital.wallet.challenge.messaging.producer;

import digital.wallet.challenge.core.messaging.CreateTransactionProducerPort;
import digital.wallet.challenge.domain.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateTransactionProducer implements CreateTransactionProducerPort {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.start-saga}")
    private String startSagaTopic;

    @Override
    public void send(String payload) {
        try {
            log.info("Sending event to topic {} with data {}", startSagaTopic, payload);
            kafkaTemplate.send(startSagaTopic, payload);
        } catch (Exception ex) {
            log.error("Error trying to send data to topic {} with data {}", startSagaTopic, payload, ex);
        }
    }
}
