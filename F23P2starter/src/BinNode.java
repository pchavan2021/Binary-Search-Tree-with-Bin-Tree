/**
 * 
 */

/**
 * 
 */
/**
 * bin node is our interface
 */
public interface BinNode {
    /**
     * 
     * @return this returns the leaf
     */
    public boolean isLeaf();


    /**
     * 
     * @return the empty
     */
    public boolean isEmpty();


    /**
     * 
     * @return the nodes visited
     */
    public int search(int x, int y, int dist, int widthLow, int widthHigh, int heightLow, int heightHigh, int level, int nodesVisited);


    /**
     * 
     * @param x
     *            the x cordinate
     * @param y
     *            the y cordinate
     * @param sem
     *            the seminar
     * @return returning the node
     */
    public BinNode delete(int x, int y, Seminar sem);


    /**
     * 
     * @param level
     *            the is the level we are on
     */
    public void print(int level);


    /**
     * 
     * @param sem
     *            the seminary
     * @param width
     *            the width of the binnode
     * @param height
     *            the height
     * @param worldWidth
     *            the width of the world
     * @param worldHeight
     *            the world height
     * @param level
     *            the level
     * @return the bin node
     */
    public BinNode insert(
        Seminar sem,
        int width,
        int height,
        int worldWidth,
        int worldHeight,
        int level);

}
