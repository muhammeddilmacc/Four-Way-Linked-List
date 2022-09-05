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
public class FourWayLinkedList {

    Node first, last, tempNode, tempFirst, tempLast;
    int size;
    int allMovements;

    public FourWayLinkedList(int size) {

        first = null;
        last = null;
        tempNode = null;
        tempFirst = null;
        tempLast = null;
        this.size = size;
        this.allMovements = 0;

        // creating matrix
        for (int i = 1; i <= size; i++) {

            for (int j = 1; j <= size; j++) {

                if (i == 1) {
                    insertFirstRow(0);
                } else {
                    insertOtherRow(0);
                }

            }//end of inner loop          
        }//end of outter loop

    }

    //inserting first row
    void insertFirstRow(int e) {

        Node newNode = new Node(0);

        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.prev = last;
        last = newNode;
        tempNode = first;
    }

    //inserting other row
    void insertOtherRow(int e) {

        Node newNode = new Node(0);

        if (tempFirst == null) {
            tempFirst = newNode;
            tempLast = newNode;
            tempNode.down = tempFirst;
            tempFirst.up = tempNode;

        } else {
            newNode.prev = tempLast;
            tempLast.next = newNode;
            tempLast = newNode;
            tempLast.up = tempNode;
            tempNode.down = tempLast;
        }

        //temporary node update
        if (tempNode.next != null) {
            tempNode = tempNode.next;
        } else {
            tempNode = tempFirst;
            tempFirst = null;
            tempLast = null;
        }

    }

    // it returns starting point
    public Node StartingNode(int starti, int startj) {
        Node temp = first;
        //find Starting point
        for (int i = 1; i < starti; i++) {
            temp = temp.down;
        }
        for (int i = 1; i < startj; i++) {
            temp = temp.next;
        }
        temp.element++;
        allMovements++;
        return temp;
    }
    
    // starts move until no left node to visited
    public void startMoving(Node currNode) {

        if (isAllVisited()) {
            return;
        }
        int way = (int) (1 + Math.random() * 4);
        Node temp = move(way, currNode);

        startMoving(temp);

    }

    //goes one step randomly
    public Node move(int way, Node temp) {

        switch (way) {

            case 1: //move up
                if (temp.up != null) {
                    temp = temp.up;
                    temp.element++;
                    allMovements++;
                }
                break;

            case 2: // move right
                if (temp.next != null) {
                    temp = temp.next;
                    temp.element++;
                    allMovements++;
                }
                break;

            case 3: //move down
                if (temp.down != null) {
                    temp = temp.down;
                    temp.element++;
                    allMovements++;
                }
                break;

            case 4: //move left
                if (temp.prev != null) {
                    temp = temp.prev;
                    temp.element++;
                    allMovements++;
                }
                break;
        }

        return temp;

    }

    // check whether all node are visited or not
    public boolean isAllVisited() {

        Node temp1 = first;
        Node temp2 = first;
        int counter = 0;

        while (temp2 != null) {

            while (temp1 != null) {

                if (temp1.element == 0) {
                    return false;
                }

                if (temp1.element != 0) {
                    counter++;
                }
                temp1 = temp1.next;
            }

            temp2 = temp2.down;
            temp1 = temp2;

        }

        return (counter >= size * size) ? true : false;
    }

    // prints matrix.
    public void print() {

        Node temp1 = first;
        Node temp2 = first;

        System.out.println("____________________________________________\n");

        while (temp2 != null) {

            while (temp1 != null) {

                System.out.printf("%2d    ", temp1.element);

                temp1 = temp1.next;
            }//inner loop

            System.out.println("");
            temp2 = temp2.down;
            temp1 = temp2;

        }// outter loop
        System.out.println("____________________________________________");
    }

}
