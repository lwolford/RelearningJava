package LW_P_011;

import java.util.*;

public class DFS {

    /**
     * All the needed variables for the DFS class
     * strSequence = the sequence of traversal
     * intTargetVertext = the goal state for the DFS algorithm
     * adjacencyMatrix = the adjacency matrix created from the txt files
     * boolVisited = an array of all visited vertices/nodes
     * stack = the stack used for the DFS algorithm
     */
    String strSequence = "";
    private int intTargetVertex;
    private int[][] adjacencyMatrix;
    private boolean[] boolVisited;
    private Stack<Integer> stack;

    /**
     * Constructor for the class
     * @param adjacencyMatrix = the adjacency matrix
     * @param intTargetVertex = the goal state of the DFS algorithm
     */
    public DFS(int[][] adjacencyMatrix, int intTargetVertex) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.intTargetVertex = intTargetVertex;

        boolVisited = new boolean[adjacencyMatrix.length];
        stack = new Stack<>();
    }

    /**
     * Method that handles traversal of the graph
     * Sets the starting vertex (A) at the beginning of the method
     * While there is an element in the stack, the DFS algorithm will continue to traverse
     * If it sees that it has already visited a node, the node is ignored and the DFS algorithm looks in the stack for
     * its next node
     * If the goal state is found, all of the necessary information is printed out and the program returns
     */
    public void traverse() {
        int intStartVertex = 0; // A
        stack.push(intStartVertex);

        System.out.print("It's path is: ");

        while (!stack.isEmpty()) {

            int intCurrentVertex = stack.pop();

            strSequence += intCurrentVertex;

            if (!boolVisited[intCurrentVertex]) {
                boolVisited[intCurrentVertex] = true;

                System.out.print(returnCharacter(intCurrentVertex));
                System.out.print(" -> ");

                List<Integer> expandedNodes = getExpandedNodes(intCurrentVertex);

                // Sorts the expanded nodes in order from the highest cost to the lowest cost
                // Now the DFS algorithm will prioritize the most expensive node
                Collections.sort(expandedNodes, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(adjacencyMatrix[intCurrentVertex][o1], adjacencyMatrix[intCurrentVertex][o2]);
                    }
                });

                for (int v : expandedNodes) {
                    if (v == intTargetVertex) {
                        System.out.println(returnCharacter(v));
                        strSequence += v;
                        targetFound();

                        return;
                    }
                    stack.push(v);
                }
            }
        }
    }

    /**
     * Expands the node to get all possible nodes to travel to next
     * @param intCurrentVertex = the current vertex/node the DFS algorithm is on
     * @return expandNodes = all expanded nodes
     */
    private List<Integer> getExpandedNodes(int intCurrentVertex) {
        List<Integer> expandNodes = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[intCurrentVertex][i] > 0) {
                expandNodes.add(i);
            }
        }
        return expandNodes;
    }

    /**
     * Returns the current vertex as a character
     * If the current vertex is 0, this will return an 'A'
     * @param intCurrentVertex = the vertex/node the DFS algorithm is on
     * @return (char) intLetter = intLetter casted as a character
     */
    private char returnCharacter(int intCurrentVertex) {
        int intLetter = intCurrentVertex + 65;
        return (char) intLetter;
    }

    /**
     * Due to the cost sorting, another way to get the sequence cost was necessary
     * Each vertex the DFS algorithm traverses is added to strSequence, and substring logic is used to calculate the total
     * cost from the sequence
     * @param strSequence = the sequence of traversal
     * @return intCost = the total cost of the traversal
     */
    private int getSequenceCost(String strSequence) {
        int intRow;
        int intColumn;
        int intCost = 0;
        for (int i = 0; i < strSequence.length() - 1; i++)  {
            intRow = Integer.parseInt(strSequence.substring(i, i+1));
            intColumn = Integer.parseInt(strSequence.substring(i+1, i+2));
            intCost += adjacencyMatrix[intRow][intColumn];
        }
        return intCost;
    }

    /**
     * User output for when a target is found
     * Prints all of the necessary information, including sequence cost
     */
    private void targetFound() {
        try {
            Thread.sleep(3000);
            System.out.print("It took a long time to find the target ");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(" and by target I definitely mean the end of the labyrinth");
            Thread.sleep(2000);
            System.out.println("The total fuel used on this path was: " + getSequenceCost(strSequence) + " liters");
            Thread.sleep(2000);
            System.out.println();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
