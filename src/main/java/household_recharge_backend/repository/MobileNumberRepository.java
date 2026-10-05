package household_recharge_backend.repository;

import household_recharge_backend.model.MobileNumber;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MobileNumberRepository
        extends MongoRepository<MobileNumber, String> {

    List<MobileNumber> findByHouseholdId(String householdId);

    List<MobileNumber> findByAccountId(String accountId);
}