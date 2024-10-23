package digital.wallet.challenge.persistence.mappers;

import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.domain.Client;
import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.persistence.model.AccountEntity;
import digital.wallet.challenge.persistence.model.ClientEntity;
import digital.wallet.challenge.persistence.model.TransactionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {

    @Mapping(source = "id", target = "id")
    Client from(final ClientEntity source);
    ClientEntity from(final Client source);

    @Mapping(source = "id", target = "id")
    Account from(final AccountEntity source);
    AccountEntity from(final Account source);

    Transaction from(final TransactionEntity source);
    TransactionEntity from(final Transaction source);
}
