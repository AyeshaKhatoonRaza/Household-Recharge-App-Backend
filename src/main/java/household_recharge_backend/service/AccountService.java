package household_recharge_backend.service;

import household_recharge_backend.model.Account;
import household_recharge_backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    public List<Account> getByHouseholdId(
            String householdId
    ) {

        return accountRepository.findByHouseholdId(
                householdId
        );
    }

    public Account getById(String accountId) {

        return accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Account not found"
                        ));
    }

    public void delete(String accountId) {

        if (!accountRepository.existsById(accountId)) {
            throw new RuntimeException(
                    "Account not found"
            );
        }

        accountRepository.deleteById(accountId);
    }
}