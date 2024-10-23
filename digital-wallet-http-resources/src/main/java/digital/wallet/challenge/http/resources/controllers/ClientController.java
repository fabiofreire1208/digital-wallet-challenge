package digital.wallet.challenge.http.resources.controllers;

import digital.wallet.challenge.core.business.ClientCreationPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.domain.Client;
import digital.wallet.challenge.http.resources.dto.ClientDto;
import digital.wallet.challenge.http.resources.mappers.ClientModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/wallet/client")
public class ClientController {
    private final ClientCreationPort clientCreationPort;
    private final ClientModelMapper mapper;

    @Autowired
    public ClientController(ClientCreationPort clientCreationPort, ClientModelMapper mapper) {
        this.clientCreationPort = clientCreationPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createClient(@RequestBody final ClientDto body) {
        final Client client = mapper.from(body);

        final Context context = new Context();
        context.setData(client);

        clientCreationPort.process(context);

        return ResponseEntity.ok().build();

    }
}
