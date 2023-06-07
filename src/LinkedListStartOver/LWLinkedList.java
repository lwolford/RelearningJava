package LinkedListStartOver;

public class LWLinkedList<T> {

    private Node head;
    private Node tail;
    private int intCounter;

    private class Node<T> {

        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {

            this.data = data;

        }

        public T getData() {
            return data;
        }

        public void setData(T e) {
            this.data = data;
        }

    }

    // if: If the counter is 0 (head is null), then the head is set to newNode, and newNode.prev is set to null
    // else: Create a temporary node to get to the end of the actual linked list, then set newNode to temp.next to add to the end of the list
    public void addLast(T e) {
        Node<T> newNode = new Node<T>(e);
        if (intCounter == 0) {
            head = newNode;
            tail = newNode;
            newNode.prev = null;
        } else {
            Node<T> temp = head;
            while(temp.next != null) {
                temp.prev = temp;
                temp = temp.next;
            }
            if (intCounter == 1) newNode.prev = head;
            else newNode.prev = temp;
            temp.next = newNode;
            tail = newNode;
        }
        intCounter++;
    }

    // Adds a new node at the specified index
    public void addAtIndex(T e, int intIndex) {
        Node<T> newNode = new Node<T>(e);
        int intCurrentPosition = 1;
        int intMax = intCounter +1;

        // If the wanted index is greater than the final node + 1, then it prevents the node from being added
        if (intIndex > intMax) {
            System.out.println("The length of the Linked List is only " + intCounter);
            System.out.println("Try the number " + intMax + " or lower");
            return;
        }
        // If the index is less than 1 (the head), then it prevents the node from being added
        else if(intIndex < 1) {
            System.out.println("Can't add at any index below 1");
            return;
        }
        else {

            //Insert new head
            if (intIndex == 1) {
                newNode.next = head;
                head.prev = newNode;
                newNode.prev = null;
                head = newNode;
            }
            // Insert new tail
            else if (intIndex == intMax) {
                Node<T> storeTail = tail;
                tail.next = newNode;
                tail = newNode;
                tail.prev = storeTail;
            }
            //Insert in the middle
            else {
                Node<T> temp = head;
                while (intCurrentPosition != intIndex) {
                    temp = temp.next;
                    intCurrentPosition++;
                }
                Node<T> storeNext = temp.next;
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = storeNext;
                storeNext.prev = newNode;
            }

        }
        intCounter++;
    }

    // Removes the first value from the queue/linked list
    public T removeFirst() {

        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;

        T rVal = (T)temp.getData();
        intCounter--;
        return rVal;

    }

    //Prints the full link list, in the same style as toString
    public void printList() {
        if (head == null) {
            return;
        }

        Node<T> temp = head;
        System.out.print("[");
        while(temp != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.next;
        }
        System.out.print("\b\b]");

        System.out.println();
    }

    //Gives the length of the LinkedList;
    public int length() {
        return intCounter;
    }

}
