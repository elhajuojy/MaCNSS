package ma.yc.service;

import ma.yc.dto.AgentDto;

import java.time.Instant;

public interface AgentService {

    boolean addAgent(AgentDto agentDto);
    boolean selectAgent(AgentDto agentDto);
    boolean insertCode(AgentDto agentDto);
    boolean updateAgent(AgentDto agentDto, String email);
    boolean deleteAgent(AgentDto agentDto);
    AgentDto update(AgentDto agentDto);
    boolean sendCodeVerificationEmail(String code);
    boolean verifyCodeVerification(AgentDto agentDto);
    String authentifier(AgentDto agentDto);

}
