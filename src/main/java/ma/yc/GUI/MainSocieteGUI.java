package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dao.impl.SocieteDaoImpl;
import ma.yc.dto.EmployeDto;
import ma.yc.dto.SocieteDto;
import ma.yc.enums.Statusretaitre;
import ma.yc.model.Hourly_emp;
import ma.yc.service.EmployeeService;
import ma.yc.service.SocieteService;
import ma.yc.service.impl.EmployeServiceImpl;
import ma.yc.service.impl.SocieteServiceImpl;
import pl.mjaron.etudes.Arr;
import pl.mjaron.etudes.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSocieteGUI implements DisplayGUI{

    private SocieteService societeService ;
    private  SocieteDto societeDto ;
    private  EmployeDto employeDto;
    private final EmployeeService employeeService ;
    private  SocieteSession societeSession;

    record SocieteSession(String email, Long id) {
    }

    public MainSocieteGUI() {
        this.societeService = new SocieteServiceImpl();
        this.societeDto = new SocieteDto();
        this.employeDto = new EmployeDto();
        this.employeeService = new EmployeServiceImpl();

    }

    @Override
    public int displayMainOptions(Scanner scanner) {
        Print.log("=== Societe  OPERATION  ===");
        Print.log("1 - Authentification ");
        Print.log("2 - Create an account as a societe ");
        Print.log("3 - Go back to the main menu ");
        Print.log("0 - Exit ");
        // : vous êtes invité à créer une interface console pour la création d'un compte société dans le système macnss
        // :chaque société enregistre un employé avec une cotisation de salaire pour le traitement de la retraite,
        // : AUTH : 1 - authentification 2 - go back to the main menu 0 - exit

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                this.authentification(scanner);
                break;
            case 2:
                this.createAccount(scanner);
                break;
            case 3:
                this.displayMainOptions(scanner);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                Print.log("your choice is not correct");
                this.displayMainOptions(scanner);
                return 0;
        }

        return 0;
    }

    private int createAccount(Scanner scanner) {
        // : ask about the company information
        try{
            String id ;
            String nom;
            String adresse;
            String email;
            id = Util.readString("ID",scanner);
            email  = Util.readString("Email",scanner);
            nom = Util.readString("Nom",scanner);
            adresse = Util.readString("Adresse",scanner);
            societeDto.id = Long.parseLong(id);
            societeDto.nom = nom;
            societeDto.adresse = adresse;
            societeDto.email = email;
            // : CREATE AN ACCOUNT AND RETURN BOOLEAN VALUE TO CHECK IF THE ACCOUNT IS CREATED OR NOT
            SocieteDto  isSaved =  this.societeService.addSociete(societeDto);
            if(isSaved != null){
                Print.log("Bienvenue !\n" +
                        "votre compte a bien été créé");

                this.authentification(scanner);
            }else {
                Print.log("Error while creating an account");
                this.displayMainOptions(scanner);
            }

            this.displayMainOptions(scanner);

        }catch (Exception e){
            Print.log("Error while creating an account");
            this.displayMainOptions(scanner);
        }
        return 0;
    }

    private int authentification(Scanner scanner) {
        //: AUTHENTIFICATION THE SOCIETE MUST PROVIDE THE EMAIL AND ID
        String email;
        email  = Util.readString("Email",scanner);
        Long id = Util.readLong("ID",scanner);
        String[] credentials = {
                email,
                String.valueOf(id)
        };
        boolean isAuthentificated = this.societeService.login(credentials);

        if (isAuthentificated){
            Print.log("Authentication success");
            this.societeSession = new SocieteSession(email,id);
            this.showDashboard(scanner);
        }
        else{
            Print.log("Authentication failed");
            this.societeSession = null;
            this.displayMainOptions(scanner);
        }
        return 0;
    }
    private void showDashboard(Scanner scanner) {
        Print.log("SOCITE DASHBOARD");
        Print.log("1 - enregistre un employé ");
        Print.log("2 - entré le nombre de jour travaillé par un employé,");
        Print.log("3 - Go back to the main menu ");
        Print.log("0 - Exit ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                this.enregistreEmploye(scanner);
                break;
            case 2:
                this.JourTravileParMois(scanner);
                break;
            case 3:
                this.displayMainOptions(scanner);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                Print.log("your choice is not correct");
                this.displayMainOptions(scanner);
                return;
        }


    }

    private void JourTravileParMois(Scanner scanner) {
        // : DECELERE JOUR DE TRAVAIL PAR EMPLOYE CHAQUE MOIS
        //WE ASK THE COMPANY FOR THE EMPLOYEE ID WHICH IS ONE WHICH IS UNIQUE OVER THE EMPLOYEE LIFE WORK
        long id = Util.readLong("MATRICULE EMPLOYE ",scanner);
        // : WE ASK THE COMPANY FOR THE NUMBER OF DAYS WORKED BY THE EMPLOYEE
        int jourTravaille = Util.readInt("Jour travaillé",scanner);
        // : MONTH AND YEAR
        int month = Util.readInt("Month",scanner);
        int year = Util.readInt("Year",scanner);
        // : CALLING THE SERVICE TO DO THE JOB
        ArrayList<EmployeDto> employeDtos = new ArrayList<>();
        employeDtos.add(this.societeService.declareJourTravileParEmployee(this.societeSession.id,id,jourTravaille));

        if (employeDtos.size() > 0){
            Print.log("Jour de travaille par mois a été enregistré avec succès");
            this.showDashboard(scanner);
        }else {
            Print.log("Jour de travaille par mois n'a pas été enregistré avec succès");
            this.showDashboard(scanner);
        }

        this.displayMainOptions(scanner);
    }


    private void enregistreEmploye(Scanner scanner) {
        //TODO : ENREGISTRE EMPLOYE
        //there's two main options to choose from
        // si employe jamis enregistre dans le systeme macnss
        // si employe deja enregistre dans le systeme macnss et un matricule lui a deja ete attribue
        Print.log("=== Enregistre un employé  ===");
        Print.log("1 - si employe jamis enregistre dans le systeme macnss");
        Print.log("2 - si employe deja enregistre dans le systeme macnss et un matricule lui a deja ete attribue");
        Print.log("3 - Go back to the main menu ");
        Print.log("0 - Exit ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                this.enregistreEmployeJamisEnregistre(scanner);
                break;
            case 2:
                this.enregistreEmployeDejaEnregistre(scanner);
                break;
            case 3:
                this.displayMainOptions(scanner);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                Print.log("your choice is not correct");
                this.displayMainOptions(scanner);
                return;
        }




    }

    private void enregistreEmployeDejaEnregistre(Scanner scanner) {
        Print.log("=== Enregistre un employé  ===");
        // : WE ASK THE COMPANY FOR THE EMPLOYEE ID WHICH IS ONE WHICH IS UNIQUE OVER THE EMPLOYEE LIFE WORK
        Long id = Util.readLong("MATIRCULE",scanner);
        // : in this case we verify if the employee is already registered in the system BY MATIRCULE
        if (this.employeeService.isEmployeeExist(id)){
            Print.log("L'employé est déjà enregistré dans le système");
            double salary = Util.readDouble("Salaire",scanner);
            // TODO : if the employee is already registerd in the system we ask the comapny to provide his based salary
           boolean isSaved = this.employeeService.updateEmployeeSalary(id ,this.societeSession.id , salary);
        }else{
            Print.log("L'employé n'est pas enregistré dans le système");
        }
    }

    private void enregistreEmployeJamisEnregistre(Scanner scanner) {
        employeDto.retaitre = Statusretaitre.NON ;
        employeDto.salaire = 0;
        employeDto.nom = Util.readString("Nom",scanner);
        employeDto.prenom = Util.readString("Prenom",scanner);
        employeDto.email = Util.readString("Email",scanner);
        employeDto.dateNaissance = Util.readString("Date de naissance",scanner);
        employeDto.tel = Util.readString("Tel",scanner);
        employeDto.salaire = Util.readDouble("Salaire de base",scanner);
        employeDto.societe = new SocieteDto();
        employeDto.societe.id  = this.societeSession.id;
        employeDto.societe.email = this.societeSession.email;
        EmployeDto employeDto1 = this.employeeService.addEmployee(employeDto);
        if (employeDto1 != null) {
            Print.log("L'employé a été enregistré avec succès");
            Print.log("MATIRCULE : " + employeDto1.matricule);
        }else {
            Print.log("L'employé n'a pas été enregistré avec succès");
        }
        this.displayMainOptions(scanner);
    }

}
