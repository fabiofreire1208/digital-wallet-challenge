package digital.wallet.challenge.http.resources.controllers;

import digital.wallet.challenge.core.business.AccountCreationPort;
import digital.wallet.challenge.core.command.Context;
import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.http.resources.dto.AccountDto;
import digital.wallet.challenge.http.resources.mappers.AccountModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/wallet/account")
public class AccountController {
    private final AccountCreationPort accountCreationPort;
    private final AccountModelMapper mapper;

    @Autowired
    public AccountController(AccountCreationPort accountCreationPort, AccountModelMapper mapper) {
        this.accountCreationPort = accountCreationPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createAccount(@RequestBody final AccountDto body) {
        final Account account = mapper.from(body);

        final Context context = new Context();
        context.setData(account);

        accountCreationPort.process(context);

        return ResponseEntity.ok().build();
    }
}
