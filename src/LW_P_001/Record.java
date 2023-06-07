package LW_P_001;

public record Record(String strName, String strArtist, String strGenre, String strYear, String strBPM,
                         String strEnergy, String strDance){

    /**
     * Constructor for the Record class
     * @param strName
     * @param strArtist
     * @param strGenre
     * @param strYear
     * @param strBPM
     * @param strEnergy
     * @param strDance
     */
    public Record(String strName, String strArtist, String strGenre, String strYear, String strBPM,
                     String strEnergy, String strDance) {
        this.strName = strName;
        this.strArtist = strArtist;
        this.strGenre = strGenre;
        this.strYear = strYear;
        this.strBPM = strBPM;
        this.strEnergy = strEnergy;
        this.strDance = strDance;
    }

    /**
     * Sets the record data type to a String array in order to properly function with the AVL tree methods
     * @return data = a String[] that contains the necessary information
     */
    public String[] recordToStringArray() {
        String[] data = new String[8];
        data[0] = "Doesn't matter";
        data[1] = strName;
        data[2] = strArtist;
        data[3] = strGenre;
        data[4] = strYear;
        data[5] = strBPM;
        data[6] = strEnergy;
        data[7] = strDance;
        return data;
    }

}
