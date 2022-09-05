/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

public class Node {

    int element;
    Node next;
    Node prev;
    Node up;
    Node down;

    public Node(int element) {
        
        this.element = element;
        next = prev = up = down = null;

    }
}
