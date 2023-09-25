package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.dto.DossierDto;
import ma.yc.service.impl.DossierServiceImpl;

import java.util.Scanner;

public class MainGUI  implements  DisplayGUI{


    @Override
    public int displayMainOptions(Scanner scanner)  {
        Print.log("=== OPERATION  ===");
        Print.log("1 - are you an admin ? ");
        Print.log("2 - are you an agent ? ");
        Print.log("3 - are you a patient ? ");
        //Todo:Test save dossier to database ...
        Print.log("4 - Add Dossier to database Test");
        Print.log("0 - Exit ");
        //get the choice from the user
        int choice = scanner.nextInt();

//        //using
//        String[] options = {"Administeur", "Agent", "Patient"};
//
//        String userOption = "Main"+options[choice-1]+"GUI";
//        Print.log(userOption);
//        try{
//            DisplayGUI displayGUI = (DisplayGUI) Class.forName(userOption).newInstance();
//           displayGUI.displayMainOptions(scanner);
//        }catch (Exception e) {
//            Print.log("Your choice is not valid");
//            e.printStackTrace();
//        }
//        ;
        switch (choice) {
            case 1:
                new MainAdministeurGUI().displayMainOptions(scanner);
                break;
            case 2:
                    new MainAgentGUI().displayMainOptions(scanner);
                break;
            case 3:
                new MainPaitentGUI().patientDashboard(scanner);
                break;
//            case 4:
//                new DossierServiceImpl().enregistrerDossier(new DossierDto());
//                break;
            default:
                //exit the application in default case
                break;
        }
        return choice;
    }
}
