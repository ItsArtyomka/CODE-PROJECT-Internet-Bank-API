package solo.artyomka.internetbankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.artyomka.internetbankapi.entity.Account;
import solo.artyomka.internetbankapi.entity.Operation;
import solo.artyomka.internetbankapi.repository.AccountRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/*
 * This code contains the main financial logic methods.
 */
@Service
public class AccountService {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private AccountRepository accountRepository;

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

    // Returns list of the account's operations within certain date period
    public List<Operation> getOperationList(Long id, Date startDate, Date endDate) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        // I'M STUCK HERE!!!!
        return null; // TO GET RID OF THE ERROR
    }
}
