package ma.yc.model;

import java.sql.Timestamp;
import java.time.Instant;

public class Agent extends Utilisateur{
    private String codeVerification;
    private Long timeRegester;

    public Long getTimeRegester() {
        return timeRegester;
    }

    public void setTimeRegester(Long timeRegester) {
        this.timeRegester = timeRegester;
    }

    public String getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(String codeVerification) {
        this.codeVerification = codeVerification;
    }
}
