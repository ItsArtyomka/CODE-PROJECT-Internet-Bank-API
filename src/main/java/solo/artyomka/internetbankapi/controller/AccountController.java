package solo.artyomka.internetbankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solo.artyomka.internetbankapi.entity.Account;
import solo.artyomka.internetbankapi.service.AccountService;

import java.util.Map;

/*
 * Exposes the financial logic as RESTful API endpoint for methods:
 * - getAccount()
 * - getBalance()
 * - takeMoney()
 * - putMoney()
 */

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
    }

    @GetMapping("/{id}/balance")
    public double getBalance(@PathVariable Long id) {
        if (id != null) {
            return accountService.getBalance(id);
        } else {
            throw new RuntimeException("Account Not Found");
        }
    }

    @PostMapping("/{id}/withdraw")
    public Account takeMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.takeMoney(id, amount);
    }

    @PostMapping("/{id}/deposit")
    public Account putMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.putMoney(id, amount);
    }
}
