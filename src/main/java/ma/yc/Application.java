package ma.yc;

import ma.yc.core.Print;
import ma.yc.database.DatabaseConnection;

import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {

        try {
            Print.log("Library Application ");

            do {
                //todo: add the other use cases
                Print.log("=== OPERATION  ===");
            }while (false);
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
