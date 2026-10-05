package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mobile_numbers")
public class MobileNumber {

    @Id
    private String id;

    private String accountId;
    private String householdId;
    private String lastRechargeId;
    private String mobileNumber;

    public MobileNumber() {
    }

    public MobileNumber(
            String id,
            String accountId,
            String householdId,
            String lastRechargeId,
            String mobileNumber
    ) {
        this.id = id;
        this.accountId = accountId;
        this.householdId = householdId;
        this.lastRechargeId = lastRechargeId;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public String getLastRechargeId() {
        return lastRechargeId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public void setLastRechargeId(String lastRechargeId) {
        this.lastRechargeId = lastRechargeId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}