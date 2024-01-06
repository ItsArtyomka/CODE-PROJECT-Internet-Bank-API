package solo.artyomka.internetbankapi.repository;

import org.springframework.data.repository.Repository;
import solo.artyomka.internetbankapi.entity.Operation;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("SpringDataMethodInconsistencyInspection")
public interface OperationRepository extends Repository<Operation, Long> {

    List<Operation> findOperationByAccount_id(Long id);

    List<Operation> findOperationsByAccount_idAddedAtBetween(Long id, LocalDate addedAtStart, LocalDate addedAtEnd);

    List<Operation> findOperationsByAccount_idAddedAfter(Long id, LocalDate addedAtStart);

    List<Operation> findOperationsByAccount_idAddedBefore(Long id, LocalDate addedAtEnd);

}
