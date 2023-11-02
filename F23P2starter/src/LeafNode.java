/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * Node class
 */
public class LeafNode implements BinNode {
    private SinglyLinkedList<Seminar> list;
 
    
    /**
     * this is the constructor
     * @param sem the seminar
     * @param widthLow low range
     * @param widthHigh high range
     * @param heightLow low range
     * @param heightHigh high range
     * @param level we're on
     */
    public LeafNode(
        Seminar sem,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh,
        int level) {
       
        this.list = new SinglyLinkedList<Seminar>();
        list.add(sem);

    }


    @Override
    public boolean isLeaf() {
        return true;
    }


    @Override
    public BinNode insert(
        Seminar sem,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh,
        int level) {

        // if i have am empty node
        // add it to the list
        // return this

        // if i have matching coordinates
        // add seminar to the list
        // return this

        // if i have coordinates that don't match
        // create an internal node
        // for loop that goes through all elements in the list
        // call the insert method
        // after the for loop, return the internal node

        if (list.isEmpty()) {
            list.add(sem);
            return this;
        }
        else if (sem.x() == list.get(0).x() && sem.y() == list.get(0).y()) {
            list.add(sem);
            return this;
        }
        else {
            IntlNode newNode = new IntlNode(EmptyNode.getEmpty(), EmptyNode
                .getEmpty());

            int size = list.size();

            for (int i = 0; i < size; i++) {

                newNode.insert(list.get(i), widthLow, widthHigh, heightLow,
                    heightHigh, level);

            }
            newNode.insert(sem, widthLow, widthHigh, heightLow, heightHigh,
                level);
            // Insert the new seminar

            // Clear the list
            // list.clear();
            return newNode;
        }

    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void print(int level) {
        for (int i = 0; i < level * 2; i++) {
            System.out.print(" ");
        }

        System.out.print("Leaf with " + list.size() + " objects: ");
        for (int x = 0; x < list.size(); x++) {

            System.out.print(" " + list.get(x).id());
        }
        System.out.println();
    }

    @Override
    public int search(
        int x,
        int y,
        int dist,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh,
        int level,
        int nodesVisited) {
        // check if the location of the seminar is less
        // than or equal to radius distance from the search point.
        // Euclidian's algorithm
        int aX = x;
        int aY = y;
        int bX = list.get(0).x();
        int bY = list.get(0).y();
        double xPower = Math.pow((aX - bX), 2);
        double yPower = Math.pow((aY - bY), 2);
        double result = Math.sqrt(xPower + yPower);
        
        if (result <= dist) {
            // if it is IDK maybe print the found message
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Found a record with key value " + list.get(
                    i).id() + " at " + list.get(i).x() + ", " + list.get(i)
                        .y());
            }

        }

        return 1;
    }


    @Override
    public BinNode delete(int x, int y, Seminar sem) {
        // there are multiple things int he linked list
        // delte 1

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id() == sem.id()) {
                list.remove(i);
            }
        }

        if (list.isEmpty()) {
            return EmptyNode.getEmpty();
        }

        return this;

    }

}
