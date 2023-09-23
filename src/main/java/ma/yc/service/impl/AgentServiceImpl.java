package ma.yc.service.impl;

import com.sun.source.tree.ReturnTree;
import ma.yc.dao.AgentDao;
import ma.yc.dao.impl.AgentDaoImpl;
import ma.yc.dto.AgentDto;
import ma.yc.service.AgentService;

public class AgentServiceImpl implements AgentService {

    private AgentDao agentDao;

    public AgentServiceImpl() {
        this.agentDao = new AgentDaoImpl();
    }

    @Override
    public AgentDto addAgent(AgentDto agentDto) {
        this.agentDao.addAgent();
        return  null;
    }

    @Override
    public AgentDto updateAgent(AgentDto agentDto) {

        return  null;
    }

    @Override
    public boolean deleteAgent(AgentDto agentDto) {
        return false;
    }

    @Override
    public AgentDto update(AgentDto agentDto) {
        return null;
    }

    @Override
    public boolean sendCodeVerificationEmail(String code) {
        return false;
    }

    @Override
    public boolean verifyCodeVerification(String code) {
        this.sendCodeVerificationEmail(code);

        return false;
    }

    @Override
    public boolean authentifier(AgentDto agentDto) {
        this.agentDao.authentifier(agentDto.email,agentDto.password);
        return false;
    }
}
