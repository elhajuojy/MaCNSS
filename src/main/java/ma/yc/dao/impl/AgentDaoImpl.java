package ma.yc.dao.impl;

import ma.yc.dao.AgentDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Agent;

import java.sql.Connection;
import java.sql.SQLException;

public class AgentDaoImpl implements AgentDao {
    private Connection connection;

    public AgentDaoImpl() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //TODO : the Agent Dao uses the AgentEntity class

    @Override
    public boolean addAgent(Agent a) {
        try{
            String query = "INSERT INTO agents (email,password) VALUES (?,?);";
            var statement = this.connection.prepareStatement(query);
            statement.setString(1, a.getEmail());
            statement.setString(2, a.getPassword());
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
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
