package household_recharge_backend.repository;

import household_recharge_backend.model.Household;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HouseholdRepository extends MongoRepository<Household, String> {

    List<Household> findByOwnerId(String ownerId);
}