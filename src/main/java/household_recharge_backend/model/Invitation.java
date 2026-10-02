package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invitations")
public class Invitation {

    @Id
    private String id;

    private String householdId;

    private String invitedMobileNumber;

    private String invitedByUserId;

    private String status;

    public Invitation() {
    }

    public Invitation(
            String householdId,
            String invitedMobileNumber,
            String invitedByUserId,
            String status
    ) {
        this.householdId = householdId;
        this.invitedMobileNumber = invitedMobileNumber;
        this.invitedByUserId = invitedByUserId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getInvitedMobileNumber() {
        return invitedMobileNumber;
    }

    public void setInvitedMobileNumber(String invitedMobileNumber) {
        this.invitedMobileNumber = invitedMobileNumber;
    }

    public String getInvitedByUserId() {
        return invitedByUserId;
    }

    public void setInvitedByUserId(String invitedByUserId) {
        this.invitedByUserId = invitedByUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}