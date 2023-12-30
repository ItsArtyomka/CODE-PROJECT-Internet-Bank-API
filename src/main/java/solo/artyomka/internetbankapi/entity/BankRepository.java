package solo.artyomka.internetbankapi.entity;

import org.springframework.data.jpa.repository.JpaRepository;

// Interfaces used to implement handling CRUD operations.
public interface BankRepository extends JpaRepository<Bank, Long> {}
