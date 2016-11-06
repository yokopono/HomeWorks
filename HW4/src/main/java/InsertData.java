import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

    public static void main(String[] args) {

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
            dbConnection = Connect.getDBConnection();
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
            dbConnection = Connect.getDBConnection();
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
