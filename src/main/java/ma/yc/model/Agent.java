package ma.yc.model;

public class Agent extends Utilisateur{
    private String codeVerification;

    public String getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(String codeVerification) {
        this.codeVerification = codeVerification;
    }
}
