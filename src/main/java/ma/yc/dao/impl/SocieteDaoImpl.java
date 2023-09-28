package ma.yc.dao.impl;

import ma.yc.dao.SocieteDao;
import ma.yc.database.DatabaseConnection;
import ma.yc.model.Employe;
import ma.yc.model.Societe;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SocieteDaoImpl implements SocieteDao {

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
}
