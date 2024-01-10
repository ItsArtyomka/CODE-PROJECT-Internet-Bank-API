package solo.artyomka.internetbankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.artyomka.internetbankapi.entity.Operation;

import java.util.Date;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByAccountId(Long accountId);
    List<Operation> findByAccountIdAndDateBetween(Long accountId, Date dateStart, Date dateEnd);
}
