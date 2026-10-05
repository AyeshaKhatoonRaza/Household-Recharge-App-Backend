package household_recharge_backend.service;

import household_recharge_backend.model.Invitation;
import household_recharge_backend.repository.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;

    public InvitationService(
            InvitationRepository invitationRepository
    ) {
        this.invitationRepository = invitationRepository;
    }

    public Invitation createInvitation(
            String householdId,
            String createdBy
    ) {

        String code = generateCode();

        long now = System.currentTimeMillis();

        // In   vitation valid for 7 days
        long expiresAt = now + (7L * 24 * 60 * 60 * 1000);

        Invitation invitation = new Invitation();

        invitation.setCode(code);
        invitation.setCreatedAt(now);
        invitation.setCreatedBy(createdBy);
        invitation.setExpiresAt(expiresAt);
        invitation.setHouseholdId(householdId);
        invitation.setStatus("pending");

        return invitationRepository.save(invitation);
    }

    public Optional<Invitation> getByCode(String code) {

        return invitationRepository.findByCode(code);
    }

    public List<Invitation> getByHouseholdId(
            String householdId
    ) {

        return invitationRepository.findByHouseholdId(
                householdId
        );
    }

    public Invitation redeemInvitation(
            String code,
            String usedBy
    ) {

        Invitation invitation =
                invitationRepository.findByCode(code)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invitation not found"
                                ));

        if (!"pending".equalsIgnoreCase(
                invitation.getStatus()
        )) {

            throw new RuntimeException(
                    "Invitation is no longer valid"
            );
        }

        long now = System.currentTimeMillis();

        if (now > invitation.getExpiresAt()) {

            invitation.setStatus("expired");

            invitationRepository.save(invitation);

            throw new RuntimeException(
                    "Invitation has expired"
            );
        }

        invitation.setStatus("used");
        invitation.setUsedAt(now);
        invitation.setUsedBy(usedBy);

        return invitationRepository.save(invitation);
    }

    private String generateCode() {

        return UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();
    }
}