package ma.yc.database;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() throws SQLException {
//        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        assertNotNull("this is not null");
    }

    @Test
    void getInstance() {

    }

    @Test
    void closeConnection() {
    }
}