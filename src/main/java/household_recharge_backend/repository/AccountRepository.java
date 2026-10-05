package household_recharge_backend.repository;

import household_recharge_backend.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository
        extends MongoRepository<Account, String> {

    List<Account> findByHouseholdId(String householdId);
}