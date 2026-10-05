package household_recharge_backend.dto;

public class InvitationRequest {

    private String householdId;

    public InvitationRequest() {
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }
}