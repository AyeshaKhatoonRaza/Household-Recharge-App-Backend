package household_recharge_backend.controller;

import household_recharge_backend.dto.HouseholdRequest;
import household_recharge_backend.model.Household;
import household_recharge_backend.service.HouseholdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(
            @RequestBody HouseholdRequest request,
            Authentication authentication
    ) {

        String authId = authentication.getName();

        Household household =
                householdService.createHousehold(
                        request.getHouseholdName(),
                        authId
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(household);
    }

    @GetMapping
    public ResponseEntity<List<Household>> getMyHouseholds(
            Authentication authentication
    ) {

        String authId = authentication.getName();

        List<Household> households =
                householdService.getHouseholdsByAuthId(authId);

        return ResponseEntity.ok(households);
    }

    // Get a household by ID
    @GetMapping("/{householdId}")
    public ResponseEntity<Household> getHouseholdById(
            @PathVariable String householdId
    ) {

        Household household =
                householdService.getHouseholdById(householdId);

        return ResponseEntity.ok(household);
    }
}