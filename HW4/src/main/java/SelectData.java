import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Yoko on 04.11.2016.
 */
public class SelectData {
    static final String DB_DRIVER = "org.postgresql.Driver";
    static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/SKLAD";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "dtfXcNKu4";

    public static void main(String[] args) {

    }

    public static String findSkladWhoHaveTovar(String nameTovar) throws SQLException {
        Connection dbConnection;
        Statement statement;
        String selectTableSQL = "SELECT \n" +
                "  sklad.name as sklad_name\n" +
                "FROM \n" +
                "  public.sklad, \n" +
                "  public.tovar\n" +
                "WHERE \n" +
                "  sklad.sklad_id = tovar.sklad AND\n" +
                "  tovar.name LIKE '%" +nameTovar+ "%';";
        String sklad_name="";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                sklad_name = rs.getString("sklad_name");
                System.out.println("Наименование склада : " + sklad_name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sklad_name;
    }

    public static void select() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Доступные команды: СКЛАД, ТОВАР, ТОВАР НА СКЛАДЕ, ПОИСК СКЛАДА ХРАНЯЩЕГО ТОВАР");
        String s = reader.readLine();
        try {
            if (s.equals("СКЛАД")) {selectDataInTableSklad();}
            else if (s.equals("ТОВАР")) {selectDataInTableTovar();}
            else if (s.equals("ПОИСК СКЛАДА ХРАНЯЩЕГО ТОВАР")) {
                System.out.println("Введи наименование товара");
                String nameTovar = reader.readLine();
                findSkladWhoHaveTovar(nameTovar);}
            else  if (s.equals("ТОВАР НА СКЛАДЕ")) {
                System.out.println("Введи наименование склада");
                String nameSklad = reader.readLine();
                selectTovarOnSklad(nameSklad);}
            else {
                System.out.println("Вы неправильно ввели команду, попробуйте заного");
                select();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private static void selectTovarOnSklad(String nameSklad) throws SQLException, IOException {
        Connection dbConnection;
        Statement statement;
        String selectTableSQL = "SELECT " +
                "  tovar.name as tovar_name, \n" +
                "  tovar.price as tovar_price, \n" +
                "  tovar.kolichestvo as tovar_kolichestvo, \n" +
                "  sklad.name as sklad_name\n" +
                "FROM " +
                "  public.sklad, \n" +
                "  public.tovar\n" +
                "WHERE " +
                "  sklad.sklad_id = tovar.sklad AND" +
                "  sklad.name LIKE '%" +nameSklad+ "%';";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String sklad_name = rs.getString("sklad_name");
                String tovar_name = rs.getString("tovar_name");
                String tovar_price = rs.getString("tovar_price");
                String tovar_kolichestvo = rs.getString("tovar_kolichestvo");

                System.out.println("Наименование склада : " + sklad_name);
                System.out.println("Наименование товара : " + tovar_name);
                System.out.println("Цена товара : " + tovar_price);
                System.out.println("Количество товара : " + tovar_kolichestvo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void selectDataInTableSklad() throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT sklad_id, name from sklad";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String sklad_id = rs.getString("sklad_id");
                String name = rs.getString("name");

                System.out.println("АЙДИ СКЛАДА : " + sklad_id);
                System.out.println("Наименование склада : " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void selectDataInTableTovar() throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT tovar_id, name, price, sklad from tovar";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String tovar_id = rs.getString("tovar_id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String kolichestvo = rs.getString("kolichestvo");
                String sklad = rs.getString("sklad");

                System.out.println("tovar_id : " + tovar_id);
                System.out.println("name : " + name);
                System.out.println("price : " + price);
                System.out.println("kolichestvo : " + kolichestvo);
                System.out.println("sklad : " + sklad);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
