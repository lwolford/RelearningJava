package LW_P_010;

public class HashEntry {

    String strKey;
    String[] strValue;

    /**
     * HashEntry constructor
     * @param strKey = key
     * @param strValue = value
     */
    public HashEntry(String strKey, String[] strValue) {
        this.strKey = strKey;
        this.strValue = strValue;
    }

    /**
     * Prints the results out neatly for the user to understand
     * @return strResults = the formatted movie title, genre, director, and year
     */
    public String returnResults() {
        String strResults = strKey + " | ";
        strResults += strValue[0] + " | ";
        strResults += strValue[2] + " | ";
        strResults += strValue[1];
        return strResults;
    }

}
