package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "households")
public class Household {

    @Id
    @JsonIgnore
    private String id;

    private String authId;
    private String householdName;

    public Household() {
    }

    public Household(String authId, String householdName) {
        this.authId = authId;
        this.householdName = householdName;
    }

    public String getId() {
        return id;
    }

    public String getAuthId() {
        return authId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }
}