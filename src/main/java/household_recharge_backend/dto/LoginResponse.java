package household_recharge_backend.dto;

public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private String id;
    private String name;
    private String mobileNumber;

    public LoginResponse(
            String accessToken,
            String refreshToken,
            String id,
            String name,
            String mobileNumber
    ) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
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