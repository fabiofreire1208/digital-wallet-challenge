package digital.wallet.challenge.http.resources.mappers;

import digital.wallet.challenge.domain.Client;
import digital.wallet.challenge.http.resources.dto.ClientDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ClientModelMapper {

    Client from(final ClientDto source);
}
