package database;

/**
 * Created by young on 26.06.2017.
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

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
