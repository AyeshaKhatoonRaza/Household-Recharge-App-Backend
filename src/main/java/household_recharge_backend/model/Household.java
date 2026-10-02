package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "households")
public class Household {

    @Id
    private String id;

    private String name;

    private String ownerId;

    private List<String> memberIds;

    public Household() {
    }

    public Household(String name, String ownerId) {
        this.name = name;
        this.ownerId = ownerId;

        // The owner is automatically the first household member
        this.memberIds = new ArrayList<>();
        this.memberIds.add(ownerId);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }
}