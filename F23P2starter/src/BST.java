
/**
 * 
 */
import java.util.Comparator;

/**
 * 
 */
public class BST<K extends Comparable<K>, V> implements Comparator<BST<K, V>> {

    private NodeK<K, V> root;
    private NodeK<K, V> removing;

    /*
     * Constructor for BST
     * intialize the root
     */
    public BST() {
        root = null;
        removing = null;
    }


    /*
     * insert seminar based on
     * its key
     * 
     * @param key to insert
     * 
     * @param val to insert
     */
    public void insert(K key, V val) {
        root = insertRec(root, key, val);
    }


    /*
     * helper method for insert
     * 
     * @param root this is root
     * 
     * @param key this is key
     * 
     * @param val this is value
     * 
     * @return the new node
     */
    private NodeK<K, V> insertRec(NodeK<K, V> root, K key, V val) {

        if (root == null) {
            root = new NodeK<K, V>(key, val);
            return root;
        }

        if (key.compareTo(root.getKey()) <= 0) {
            root.setLeft(insertRec(root.getLeft(), key, val));
        }
        else {
            root.setRight(insertRec(root.getRight(), key, val));
        }
        // System.out.println(val);
        return root;
    }


    /*
     * For the cost and date tree searches
     * 
     * @param root
     * this is the root node
     * 
     * @param low
     * this is the low range
     * 
     * @param high
     * this is the high range
     * 
     * @return the number of nodes visited
     */
    public int rangeSearch(NodeK<K, V> root, K low, K high) {
        int counter = 1;

        if (root == null) {
            return 1;
        }

        if (root.getKey().compareTo(low) < 0) {
            counter += rangeSearch(root.getRight(), low, high);
        }
        else if (root.getKey().compareTo(high) > 0) {
            counter += rangeSearch(root.getLeft(), low, high);
        }
        else {
            counter += rangeSearch(root.getLeft(), low, high);
            System.out.println(root.getElement());

            if (root.getKey().compareTo(high) != 0) {
                counter += rangeSearch(root.getRight(), low, high);
            }
        }
        return counter;
    }


    /*
     * Use this search for keywords
     * 
     * @param root this is root
     * 
     * @param key this is key
     */
    public void inOrderSearch(NodeK<K, V> root, K key) {
        if (root == null) {
            return;
        }
        // Search left subtree
        inOrderSearch(root.getLeft(), key);

        // Check the current node
        if (root.getKey().equals(key)) {
            System.out.println(root.getElement());
        }

        // Search right subtree
        inOrderSearch(root.getRight(), key);

    }


