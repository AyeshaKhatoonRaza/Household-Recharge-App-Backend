package household_recharge_backend.dto;

public class SignupResponse {

    private String id;
    private String name;
    private String mobileNumber;

    public SignupResponse(String id, String name, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}