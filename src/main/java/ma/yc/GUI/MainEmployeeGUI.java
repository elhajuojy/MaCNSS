package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dto.EmployeDto;
import ma.yc.service.EmployeeService;
import ma.yc.service.impl.EmployeServiceImpl;
import pl.mjaron.etudes.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEmployeeGUI implements DisplayGUI{

    private EmployeeService employeeService;

    public MainEmployeeGUI() {
        this.employeeService = new EmployeServiceImpl();
    }

    //: THE EMPLOYE HAVE ONE OPTION TO CHOOSE WHICH IS THE CONSULTATION OF HIS ACCOUNT
    //  : 1 - CONSULTATION 2 - GO BACK TO THE MAIN MENU 0 - EXIT
    // : POUR CONSULTER SON COMPTE IT FAUT QUE L'EMPLOYE SAISIT SON (matricule)
    //si un employé change de socité, il garde le même matricule avec changement de société qu'elle a employé

    @Override
    public int displayMainOptions(Scanner scanner) {
        Print.log("=== Employee  OPERATION  ===");
        Print.log("1 - Consultation votre compte ");
        Print.log("2 - Go back to the main menu ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                this.authentification(scanner);
                break;
            case 2:
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

    private void authentification(Scanner scanner) {

        Print.log("=== Authentification  ===");
        String matricule;
        matricule = Util.readString("Matricule",scanner);
        String[] credentials  = {
                matricule
        };
        boolean isAuthentificated = this.employeeService.login(credentials);
        if (isAuthentificated){
            Print.log("you are authentificated");
            this.consultationCompte(matricule,scanner);
        }else {
            Print.log("something went wrong matirucle  or id not correct");
            this.authentification(scanner);
        }
    }

    private int consultationCompte(String matricule, Scanner scanner) {
        //consulter compte avec possibilité de savoir
        //s'il peut bénéficier d'une retraite ou non, si oui il peut voir son salaire de retraite
        //i guess i just need to show the user information about his account
        Print.log("=== Consultation compte  ===");
        // : CONSULTATION DU COMPTE DE L'EMPLOYE CALL SERVICE AND THAN DISPLAY THE RESULT
        EmployeDto employeDto =  this.employeeService.consultEmployee(Long.parseLong(matricule));
        ArrayList<EmployeDto> employeDtos = new ArrayList<>();
        employeDtos.add(employeDto);
        Print.log("=== Consultation compte  ===");
        Print.log("nom : "+employeDto.nom);
        Print.log("prenom : "+employeDto.prenom);
        Print.log("email : "+employeDto.email);
        Print.log("tel : "+employeDto.tel);
        Print.log("dateNaissance : "+employeDto.dateNaissance);
        Print.log("salaire : "+employeDto.salaire);
        Print.log("nombreJourTravaille : "+employeDto.nombreJourTravaille);
        Print.log("retaitre : "+employeDto.retaitre);
        Print.log("salaireRetraite : "+employeDto.salaireRetraite);

//        Print.log(employeDto.toString());
        Print.log("click any key to exit");
        scanner.next();
        return  0;
    }
}
