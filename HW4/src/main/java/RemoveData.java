import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yoko on 04.11.2016.
 */
public class RemoveData {

    public static void main(String[] args) {

    }

    public static void removeDataInTableSklad(String s) throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        String key = s;

        String insertTableSQL = "DELETE FROM sklad WHERE name ='"+ key+"'";

        try {
            dbConnection = Connect.getDBConnection();
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
            dbConnection = Connect.getDBConnection();
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
