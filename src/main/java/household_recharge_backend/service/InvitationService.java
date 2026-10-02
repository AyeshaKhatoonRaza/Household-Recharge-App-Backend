package household_recharge_backend.service;

import household_recharge_backend.model.Household;
import household_recharge_backend.model.Invitation;
import household_recharge_backend.model.User;
import household_recharge_backend.repository.HouseholdRepository;
import household_recharge_backend.repository.InvitationRepository;
import household_recharge_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final HouseholdRepository householdRepository;
    private final UserRepository userRepository;

    public InvitationService(
            InvitationRepository invitationRepository,
            HouseholdRepository householdRepository,
            UserRepository userRepository
    ) {
        this.invitationRepository = invitationRepository;
        this.householdRepository = householdRepository;
        this.userRepository = userRepository;
    }

    public Invitation createInvitation(
            String householdId,
            String invitedMobileNumber,
            String invitedByUserId
    ) {

        Invitation invitation = new Invitation(
                householdId,
                invitedMobileNumber,
                invitedByUserId,
                "PENDING"
        );

        return invitationRepository.save(invitation);
    }

    public Invitation acceptInvitation(
            String invitationId,
            String userId
    ) {

        // Find invitation
        Invitation invitation = invitationRepository
                .findById(invitationId)
                .orElseThrow(() ->
                        new RuntimeException("Invitation not found"));

        // Check invitation status
        if (!"PENDING".equals(invitation.getStatus())) {
            throw new RuntimeException("Invitation is no longer pending");
        }

        // Find logged-in user
        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Verify this invitation belongs to the logged-in user
        if (!user.getMobileNumber()
                .equals(invitation.getInvitedMobileNumber())) {

            throw new RuntimeException(
                    "You are not authorized to accept this invitation"
            );
        }

        // Find household
        Household household = householdRepository
                .findById(invitation.getHouseholdId())
                .orElseThrow(() ->
                        new RuntimeException("Household not found"));

        // Add user if they are not already a member
        if (!household.getMemberIds().contains(userId)) {
            household.getMemberIds().add(userId);
            householdRepository.save(household);
        }

        // Update invitation status
        invitation.setStatus("ACCEPTED");

        return invitationRepository.save(invitation);
    }
}