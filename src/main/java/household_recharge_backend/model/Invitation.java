package household_recharge_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invitations")
public class Invitation {

    @Id
    private String id;

    private String code;
    private Long createdAt;
    private String createdBy;
    private Long expiresAt;
    private String householdId;
    private String status;
    private Long usedAt;
    private String usedBy;

    public Invitation() {
    }

    public Invitation(
            String code,
            Long createdAt,
            String createdBy,
            Long expiresAt,
            String householdId,
            String status
    ) {
        this.code = code;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.expiresAt = expiresAt;
        this.householdId = householdId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public String getStatus() {
        return status;
    }

    public Long getUsedAt() {
        return usedAt;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsedAt(Long usedAt) {
        this.usedAt = usedAt;
    }

    public void setUsedBy(String usedBy) {
        this.usedBy = usedBy;
    }
}