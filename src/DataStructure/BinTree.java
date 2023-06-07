package DataStructure;

public class BinTree {

    BinNode root;

    public BinTree() {
        System.out.println("Made a tree");
    }

    public void printVLR() {
        printVLR(root);
        System.out.println();
    }

    //Pre-Order
    private void printVLR(BinNode current) {

        if (current == null) {
            // System.out.print("null");
            return;
        }

        System.out.println(current.intValue);
        printVLR(current.left);
        printVLR(current.right);

    }

    public void printLRV() {
        printLRV(root);
        System.out.println();
    }

    //Post-Order
    private void printLRV(BinNode current) {

        if (current == null) {
            // System.out.print("null");
            return;
        }

        printLRV(current.left);
        printLRV(current.right);
        System.out.println(current.intValue);

    }

    public void printLVR() {
        printVLR(root);
        System.out.println();
    }

    //In-Order
    private void printLVR(BinNode current) {

        if (current == null) {
            // System.out.print("null");
            return;
        }

        printLVR(current.left);
        System.out.println(current.intValue);
        printLVR(current.right);

    }

}
