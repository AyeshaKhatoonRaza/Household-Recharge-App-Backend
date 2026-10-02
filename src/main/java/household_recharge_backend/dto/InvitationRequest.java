package household_recharge_backend.dto;

public class InvitationRequest {

    private String householdId;
    private String invitedMobileNumber;

    public InvitationRequest() {
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
}