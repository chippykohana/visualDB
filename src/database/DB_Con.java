package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class DB_Con {
    //private static final String URL = "jdbc:oracle:thin:@dbl43.beuth-hochschule.de:1521:oracle";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:oracle";
    private static final String USER = "s860341";
    private static final String PASSWORD = "1997";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private Connection con;
    private ArrayList<Info_Storage> list;

    /**
     * Authentifizierung
     * @return Die Konnektivität zur Datenbank
     * @throws SQLException wirft eine Exception mit Fehlermeldung
     */
    private Connection connect() throws SQLException {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            System.out.println("driver funkt");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.exit(-1);
        }
        return con;
    }

    public ArrayList<Info_Storage> getList() {
        return list;
    }

    /**
     * Bearbeitung des SQL Statements und speichert die Datensätze in ein ResultSet
     * @param statement SQL Statement
     */
    public void print(String statement) {
        ResultSet rs;
        try {
            Statement s = con.createStatement();
            long begin = System.currentTimeMillis();
            rs = s.executeQuery(statement);
            long executiontime = System.currentTimeMillis() - begin;
            list = this.printResultSet2Shell(rs, statement, executiontime);
            rs.close();
            s.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.exit(-1);
        }
    }

    /**
     * Verbindung zur Datenbank herstellen
     * @throws SQLException wirft eine Exception mit Fehlermeldung
     */
    public void openDB() throws SQLException {
        con = this.connect();
        System.out.println("Connected to: " +
                con.getMetaData().getDatabaseProductName() + " " +
                con.getMetaData().getDatabaseProductVersion()
        );
    }

    /**
     * Verbindung zur Datenbank schliessen
     * @throws SQLException wirft eine Exception mit Fehlermeldung
     */
    public void closeDB() throws SQLException {
        con.close();
        System.out.println("Connection is closed: " + con.isClosed());
    }

    /**
     * In dieser Methode werden die Einträge der Ergebnisse jeweils in eine ArrayList gespeichert.
     * @param rs ResultSet
     * @param query Das SQL Statement
     * @param executiontime Gesamtzeit der Bearbeitung vom SQL Statement
     * @return eine ArrayList mit allen Ergebnissen, welches das SQL Statement liefert
     * @throws SQLException wirft eine Exception mit Fehlermeldung
     */
    private ArrayList<Info_Storage> printResultSet2Shell(ResultSet rs, String query, long executiontime) throws SQLException {
        ArrayList<Info_Storage> store = new ArrayList<>();

        System.out.println("===============================================================");
        System.out.println(query);
        System.out.println("Execution Time: " + executiontime + "ms");
        System.out.println("===============================================================");

        /*try {
            convertToCsv(rs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        while (rs.next()) {
            String name = rs.getString("Key");
            int value = rs.getInt("Anzahl");
            store.add(new Info_Storage(name,value));

        }

        System.out.println("===============================================================");
        return store;
    }

    /**
     * Speichert die Ergebnisse der SQL Anfragen in eine CSV Datei
     * @param rs ResultSet beinhaltet die Ergebnisse
     * @throws SQLException wirft eine Exception mit Fehlermeldung
     * @throws FileNotFoundException wirft eine Exception
     */
    private static void convertToCsv(ResultSet rs) throws SQLException, FileNotFoundException {
        PrintWriter csvWriter = new PrintWriter(new File("frage9.csv")) ;
        ResultSetMetaData meta = rs.getMetaData() ;
        int numberOfColumns = meta.getColumnCount() ;
        while (rs.next()) {
            StringBuilder row = new StringBuilder("\"" + rs.getString(1).replaceAll("\"", "\\\"") + "\"");
            for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
                row.append(",\"").append(rs.getString(i).replaceAll("\"", "\\\"")).append("\"");
            }
            csvWriter.println(row) ;
        }
        csvWriter.close();
    }
}
