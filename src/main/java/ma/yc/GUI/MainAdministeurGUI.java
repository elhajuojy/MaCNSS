package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.dto.UserDto;
import ma.yc.service.AdminService;

import java.util.Scanner;

public class MainAdministeurGUI implements DisplayGUI{



    AdminService adminService ;
    boolean isAuthentificated = false;
    public MainAdministeurGUI() {
    }

    public MainAdministeurGUI(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public int displayMainOptions(Scanner scanner) {
        //show the admin options
        // there's one option for now which is authentification before he can do anything
        // if the authentification is successful then he can do anything
        Print.log("Bienvenue dans l'application de gestion des patients");
        Print.log("=== OPERATION  ===");
        Print.log("1 - Authentification ");
        //go back to the main menu
        Print.log("2 - Go back to the main menu ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //authentification
                // ask the user about his information email and password
                // then call the service to authentificate the user
                String email = "";
                String password = "";
                Print.log("Email : ");
                email = scanner.next();
                Print.log("Password : ");
                password = scanner.next();
                UserDto userDto = new UserDto(email,password);
                isAuthentificated = this.adminService.authentifier(userDto);
                if (isAuthentificated){
                    //if the authentification is successful then show the admin dashboard
                    this.AdminDashboard(scanner);
                }
                else{
                    Print.log("Authentification failed");
                    this.displayMainOptions(scanner);
                }
                break;
            case 2:
                //go back to the main menu

                return 0;
            case 0:
                //exit
                return -1;
            default:
                Print.log("Invalid choice");
                break;
        }


        return 0;
    }

    public void AdminDashboard(Scanner scanner){
        //show the admin dashboard
        //there's many options to do
        //Agents management

        Print.log("=== OPERATION  ===");
        //if the user want to exit the dashboard then he can do it
         this.displayMainOptions(scanner);
    }

}
