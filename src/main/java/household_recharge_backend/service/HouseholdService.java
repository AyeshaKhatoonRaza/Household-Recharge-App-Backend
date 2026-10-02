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
    public Household createHousehold(String name, String ownerId) {

        Household household = new Household(name, ownerId);

        return householdRepository.save(household);
    }

    // Get all households owned by a user
    public List<Household> getHouseholdsByOwnerId(String ownerId) {
        return householdRepository.findByOwnerId(ownerId);
    }

    // Get household by ID
    public Household getHouseholdById(String householdId) {
        return householdRepository.findById(householdId)
                .orElseThrow(() ->
                        new RuntimeException("Household not found"));
    }
}