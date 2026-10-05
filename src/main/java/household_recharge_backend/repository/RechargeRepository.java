package household_recharge_backend.repository;

import household_recharge_backend.model.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RechargeRepository
        extends MongoRepository<Recharge, String> {

    List<Recharge> findByHouseholdId(String householdId);

    List<Recharge> findByAccountId(String accountId);

    List<Recharge> findByMobileNumber(String mobileNumber);
}