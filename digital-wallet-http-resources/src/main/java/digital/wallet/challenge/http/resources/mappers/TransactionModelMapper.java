package digital.wallet.challenge.http.resources.mappers;

import digital.wallet.challenge.domain.Transaction;
import digital.wallet.challenge.http.resources.dto.TransactionDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface TransactionModelMapper {

    Transaction from(final TransactionDto source);
}
