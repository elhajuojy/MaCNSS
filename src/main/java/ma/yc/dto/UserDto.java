package ma.yc.dto;

public class UserDto {

    public String email;
    public String password;
    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
