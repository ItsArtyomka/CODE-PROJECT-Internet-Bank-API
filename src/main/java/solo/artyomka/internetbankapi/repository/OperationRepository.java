package solo.artyomka.internetbankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.artyomka.internetbankapi.entity.Operation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringDataMethodInconsistencyInspection")
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @SuppressWarnings("NullableProblems")
    Optional<Operation> findById(Long id);

    List<Operation> findByIdAddedAtBetween(Long id, LocalDate addedAtStart, LocalDate addedAtEnd);
}
