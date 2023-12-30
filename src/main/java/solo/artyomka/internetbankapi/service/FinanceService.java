package solo.artyomka.internetbankapi.service;

// Interface acts as a bridge between the controller and the data access.
public interface FinanceService {
    Long getBalance(Long id);

    Long takeMoney(Long id, Long money);

    Long putMoney(Long id, Long money);
}
