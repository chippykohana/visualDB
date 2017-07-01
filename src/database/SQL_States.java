package database;

/**
 * Die SQL Statements
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
    private final static String qTimeToCharHour = "to_char(querytime,'HH24')";
    private final static String qTimeToCharDate = "to_char(querytime,'mm-dd')";
    private final static String extractMonth = "extract(month from " + querytime + ")";

    private final static String name = "name";
    private final static String status = "teilnahme.status";
    private final static String platzierung = "teilnahme.platzierung";

    //Anfrage 1.1
    public final static String WEBSITE = "SELECT nvl((" + clickurl + "), 'undefiniert') AS Key, " + "COUNT(*) AS Anzahl " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + clickurl + " " +
            "HAVING COUNT(*) >= 10 " +
            "ORDER BY COUNT(*) DESC";

    //Anfrage 1.2
    public final static String CLICKS_PER_MONTHS = "SELECT COUNT(" + extractMonth + ") AS Anzahl, " +
            "CASE WHEN " + extractMonth + " = 3 then 'Maerz' " +
            "WHEN " + extractMonth + " = 4 then 'April' " +
            "WHEN " + extractMonth + " = 5 then 'Mai' end AS Key " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + extractMonth + " " +
            "ORDER BY " + extractMonth;

    //Anfrage 1.3
    public final static String NAME_OF_CANDIDATE = "SELECT " + status + " AS Key, " +
            "COUNT(" + platzierung + ") AS Anzahl " +
            "FROM " + TBL_teilnahme + " INNER JOIN (SELECT " + query + " FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE '%miss usa%' and " + query + " NOT LIKE '%200%') " +
            "ON " + query + " LIKE LOWER('%' || " + status + " || '%') " +
            "OR " + query + " LIKE ('%' || " + platzierung + "|| '%') " +
            "GROUP BY " + status + "," + platzierung + " " +
            "ORDER BY COUNT(" + platzierung + ") DESC";

    //Anfrage 1.4
    public final static String NAME_OF_WINNER = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";

    //Anfrage 1.5
    public final static String DAYS_MOST_CLICKED = "SELECT " + qTimeToCharDate + " AS Key, " +
            "COUNT(*) AS Anzahl " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + qTimeToCharDate + " " +
            "HAVING COUNT(*) >= 5 " +
            "ORDER BY " + qTimeToCharDate;

    //Anfrage 1.6
    public final static String MOST_CLICKED_GENERAL = "";

    //Anfrage 1.7
    public final static String TIME = "SELECT " + qTimeToCharHour + " AS Key, " +
            "COUNT(" + qTimeToCharHour + ") AS Anzahl " +
            "FROM " + TBL_aol + " " +
            "WHERE " + query + " LIKE " + searchMissUsa + " " +
            "GROUP BY " + qTimeToCharHour + " " +
            "ORDER BY " + qTimeToCharHour;

    //Anfrage 1.8
    public final static String PARTIC_BEFORE_CONTEST = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "WHERE " + querytime + " < '" + contestDay + "' " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";

    //Anfrage 1.9
    public final static String PARTIC_AFTER_CONTEST = "SELECT " + name + " AS Key, " +
            "COUNT(" + name + ") AS Anzahl " +
            "FROM " + TBL_aol + " INNER JOIN " + TBL_kandidat + " ON " + query + " LIKE LOWER('%' || " + name + " || '%') " +
            "WHERE " + querytime + " >= '" + contestDay + "' " +
            "GROUP BY " + name + " " +
            "ORDER BY COUNT(" + name + ") DESC";
}
