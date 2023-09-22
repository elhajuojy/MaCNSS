package ma.yc.dao.impl;

import ma.yc.dao.AgentDao;

public class AgentDaoImpl implements AgentDao {

    //TODO : the Agent Dao uses the AgentEntity class

    @Override
    public void addAgent() {

    }

    @Override
    public void updateAgent() {

    }

    @Override
    public void deleteAgent() {

    }

    @Override
    public void update() {

    }

    @Override
    public boolean sendCodeVerificationEmail(String code) {
        return false;
    }

    @Override
    public boolean verifyCodeVerification(String code) {
        return false;
    }

    @Override
    public boolean authentifier(String email, String password) {
        return false;
    }
}
