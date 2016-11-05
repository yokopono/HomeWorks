import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTable {
    static final String DB_DRIVER = "org.postgresql.Driver";
    static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/SKLAD";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "dtfXcNKu4";

    public static void main(String[] args) {
        getDBConnection();
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
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table SKLAD by "+ DB_USER+ " is created!");
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
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table Tovar by "+ DB_USER+ " is created!");
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
