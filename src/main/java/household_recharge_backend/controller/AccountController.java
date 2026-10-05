package household_recharge_backend.controller;

import household_recharge_backend.model.Account;
import household_recharge_backend.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(
            @RequestBody Account account
    ) {

        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAll() {

        return accountService.getAllAccounts();
    }

    @GetMapping("/household/{householdId}")
    public List<Account> getByHousehold(
            @PathVariable String householdId
    ) {

        return accountService.getByHouseholdId(
                householdId
        );
    }

    @GetMapping("/{accountId}")
    public Account getById(
            @PathVariable String accountId
    ) {

        return accountService.getById(accountId);
    }

    @DeleteMapping("/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String accountId
    ) {

        accountService.delete(accountId);
    }
}