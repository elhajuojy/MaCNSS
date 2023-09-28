package ma.yc.dao;

import ma.yc.model.Employe;

public interface SocieteDao {

 // vous êtes invité à créer une interface console pour la création d'un compte société dans le système macnss
    public void createSociete();

    //chaque société enregistre un employé avec une cotisation de salaire pour le traitement de la retraite,
    public void createEmploye();

    //chaque société doit entré le nombre de jour travaillé par un employé, généralement le nombre de jour mensuels est fixé 26,
    // en cas de maladie ou absence ce nombre diminue
    public Employe declareJourTravileParEmploye(Employe employe, int nombreJourTravaille);


}
