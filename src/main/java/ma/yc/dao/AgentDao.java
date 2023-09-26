package ma.yc.dao;

import ma.yc.model.Agent;

import java.util.List;

public interface AgentDao {
    boolean addAgent(Agent agent);
    boolean insertCodeVerif(Agent agent);
    boolean updateAgent(Agent agent,String email);
    List<Agent> selectAgent(Agent agent);
    boolean agentExist(Agent agent);

    boolean deleteAgent(String email);
    void update();
    Agent sendCodeVerificationEmail(Agent agent);
    boolean verifyCodeVerification(String code);
    String authentifier(Agent agent);

}
