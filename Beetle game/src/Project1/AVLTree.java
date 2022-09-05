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
public class AVLTree {

    AVLNode root;
    int counter = 0;
    

    public AVLTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
        if(counter > 0){
            
            printAllOrder();
            counter--;
        }
    }

    public AVLNode insert(AVLNode focus, int key) {
        if (focus == null) {
            focus = new AVLNode(key);
        } //insert left side
        else if (key < focus.key) {
            focus.left = insert(focus.left, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateMyLeft(focus);
                }
                counter++;
            }

        } //insert right side
        else if (key > focus.key) {
            focus.right = insert(focus.right, key);
            if (getBalance(focus) == -2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateMyRight(focus);
                }
                counter++;
            }

        } // case; key equal
        else {
        }

        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }

    public AVLNode rotateMyLeft(AVLNode focus) {
        AVLNode k = focus.left;
        focus.left = k.right;
        k.right = focus;

        //update heights
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode rotateMyRight(AVLNode focus) {
        AVLNode k = focus.right;
        focus.right = k.left;
        k.left = focus;

        //update heights
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode doubleRotateMyLeft(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode doubleRotateMyRight(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    public int height(AVLNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public int getBalance(AVLNode focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

    public void inorder(AVLNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public void preOrder(AVLNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(AVLNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key + " ");
    }

    public void printAllOrder() {

        System.out.print("In Order: ");
        inorder(root);
        System.out.println("");

        System.out.print("pre Order: ");
        preOrder(root);
        System.out.println("");

        System.out.print("post Order: ");
        postOrder(root);
        System.out.println("\n_________________________________________\n");

    }

}
