package ma.yc.service.impl;

import com.sun.source.tree.ReturnTree;
import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.UserMapper;
import ma.yc.dao.AgentDao;
import ma.yc.dao.impl.AgentDaoImpl;
import ma.yc.dto.AgentDto;
import ma.yc.model.Agent;
import ma.yc.service.AgentService;

public class AgentServiceImpl implements AgentService {

    //todo:todoagent
    private AgentDao agentDao;
    private Mapper<AgentDto,Agent> userMapper;

    public AgentServiceImpl() {
        this.agentDao = new AgentDaoImpl();
        this.userMapper = new UserMapper();
    }

    @Override
    public boolean addAgent(AgentDto agentDto) {
        Agent agent = userMapper.toEntity(agentDto);
        boolean test = this.agentDao.addAgent(agent);
        if (test){
            return true;
        }
        return false;
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
