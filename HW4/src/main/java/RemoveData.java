import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yoko on 04.11.2016.
 */
public class RemoveData {
    static final String DB_DRIVER = "org.postgresql.Driver";
    static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/SKLAD";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "dtfXcNKu4";

    public static void main(String[] args) {

    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
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

    public static void removeDataInTableSklad(String s) throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        String key = s;

        String insertTableSQL = "DELETE FROM sklad WHERE name ='"+ key+"'";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.executeUpdate(insertTableSQL);
            System.out.println("Data was delete from table SKLAD");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    public static void removeDataInTableTovar(String s) throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = s;

        String insertTableSQL = "DELETE FROM tovar WHERE tovar_id ="+ key;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.executeUpdate(insertTableSQL);
            System.out.println("Data was delete from table TOVAR");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

}
