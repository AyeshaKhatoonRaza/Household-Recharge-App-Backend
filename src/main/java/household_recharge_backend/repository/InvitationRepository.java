package household_recharge_backend.repository;

import household_recharge_backend.model.Invitation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InvitationRepository
        extends MongoRepository<Invitation, String> {

    Optional<Invitation> findByCode(String code);

    List<Invitation> findByHouseholdId(String householdId);

    List<Invitation> findByCreatedBy(String createdBy);
}