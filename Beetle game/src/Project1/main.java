package Project1;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //write your code here

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the size of matrix: ");
        int size = input.nextInt();

        FourWayLinkedList matrix = new FourWayLinkedList(size);

        // creating random start point
        int starti = (int) (1 + Math.random() * size);
        int startj = (int) (1 + Math.random() * size);

        Node startingNode = matrix.StartingNode(starti, startj);

        matrix.startMoving(startingNode);
        matrix.print();
        System.out.println("\nNumber of all movement: " + matrix.allMovements);

        System.out.println("");

        AVLTree tree = new AVLTree();
        
        // inserting data to AVL tree from matrix
        insertIntoAVLTree(matrix.first, tree);
        
        System.out.println("Last Shape Of Tree;\n");
        tree.printAllOrder();

    }

    public static void insertIntoAVLTree(Node first, AVLTree tree) {

        Node temp1 = first;
        Node temp2 = first;

        while (temp2 != null) {

            while (temp1 != null) {
                tree.insert(temp1.element);
                
                temp1 = temp1.next;
            }

            temp2 = temp2.down;
            temp1 = temp2;

        }
    }

}
