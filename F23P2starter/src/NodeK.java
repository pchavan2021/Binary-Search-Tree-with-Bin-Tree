/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * Node class
 */
public class NodeK<K, V>  {
    private boolean isLeaf;
    private K key;
    private V value;
    private NodeK<K, V> left;
    private NodeK<K, V> right;

    /**
     * constructor for the leaf nodes
     * @param key is the key
     * @param value is the value
     */
    public NodeK(K key, V value) {
        isLeaf = true;
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * constructor for the non leaf
     * nodes
     * @param key is the key
     * @param value is the value
     * @param leftChild is the left node
     * @param rightChild is the right node
     */
    public NodeK(K key, V value, NodeK<K, V> leftChild, 
        NodeK<K, V> rightChild) {
        isLeaf = false;
        this.key = key;
        this.value = value;
        this.left = leftChild;
        this.right = rightChild;
    }

    /**
     * return the key
     * @return the key
     */
    public K getKey() {
        return key;
    }
    
    /**
     * set it
     * @param key the key
     */
    public void setKey(K key) {
        this.key = key;
    }
    
    /**
     * get it 
     * @return the value
     */
    public V getElement() {
        return value;
    }

    /**
     * set it
     * @param value the value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * get it
     * @return the left child
     */
    public NodeK<K, V> getLeft() {
        return left;
    }

    /**
     * set it
     * @param left child
     */
    public void setLeft(NodeK<K, V> left) {
        this.left = left;
    }

    /**
     * get it
     * @return the right child
     */
    public NodeK<K, V> getRight() {
        return right;
    }

    /**
     * set it
     * @param right the right
     */
    public void setRight(NodeK<K, V> right) {
        this.right = right;
    }

    /**
     * compare two nodes
     * @param value2 the node
     * @return its comparsion
     */
    public int compareTo(NodeK<K, V> value2) {

        return 0;
    }

   
}
