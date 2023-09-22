package ma.yc.GUI;

import ma.yc.core.Util;
import ma.yc.dto.UserDto;

import java.util.Scanner;

public class UserGUI {
    private Scanner scanner  = new Scanner(System.in);
    public UserDto displayOptions(String email , String password){

        email = Util.readString("Email : ",scanner);
        password = Util.readString("Password : ",scanner);
        return new UserDto(email,password);
    }
    public UserDto displayOptions(String email){
        email = Util.readString("Email : ",scanner);
        return new UserDto(email,null);
    }
}
