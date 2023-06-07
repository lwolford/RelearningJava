package DataStructure;

import LW_ICA_001.Pokemon;

public class QueueDriver {

    public static void main(String[] args) {

        runQueueDriver();

    }

    public static void runQueueDriver() {

        LWLinkedList<String> list = new LWLinkedList<>();
        /*list.addLast("last?");
        list.addLast("second");
        list.addLast("third last?");
        list.addLast("4?");
        list.addLast("5?");

        list.addAtIndex("Hi", 3);*/

        list.addLast("1");
        list.addLast("10");
        list.addLast("100");

        System.out.println("");
        list.PrintLinkedList();

    }

}
