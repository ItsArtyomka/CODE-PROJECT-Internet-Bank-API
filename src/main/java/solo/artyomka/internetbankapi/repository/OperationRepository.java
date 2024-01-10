package solo.artyomka.internetbankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.artyomka.internetbankapi.entity.Operation;

import java.util.Date;
import java.util.List;

/*
 * Extending JpaRepository to be able to perform CRUD database operations on Account entity.
 * The inheritance allows the Spring Data JPA to generate queries based on method names.
 */

public interface OperationRepository extends JpaRepository<Operation, Long> {
//    List<Operation> findByAccountId(Long accountId);
    List<Operation> findByAccountIdAndDateBetween(Long accountId, Date dateStart, Date dateEnd);
}
