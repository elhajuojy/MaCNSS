package ma.yc.dao.impl;

import ma.yc.dao.DossierDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Dossier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DossierDaoImpl implements DossierDao {

    private Dossier dossier;
    //Dossier uses the DossierEntity class which means
    // all subclass which inside the DossierEntity class
    //todo : the DossierDaoImpl uses the DossierEntity class
    @Override
    public boolean enregistrerDossier() {
        return false;
    }

    @Override
    public boolean modifierDossier() {
        return false;
    }

    @Override
    public float totalRemoursement() {
        return 0;
    }

    @Override
    public Dossier consulterDossier(String CodeDossier) {
        try {
            Dossier dossier = null;
            String Query = "Select *from dossiers where numDossier = ?";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setString(1,CodeDossier);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                this.dossier.setTotalRemboursement(resultSet.getFloat("totalRemboursement")) ;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.dossier;
    }

    @Override
    public List<Dossier> consulterDossiers(String MatriculeUser) {
        return null;
    }

    @Override
    public boolean suiviEtatDossier(String statusDossier) {
        return false;
    }

    @Override
    public boolean envoyeEmailChangemenetEtat(String statusDossier) {
        return false;
    }
}
