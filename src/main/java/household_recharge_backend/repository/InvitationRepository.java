package household_recharge_backend.repository;

import household_recharge_backend.model.Invitation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InvitationRepository extends MongoRepository<Invitation, String> {

    List<Invitation> findByInvitedMobileNumber(String invitedMobileNumber);

    List<Invitation> findByHouseholdId(String householdId);
}