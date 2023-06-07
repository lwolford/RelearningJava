package DataStructure;

import javax.swing.*;
import java.util.LinkedList;

public class LWLinkedList<T> {

    private static class Node<T> {

        private T dat;
        private Node next;
        private Node prev;

        Node(T dat) {

            this.dat = dat;

        }

        public T getDat() {
            return dat;
        }

        public void setDat(T dat) {
            this.dat = dat;
        }
    }

    private Node head;
    private int count = 0;

    public LWLinkedList() {

        head = null;

    }

    /*public void addLast(T e) {
        //Nothing in the list
        if (head == null) {
            // make node
            head = new Node(e);
        }
        else if (head.next == null){
            Node n = new Node(e);
            head.next = n;
        }
        else {
            Node node = new Node(e);
            while (head.next != null) {
                node = node.next;
            }
            Node n = new Node(e);
            node.next = n;
        }

    }*/

    public void addLast(T e) {
        if (count == 0) {
            head = new Node<T>(e);
        }
        else {

            Node<T> node = head;
            while (node.next != null) {
                node.prev = node;
                node = node.next;
            }

            Node<T> newNode = new Node<T>(e);
            newNode.prev = newNode;
            node.next = newNode;
        }
        count++;
    }

    public void addAtIndex(T e, int index) {
        Node<T> newNode = new Node<T>(e);

        if (head == null) {
            if (index != 0) {
                return;
            }
            else {
                head = newNode;
            }
        }

        if (head != null && index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currentNode = head;
        Node previousNode = null;

        for (int i=0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if (currentNode == null) break;
        }
    }

    // Prints the List, but then destroys it. Will hopefully figure out a better system before time is up
    public void PrintLinkedList() {

        if (head != null) {
            System.out.println(head.getDat());
            while(head.next != null) {
                head = head.next;
                System.out.println(head.getDat());
            }
        }
        else {
            System.out.println("This list has no elements");
        }


    }

    public T removeFirst() {

        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;

        T rVal = (T)temp.getDat();

        return rVal;

    }

}
