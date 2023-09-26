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
import java.time.Instant;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgentServiceImpl implements AgentService {

    private AgentDao agentDao;
    private Mapper<AgentDto,Agent> userMapper;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static boolean verifyEmail(String input){
        String rgx = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public AgentServiceImpl() {
        this.agentDao = new AgentDaoImpl();
        this.userMapper = new UserMapper();
    }

    @Override
    public boolean addAgent(AgentDto agentDto) {
        boolean result = false;
        if (verifyEmail(agentDto.email)) {
            Agent agent = this.userMapper.toEntity(agentDto);
            boolean exist = this.agentDao.agentExist(agent);
            if (exist) {
                result = false;
            } else {
                String hashedPassword = BCrypt.hashpw(agent.getPassword(), BCrypt.gensalt());
                agent.setPassword(hashedPassword);
                boolean test = this.agentDao.addAgent(agent);
                if (test) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean selectAgent(AgentDto agentDto) {
        boolean result = false;
        if (verifyEmail(agentDto.email)){
            Agent agent = this.userMapper.toEntity(agentDto);
            List <Agent> retrieve = this.agentDao.selectAgent(agent);
            String retieveEmail = retrieve.get(0).getEmail();
            if(!retieveEmail.isEmpty()){
                result=true;
            }
        }
        return result;
    }

    @Override
    public boolean insertCode(AgentDto agentDto) {
        boolean result = false;
        agentDto.timeRegester = System.currentTimeMillis();
        Agent agent = this.userMapper.toEntity(agentDto);
        boolean returnInsert = this.agentDao.insertCodeVerif(agent);
        if (returnInsert){
            result=true;

        }
        return result;
    }


    @Override
    public AgentDto update(AgentDto agentDto) {

        return  null;
    }

    @Override
    public boolean deleteAgent(AgentDto agentDto) {
        boolean isDelete = false;
        if (verifyEmail(agentDto.email)){
            Agent agent = this.userMapper.toEntity(agentDto);
            isDelete = agentDao.deleteAgent(agent.getEmail());

        }
        return isDelete;
    }

    @Override
    public boolean updateAgent(AgentDto agentDto, String email) {
        boolean result = false;
        if (verifyEmail(agentDto.email)){
            Agent agent = this.userMapper.toEntity(agentDto);
            result = this.agentDao.updateAgent(agent,email);
        }
        return result;
    }

    @Override
    public boolean sendCodeVerificationEmail(String code) {
        return false;
    }

    @Override
    public boolean verifyCodeVerification(AgentDto agentDto) {
        boolean result = false;
        Agent agent = this.userMapper.toEntity(agentDto);
        Agent agent1 = this.agentDao.sendCodeVerificationEmail(agent);

        long storedTimestamp = agent1.getTimeRegester();
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - storedTimestamp;
        long CODE_VALIDITY_DURATION = 5 * 60 * 1000;

        if( timeDifference < CODE_VALIDITY_DURATION){
            result = true;
        }

        return result;
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
        if (!passwordHashed.isEmpty()){
        if(BCrypt.checkpw(agent.getPassword(), passwordHashed)){

            code = generateRandomString(21);
         }
        }

        return code;
    }
}
