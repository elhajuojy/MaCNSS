package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.dto.UserDto;
import ma.yc.service.AdminService;
import ma.yc.service.AgentService;
import ma.yc.service.impl.AdminServiceImpl;
import ma.yc.service.impl.AgentServiceImpl;

import java.util.Scanner;

public class MainAdministeurGUI implements DisplayGUI{



    //need AgentService which is all agent function stored
    // in like add agent delete agent and update agent we looked in
    AdminService adminService ;
    AgentService agentService ;
    boolean isAuthentificated = false;
    public MainAdministeurGUI() {
        this.agentService = new AgentServiceImpl();
        this.adminService = new AdminServiceImpl();
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

        Print.log("=== Gestion des comptes des agents CNSS   ===");
        //if the user want to exit the dashboard then he can do it
        Print.log("1- Add an agent ");
        Print.log("2- Select All agents ");
        Print.log("3- Delete an agent ");
        Print.log("4- Update an agent ");
        Print.log("5- Go back to the main menu ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //add an agent
                //ask about agent information
                this.addAgent(scanner);
                break;
            case 2:
                //select all agents
                this.selectAllAgents(scanner);
                break;
            case 3:
                //delete an agent
                this.deleteAgent(scanner);
                break;
            case 4:
                //update an agent
                this.updateAgent(scanner);
                break;

            case 5:
                //go back to the main menu
                this.displayMainOptions(scanner);
                break;
            default:
                Print.log("Invalid choice");
                break;
        }


    }

    private void updateAgent(Scanner scanner) {
        //todo : ask about the agent information to update

        //todo : setup the information in the agentDto

        //todo : call the service to update the agent

    }

    private void deleteAgent(Scanner scanner) {
        //ask about the agent email ;
    }

    private void selectAllAgents(Scanner scanner) {
        //show all agents
    }

    private void addAgent(Scanner scanner) {
        //ask about the agent information

    }

}
