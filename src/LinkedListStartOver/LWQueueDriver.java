package LinkedListStartOver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LWQueueDriver {

    public static void main(String[] args) {

        // Index starts at 1
        LWLinkedList<String> list = new LWLinkedList<>();
        ArrayList<String> alist = new ArrayList<>();

        list.addLast("Hello");
        list.addLast("Hello Again");
        list.addLast("Hello a Third");
        list.addLast("Hello a Fourth");
        list.addLast("Hello a Fifth");

        alist.add("A Hello");
        alist.add("A hello again");
        alist.add("A hello a third");
        alist.add("A hello a fourth");
        alist.add("A hello a fifth");

        list.removeFirst();
        alist.remove(0);

        list.addAtIndex("Hello a 3.5th", 2);
        alist.add(2, "A Hello a 3.5th");

        list.addAtIndex("Hello a 3.4th", 2);
        alist.add(2, "A Hello a 3.4th");

        list.printList();
        System.out.println(alist.toString());

        // Testing for addAtIndex
        /*list.addAtIndex("Hello a 3.5th", 3);
        list.addAtIndex("Final Node", 7);
        list.addAtIndex("Hello a 3.6th", 3);
        list.addAtIndex("Hello a 3.7th", 3);
        list.addAtIndex("New Final Node", 10);
        list.addAtIndex("New Head", 1);
        list.addAtIndex("Shouldn't work", -3);
        list.addAtIndex("Shouldn't work 2", 99);
        list.addAtIndex("Another new head", 1);

        list.printList();*/

    }

}
