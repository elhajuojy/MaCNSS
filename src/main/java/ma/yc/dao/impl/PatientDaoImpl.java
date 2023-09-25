package ma.yc.dao.impl;

import ma.yc.core.Print;
import ma.yc.dao.PatientDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Patient;

import java.sql.Connection;
import java.sql.SQLException;

public class PatientDaoImpl implements PatientDao {
    private  Connection connection;
    private Patient patient;

    public PatientDaoImpl() {
       try{
           this.connection = DatabaseConnection.getInstance().getConnection();
       }catch (SQLException e){
              e.printStackTrace();
       }
    }

    @Override
    public boolean authentification(Patient p) {
        String query = "SELECT * FROM patients WHERE matricule = ?";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1,p.getMatricule());
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        }catch (SQLException e){
            Print.log(e.toString());
        }

        return false;
    }
}
