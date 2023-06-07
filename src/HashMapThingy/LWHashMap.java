package HashMapThingy;

public class LWHashMap {

    String[] table; // Probably want to change the type of this
    int count; // the number of elements in this table

    public LWHashMap() {
        table = new String[9973];
    }

    public boolean add(String key, String value) {    // again, your value is probably better off as a different type
        int index = hash(key);
        table[index] = value;
        return false;

    }

    public String find(String key) {
        return "something";
    }

    public boolean remove(String key) {
        return false;
    }

    // other stuff

    // the return is the table index
    private int hash(String key) {
        int index = Math.abs(key.hashCode()) % table.length;

        return index;
    }

}
