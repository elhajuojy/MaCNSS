package ma.yc.database;

import ma.yc.core.Print;
import ma.yc.core.envLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private final envLoader envLoader = new envLoader();
    //WORNING: this is not a good practice to put the password in the code
    // : THOSE INFORMATION MUST COME FROM .ENV FILE
    public String url = envLoader.get("URL");
    private String username = envLoader.get("USER");
    private String password = envLoader.get("PASSWORD");
    private String driver = envLoader.get("DRIVER");


    private DatabaseConnection() throws SQLException {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, username, password);
            Print.log("Connection established.");
        } catch (ClassNotFoundException ex) {
            Print.log("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {

        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public static boolean closeConnection(){

        if (instance ==null){
            return false;
        }else {
            try {
                instance.getConnection().close();
                instance = null;
                return true;
            } catch (SQLException e) {
                Print.log(e.toString());
            }
        }
        return false;
    }


}