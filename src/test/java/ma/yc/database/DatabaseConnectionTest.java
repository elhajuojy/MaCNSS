package ma.yc.database;

import ma.yc.core.envLoader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

//how to make maven recognize the test folder

class DatabaseConnectionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() throws SQLException {
      envLoader envloader1 = new envLoader();
      assertEquals("jdbc:mysql://localhost:3306/MACNSS",envloader1.get("URL"));
    }

    @Test
    void getInstance() {

    }

    @Test
    void closeConnection() {
    }
}