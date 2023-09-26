package ma.yc;

import ma.yc.GUI.*;
import ma.yc.core.Print;
import ma.yc.database.DatabaseConnection;

import java.util.Scanner;


public class Application {


    public static void main(String[] args)  {
        DisplayGUI displayGUI = new MainGUI();
        Scanner scanner = new Scanner(System.in);
        try {
            Print.log("MACNSS Application ");

            int choice = 0;
            do {
                choice  = displayGUI.displayMainOptions(scanner);
            }while (choice != 0);
        } catch(Exception e){
            Print.log(e.toString());
        }
        finally {
            Print.log("Finally Done ");
            boolean isClosed = DatabaseConnection.closeConnection();
            Print.log(isClosed);
        }


    }

}
