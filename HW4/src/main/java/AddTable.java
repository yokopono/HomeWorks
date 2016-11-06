import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTable {

    public static void main(String[] args) {

    }

    public static void createTableSklad() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE public.SKLAD"
                + "("
                + "sklad_id serial NOT NULL,"
                + "name text NOT NULL,"
                +"PRIMARY KEY(sklad_id)"
                + ")"
                + "WITH ("
                + " OIDS=FALSE"
                + ");";

        try {
            dbConnection = Connect.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table SKLAD by "+ Connect.DB_USER+ " is created!");
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
    public static void createTableTovar() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE public.TOVAR"
                +"("
                +    "tovar_id serial NOT NULL,"
                +   "name text NOT NULL,"
                +   "price integer NOT NULL,"
                +   "kolichestvo integer NOT NULL,"
                +    "sklad integer NOT NULL,"
                +"PRIMARY KEY(tovar_id)"
                +")"
                +"WITH ("
                +" OIDS=FALSE"
                +");";

        try {
            dbConnection = Connect.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table Tovar by "+ Connect.DB_USER+ " is created!");
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
