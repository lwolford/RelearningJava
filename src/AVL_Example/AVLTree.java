/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL_Example;

/**
 *
 * @author jrose
 */
public class AVLTree {
    Node root;
    
    /**
     * Height of node
     * @param nd
     * @return 
     */
    int height(Node nd){
        if(nd==null){
            return -1;
        }
        return nd.height;
    }
    
    /**
     *  Checking balance
     * @param nd
     * @return 
     */
    int checkBalance(Node nd){
        if(nd == null){
            return 0;
        }
        
        return height(nd.left) - height(nd.right);
    }
    
    /**
     *  Returns highest value
     * @param a
     * @param b
     * @return 
     */
    public int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    /**
     * 
     * @param dat 
     */
    public void add(int dat){
        root = add(root, dat); // kicks off recursion
    }
    
    Node add(Node nd, int dat){
        if(nd == null){
            return new Node(dat);
        }
        
        // BST insertion
        if(dat < nd.dat){   // does not allow dupe keys (bc of keymap reasons)
            nd.left = add(nd.left, dat);
        }else if(dat > nd.dat){
            nd.right = add(nd.right, dat);
        } else {    // dat is ==
            return nd;
        }
        
        // here is where rebalancing happens
        // update height
        nd.height = max(height(nd.left), height(nd.right)) + 1;
        
        // check the balance
        int balance = checkBalance(nd);
        
        if((balance > 1) && (dat < nd.left.dat)){
            nd = rotateRight(nd);
        }
        // other imbalance cases go here //
        
        return nd;
    }
    
    // for left left
    Node rotateRight(Node C){
        System.out.println("rotate right->");
        
        Node B = C.left;
        Node y = B.right;
        
        // rotate 
        B.right = C;
        C.left = y;
        
        // update heights
        B.height = max(height(B.left), height(B.right)) + 1;
        C.height = max(height(C.left), height(C.right)) + 1;
        
        // return new root
        return B;
    }
    
    // need to do for left rotate (opposite of right rotate) 
    
    // and double right rotate
    
    // and double left rotate
}
