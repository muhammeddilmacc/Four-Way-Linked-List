/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 *
 * @author Muhammed
 */
public class AVLNode {
    
    
    public int key;
    public AVLNode left;
    public AVLNode right;
    public int height;
    
    public AVLNode(int key){
        
        this.key = key;
        left = null;
        right = null;
        height = 1;
    
    }
}
