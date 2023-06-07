package HashMapThingy;

import static java.util.Objects.hash;

public class LWHashDriver implements MoviesProject{

    public static void main(String[] args) {

        LWHashDriver proj = new LWHashDriver();

        String strName = "Star Wars";
        System.out.println(Math.abs(strName.hashCode()) % 1000);

    }

    LWHashMap map;

    public LWHashDriver() {
        map = new LWHashMap();

        int result = hash("Hello World");
        System.out.println(result);
    }

    public void go() {
        // read the file
        // add the data

        String[] data = {"First", "Second", "etc"};  //example. real version would get this from the file

        add("Ghostbuster V", data);
    }

    @Override
    public String find(String movie) {
        return null;
    }

    @Override
    public boolean add(String movie, String[] entry) {
        // entry would be converted to the aggregate type, i.e. container, i.e. record class
        return map.add(movie, movie);
    }

    @Override
    public boolean delete(String movie) {
        return false;
    }

    @Override
    public void printHT() {

    }

    @Override
    public double getLoadFactor() {
        return 0;
    }

    @Override
    public double getMaxLoadFactor() {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void who() {

    }

    @Override
    public void help() {

    }

    @Override
    public void exit() {
        System.out.println("Goodbye");
    }
}
