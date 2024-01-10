package solo.artyomka.internetbankapi.service;

import org.springframework.stereotype.Service;
import solo.artyomka.internetbankapi.entity.Account;
import solo.artyomka.internetbankapi.entity.Operation;
import solo.artyomka.internetbankapi.repository.AccountRepository;
import solo.artyomka.internetbankapi.repository.OperationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;



/*
 * This class contains the business logic, acting as an intermediary between the controllers and the repositories.
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    public AccountService(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    // Adds new account to the database
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get the account's details by ID
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    // Get the current balance of the user's account
    public double getBalance(Long id) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        return account.getBalance();
    }

    // withdraw of an amount from an account
    public Account takeMoney(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    // Deposit of an amount into an account
    public Account putMoney(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    // Get the  list of the operation done by the account
    public List<Operation> getOperationList(Long id, Date startDate, Date endDate) {
        return operationRepository.findByAccountIdAndDateBetween(id, startDate, endDate);
    }
}
