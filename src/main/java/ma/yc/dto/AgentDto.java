package ma.yc.dto;

public class AgentDto {

    public String email;
    public String password;
    public String codeVerification;

    public AgentDto(String email, String password, String codeVerification) {
        this.email = email;
        this.password = password;
        this.codeVerification = codeVerification;
    }
}
