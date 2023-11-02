
import java.io.ByteArrayOutputStream;

import org.junit.Test;

import java.io.PrintStream;

import org.junit.Test;

import student.TestCase;

public class BinTreeTest extends TestCase {
    private BinTree tree;
    private final ByteArrayOutputStream outputStreamCaptor =
        new ByteArrayOutputStream();
    private Seminar sem;
    private Seminar sem1;
    private Seminar sem2;
    private Seminar sem3;
    private Seminar sem4;

    @Test
    public void setUp() {
        tree = new BinTree();
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
            "Introduction to   bioinformatics and computation biology"; // Seminar
        // description
        int cost = 300; // Seminar cost
        // int id = 1; // Seminar ID
        sem = new Seminar(1, title, date, length, x, y, cost, keywords, desc);
        sem1 = new Seminar(0, title, date, length, x2, y1, 20, keywords, desc);
        sem2 = new Seminar(3, title, date, length, x3, y2, 30, keywords, desc);
        sem3 = new Seminar(4, title, date, length, x4, y3, 40, keywords, desc);
        sem4 = new Seminar(5, title, date, length, x4, y3, 40, keywords, desc);
    }


    public void testBinTree() {

        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem1, 0, 128, 0, 128);
        tree.insert(sem2, 0, 128, 0, 128);
        tree.insert(sem3, 0, 128, 0, 128);
        tree.print();

        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n"
            + "leaf with 1 objects 1\r\n" + "e", output);

    }


    public void testBinDelete() {

        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem1, 0, 128, 0, 128);
        tree.insert(sem2, 0, 128, 0, 128);
        tree.insert(sem3, 0, 128, 0, 128);
        tree.delete(60, 75, sem);
        tree.print();

        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n" + "e\r\n" + "e", output);
        tree.delete(40, 55, sem1);
        tree.delete(45, 45, sem2);
        tree.delete(30, 5, sem3);
        tree.print();
        output += systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 4\r\n"
            + "i\r\n" + "e\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 3\r\n" + "leaf with 1 objects 0\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "e\r\n" + "i\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e", output);
        tree.insert(sem3, 0, 128, 0, 128);
        tree.insert(sem4, 0, 128, 0, 128);
        tree.delete(30, 5, sem3);
        tree.print();
        tree.delete(30, 5, sem4);
        tree.print();
        output += systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 4\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 4\r\n"
            + "i\r\n" + "e\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 3\r\n" + "leaf with 1 objects 0\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "e\r\n" + "i\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 4\r\n"
            + "i\r\n" + "e\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 3\r\n" + "leaf with 1 objects 0\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "e\r\n" + "i\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 5\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "i\r\n" + "i\r\n" + "e\r\n"
            + "e\r\n" + "e", output);

    }


    public void testDelete() {
        tree.insert(sem, 0, 128, 0, 128);
        tree.delete(sem.x(), sem.y(), sem);
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("e", output);
    }


    public void testDelete2() {
        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem1, 0, 128, 0, 128);
        tree.delete(sem.x(), sem.y(), sem);
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "leaf with 1 objects 0\r\n"
            + "e\r\n" + "e", output);
    }


    public void testDelete3() {
        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem1, 0, 128, 0, 128);
        tree.delete(sem.x(), sem.y(), sem);
        tree.delete(sem1.x(), sem1.y(), sem1);
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "e\r\n" + "e", output);

    }


    public void testPrint() {
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("e", output);
    }


    public void testDeleteFurther() {
        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem, 0, 128, 0, 128);
        tree.delete(sem.x(), sem.y(), sem);
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("leaf with 1 objects 1", output);

        tree.delete(sem.x(), sem.y(), sem);
        tree.print();
        output = systemOut().getHistory();
        assertFuzzyEquals("leaf with 1 objects 1\r\n" + "e", output);

    }


    public void testDeleteAgain() {
        tree.insert(sem, 0, 128, 0, 128);
        tree.insert(sem1, 0, 128, 0, 128);
        tree.insert(sem2, 0, 128, 0, 128);
        tree.print();
        String output = systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "e\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n"
            + "leaf with 1 objects 1\r\n" + "e", output);
        tree.delete(sem.x(), sem.y(), sem);
        tree.delete(sem1.x(), sem1.y(), sem1);
        tree.delete(sem2.x(), sem2.y(), sem2);
        tree.print();
        output += systemOut().getHistory();
        assertFuzzyEquals("i\r\n" + "i\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "e\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 0\r\n" + "e\r\n"
            + "leaf with 1 objects 1\r\n" + "e\r\n" + "i\r\n" + "i\r\n"
            + "i\r\n" + "e\r\n" + "i\r\n" + "e\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 3\r\n" + "leaf with 1 objects 0\r\n"
            + "e\r\n" + "leaf with 1 objects 1\r\n" + "e\r\n" + "i\r\n"
            + "i\r\n" + "i\r\n" + "e\r\n" + "i\r\n" + "e\r\n" + "i\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "e", output);

    }

}
