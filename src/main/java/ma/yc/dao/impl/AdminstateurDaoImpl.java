package ma.yc.dao.impl;

import ma.yc.dao.AdministateurDao;
import ma.yc.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminstateurDaoImpl implements AdministateurDao {

    //todo: admintodo
    @Override
    public boolean authentifier(String email, String password) {
        try{
            Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
            // here we can interact with the database
            // we can use the databaseConnection to do operation

        }catch (SQLException e){
            e.printStackTrace();
        }


        // interact with database
//        to do operation which return true or false


        return false;
    }
}
