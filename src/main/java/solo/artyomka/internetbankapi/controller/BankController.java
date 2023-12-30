package solo.artyomka.internetbankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solo.artyomka.internetbankapi.entity.Bank;

// Used for handling incoming HTTP requests
@RequestMapping("/api/operations")
@RestController
public class BankController {
    private final Bank bank;

    @Autowired
    public BankController(Bank bank) {
        this.bank = bank;
    }

    // Implementing Endpoints
    @GetMapping("/balance")
    public String getBalance() {
        Long balance = bank.getBalance();
        return "Balance: $" + balance;
    }

    @PutMapping("/{id}")
    public String takeMoney(@PathVariable Long id, Long money) {
        if (id != null && money > 0) {
            if ((bank.getBalance() - money) > 0) {
                return "Money taken: $" + money;
            }
        }
        return "Error: 0";
    }

    @PutMapping("/{id}")
    public String putMoney(@PathVariable Long id, Long money) {
        if (id != null && money > 0) {
            return "Money transferred to the account: $" + money;
        }
        return "Error: 0";
    }
}
