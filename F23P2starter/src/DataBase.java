
public class DataBase {
    // private BinaryTree tree;
    private int worldSize;
    private BST<Integer, Seminar> treeID;
    private BST<Integer, Seminar> treeCost;
    private BST<String, Seminar> treeDate;
    private BST<String, Seminar> treeKeyWord;
    private BinTree locationTree;

    public DataBase(int initialSize) {
        // size = worldSize - 1
        worldSize = initialSize;
        treeID = new BST<Integer, Seminar>();
        treeCost = new BST<Integer, Seminar>();
        treeDate = new BST<String, Seminar>();
        treeKeyWord = new BST<String, Seminar>();
        locationTree = new BinTree();

    }


    /*
     * use the specificSearch to determine if seminar
     * already exists in the tree
     * 
     * if not print success message and insert into all trees
     * 
     * use a for loop to loop through keywords and insert
     * each one
     * 
     * if the seminar already exists print the
     * failure message
     * 
     * @param sem to insert
     */
    public void add(Seminar sem) {
        Seminar trial = sem;

        int x = trial.x();
        int y = trial.y();

        if (x >= 0 && x < worldSize && y >= 0 && y < worldSize) {

            boolean found = treeID.specificSearch(treeID.returnRoot(), trial
                .id());

            if (!found) {
                System.out.println("Successfully inserted record with ID "
                    + trial.id());
                System.out.println(trial);
                locationTree.insert(sem, 0, worldSize, 0, worldSize);
                treeID.insert(trial.id(), trial);
                treeCost.insert(trial.cost(), trial);
                treeDate.insert(trial.date(), trial);

                for (int i = 0; i < trial.keywords().length; i++) {
                    treeKeyWord.insert(trial.keywords()[i], trial);
                }
            }
            else {
                System.out.println(
                    "Insert FAILED - There is already a record with ID " + trial
                        .id());
            }
        }
        else

        {
            System.out.println("Insert FAILED - Bad x, y coordinates: " + x
                + ", " + y);
        }
    }


    /*
     * Call the specificSearch method
     * to find the matching key in the ID
     * tree
     * 
     * @param id
     */
    public void searchId(int id) {

        boolean found = treeID.searchID(treeID.returnRoot(), id);

        if (!found) {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }

    }


    /*
     * Use the range search
     * 
     * @param lowCost low range
     * 
     * @param highCost high range
     */
    public void searchCost(int lowCost, int highCost) {
        System.out.println("Seminars with costs in range " + lowCost + " to "
            + highCost + ":");

        int nodeCount = treeCost.rangeSearch(treeCost.returnRoot(), lowCost,
            highCost);
        System.out.println(nodeCount + " nodes visited in this search");

    }


    /*
     * use the inOrderSearch
     * 
     * @param key the key
     * to find
     */
    public void searchKeyWord(String key) {
        System.out.println("Seminars matching keyword " + key + ":");
        treeKeyWord.inOrderSearch(treeKeyWord.returnRoot(), key);

    }


    /*
     * use the range search
     * 
     * @param firstDate low range
     * 
     * @param secondDate high range
     */
    public void searchDate(String firstDate, String secondDate) {

        System.out.println("Seminars with dates in range " + firstDate + " to "
            + secondDate + ":");
        int dog = treeDate.rangeSearch(treeDate.returnRoot(), firstDate,
            secondDate);
        System.out.println(dog + " nodes visited in this search");
    }


    public void searchLocation(int x, int y, int radius) {
        System.out.println("Seminars within " + radius + " units of " + x + ", "
            + y + ":");
        int nodes = locationTree.search(x, y, radius, worldSize);

        System.out.println(nodes + " nodes visited in this search");
    }


    public void delete(int delete) {
        int x = treeID.size(treeID.returnRoot());
        NodeK<Integer, Seminar> node = treeID.returnNode(treeID.returnRoot(),
            delete);
        if (node == null) {
            System.out.println("Delete FAILED -- There is no record with ID "
                + delete);
            return;
        }
        Seminar sem = node.getElement();
        locationTree.delete(sem.x(), sem.y(), sem);
        treeID.delete(new NodeK<Integer, Seminar>(delete, sem));
        int y = treeID.size(treeID.returnRoot());
        if (x != y) {
            treeCost.removeDuplicates(new NodeK<Integer, Seminar>(sem.cost(),
                sem));
            treeDate.removeDuplicates(new NodeK<String, Seminar>(sem.date(),
                sem));
            for (int i = 0; i < sem.keywords().length; i++) {
                String word = sem.keywords()[i];
                treeKeyWord.removeDuplicates(new NodeK<String, Seminar>(word,
                    sem));
            }
            System.out.println("Record with ID " + delete
                + " successfully deleted from the database");
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + delete);
        }
    }


    public void printDate() {
        System.out.println("Date Tree:");
        treeDate.printReverse(treeDate.returnRoot(), true, 0);
        if (treeDate.size(treeDate.returnRoot()) > 0) {
            System.out.println("Number of records: " + treeDate.size(treeDate
                .returnRoot()));
        }

    }


    public void printKeyword() {
        System.out.println("Keyword Tree:");
        treeKeyWord.printReverse(treeKeyWord.returnRoot(), true, 0);
        if (treeKeyWord.size(treeKeyWord.returnRoot()) > 0) {
            System.out.println("Number of records: " + treeKeyWord.size(
                treeKeyWord.returnRoot()));
        }
    }


    public void printCost() {
        System.out.println("Cost Tree:");
        treeCost.printReverse(treeCost.returnRoot(), true, 0);
        if (treeCost.size(treeCost.returnRoot()) > 0) {
            System.out.println("Number of records: " + treeCost.size(treeCost
                .returnRoot()));
        }
    }


    public void printID() {
        System.out.println("ID Tree:");
        treeID.printReverse(treeID.returnRoot(), true, 0);
        if (treeID.size(treeID.returnRoot()) > 0) {
            System.out.println("Number of records: " + treeID.size(treeID
                .returnRoot()));
        }
    }


    public void printLocation() {
        System.out.println("Location Tree:");
        // System.out.println("E");
        locationTree.print();
    }

}
