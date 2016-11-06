import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Yoko on 04.11.2016.
 */
public class SelectData {

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
            dbConnection = Connect.getDBConnection();
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

    public static ArrayList<String> selectTovarOnSklad(String nameSklad) throws SQLException, IOException {
        Connection dbConnection;
        Statement statement;
        ArrayList<String> list = new ArrayList<String>();

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
            dbConnection = Connect.getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String sklad_name = rs.getString("sklad_name");
                String tovar_name = rs.getString("tovar_name");
                String tovar_price = rs.getString("tovar_price");
                String tovar_kolichestvo = rs.getString("tovar_kolichestvo");

                list.add("Название склада " + sklad_name);
                list.add("Название товара " + tovar_name);
                list.add("Цена товара " + tovar_price);
                list.add("Количество товара" + tovar_kolichestvo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static ArrayList<String> selectDataInTableSklad() throws SQLException, IOException {
        Connection dbConnection;
        Statement statement;
        ArrayList<String> list = null;

        String selectTableSQL = "SELECT sklad_id, name from sklad";
        try {
            dbConnection = Connect.getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String sklad_id = rs.getString("sklad_id");
                String name = rs.getString("name");

                list.add("АЙДИ СКЛАДА : " + sklad_id);
                list.add("Наименование склада : " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private static ArrayList<String> selectDataInTableTovar() throws SQLException, IOException {
        Connection dbConnection;
        Statement statement;
        ArrayList<String> list = null;

        String selectTableSQL = "SELECT tovar_id, name, price, sklad from tovar";

        try {
            dbConnection = Connect.getDBConnection();
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

                list.add("tovar_id : " + tovar_id);
                list.add("name : " + name);
                list.add("price : " + price);
                list.add("kolichestvo : " + kolichestvo);
                list.add("sklad : " + sklad);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
