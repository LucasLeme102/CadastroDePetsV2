package ConnectionDb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnectiob() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/cadastro_pets";
        String password ="admin123";
        String username = "admin";
        return  DriverManager.getConnection(url, username, password);
    }
}
