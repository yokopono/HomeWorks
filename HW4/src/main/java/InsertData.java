import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
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

    public static void insertDataInTableSklad(String s) throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        System.out.println("Ввод данных в таблицу Склад.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введи наименование склада");
            String valueName = s;


        String insertTableSQL = "INSERT INTO sklad(name) VALUES" +"('"+ valueName+"')";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.executeUpdate(insertTableSQL);
            System.out.println("Data was put in table SKLAD");
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

    public static void insertDataInTableTovar(String name, int price, int kolichestvo, String sklad) throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        System.out.println("Ввод данных в таблицу Товар.");

        String valueName = name;

        int valuePrice = price;

        int valueKolichestvo = kolichestvo;

        String valueSkladID = sklad;

        String insertTableSQL = "INSERT INTO tovar(name, price, kolichestvo, sklad) VALUES" +"('"+ valueName+"','"
                + valuePrice+"','"+ valueKolichestvo+"','"+ valueSkladID+"')";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.executeUpdate(insertTableSQL);
            System.out.println("Data was put in table TOVAR");
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
