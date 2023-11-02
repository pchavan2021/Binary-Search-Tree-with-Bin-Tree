
public class BinTree {
    private BinNode root;

    public BinTree() {
        root = EmptyNode.getEmpty();
    }


    public void insert(
        Seminar sem,
        int widthLow,
        int widthHigh,
        int heightLow,
        int heightHigh) {

        // root = root.insert(sem, 0, widthHigh, 0, heightHigh, 0);
        root = root.insert(sem, 0, widthHigh, 0, heightHigh, 0);

    }



    public int search(int x, int y, int dist, int size) {
           int count = root.search(x, y, dist, 0, size, 0, size, 0, 0);
           return count;
       }

    public void delete(int x, int y, Seminar sem) {
        root = root.delete(x, y, sem);

    }


    public void print() {
        if (root != null) {
            root.print(0);
        }

    }


    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

}
