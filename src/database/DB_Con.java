package database;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by young on 25.06.2017.
 */
public class DB_Con {
    private static final String DBNAME = "dbsBeuth";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:oracle";
    private static final String USER = "s856667";
    private static final String PASSWORD = "lovey";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private Connection con;
    private HashMap<String, Integer> list;

    private Connection connect(String dbname) throws SQLException {
        Connection con = null;
        try {
            System.out.println("test");
            Class.forName(DRIVER);
            System.out.println("test");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.exit(-1);
        }
        return con;
    }

    public HashMap<String, Integer> getList() {
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

    private HashMap<String, Integer> printResultSet2Shell(ResultSet rs, String query, long executiontime) throws SQLException {
        HashMap<String, Integer> store = new HashMap<>();

        System.out.println("===============================================================");
        System.out.println(query);
        System.out.println("Execution Time: " + executiontime + "ms");
        System.out.println("===============================================================");

        while (rs.next()) {
            String name = rs.getString("Key");
            int value = rs.getInt("Anzahl");
            System.out.println("name : " + name + " value: " + value);
            store.put(name,value);
        }

        System.out.println("===============================================================");
        return store;
    }
}
