package household_recharge_backend.dto;

public class MemberRequest {

    private String householdId;

    private String name;
    private String mobileNumber;
    private Integer planDurationDays;
    private Integer planAmount;

    public MemberRequest() {
    }

    public String getHouseholdId() {
        return householdId;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getPlanDurationDays() {
        return planDurationDays;
    }

    public Integer getPlanAmount() {
        return planAmount;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPlanDurationDays(Integer planDurationDays) {
        this.planDurationDays = planDurationDays;
    }

    public void setPlanAmount(Integer planAmount) {
        this.planAmount = planAmount;
    }
}