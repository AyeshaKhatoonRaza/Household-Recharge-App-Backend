package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {

    @Id
    private String accountId;

    private String accountName;
    private String householdId;

    public Account() {
    }

    public Account(
            String accountId,
            String accountName,
            String householdId
    ) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.householdId = householdId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }
}