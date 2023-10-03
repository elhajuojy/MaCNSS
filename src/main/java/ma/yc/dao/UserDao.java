package ma.yc.dao;

import ma.yc.model.Utilisateur;

public interface UserDao {
    //authentification
    public boolean login(Utilisateur user);
    public boolean logout();
}
