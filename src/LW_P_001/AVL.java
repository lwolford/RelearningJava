package LW_P_001;

public class AVL {

    Node root;

    /**
     * Gets the height of the AVL tree, starting from a specified node
     * @param node
     * @return The height of the AVL tree from the specified node
     */
    int height(Node node) {
        if (node != null) return node.getIntHeight();
        else return -1;
    }

    /**
     * Takes two int variables, and finds the higher value of the two
     * @param a
     * @param b
     * @return a if a is greater then b. b if b is greater than a
     */
    public int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    // Positive if left is bigger than right

    /**
     * Checks the balance of the AVL tree by getting the height of node.left and subtracting it by the height of node.right
     * If the value is positive, the node.left height is higher
     * If the value is negative, the node.right height is higher
     * @param node
     * @return The difference in the height of node.left and node.right
     */
    public int checkBalance(Node node) {
        if (node != null) return height(node.left) - height(node.right);
        else return 0;
    }

    /**
     * Kicks off the recursive add method below this method by starting at the root node
     * @param data = the values in the CSV or what the user wants to add to the list through input
     */
    public void add(String[] data) {
        root = add(root, data);
    }

    /**
     * Main add method for adding items into the AVL tree
     * If the current node is null, then it returns a new node with the entered data
     * If the data's name is lexicographically less than the current node's data's name, then recursively call add for
     * node.left and then balance the tree once the recursive calls finish
     * If the data's name is lexicographically larger than the current node's data's name, then recursively call add for
     * node.right and then balance the tree once the recursive calls finish
     * If else is hit, then the name of data that is attempting to be added is the same as a name in the tree already
     * and is then ignored by returning the node
     * After these steps, + 1 is given to the height since a new node is added, and then the node with the new data
     * is returns
     * @param node = node that is currently being visited in the add method
     * @param data = the values in the CSV or what the user wants to add to the list through input
     * @return The node that the data is added to
     */
    private Node add(Node node, String[] data) {;
        if (node == null) {
            return new Node(dataToString(data));
        }
        else if (data[1].compareToIgnoreCase(getDataName(node)) < 0) {
            node.left = add(node.left, data);
            if (checkBalance(node) > 1) {
                if (data[1].compareToIgnoreCase(getDataName(node.left)) < 0) {
                    node = leftChildRotate(node);
                }
                else {
                    node = doubleLeftChildRotate(node);
                }
            }
        }
        else if (data[1].compareToIgnoreCase(getDataName(node)) > 0) {
            node.right = add(node.right, data);
            if (checkBalance(node) < -1) {
                if (data[1].compareToIgnoreCase(getDataName(node.right)) > 0) {
                    node = rightChildRotate(node);
                }
                else {
                    node = doubleRightChildRotate(node);
                }
            }
        }
        else {
            return node;
        }
        node.setIntHeight(max(height(node.left), height(node.right)) + 1);
        return node;
    }

    /**
     * Method for rotating part of the AVL tree that has a left child
     * @param current = current node
     * @return left
     */
    private Node leftChildRotate(Node current) {
        Node left = current.left;
        current.left = left.right;
        left.right = current;

        current.setIntHeight(max(height(current.left), height(current.right)) + 1);
        left.setIntHeight(max(height(left.left), height(left.right)) + 1);

        return left;
    }

    /**
     * Method for rotating part of the AVL tree that has a right child
     * @param current = current node
     * @return left
     */
    private Node rightChildRotate(Node current) {

        Node right = current.right;
        current.right = right.left;
        right.left = current;

        current.setIntHeight(max(height(current.left), height(current.right)) + 1);
        right.setIntHeight(max(height(right.left), height(right.right)) + 1);

        return right;

    }

    /**
     * Method for rotating part of the AVL tree that has a double left
     * @param current = current node
     * @return a left child rotation of the current node after settings current.left to a right child rotation of itself
     */
    private Node doubleLeftChildRotate(Node current) {
        current.left = rightChildRotate(current.left);
        return leftChildRotate(current);
    }

    /**
     * Method for rotating part of the AVL tree that has a double right
     * @param current = current node
     * @return a right child rotation of the current node after settings current.right to a left child rotation of itself
     */
    private Node doubleRightChildRotate(Node current) {
        current.right = leftChildRotate(current.right);
        return rightChildRotate(current);
    }

