package ma.yc.dao.impl;

import ma.yc.dao.AgentDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Agent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImpl implements AgentDao {
    private Connection connection;

    //: the Agent Dao uses the AgentEntity class
    private Agent agent;

    public AgentDaoImpl() {

        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addAgent(Agent a) {
        String query = "INSERT INTO agents (email,password) VALUES (?,?);";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1, a.getEmail());
            statement.setString(2, a.getPassword());
            var resultSet = statement.executeUpdate();
            if(resultSet!=0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean insertCodeVerif(Agent agent) {
        String query = "UPDATE `agents` SET `codeVerification`=? ,`timeRegester` = ? WHERE email=?;";
        boolean result = false;
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1, agent.getCodeVerification());
            statement.setLong(2, agent.getTimeRegester ());
            statement.setString(3, agent.getEmail());

            int execute = statement.executeUpdate();
            if (execute != 0){
                result = true;
            }
        }catch (SQLException e){
            throw  new RuntimeException();
        }
      return result;
    }

    @Override
    public boolean updateAgent(Agent agent,String eamil) {
        boolean results = false;
        String query = "UPDATE agents SET email=?, password=? WHERE email=?;";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1,agent.getEmail());
            statement.setString(2, agent.getPassword());
            statement.setString(3, eamil);
            int result = statement.executeUpdate();
            if (result != 0){
                results= true;
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return results;
    }

    @Override
    public List<Agent> selectAgent(Agent agent) {
        String query = "SELECT email, password FROM agents WHERE email = ?;";
        List<Agent> agents = new ArrayList<>();
                try{

                   var statement = this.connection.prepareStatement(query);
                   statement.setString(1,agent.getEmail());
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        String email = resultSet.getString("email");
                        String password = resultSet.getString("password");
                        Agent retrievedAgent = new Agent();
                        retrievedAgent.setEmail(email);
                        retrievedAgent.setPassword(password);
                        agents.add(retrievedAgent);
                    }
                }catch(SQLException e){
                    throw new RuntimeException(e);
                }
        return agents;
    }

    @Override
    public boolean agentExist(Agent agent) {
        String query = "SELECT email, password FROM agents WHERE email = ?;";
        boolean result = false;
        try{

            var statement = this.connection.prepareStatement(query);
            statement.setString(1,agent.getEmail());
            ResultSet test = statement.executeQuery();
           while (test.next()){
               result = true;
           }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean deleteAgent(String email) {
        boolean results = false;
        String query = "DELETE FROM agents WHERE email = ?;";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1, email);
            int result = statement.executeUpdate();
            if (result!=0){
                results= true;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return results;
    }

    @Override
    public void update() {

    }

    @Override
    public Agent sendCodeVerificationEmail(Agent agent) {
        String query = "SELECT `codeVerification`,`timeRegester` FROM agents WHERE email = ? and codeVerification = ?;";

        boolean result = false;
        try{

            var statement = this.connection.prepareStatement(query);
            statement.setString(1,agent.getEmail());
            statement.setString(2,agent.getCodeVerification());
            ResultSet test = statement.executeQuery();
            while (test.next()){
                agent.setCodeVerification(test.getString("codeVerification"));
                agent.setTimeRegester(test.getLong("timeRegester"));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
       return agent;
    }

    @Override
    public boolean verifyCodeVerification(String code) {
        return false;
    }

    @Override
    public String authentifier(Agent agent) {
        String query = "SELECT  password FROM agents WHERE email=?;";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1, agent.getEmail());
            var resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
