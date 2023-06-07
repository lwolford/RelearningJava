package DataStructure;

public class BinDriver {

    public static void main(String[] args) {

        BinDriver ex = new BinDriver();
        ex.run();

    }

    public void run() {
        // make a tree
        BinTree t = new BinTree();
        BinNode n1 = new BinNode(5);
        BinNode n2 = new BinNode(4);
        BinNode n3 = new BinNode(7);
        BinNode n4 = new BinNode(1);
        BinNode n5 = new BinNode(2);

        t.root = n1;
        t.root.left = n2;
        t.root.right = n3;
        t.root.left.left = n4;
        t.root.left.right = n5;
        // add elements
        // look at this
    }

}
