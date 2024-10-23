package digital.wallet.challenge.http.resources.mappers;

import digital.wallet.challenge.domain.Account;
import digital.wallet.challenge.http.resources.dto.AccountDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface AccountModelMapper {

    @Mapping(source = "clientInfo.document", target = "client.document")
    Account from(final AccountDto source);
}
