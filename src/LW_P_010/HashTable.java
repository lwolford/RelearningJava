package LW_P_010;

public class HashTable {

    private int intSize;
    private HashEntry[] table;

    /**
     * Hash table constructor
     * @param intCapacity = capacity of the array
     */
    public HashTable(int intCapacity) {
        intSize = 0;
        table = new HashEntry[intCapacity];
    }

    /**
     * Gets the current number of entries in the hash table
     * @return intSize = number of entries in the hash table
     */
    public int getIntSize() {
        return intSize;
    }

    /**
     * Gets the correct index point for the key being sent into the getHash() method
     * @param strKey = The hash entry key
     * @return intIndex = the correct index for this key
     */
    private int getHash(String strKey) {
        int intIndex = Math.abs(strKey.hashCode()) % table.length;
        return intIndex;
    }

    /**
     * Adds a new entry to the hash table
     * @param strKey = the hash entry key
     * @param strValue = the hash entry value
     * @return true if the entry is successfully added, false if the entry is not successfully added
     */
    public boolean add(String strKey, String[] strValue) {
        if (getLoadFactor() < 0.8) {
            int intStoreHash = getHash(strKey);
            if (table[intStoreHash] == null) {
                table[intStoreHash] = new HashEntry(strKey, strValue);
                intSize++;
                return true;
            } else {
                for (int i = 0; i < table.length; i++) {
                    int intNewHash = (intStoreHash + i * i) % table.length;
                    if (table[intNewHash] == null) {
                        table[intNewHash] = new HashEntry(strKey, strValue);
                        intSize++;
                        return true;
                    }
                }
                return false;
            }
        }
        else {
            System.out.println("Sorry, this hash table's load factor is too high. Your information could not be added");
            return false;
        }
    }

    /**
     * Returns the value using the requested key
     * @param strKey = the hash entry key
     * @return the index's HashEntry if not null, null if the index is null
     */
    public HashEntry get(String strKey) {
        int intStoreHash = getHash(strKey);
        if (table[intStoreHash] != null) {
            if (table[intStoreHash].strKey.equals(strKey)) {
                return table[intStoreHash];
            } else {
                for (int i = 0; i < table.length; i++) {
                    int intNewHash = (intStoreHash + i * i) % table.length;
                    if (table[intNewHash].strKey.equals(strKey)) return table[intNewHash];
                }
                return null;
            }
        }
        return null;
    }

    /**
     * Removes an entry from the table using the specified key
     * @param strKey = specified key
     * @return true if the node is successfully removed, false if the node is not removed
     */
    public boolean remove(String strKey) {
        int intStoreHash = getHash(strKey);
        if (table[intStoreHash] != null) {
            if (table[intStoreHash].strKey.equals(strKey)) {
                table[intStoreHash] = null;
                return true;
            } else {
                for (int i = 0; i < table.length; i++) {
                    int intNewHash = (intStoreHash + i * i) % table.length;
                    if (table[intNewHash].strKey.equals(strKey)) {
                        table[intNewHash] = null;
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Prints the entire hash table, prints the index number of the table and that index's key
     */
    public void printHT() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) System.out.println("Index " + i + ": " + table[i].strKey);
        }
    }

    /**
     * Gets the current load factor of the table
     * @return intSize/table.length = the load factor of the table
     */
    public double getLoadFactor() {
        return intSize/table.length;
    }

}
