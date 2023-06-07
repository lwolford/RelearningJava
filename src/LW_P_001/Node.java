package LW_P_001;

public class Node {

    private String data;
    private int intHeight;
    Node left;
    Node right;

    /**
     * Constructor for the AVL node
     * @param data
     */
    public Node(String data) {
        this.data = data;
        intHeight = 0;
    }

    // Getters and Setters

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIntHeight() {
        return intHeight;
    }

    public void setIntHeight(int intHeight) {
        this.intHeight = intHeight;
    }

    /**
     * Overridden toString method for the node
     * @return returns the node's data as a string
     */
    @Override
    public String toString() {
        String strData = "[";
        strData += data.replace("~", ", ");
        strData += "]";
        return strData;
    }
}
