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
public class Node {
    int height;
    int dat;
    Node left;
    Node right;
    
    public Node(int dat){
        this.dat = dat;
        height = 0;
    }
}
