/**
 * 
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * @param <T>
 * Node class
 */
public class Node<T> {
    private boolean isLeaf;
    private T element;
    private Node<T> left;
    private Node<T> right;

    /**
     * 
     * Creates a single binary tree node containing the
     * 
     * given element and no children.
     * 
     * This is also the leaf node
     * 
     * @param value
     * 
     *            The data element to store in the new tree node.
     * 
     */
    public Node(T value) {
        
        isLeaf = true;
        
        element = value;

        left = null;

        right = null;
        
    }

    
    // ----------------------------------------------------------
    /**
     * 
     * Creates a single binary tree node containing the given
     *
     * element and child subtrees.

     * @param value
     * 
     *            The data value to store on the new node.
     * 
     * @param leftChild
     * 
     *            A reference to the left child for the new node.
     * 
     * @param rightChild
     * 
     *            A reference to the right child for the new node.
     * 
     */
    public Node(T value, Node<T> leftChild, Node<T> rightChild) {
        
        isLeaf = false;
        
        element = value;

        left = leftChild;

        right = rightChild;
    }
    
    /**
     * Return whether the node is a leaf or not
     * @return whether it's a leaf or not
     */
    public boolean getLeaf() {
        return isLeaf;
    }
    
    /**
     * 
     * Get the data element in this node (i.e., stored at the root of
     * 
     * this tree).
     * 
     * 
     * 
     * @return This node's data element
     * 
     */

    public T getElement() {

        return element;

    }


    // ----------------------------------------------------------
    /**
     * 79
     * Sets the data element in this node (i.e., store it at the root of
     * 80
     * this tree).
     * 81
     * 
     * 82
     * 
     * @param value
     *            83
     *            The new data value to store in this node
     *            84
     */
    public void setElement(T value) {

        this.element = value;

    }


    // ----------------------------------------------------------
    /**
     * 92
     * Get the left child of this node.
     * 93
     * 
     * 94
     * 
     * @return This node's left child, or null if none.
     *         95
     */
    public Node<T> getLeft() {

        return left;

    }


    // ----------------------------------------------------------
    /**
     * 103
     * Sets the left child of this node.
     * 104
     * 
     * 105
     * 
     * @param subtree
     *            106
     *            A reference to the new left child for this node.
     *            107
     */

    public void setLeft(Node<T> subtree) {

        left = subtree;

    }


    // ----------------------------------------------------------
    /**
     * 115
     * Get the right child of this node.
     * 116
     * 
     * 117
     * 
     * @return This node's right child, or null if none.
     *         118
     */

    public Node<T> getRight() {

        return right;

    }


    // ----------------------------------------------------------
    /**
     * 127
     * Sets the right child of this node.
     * 128
     * 
     * 129
     * 
     * @param subtree
     *            130
     *            A reference to the new right child for this node.
     *            131
     */

    public void setRight(Node<T> subtree) {

        right = subtree;

    }

}