package household_recharge_backend.dto;

public class LoginRequest {

    private String mobileNumber;
    private String password;

    public LoginRequest() {
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}