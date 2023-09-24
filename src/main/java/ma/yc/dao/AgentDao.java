package ma.yc.dao;

import ma.yc.model.Agent;

public interface AgentDao {
    boolean addAgent(Agent agent);
    void updateAgent();
    void deleteAgent();
    void update();
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(String code);
    boolean authentifier(String email, String password);

}
