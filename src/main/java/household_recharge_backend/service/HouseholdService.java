package household_recharge_backend.service;

import household_recharge_backend.model.Household;
import household_recharge_backend.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    // Create a household
    public Household createHousehold(
            String householdName,
            String authId
    ) {

        Household household = new Household();
        household.setAuthId(authId);
        household.setHouseholdName(householdName);

        return householdRepository.save(household);
    }

    public List<Household> getHouseholdsByAuthId(String authId) {

        return householdRepository.findByAuthId(authId);
    }

    // Get household by ID
    public Household getHouseholdById(String householdId) {
        return householdRepository.findById(householdId)
                .orElseThrow(() ->
                        new RuntimeException("Household not found"));
    }
}