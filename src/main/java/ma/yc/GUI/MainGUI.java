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
        Print.log("0 - Exit ");
        int choice = scanner.nextInt();

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
            default:
                //exit the application in default case
                break;
        }
        return choice;
    }
}
