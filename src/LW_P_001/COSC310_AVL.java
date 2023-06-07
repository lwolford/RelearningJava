/*
 * Interface for this project.  Create your own concrete class that implements this
 *    interface.  The methods are described in the program specification.
 *    Please do not modify the interface.
 */
package LW_P_001;

/**
 * Public interface for AVL Project.
 * @author Steve Kennedy
 */
public interface COSC310_AVL {

    /* ----------------------------------------------------------------   */
    /* The following methods should be implemented for this assignment.  */
    /* ----------------------------------------------------------------   */

    /** Runs project.  You will create an instance of your project in main
     *      and then have it invoke this method to begin running.
     */
    public void go();

    /* The following methods are commands that the user can run */
    public void find(String name);  // find and print Record
    public boolean add(Record record); // add new item
    public int count(); // # of elements

    public void printInorder();
    public void printPreorder();
    public void printPostorder();

    /* These are useful output methods */
    public void greeting(); // print your name, the class, date and other useful info
    public void help(); // explain how to use this program
    public void exit(); // exit the program in a cleann way

    /** Returns your name **/
    public String getMyName();

}
