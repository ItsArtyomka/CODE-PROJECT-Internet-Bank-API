package solo.artyomka.internetbankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.artyomka.internetbankapi.entity.BankRepository;

@Service
public class FinanceServiceImplementation implements FinanceService {

    @Override
    public Long getBalance(Long id) {
        if (id != null) {
            return getBalance(id);
        }
        return -1L;
    }

    @Override
    public Long takeMoney(Long id, Long money) {
        if (getBalance(id) - money > 0) {
            return 1L;
        }
        System.out.print("Insufficient balance; Error: ");
        return 0L;

    }

    @Override
    public Long putMoney(Long id, Long money) {
        if (money > 0) {
            return 1L;
        }
        System.out.print("Not enough money selected; Error: ");
        return 0L;
    }
}
