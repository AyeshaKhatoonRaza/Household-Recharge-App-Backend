package household_recharge_backend.controller;

import household_recharge_backend.dto.InvitationRequest;
import household_recharge_backend.model.Invitation;
import household_recharge_backend.service.InvitationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invitations")
public class InvitationController {

    private final InvitationService invitationService;

    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping
    public ResponseEntity<Invitation> createInvitation(
            @RequestBody InvitationRequest request,
            Authentication authentication
    ) {

        String invitedByUserId = authentication.getName();

        Invitation invitation = invitationService.createInvitation(
                request.getHouseholdId(),
                request.getInvitedMobileNumber(),
                invitedByUserId
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(invitation);
    }

    @PostMapping("/{invitationId}/accept")
    public ResponseEntity<Invitation> acceptInvitation(
            @PathVariable String invitationId,
            Authentication authentication
    ) {

        String userId = authentication.getName();

        Invitation invitation = invitationService.acceptInvitation(
                invitationId,
                userId
        );

        return ResponseEntity.ok(invitation);
    }
}