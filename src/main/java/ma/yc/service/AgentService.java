package ma.yc.service;

public interface AgentService {

    void addAgent( );
    void updateAgent();
    void deleteAgent();
    void update();
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(String code);
    boolean authentifier(String email, String password);

}
