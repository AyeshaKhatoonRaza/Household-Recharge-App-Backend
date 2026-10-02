package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {

    @Id
    private String id;

    private String householdId;

    private String name;
    private String mobileNumber;

    private Integer planDurationDays;

    private Long lastRechargeDate;
    private Long planExpiryDate;

    private Integer planAmount;

    public Member() {
    }

    public Member(
            String householdId,
            String name,
            String mobileNumber,
            Integer planDurationDays,
            Long lastRechargeDate,
            Long planExpiryDate,
            Integer planAmount
    ) {
        this.householdId = householdId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.planDurationDays = planDurationDays;
        this.lastRechargeDate = lastRechargeDate;
        this.planExpiryDate = planExpiryDate;
        this.planAmount = planAmount;
    }

    public String getId() {
        return id;
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

    public Long getLastRechargeDate() {
        return lastRechargeDate;
    }

    public Long getPlanExpiryDate() {
        return planExpiryDate;
    }

    public Integer getPlanAmount() {
        return planAmount;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setLastRechargeDate(Long lastRechargeDate) {
        this.lastRechargeDate = lastRechargeDate;
    }

    public void setPlanExpiryDate(Long planExpiryDate) {
        this.planExpiryDate = planExpiryDate;
    }

    public void setPlanAmount(Integer planAmount) {
        this.planAmount = planAmount;
    }
}