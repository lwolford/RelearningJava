/*
 *
 */
package AVL_Example;

/**
 *
 * @author jrose
 */
public class AVLExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLExample ex1 = new AVLExample();
        ex1.go();
    }
    
    AVLTree tree;
    
    public AVLExample(){
        tree = new AVLTree();
    }
    public void go(){
        System.out.println("Here we go!");
        
        add(30);
        add(20);
        add(10);
    }
    
    public void add(int n){
        tree.add(n);
    }
}
