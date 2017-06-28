package database;

/**
 * Created by young on 25.06.2017.
 */
public class SQL_States {

    //Tables
    private final static String TBL_aol = "aoldata.querydata";
    private final static String TBL_kandidat = "kandidat";
    private final static String TBL_teilnahme = "teilnahme";

    private final static String querytime = "querytime";
    private final static String query = "query";
    private final static String clickurl = "clickurl";
    private final static String contestDay = "21.04.06 00:00:00";
    private final static String searchMissUsa = "'%miss usa%'";
    private final static String qTimeToChar = "to_char(querytime,'mm-dd')";
    private final static String extractMonth = "extract(month from " + querytime + ")";

    private final static String name = "name";
    private final static String status = "status";
    private final static String platzierung = "platzierung";

    //Aufgabe 1.1
    public final static String WEBSITE = "SELECT " + clickurl + " AS Key, " +
            "COUNT(*) AS Anzahl " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + clickurl + " " +
            "HAVING COUNT(*) >= 10 " +
            "ORDER BY COUNT(*) DESC;";

    //Aufgabe 1.2
    public final static String CLICKS_PER_MONTHS = "SELECT COUNT(" + extractMonth + ") AS Anzahl, " +
            "CASE WHEN " + extractMonth + " = 3 then 'Maerz' " +
            "WHEN " + extractMonth + " = 4 then 'April' " +
            "WHEN " + extractMonth + " = 5 then 'Mai' end AS Key " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + extractMonth + " " +
            "ORDER BY " + extractMonth;

    //Aufgabe 1.3
    public final static String NAME_OF_CANDIDATE = "SELECT " + status + " AS Teilnehmerin, " + platzierung + " AS Platzierung, " +
            "COUNT(" + platzierung + " ) AS Anzahl " +
            "FROM "  + TBL_teilnahme + " INNER JOIN ( SELECT " + query + " FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE '%miss usa%' and " + query + " NOT LIKE '%200%') " + " " +
            "ON " + query + " LIKE LOWER('%' || " + status + " || '%') " +
            "OR " + query + " LIKE ('%' || " + platzierung  + "|| '%') " +
            "GROUP BY " + status + "," + platzierung + "," + name + " " +
            "ORDER BY COUNT(" + platzierung + ") DESC";

    //Aufgabe 1.4
    public final static String NAME_OF_WINNER = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";

    //Aufgabe 1.5
    public final static String DAYS_MOST_CLICKED = "SELECT " + qTimeToChar + " AS Key, " +
            "COUNT(*) AS Anzahl " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + qTimeToChar + " " +
            "HAVING COUNT(*) >= 5 " +
            "ORDER BY " + qTimeToChar;

    //Aufgabe 1.8
    public final static String PARTIC_BEFORE_CONTEST = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "WHERE " + querytime + " < '" + contestDay + "' " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";

    //Aufgabe 1.9
    public final static String PARTIC_AFTER_CONTEST = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "WHERE " + querytime + " >= '" + contestDay + "' " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";
}
