package ma.yc.dao;

import ma.yc.model.Utilisateur;
import org.springframework.security.core.userdetails.User;

public interface UserDao {
    //authentification
    public Utilisateur authentification(User user);
}
