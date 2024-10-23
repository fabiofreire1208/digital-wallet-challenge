package digital.wallet.challenge.http.resources.controllers;

import digital.wallet.challenge.core.business.CreateTransactionPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.http.resources.dto.TransactionDto;
import digital.wallet.challenge.http.resources.mappers.TransactionModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/wallet/transaction")
public class TransactionController {
    private final CreateTransactionPort transactionPort;
    private final TransactionModelMapper mapper;

    public TransactionController(CreateTransactionPort transactionPort, TransactionModelMapper mapper) {
        this.transactionPort = transactionPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createTransaction(@RequestBody final TransactionDto body) {
        final Transaction transaction = mapper.from(body);

        final Context context = new Context();
        context.setData(transaction);

        transactionPort.process(context);

        return ResponseEntity.ok().build();
    }
}
