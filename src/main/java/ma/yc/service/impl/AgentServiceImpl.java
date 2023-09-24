package ma.yc.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.UserMapper;
import ma.yc.dao.AgentDao;
import ma.yc.dao.impl.AgentDaoImpl;
import ma.yc.dto.AgentDto;
import ma.yc.model.Agent;
import ma.yc.service.AgentService;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgentServiceImpl implements AgentService {

    //todo:todoagent
    private AgentDao agentDao;
    private Mapper<AgentDto,Agent> userMapper;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public AgentServiceImpl() {
        this.agentDao = new AgentDaoImpl();
        this.userMapper = new UserMapper();
    }

    @Override
    public boolean addAgent(AgentDto agentDto) {
        Agent agent = userMapper.toEntity(agentDto);
        String hashedPassword = BCrypt.hashpw(agent.getPassword(), BCrypt.gensalt());
        agent.setPassword(hashedPassword);
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
    public static String generateRandomString(int length) {

        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    @Override
    public String authentifier(AgentDto agentDto) {
        String code = "";
        Agent agent = this.userMapper.toEntity(agentDto);
        String passwordHashed = this.agentDao.authentifier(agent);
        if(BCrypt.checkpw(agent.getPassword(), passwordHashed)){

            code = generateRandomString(21);
        }else {
            System.out.println("drop");
        }

        return code;
    }
}
