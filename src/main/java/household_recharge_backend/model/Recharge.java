package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recharges")
public class Recharge {

    @Id
    private String id;

    private String accountId;
    private Long expiryDate;
    private String householdId;
    private String mobileNumber;
    private Integer rechargeAmount;
    private Long rechargeDate;
    private String rechargeDescription;
    private String rechargedBy;

    public Recharge() {
    }

    public Recharge(
            String id,
            String accountId,
            Long expiryDate,
            String householdId,
            String mobileNumber,
            Integer rechargeAmount,
            Long rechargeDate,
            String rechargeDescription,
            String rechargedBy
    ) {
        this.id = id;
        this.accountId = accountId;
        this.expiryDate = expiryDate;
        this.householdId = householdId;
        this.mobileNumber = mobileNumber;
        this.rechargeAmount = rechargeAmount;
        this.rechargeDate = rechargeDate;
        this.rechargeDescription = rechargeDescription;
        this.rechargedBy = rechargedBy;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getRechargeAmount() {
        return rechargeAmount;
    }

    public Long getRechargeDate() {
        return rechargeDate;
    }

    public String getRechargeDescription() {
        return rechargeDescription;
    }

    public String getRechargedBy() {
        return rechargedBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public void setRechargeDate(Long rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public void setRechargeDescription(String rechargeDescription) {
        this.rechargeDescription = rechargeDescription;
    }

    public void setRechargedBy(String rechargedBy) {
        this.rechargedBy = rechargedBy;
    }
}