package ma.yc.service;

import ma.yc.dto.AgentDto;

public interface AgentService {

    boolean addAgent(AgentDto agentDto);
    AgentDto updateAgent(AgentDto agentDto);
    boolean deleteAgent(AgentDto agentDto);
    AgentDto update(AgentDto agentDto);
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(String code);
    String authentifier(AgentDto agentDto);

}
