package ma.yc.service;

import ma.yc.dto.AgentDto;
import ma.yc.model.Agent;

public interface AgentService {

    AgentDto addAgent(AgentDto agentDto);
    AgentDto updateAgent(AgentDto agentDto);
    boolean deleteAgent(AgentDto agentDto);
    AgentDto update(AgentDto agentDto);
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(String code);
    boolean authentifier(AgentDto agentDto);

}
