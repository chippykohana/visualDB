package database;

/**
 * Created by young on 26.06.2017.
 */

/**
 * Ein Speicher für die Datensaetze aus der Datenbank
 */
public class Info_Storage {

    String key;
    int value;

    public Info_Storage(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}
