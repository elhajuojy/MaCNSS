package ma.yc.dao.impl;

import ma.yc.core.Print;
import ma.yc.dao.SocieteDao;
import ma.yc.dao.UserDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Employe;
import ma.yc.model.Societe;
import ma.yc.model.Utilisateur;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SocieteDaoImpl implements SocieteDao , UserDao {

    private Connection connection ;
    private List<Employe> employes = new ArrayList<>();
    private Societe societe = new Societe();


    public SocieteDaoImpl() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createSociete() {

    }

    @Override
    public void createEmploye() {

    }

    @Override
    public Employe declareJourTravileParEmploye(Employe employe, int nombreJourTravaille) {
        return null;
    }

    @Override
    public boolean login(Utilisateur user) {
        String query = "SELECT * FROM societe WHERE email = ? AND id = ?";
        try{
            var statement = this.connection.prepareStatement(query);
            statement.setString(1,user.getEmail());
            statement.setLong(2,Long.valueOf(user.getPassword()));
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        }catch (Exception e){
            Print.log(e.toString());
        }
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