    /*
     * This search is for the ID tree
     * Boolean determines whether
     * the other search methods are called
     * or not
     * 
     * @param root root of the tree
     * 
     * @param key we're trying to find
     * 
     * @return if we found the key
     */
    public boolean specificSearch(NodeK<K, V> root, K key) {
        if (root == null) {
            return false;
        }

        if (root.getKey() == key) {
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (root.getLeft() != null) {
            left = specificSearch(root.getLeft(), key);
        }

        if (root.getRight() != null) {
            right = specificSearch(root.getRight(), key);
        }

        return left || right;
    }


    public boolean searchID(NodeK<K, V> root, K key) {
        if (root == null) {
            return false;
        }

        if (root.getKey() == key) {
            System.out.println("Found record with ID " + key + ":");
            System.out.println(root.getElement());
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (root.getLeft() != null) {
            left = searchID(root.getLeft(), key);
        }

        if (root.getRight() != null) {
            right = searchID(root.getRight(), key);
        }

        return left || right;
    }


    public NodeK<K, V> returnNode(NodeK<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        if (root.getKey().equals(key)) {
            return root;
        }

        NodeK<K, V> leftResult = null;
        NodeK<K, V> rightResult = null;

        if (root.getLeft() != null) {
            leftResult = returnNode(root.getLeft(), key);
        }

        if (leftResult == null && root.getRight() != null) {
            rightResult = returnNode(root.getRight(), key);
        }

        if (leftResult != null) {
            return leftResult;
        }
        else {
            return rightResult;
        }
    }


    /*
     * calls the specific Search method
     * prints a failure method
     * 
     * @param root root of the tree
     * 
     * @param key we're trying to find
     */
    public void search(NodeK<K, V> root, K key) {
        if (!specificSearch(root, key)) {
            System.out.println("Search FAILED -- There is no record with ID "
                + key);
        }
    }


    /*
     * 
     * @param root this is the root
     * 
     * @param groot a boolean
     * 
     * @param level the level
     * prints the tree in reverse inorder
     * indents the node based on it's depth
     */
    public void printReverse(NodeK<K, V> root, boolean groot, int level) {
        if (root == null && groot) {
            System.out.println("This tree is empty");
            return;
        }

        if (root.getRight() != null) {
            printReverse(root.getRight(), false, level + 1);
        }
        else {
            for (int y = 0; y <= level; y++) {
                System.out.print("  ");
            }
            System.out.println("null");
        }
        for (int x = 0; x < level; x++) {
            System.out.print("  ");

        }
        System.out.println(root.getKey());
        if (root.getLeft() != null) {
            printReverse(root.getLeft(), false, level + 1);
        }
        else {
            for (int x = 0; x <= level; x++) {
                System.out.print("  ");
            }
            System.out.println("null");
        }
    }


    /**
     * 
     * @param root
     *            this is root
     * @return the key from
     *         the greatest node
     */
    public K maxValue(NodeK<K, V> root) {
        K maxValue = root.getKey();
        while (root.getRight() != null) {
            maxValue = root.getRight().getKey();
            root = root.getRight();
        }
        return maxValue;

    }


    /*
     * 
     * @param root this is root
     * 
     * @return the seminar from the
     * greatest node
     */
    public V maxSem(NodeK<K, V> root) {
        V maxSem = root.getElement();
        while (root.getRight() != null) {
            maxSem = root.getRight().getElement();
            root = root.getRight();
        }
        return maxSem;
    }


    /*
     * 
     * @param root root of tree
     * 
     * @return the size of
     * the tree
     */
    public int size(NodeK<K, V> root) {
        if (root == null) {
            return 0;
        }
        int size = 1;

        if (root.getLeft() == null && root.getRight() == null) {
            return size;
        }

        if (root.getLeft() != null) {
            size = size + size(root.getLeft());
        }

        if (root.getRight() != null) {
            size = size + size(root.getRight());
        }

        return size;
    }


    /*
     * in order traversal of the tree
     * 
     * @param root root of the tree
     * 
     * @return the nodes
     */
    public String toInOrderString(NodeK<K, V> root) {

        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();

        builder.append("(");

        if (root.getLeft() != null) {
            builder.append(toInOrderString(root.getLeft()));
        }

        builder.append(root.getElement());

        if (root.getRight() != null) {
            builder.append(toInOrderString(root.getRight()));
        }

        builder.append(")");

        return builder.toString();
    }


    /*
     * @return the root
     */
    public NodeK<K, V> returnRoot() {
        return root;
    }


    @Override
    public int compare(BST<K, V> o1, BST<K, V> o2) {
        // TODO Auto-generated method stub
        return 0;
    }


    public NodeK<K, V> getMax(NodeK<K, V> root) {
        if (root.getRight() == null) {
            return root;
        }
        return getMax(root.getRight());
    }


    public NodeK<K, V> delete(NodeK<K, V> id) {

        root = deleteRec(root, id);
        return root;

    }


    public NodeK<K, V> deleteMax(NodeK<K, V> root) {
        if (root.getRight() == null) {
            return root.getLeft();
        }
        root.setRight(deleteMax(root.getRight()));
        return root;
    }


    public NodeK<K, V> deleteRec(NodeK<K, V> currentRoot, NodeK<K, V> value) {
        if (currentRoot == null) {
            return currentRoot;
        }

        if (currentRoot.getKey().compareTo(value.getKey()) > 0) {
            currentRoot.setLeft(deleteRec(currentRoot.getLeft(), value));
        }
        else if (currentRoot.getKey().compareTo(value.getKey()) < 0) {
            currentRoot.setRight(deleteRec(currentRoot.getRight(), value));
        }
        else {
            if (currentRoot.getLeft() == null) {
                return currentRoot.getRight();
            }
            else if (currentRoot.getRight() == null) {
                return currentRoot.getLeft();
            }
            else {
                NodeK<K, V> temp = getMax(currentRoot.getLeft());
                currentRoot.setKey(temp.getKey());
                currentRoot.setValue(temp.getElement());
                currentRoot.setLeft(deleteMax(currentRoot.getLeft()));
            }
        }
        return currentRoot;
    }


    public NodeK<K, V> removeDuplicates(NodeK<K, V> value) {
        root = remHelper(root, value);
        return root;

    }


    public NodeK<K, V> remHelper(NodeK<K, V> root, NodeK<K, V> value) {
        if (root == null) {
            return root;
        }
        if (root.getKey().compareTo(value.getKey()) > 0) {
            root.setLeft(remHelper(root.getLeft(), value));
        }
        else if (root.getKey().compareTo(value.getKey()) < 0) {
            root.setRight(remHelper(root.getRight(), value));
        }
        else {
            if (root.getElement().equals(value.getElement())) {
                if (root.getLeft() == null) {
                    return root.getRight();
                }
                else if (root.getRight() == null) {
                    return root.getLeft();
                }
                else {
                    NodeK<K, V> temp = getMax(root.getLeft());
                    root.setValue(temp.getElement());
                    root.setKey(temp.getKey());
                    root.setLeft(deleteMax(root.getLeft()));
                }
            }
            else {
                root.setLeft(remHelper(root.getLeft(), value));
                root.setRight(remHelper(root.getRight(), value));
            }
        }
        return root;

    }
}
