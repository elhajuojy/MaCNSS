package ma.yc.dao;

public interface AgentDao {
    void addAgent();
    void updateAgent();
    void deleteAgent();
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(String code);
    boolean authentifier(String email, String password);

}
