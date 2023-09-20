package ma.yc;

import ma.yc.core.Print;
import ma.yc.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {

        try {
            Scanner scanner = new Scanner(System.in);
            Print.log("Library Application ");

            int mainChoice = 0;
            do {
                //todo: add the other use cases
                Print.log("=== OPERATION  ===");
            }while (mainChoice > 0 && mainChoice < 4);
            scanner.close();
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
