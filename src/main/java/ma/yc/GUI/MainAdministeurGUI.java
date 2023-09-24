package ma.yc.GUI;


import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.database.DatabaseConnection;
import ma.yc.dto.AdminDto;
import ma.yc.dto.AgentDto;
import ma.yc.dto.UserDto;
import ma.yc.service.AdminService;
import ma.yc.service.AgentService;
import ma.yc.service.impl.AdminServiceImpl;
import ma.yc.service.impl.AgentServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Scanner;

public class MainAdministeurGUI implements DisplayGUI{
    //need AgentService which is all agent function stored
    // in like add agent delete agent and update agent we looked in
    AdminService adminService ;
    AgentService agentService ;
    boolean isAuthentificated = false;
    private  AgentDto agentDto;
    public MainAdministeurGUI() {
        this.agentService = new AgentServiceImpl();
        this.adminService = new AdminServiceImpl();
        this.agentDto = new AgentDto();
    }



    @Override
    public int displayMainOptions(Scanner scanner)  {
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

                //authentication: Admin need to be authenticated before he can do anything
                String email;
                String password ;
                Print.log("Email : ");
                email  = Util.readString("Email",scanner);
                Print.log("Password : ");
                password = scanner.next();
                AdminDto adminDto = new AdminDto(email,password);
                isAuthentificated = this.adminService.authentifier(adminDto);
                if (isAuthentificated){
                    //if the authentication is successful then show the admin dashboard
                    this.AdminDashboard(scanner);
                }
                else{
                    Print.log("Authentication failed");
                    this.displayMainOptions(scanner);
                }
                break;
            case 2:
                //go back to the main menu
                new MainGUI().displayMainOptions(scanner);
                return 0;
            case 0:
                //exit
                Print.log("Bye Bye");
                return -1;
            default:
                Print.log("Invalid choice");
                break;
        }


        return 0;
    }

    public void AdminDashboard(Scanner scanner)  {

        Print.log("=== Gestion des comptes des agents CNSS   ===");
        Print.log("1- Add an agent ");
        Print.log("2- Select All agents ");
        Print.log("3- Delete an agent ");
        Print.log("4- Update an agent ");
        Print.log("5- Go back to the main menu ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1 ->this.addAgent(scanner);
            case 2->
                this.selectAllAgents(scanner);
            case 3 ->
                this.deleteAgent(scanner);
            case 4->
                this.updateAgent(scanner);
            case 5->
                this.displayMainOptions(scanner);
            default ->
                Print.log("Invalid choice");
        }


    }

    private void updateAgent(Scanner scanner) {
        Print.log("=== Update an agent ===");
        UserDto userDto = new UserGUI().displayOptions("email");
        //todo : call update agent srevice
//        AgentDto agentDto = new AgentDto(userDto.email, userDto.password, null);
//        this.agentService.updateAgent(agentDto);

    }

    private void deleteAgent(Scanner scanner) {
        Print.log("=== Delete an agent ===");
        UserDto userDto = new UserGUI().displayOptions("email");
        //todo : delete agent
//        AgentDto agentDto = new AgentDto(userDto.email, null,null);
//        this.agentService.deleteAgent(agentDto);
    }

    private void selectAllAgents(Scanner scanner) {
        //todo : show all agents
    }

    private void addAgent(Scanner scanner) {

        Print.log("Bienvenue dans l'application de gestion des patients");
        Print.log("Authentification");
        String email = Util.readString("Email",scanner);
        String password = Util.readString("Password",scanner);

        agentDto.email = email;
        agentDto.password = password;
        isAuthentificated = this.agentService.addAgent(agentDto);
        if (isAuthentificated){
            System.out.println("Success");
        }else {
            System.out.println("Ops");
        }
    }

}
