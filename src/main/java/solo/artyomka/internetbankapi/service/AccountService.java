package solo.artyomka.internetbankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.artyomka.internetbankapi.entity.Account;
import solo.artyomka.internetbankapi.entity.Operation;
import solo.artyomka.internetbankapi.repository.AccountRepository;
import solo.artyomka.internetbankapi.repository.OperationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*
 * This code contains the main financial logic methods.
 */
@SuppressWarnings("CommentedOutCode")
@Service
public class AccountService {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private AccountRepository accountRepository;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private OperationRepository operationRepository;

//    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
//    @Autowired
//    private OperationRepository operationRepository;

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
    public List<Operation> getOperationsList(Long id, LocalDate startDate, LocalDate endDate) {
//        // Maybe this is more simple than I thought...
//        if (startDate != null && endDate != null) {
//            return operationRepository.findByIdAddedAtBetween(id, startDate, endDate);
//        } else if (startDate != null) {
//            return operationRepository.findByIdAddedAfter(id, startDate);
//        } else if (endDate != null){
//            return operationRepository.findByIdAddedBefore(id, endDate);
//        } else {
//            return operationRepository.findById(id).stream().toList();
//        }
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        return operationRepository.findByIdAddedAtBetween(account.getId(), startDate, endDate);
    }

}
