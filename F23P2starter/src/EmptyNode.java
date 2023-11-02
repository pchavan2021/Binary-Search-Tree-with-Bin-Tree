
public class EmptyNode implements BinNode {

    private static EmptyNode fw = new EmptyNode();

    public EmptyNode() {

//
    }


    static public EmptyNode getEmpty() {
        return fw;
    }


    @Override
    public BinNode insert(
        Seminar sem,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh,
        int level) {
        // returns a new leaf node that contains the seminar record
        /**
         * 
         * creating a leaf node
         * leaf.insert(node)
         * return leaf
         */
        //// .insert(sem, width, height, worldWidth, worldHeight, level);

        // LeafNode leafNode = new LeafNode(sem);
        LeafNode leafNode = new LeafNode(sem, widthLow, widthHigh, heightLow,
            heightHigh, level);
        return leafNode;

    }


    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public void print(int level) {
        for (int i = 0; i < level * 2; i++) {
            System.out.print(" ");
        }
        System.out.println("E");

    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return true;
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
        return 1;

    }


    @Override
    public BinNode delete(int x, int y, Seminar sem) {
        // return the flyweight
        return fw;
    }

}
