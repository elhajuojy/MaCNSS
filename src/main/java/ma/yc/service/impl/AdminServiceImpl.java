package ma.yc.service.impl;

import ma.yc.Mapper.impl.UserMapper;
import ma.yc.dao.AdministateurDao;
import ma.yc.Mapper.Mapper;
import ma.yc.dto.UserDto;
import ma.yc.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdministateurDao administateurDao;
    //:TODO injecter l'implémentation de Mapper to use the Administateur entity
    private Mapper<String> mapper;

    public AdminServiceImpl() {
        //:TODO injecter l'implémentation de AdministateurDao
        this.administateurDao = null ;
        this.mapper = new UserMapper();
    }

    @Override
    public boolean authentifier(UserDto userDto) {
        //:TODO appeler la méthode authentifier de AdministateurDao
        //here you can map the userDto to the entity
        //then call the dao


        //  Administateur adminEntity = this.mapper.toEntity();
        // now we have the entity we can call the dao which will call the
        // database with the entity
        if (this.administateurDao.authentifier(userDto.email,userDto.password))
            return true;
        else
            return false;
    }
}
