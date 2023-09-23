package ma.yc.GUI;

import com.sun.tools.javac.Main;
import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dao.PatientDao;
import ma.yc.dto.DossierDto;
import ma.yc.dto.PatientDto;
import ma.yc.service.PatientService;
import ma.yc.service.impl.PatientServiceImpl;

import java.security.PublicKey;
import java.util.Scanner;

public class MainPaitentGUI implements DisplayGUI{

    private PatientService patientService;

    public MainPaitentGUI() {
        this.patientService = new PatientServiceImpl();
    }

    @Override
    public int displayMainOptions(Scanner scanner) {
       this.patientAuth(scanner);
        return 0;
    }

    public int patientAuth(Scanner scanner){
        Print.log("Bienvenue dans l'application de gestion des patients");
        Print.log("Authentification");
        String matricule = Util.readString("Matricule",scanner);
        PatientDto patientDto = new PatientDto();
        patientDto.matricule = matricule;
        boolean isAuth = this.patientService.authentification( patientDto);
        if (isAuth){
            this.patientDashboard(scanner);
        }

        Print.log("this matricule is not correct ");
        return 0;
    }
    public boolean authentifier(PatientDto patientDto) {
        return this.patientService.authentification(patientDto);
    }

    private int patientDashboard(Scanner scanner) {
        Print.log("=== OPERATION  ===");
        Print.log("1 - Consult your dossier by num_dossier ");
        Print.log("2 - Consult all dossiers ");
        //go back to the main menu
        Print.log("3 - Go back to the main menu ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //consult dossier by matricule
                Print.log("Entre le num_dossier de votre dossier");
                String code_bar = Util.readString("num_dossier",scanner);
                Print.log("Entre votre matricule");
                String matricule = Util.readString("Matricule",scanner);
                DossierDto dossierDto = new DossierDto(code_bar,matricule);
                this.patientService.consulterDossierParCode(dossierDto);
                break;
            case 2:
                Print.log("Entre votre matricule");
                String codePatient = Util.readString("Matricule",scanner);
                DossierDto dossierDto1 = new DossierDto(null, codePatient);
                this.patientService.consulterDossiers(dossierDto1);
                break;
            case 3:
                //go back to the main menu
                Print.log("Go back to the main menu");
                new MainGUI().displayMainOptions(scanner);
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
