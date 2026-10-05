package household_recharge_backend.controller;

import household_recharge_backend.model.Recharge;
import household_recharge_backend.service.RechargeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(
            RechargeService rechargeService
    ) {
        this.rechargeService = rechargeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recharge create(
            @RequestBody Recharge recharge
    ) {

        return rechargeService.createRecharge(recharge);
    }

    @GetMapping
    public List<Recharge> getAll() {

        return rechargeService.getAllRecharges();
    }

    @GetMapping("/household/{householdId}")
    public List<Recharge> getByHousehold(
            @PathVariable String householdId
    ) {

        return rechargeService.getByHouseholdId(
                householdId
        );
    }

    @GetMapping("/account/{accountId}")
    public List<Recharge> getByAccount(
            @PathVariable String accountId
    ) {

        return rechargeService.getByAccountId(
                accountId
        );
    }

    @GetMapping("/mobile/{mobileNumber}")
    public List<Recharge> getByMobileNumber(
            @PathVariable String mobileNumber
    ) {

        return rechargeService.getByMobileNumber(
                mobileNumber
        );
    }

    @GetMapping("/{id}")
    public Recharge getById(
            @PathVariable String id
    ) {

        return rechargeService.getById(id);
    }
}