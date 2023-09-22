package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.service.PatientService;

import java.util.Scanner;

public class MainPaitentGUI implements DisplayGUI{

    private PatientService patientService;

    @Override
    public int displayMainOptions(Scanner scanner) {

        //Patient have two many actions to do
        //1 - consult his dossier by Matricule

        Print.log("=== OPERATION  ===");
        Print.log("1 - Consult your dossier by Matricule ");
        Print.log("2 - Consult all dossiers ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //consult dossier by matricule
                Print.log("Matricule : ");
                String matricule = scanner.next();
                this.patientService.consulterDossierMatricule(matricule);
                break;
            case 2:
                //consult all dossiers
                this.patientService.consulterDossiers();
                break;
            case 0:
                //exit
                return -1;
            default:
                Print.log("Invalid choice");
                break;
        }



        return 0;
    }
}
