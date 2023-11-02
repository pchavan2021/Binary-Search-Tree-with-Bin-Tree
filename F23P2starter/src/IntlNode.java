/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 *          Internal Node class
 */
public class IntlNode implements BinNode {

    private BinNode left; // Left child
    private BinNode right; // Right child
    // private Seminar operator; // Operator value

    /**
     * constructor that initializes
     * children
     * 
     * @param l
     *            left child
     * @param r
     *            right child
     */
    public IntlNode(BinNode l, BinNode r) {
        // operator = sem;
        left = l;
        right = r;
    }


    @Override
    public BinNode insert(
        Seminar sem,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh,
        int level) {

        if (level % 2 == 0) {
            int diff = (widthHigh - widthLow) / 2;
            if (sem.x() <= diff + widthLow && sem.x() >= widthLow && sem
                .y() >= heightLow && sem.y() <= heightHigh) {

                left = left.insert(sem, widthLow, widthLow + diff, heightLow,
                    heightHigh, level + 1);

            }
            else {
                right = right.insert(sem, widthLow + diff, widthHigh, heightLow,
                    heightHigh, level + 1);
            }

        }
        else {
            int diff = (heightHigh - heightLow) / 2;
            if (sem.y() <= diff + heightLow && sem.y() >= heightLow && sem
                .x() >= widthLow && sem.x() <= widthHigh) {

                left = left.insert(sem, widthLow, widthHigh, heightLow,
                    heightLow + diff, level + 1);
            }
            else {
                right = right.insert(sem, widthLow, widthHigh, heightLow + diff,
                    heightHigh, level + 1);
            }
        }

        return this;
    }


    /**
     * get it
     * 
     * @return the left child
     */
    public BinNode left() {
        return left;
    }


    /**
     * get it
     * 
     * @return the right child
     */
    public BinNode rightchild() {
        return right;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }


    @Override
    public boolean isEmpty() {
        return false;
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
        
        int nodes = 1;

        int disc = level % 2;
        if (disc == 0) {
            int diff = (widthHigh - widthLow) / 2;
            int comp = x - dist;
            if (!(comp >= widthLow + diff)) {
                nodes += left.search(x, y, dist, widthLow, widthLow + diff,
                    heightLow, heightHigh, level + 1, nodesVisited);
            }
            // x-dist + (2*dist +1) < widthLow + diff
            // intersects(x, y, dist, widthLow + diff, diff, heightLow,
            // heightHigh)
            if (((x - dist) + 2 * dist + 1) > widthLow) {
                nodes += right.search(x, y, dist, widthLow + diff, widthHigh,
                    heightLow, heightHigh, level + 1, nodesVisited);
            }
        }
        else {
            
            int diff = (heightHigh - heightLow) / 2;
            int comp = y - dist;
            // intersects(x, y, dist, widthLow, widthHigh, heightLow, diff)
            if (!(comp >= heightLow + diff)) {
                nodes += left.search(x, y, dist, widthLow, widthLow, heightLow,
                    heightLow + diff, level + 1, nodesVisited);

            }
            // intersects(x, y, dist, widthLow, widthHigh, heightLow + diff,
            // diff)
            if (((y - dist) + 2 * dist + 1) > heightLow) {
                nodes += right.search(x, y, dist, widthLow, widthHigh, heightLow
                    + diff, heightHigh, level + 1, nodesVisited);
            }
        }
        return nodes;
    }


    @Override
    public BinNode delete(int x, int y, Seminar sem) {
        // check if there's a leaf node
        if (left.isLeaf() && right.isEmpty()) {
            left = left.delete(x, y, sem);
            if (left.isEmpty()) {
                return right;
            }
        }
        else if (right.isLeaf() && left.isEmpty()) {
            right = right.delete(x, y, sem);
            if (right.isEmpty()) {
                return left;
            }
        }
        else {
            left = left.delete(x, y, sem);
            right = right.delete(x, y, sem);
        }
        // then undo the split from insert

        return this;
    }


    @Override
    public void print(int level) {
        for (int i = 0; i < level * 2; i++) {
            System.out.print(" ");
        }
        System.out.println("I");

        // Now, print the left child
        if (left != null) {
            left.print(level + 1);
        }

        // And then print the right child
        if (right != null) {
            right.print(level + 1);
        }

    }

}
