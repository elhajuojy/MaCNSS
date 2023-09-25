package ma.yc.service.impl;

import ma.yc.Mapper.impl.AdminMapper;
//import ma.yc.Mapper.impl.UserMapper;
import ma.yc.dao.AdministateurDao;
import ma.yc.Mapper.Mapper;
import ma.yc.dao.impl.AdminstateurDaoImpl;
import ma.yc.dto.AdminDto;
import ma.yc.dto.UserDto;
import ma.yc.model.Administrateur;
import ma.yc.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdministateurDao administateurDao;
    //: injecter l'implémentation de Mapper to use the Administateur entity

    private Mapper<AdminDto, Administrateur> Adminmapper;

    public AdminServiceImpl() {
        //: injecter l'implémentation de AdministateurDao
        this.administateurDao = new AdminstateurDaoImpl();
        this.Adminmapper = new AdminMapper();
    }

    @Override
    public boolean authentifier(AdminDto adminDto) {
        //: appeler la méthode authentifier de AdministateurDao
        //here you can map the userDto to the entity
        //then call the dao


        //  Administateur adminEntity = this.mapper.toEntity();
        // now we have the entity we can call the dao which will call the
        // database with the entity
        Administrateur AdminEntity = this.Adminmapper.toEntity(adminDto);

        if (this.administateurDao.authentifier(AdminEntity))
            return true;
        else
            return false;
    }
}
