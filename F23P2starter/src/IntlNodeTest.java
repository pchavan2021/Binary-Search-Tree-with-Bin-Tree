import java.io.ByteArrayOutputStream;

import student.TestCase;
/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * Node class
 */
public class IntlNodeTest extends TestCase {
    private IntlNode node;
    private BinNode l;
    private BinNode r;
    private Seminar sem;
    private Seminar sem1;
    private Seminar sem2;
    private Seminar sem3;
    private Seminar sem4;
    private IntlNode inode;
    private final ByteArrayOutputStream outputStreamCaptor =
        new ByteArrayOutputStream();

    /**
     * setup method
     */
    public void setUp() {
        l = new EmptyNode();
        r = new EmptyNode();

        node = new IntlNode(new EmptyNode(), new EmptyNode());
        String title = "fish"; // Seminar title
        String date = "0610071600"; // Seminar date
        int length = 30; // Seminar length
        String[] keywords = { "fish", "hampster", "wheel" }; // Seminar keywords
        short x = 60; // Seminar x coord
        short x2 = 40;
        short x3 = 45;
        short x4 = 30;
        short y = 75; // Seminar y coord
        short y1 = 55; // Seminar y coord
        short y2 = 45; // Seminar y coord
        short y3 = 5; // Seminar y coord

        String desc =
            "Introduction to   bioinformatics "
            + "and computation biology"; // Seminar
        // description
        int cost = 300; // Seminar cost
        // int id = 1; // Seminar ID
        sem = new Seminar(1, title, date, length, x, y, cost, keywords, desc);
        sem1 = new Seminar(0, title, date, length, x2, y1, 20, keywords, desc);
        sem2 = new Seminar(3, title, date, length, x3, y2, 30, keywords, desc);
        sem3 = new Seminar(4, title, date, length, x4, y3, 40, keywords, desc);
        sem4 = new Seminar(5, title, date, length, x4, y3, 40, keywords, desc);

    }

    /**
     * tests the insert method
     */
    public void testInsert() {
        node.insert(sem, 0, 128, 0, 128, 0);
        assertFalse(node.left().isEmpty());
        node.insert(sem1, 0, 128, 0, 128, 0);
        assertTrue(node.rightchild().isEmpty());

    }

    /**
     * more tests for the insert
     */
    public void testInsert2() {
        assertFalse(node.isEmpty());
        node.insert(sem1, 0, 128, 0, 128, 1);
        assertFalse(node.left().isEmpty());
    }

    /**
     * tests the delete method
     */
    public void testdelete() {
        node.print(0);
        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "e\r\n" + "e", output);
        BinNode left = node.insert(sem, 0, 128, 0, 128, 0);
        node = new IntlNode(left, new EmptyNode());
        node.delete(60, 75, sem);
        assertTrue(node.left().isEmpty());
        assertTrue(node.rightchild().isEmpty());
    }

    /**
     * another test for delete
     */
    public void testDelete2() {
        node.insert(sem, 0, 128, 0, 128, 0);
        node.insert(sem1, 0, 128, 0, 128, 1);
        node.insert(sem2, 0, 128, 0, 128, 2);
        node.insert(sem3, 0, 128, 0, 128, 3);
        node.delete(60, 75, sem);
        assertFalse(node.left().isEmpty());

        node.delete(40, 55, sem1);
        assertTrue(node.rightchild().isEmpty());
        assertEquals(2, node.search(0, 0, 0, 0, 0, 0, 0, 0, 0));
        node.print(0);
        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e", output);
        node.delete(sem2.x(), sem2.y(), sem2);
        node.delete(sem.x(), sem.y(), sem);
        node.delete(sem3.x(), sem3.y(), sem3);
        node.print(1);
        output += systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n" + "e", output);

    }

}