    /**
     * Kicks off the recursive method for getting Pre-Order Traversal of the AVL Tree
     * Begins at the root
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * Main method to getting the AVL tree in Pre-Order
     * Visits, then goes left, then goes right
     * @param current = current node
     */
    private void preOrderTraversal(Node current) {
        if (current != null) {
            System.out.println(current.toString());
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    /**
     * Kicks off the recursive method for getting In-Order Traversal of the AVL Tree
     * Begins at the root
     */
    public void inOrderTraversal() { inOrderTraversal(root); }

    /**
     * Main method to getting the AVL Tree in In-Order
     * Goes left, then visits, then goes right
     * @param current = current node
     */
    private void inOrderTraversal(Node current) {
        if (current != null) {
            inOrderTraversal(current.left);
            System.out.println(current.toString());
            inOrderTraversal(current.right);
        }
    }

    /**
     * Kicks off the recursive method for getting Post-Order traversal of the AVL Tree
     * Begins at the root
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * Main method to getting the AVL Tree in Post-Order
     * Goes left, goes right, then visits
     * @param current
     */
    private void postOrderTraversal(Node current) {
        if (current != null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.println(current.toString());
        }
    }

    /**
     * Kicks off the main recursive search method
     * @param search = data the user wants to search
     * @return is a call to the main search method starting from the root
     */
    public boolean search(String search) {
        return search(root, search);
    }

    /**
     * Main method for searching for a song name in the AVL tree
     * If the node is not null and the song has not yet been found:
     * If the search is lexicographically less than the name of the current node's song, then go to current.left and
     * print an arrow that shows which direction the search went to find the song
     * If the search is lexicographically more than the name of the current node's song, then go to current.right and
     * print an arrow that shows which direction the search went to find the song
     * If else is hit, then this means that the searched song is the same as the current node's song. boolFound is set
     * to true and the information of the searched song is printed to the user. This statement is then broken out of
     * If else is not hit, the search method is recursively called with the new current node that was set in the previous
     * if statements
     * @param current = current node
     * @param search = what song the user is searching for
     * @return boolFound which is true if the song is found, and is false if the song is not found
     */
    private boolean search(Node current, String search) {
        boolean boolFound = false;
        while (current != null && !boolFound) {
            if (search.compareToIgnoreCase(getDataName(current)) < 0) {
                current = current.left;
                System.out.println("<---");
            }
            else if (search.compareToIgnoreCase(getDataName(current)) > 0) {
                current = current.right;
                System.out.println("--->");
            }
            else {
                boolFound = true;
                System.out.println("\"" + getDataName(current) + "\"" + " is a song by " + getDataArtist(current) +
                        ". It is a " + getDataGenre(current) + " song that was popular in " + getDataYear(current) + ".");
                break;
            }
            boolFound = search(current, search);
        }
        return boolFound;
    }

    /**
     * Kicks off the main recursive privateSearch method
     * @param search = data the user wants to search
     * @return is a call to the main privateSearch method starting from the root
     */
    public boolean privateSearch(String search) {
        return privateSearch(root, search);
    }

    /**
     * Main method for privateSearching for a song name in the AVL tree
     * If the node is not null and the song has not yet been found:
     * If the search is lexicographically less than the name of the current node's song, then go to current.left
     * If the search is lexicographically more than the name of the current node's song, then go to current.right
     * If else is hit, then this means that the searched song is the same as the current node's song and boolFound is set
     * to true
     * If else is not hit, the privateSearch method is recursively called with the new current node that was set in the
     * previous if statements
     * Private search is used to find the song for the user, before printing out the arrows from the search method
     * It is cool for the user to see the arrows if it works, but it looks unnecessary if the song is not in the tree
     * @param current = current node
     * @param search = what song the user is searching for
     * @return boolFound which is true if the song is found, and is false if the song is not found
     */
    private boolean privateSearch(Node current, String search) {
        boolean boolFound = false;
        while (current != null && !boolFound) {
            if (search.compareToIgnoreCase(getDataName(current)) < 0) {
                current = current.left;
            }
            else if (search.compareToIgnoreCase(getDataName(current)) > 0) {
                current = current.right;
            }
            else {
                boolFound = true;
                break;
            }
            boolFound = privateSearch(current, search);
        }
        return boolFound;
    }

    /**
     * Kicks off the main recursive directSearch method
     * @param search = data the user wants to search
     * @return is a call to the main directSearch method starting from the root
     */
    public boolean directSearch(String[] search) {
        return directSearch(root, search);
    }

    /**
     * Main method for directSearching for a song name in the AVL tree
     * If the node is not null and the song has not yet been found:
     * If the search is lexicographically less than the name of the current node's full data, then go to current.left
     * If the search is lexicographically more than the name of the current node's full data, then go to current.right
     * If else is hit, then this means that the searched data is the same as the current node's full data and boolFound
     * is set to true
     * If else is not hit, the privateSearch method is recursively called with the new current node that was set in the
     * previous if statements
     * Direct search is used to confirm that a song has been added into the AVL tree properly
     * This prevents incorrect message being given to the user if a they add a song with the same name as another song
     * in the AVL tree
     * @param current = current node
     * @param search = what song the user is searching for
     * @return boolFound which is true if the song is found, and is false if the song is not found
     */
    private boolean directSearch(Node current, String[] search) {
        String strSearched = dataToString(search);
        boolean boolFound = false;
        while (current != null && !boolFound) {
            if (strSearched.compareToIgnoreCase(current.getData()) < 0) {
                current = current.left;
            }
            else if (strSearched.compareToIgnoreCase(current.getData()) > 0) {
                current = current.right;
            }
            else {
                boolFound = true;
                break;
            }
            boolFound = directSearch(current, search);
        }
        return boolFound;
    }

    /**
     * Kicks off the recursive method for getNodeNumber
     * @return getNodeNumber starting at the root
     */
    public int getNodeNumber() {
        return getNodeNumber(root);
    }

    /**
     * Main method for getting the total number of nodes in an AVL tree
     * If the current node is null, then 0 is returned
     * Else, the intNodeCount is set to 1 (the root) and intNodeCount then has getNodeNumber of current.left added to
     * it along with having getNodeNumber of current.right added to it
     * @param current = current node
     * @return intNodeCount = total number of nodes in the tree
     */
    private int getNodeNumber(Node current) {
        if (current == null) {
            return 0;
        }
        else {
            int intNodeCount = 1;             // Root = 1 node
            intNodeCount += getNodeNumber(current.left);
            intNodeCount += getNodeNumber(current.right);
            return intNodeCount;
        }
    }

    /**
     * Takes the String[] from CSV and user inputs and sets it to a single string will all the necessary data
     * Removes all quotation marks from the CSV and input names, and puts a ~ between each information segment
     * This string is what is stored inside of each node
     * @param data = String[] that is either the CSV inputs or the user inputs
     * @return strData = a string that is the concatenation of all the data segments
     */
    public String dataToString(String[] data) {
        String strData = "";
        strData += data[1].replace("\"", "") + "~";
        strData += data[2].replace("\"", "") + "~";
        strData += data[3].replace("\"", "") + "~";
        strData += data[4].replace("\"", "") + "~";
        strData += data[5].replace("\"", "") + "~";
        strData += data[6].replace("\"", "") + "~";
        strData += data[7].replace("\"", "") + "";
        return strData;
    }

    /**
     * Takes the String from above and resplits it into a String[] after the data has been added to the node
     * Using this system simplifies searching and adding by name, but it does seem a little backwards
     * @param current
     * @return
     */
    private String[] dataSplit(Node current) {
        String[] splitArray = current.getData().split("~", 0);
        return splitArray;
    }

    /**
     * Gets only the song's name from the current node
     * @param current = current node
     * @return the name of the song
     */
    private String getDataName(Node current) {
       return dataSplit(current)[0];
    }

    /**
     * Gets only the song's artist from the current node
     * @param current = current node
     * @return the artist of the song
     */
    private String getDataArtist(Node current) {
        return dataSplit(current)[1];
    }

    /**
     * Gets only the song's genre from the current node
     * @param current = current node
     * @return the genre of the song
     */
    private String getDataGenre(Node current) {
        return dataSplit(current)[2];
    }

    /**
     * Gets only the song's year from the current node
     * @param current = current node
     * @return the year of the song
     */
    private String getDataYear(Node current) {
        return dataSplit(current)[3];
    }

    /**
     * Gets only the song's BPM from the current node
     * @param current = current node
     * @return the BPM of the song
     */
    private String getDataBPM(Node current) {
        return dataSplit(current)[4];
    }

    /**
     * Gets only the song's energy level from the current node
     * @param current = current node
     * @return the energy level of the song
     */
    private String getDataEnergy(Node current) {
        return dataSplit(current)[5];
    }

    /**
     * Gets only the song's danceability level from the current node
     * @param current = current node
     * @return the danceability level of the song
     */
    private String getDataDance(Node current) {
        return dataSplit(current)[6];
    }

}
