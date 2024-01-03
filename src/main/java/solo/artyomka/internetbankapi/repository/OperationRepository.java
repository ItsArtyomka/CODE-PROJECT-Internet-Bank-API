package solo.artyomka.internetbankapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import solo.artyomka.internetbankapi.entity.Operation;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("CommentedOutCode")
public interface OperationRepository extends Repository<Operation, Long> {

//    Optional<Operation> findById(Long id);

//    @Query("SELECT o.operation FROM Operation o WHERE o.id = :id")
//    Optional<Integer> findOperationById(@Param("id") Long id);

    @Query("SELECT o.operation FROM Operation o WHERE o.id = :account_id")
    List<Operation> findOperationByAccount_id(@Param("account_id") Long id);

    @Query("SELECT o.operation FROM Operation o WHERE o.id = :account_id")
    List<Operation> findOperationsByAccount_idAddedAtBetween(@Param("account_id") Long id, LocalDate addedAtStart, LocalDate addedAtEnd);

    @Query("SELECT o.operation FROM Operation o WHERE o.id = :account_id")
    List<Operation> findOperationsByAccount_idAddedAfter(@Param("account_id") Long id, LocalDate addedAtStart);

    @Query("SELECT o.operation FROM Operation o WHERE o.id = :account_id")
    List<Operation> findOperationsByAccount_idAddedBefore(@Param("account_id") Long id, LocalDate addedAtEnd);

}
