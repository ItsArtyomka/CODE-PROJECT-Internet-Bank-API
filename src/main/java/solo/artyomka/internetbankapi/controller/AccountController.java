package solo.artyomka.internetbankapi.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import solo.artyomka.internetbankapi.entity.Account;
import solo.artyomka.internetbankapi.entity.Operation;
import solo.artyomka.internetbankapi.service.AccountService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * Exposes the financial logic as RESTful API endpoint for methods:
 * - getAccount()
 * - getBalance()
 * - takeMoney()
 * - putMoney()
 */

@RestController
@RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
public class AccountController {
    private AccountService accountService;

    @Transactional
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @Transactional
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
    }

    @Transactional
    @GetMapping("/{id}/balance")
    public double getBalance(@PathVariable Long id) {
        if (id != null) {
            return accountService.getBalance(id);
        } else {
            throw new RuntimeException("Account Not Found");
        }
    }

    @Transactional
    @PostMapping("/{id}/withdraw")
    public Account takeMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.takeMoney(id, amount);
    }

    @Transactional
    @PostMapping("/{id}/deposit")
    public Account putMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.putMoney(id, amount);
    }

    @Transactional
    @PostMapping("/{id}/getOperationList")
    public List<Operation> getOperationList(@PathVariable Long id, @RequestParam Date startDate, @RequestParam Date endDate) {
        return accountService.getOperationList(id, startDate, endDate);
    }
}
