package ma.yc.dao.impl;

import ma.yc.dao.AdministateurDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Administrateur;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminstateurDaoImpl implements AdministateurDao {
    private Boolean AuthState = false;
    private Administrateur administrateur;
    @Override
    public boolean authentifier(Administrateur A) {
        try{
            this.AuthState = false;
            String query = "Select *FROM administrateurs WHERE email = ?";
            Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1,A.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(BCrypt.checkpw(A.getPassword(),resultSet.getString("password"))) {
                    AuthState = true;
                }

            }
            // here we can interact with the database
            // we can use the databaseConnection to do operation

        }catch (SQLException e){
            e.printStackTrace();
        }


        // interact with database
//        to do operation which return true or false


        return this.AuthState;
    }
}
