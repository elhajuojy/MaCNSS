package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.service.SocieteService;

import java.util.Scanner;

public class MainSocieteGUI implements DisplayGUI{

    private SocieteService societeService;


    @Override
    public int displayMainOptions(Scanner scanner) {
        Print.log("=== Societe  OPERATION  ===");
        return 0;
    }
}
