package ma.yc.Mapper.impl;
import ma.yc.Mapper.Mapper;
import ma.yc.dto.AgentDto;
import ma.yc.model.Agent;

import java.sql.PreparedStatement;

public class UserMapper implements Mapper<AgentDto, Agent> {



    @Override
    public Agent toEntity() {
        return null;
    }

    @Override
    public Agent toEntity(AgentDto agentDto) {
        Agent agent = new Agent();
        agent.setEmail(agentDto.email);
        agent.setPassword(agentDto.password);
        agent.setCodeVerification(agentDto.codeVerification);
        agent.setTimeRegester(agentDto.timeRegester);
        return agent;
    }

    @Override
    public AgentDto toDto() {
        return null;
    }

    @Override
    public AgentDto toDto(Agent t) {
        return null;
    }

    @Override

    public PreparedStatement toPreparedStatement(Agent agent, PreparedStatement preparedStatement) {

        return null;
    }

//    @Override
//    public String toDto() {
//        return null;
//    }
//
//    @Override
//    public String toDto(String s) {
//        return null;
//    }
//
//    @Override
//    public PreparedStatement toPreparedStatement(String s, PreparedStatement preparedStatement) {
//        return null;
//    }
}


