package household_recharge_backend.controller;

import household_recharge_backend.model.MobileNumber;
import household_recharge_backend.service.MobileNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile-numbers")
public class MobileNumberController {

    private final MobileNumberService mobileNumberService;

    public MobileNumberController(
            MobileNumberService mobileNumberService
    ) {
        this.mobileNumberService = mobileNumberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MobileNumber addMobileNumber(
            @RequestBody MobileNumber mobileNumber
    ) {

        return mobileNumberService.addMobileNumber(
                mobileNumber
        );
    }

    @GetMapping
    public List<MobileNumber> getAllMobileNumbers() {

        return mobileNumberService.getAllMobileNumbers();
    }

    @GetMapping("/household/{householdId}")
    public List<MobileNumber> getByHousehold(
            @PathVariable String householdId
    ) {

        return mobileNumberService.getByHouseholdId(
                householdId
        );
    }

    @GetMapping("/account/{accountId}")
    public List<MobileNumber> getByAccount(
            @PathVariable String accountId
    ) {

        return mobileNumberService.getByAccountId(
                accountId
        );
    }

    @GetMapping("/{id}")
    public MobileNumber getById(
            @PathVariable String id
    ) {

        return mobileNumberService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id
    ) {

        mobileNumberService.delete(id);
    }
}