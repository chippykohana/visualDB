package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by young on 25.06.2017.
 */
public class DB_Con {
    private static final String DBNAME = "dbsBeuth";
    //private static final String URL = "jdbc:oracle:thin:@dbl43.beuth-hochschule.de:1521:oracle";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:oracle";
    private static final String USER = "s856667";
    private static final String PASSWORD = "lovey";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private Connection con;
    private ArrayList<Info_Storage> list;

    private Connection connect(String dbname) throws SQLException {
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

    public void print(String statement) {
        String query = statement;
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            long begin = System.currentTimeMillis();
            rs = s.executeQuery(query);
            long executiontime = System.currentTimeMillis() - begin;
            list = this.printResultSet2Shell(rs, query, executiontime);
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

    public void openDB() throws SQLException {
        con = this.connect(DBNAME);
        System.out.println("Connected to: " +
                con.getMetaData().getDatabaseProductName() + " " +
                con.getMetaData().getDatabaseProductVersion()
        );
    }

    public void closeDB() throws SQLException {
        con.close();
        System.out.println("Connection is closed: " + con.isClosed());
    }

    private ArrayList<Info_Storage> printResultSet2Shell(ResultSet rs, String query, long executiontime) throws SQLException {
        ArrayList<Info_Storage> store = new ArrayList<>();

        System.out.println("===============================================================");
        System.out.println(query);
        System.out.println("Execution Time: " + executiontime + "ms");
        System.out.println("===============================================================");

        while (rs.next()) {
            String name = rs.getString("Key");
            int value = rs.getInt("Anzahl");
            System.out.println("name : " + name + " value: " + value);
            store.add(new Info_Storage(name,value));
        }

        System.out.println("===============================================================");
        return store;
    }
}
