package solo.artyomka.internetbankapi.repository;

import org.springframework.data.repository.Repository;
import solo.artyomka.internetbankapi.entity.Operation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface OperationRepository extends Repository<Operation, Long> {

    // List<Operation> findOperationsByAddedAtBetween(LocalDate addedAtStart, LocalDate addedAtEnd);

    Collection<Object> getOperation(Long id);
}
