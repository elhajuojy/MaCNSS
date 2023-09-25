package ma.yc.dao.impl;

import ma.yc.core.Print;
import ma.yc.dao.DossierDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.enums.statusDossier;
import ma.yc.model.Dossier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DossierDaoImpl implements DossierDao {

    private Dossier dossier ;
    private List<Dossier> listdossier ;
    private Connection connection;
    public DossierDaoImpl(){
        try{
            connection = DatabaseConnection.getInstance().getConnection();
            dossier = new Dossier();
            listdossier =  new ArrayList<Dossier>();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
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
            String Query = "SELECT *from dossiers where dossiers.numDossier = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(Query);
            preparedStatement.setString(1,CodeDossier);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                statusDossier status = null;
                String st =  resultSet.getString("status");
                if(st.equals(statusDossier.En_attend.toString())){
                    status = statusDossier.En_attend;
                }else if(st.equals(statusDossier.Refusé.toString())){
                    status = statusDossier.Refusé;
                }else if(st.equals(statusDossier.Validé.toString())){
                    status = statusDossier.Validé;
                }
                this.dossier.setTotalRemboursement(resultSet.getFloat("totalRemboursement")) ;
                this.dossier.setStatus(status);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.dossier;
    }

    @Override
    public List<Dossier> consulterDossiers(String MatriculeUser) {
        try{
            List<Dossier> listdossier = new ArrayList<Dossier>();
            String Query = "SELECT *from dossiers where dossiers.matricule = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(Query);
            preparedStatement.setString(1,MatriculeUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dossier dossier1 = new Dossier();
                statusDossier status = null;
                String st = resultSet.getString("status");
                if(st.equals(statusDossier.En_attend.toString())){
                    status = statusDossier.En_attend;
                }else if(st.equals(statusDossier.Refusé.toString())){
                    status = statusDossier.Refusé;
                }else if(st.equals(statusDossier.Validé.toString())){
                    status = statusDossier.Validé;
                }
                dossier1.setTotalRemboursement(resultSet.getFloat("totalRemboursement"));
                dossier1.setNumDossier(resultSet.getString("numDossier"));
                dossier1.setStatus(status);

                this.listdossier.add(dossier1);

                //Dossier dossier1 = new Dossier(String numDossier, statusDossier status, resultSet.getFloat("totalRemboursement")));
                Print.log("total de remboursement ");


            }


        }catch(SQLException e ){
            e.printStackTrace();
        }


        return this.listdossier;
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
