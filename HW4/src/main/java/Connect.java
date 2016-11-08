import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Yoko on 06.11.2016.
 */
public class Connect {
    static final String DB_DRIVER = "org.postgresql.Driver";
    static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/SKLAD";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "12345678";
    private static Connection dbConnection = null;

    public static Connection getDBConnection() {

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
