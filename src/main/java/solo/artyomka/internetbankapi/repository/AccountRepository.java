package solo.artyomka.internetbankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.artyomka.internetbankapi.entity.Account;

/*
 * Extending JpaRepository to be able to perform CRUD database operations on Account entity.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
