
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import java.io.PrintStream;

import org.junit.Test;

import student.TestCase;

public class BSTTest extends TestCase {
    private BST<String, Seminar> tree;
    private Seminar sem;
    private Seminar sem1;
    private Seminar sem2;
    private Seminar sem3;
    private final ByteArrayOutputStream outputStreamCaptor =
        new ByteArrayOutputStream();

    public void setUp() {
        tree = new BST<>();
        String title = "fish"; // Seminar title
        String date = "0610071600"; // Seminar date
        int length = 30; // Seminar length
        String[] keywords = { "fish", "hampster", "wheel" }; // Seminar keywords
        short x = 60; // Seminar x coord
        short y = 20; // Seminar y coord
        String desc =
            "Introduction to   bioinformatics and computation biology"; // Seminar
        // description
        int cost = 300; // Seminar cost
        // int id = 1; // Seminar ID
        sem = new Seminar(1, title, date, length, x, y, cost, keywords, desc);
        sem1 = new Seminar(0, title, date, length, x, y, 20, keywords, desc);
        sem2 = new Seminar(3, title, date, length, x, y, 30, keywords, desc);
        sem3 = new Seminar(4, title, date, length, x, y, 40, keywords, desc);
    }


    public void testInsert() {
        tree.insert("300", sem);
        tree.insert("301", sem1);
        tree.insert("200", sem2);
        tree.printReverse(tree.returnRoot(), true, 0);
        String printedText = outputStreamCaptor.toString();
        assertFuzzyEquals("id 3 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheelid 1 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 300\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheelid 0 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 20\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheel", tree.toInOrderString(tree
                .returnRoot()));
    }


    public void testSize() {
        assertEquals(0, tree.size(tree.returnRoot()));
        tree.insert("300", sem);
        tree.insert("301", sem1);
        tree.insert("200", sem2);
        assertEquals(3, tree.size(tree.returnRoot()));
    }


    public void testMaxValue() {
        tree.insert("300", sem);
        tree.insert("301", sem1);
        tree.insert("200", sem2);
        assertFuzzyEquals("301", tree.maxValue(tree.returnRoot()));
        assertEquals(sem1, tree.maxSem(tree.returnRoot()));
    }


    public void testSearchID() {
        tree.insert("1", sem);
        tree.insert("2", sem1);
        tree.insert("3", sem2);
        assertTrue(tree.searchID(tree.returnRoot(), "1"));
        assertFalse(tree.searchID(tree.returnRoot(), "11"));
    }


    public void testDelete() {
        tree.insert("1", sem);
        tree.insert("2", sem1);
        tree.insert("3", sem2);
        NodeK<String, Seminar> test = tree.returnNode(tree.returnRoot(), "1");
        NodeK<String, Seminar> test1 = tree.returnNode(tree.returnRoot(), "12");
        tree.delete(test);
        // String printedText = outputStreamCaptor.toString();
        assertFuzzyEquals("id 1 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 300\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheelid 0 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 20\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheelid 3 title fish\r\n"
            + "date 0610071600 length 30 x 60 y 20 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords fish hampster wheel", tree.toInOrderString(test));
    }


    public void testDelete2() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "1024";
        args[1] = "delete.txt";
        SemSearch.main(args);
        String output = systemOut().getHistory();
        assertFuzzyEquals("delete failed there is no record with id 1\r\n"
            + "successfully inserted record with id 10\r\n"
            + "id 10 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 25\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "successfully inserted record with id 1\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 30\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 2\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "keyword tree\r\n" + "null\r\n" + "science\r\n" + "null\r\n"
            + "high_performance_computing\r\n" + "null\r\n" + "grids\r\n"
            + "null\r\n" + "computer\r\n" + "null\r\n"
            + "computation_biology\r\n" + "null\r\n" + "virginia_tech\r\n"
            + "null\r\n" + "virginia_tech\r\n" + "null\r\n" + "vt\r\n"
            + "null\r\n" + "vt\r\n" + "null\r\n" + "vt\r\n" + "null\r\n"
            + "hci\r\n" + "null\r\n" + "computer_science\r\n" + "null\r\n"
            + "computer_science\r\n" + "null\r\n" + "biology\r\n" + "null\r\n"
            + "bioinformatics\r\n" + "null\r\n" + "number of records 15\r\n"
            + "record with id 10 successfully deleted from the database\r\n"
            + "cost tree\r\n" + "null\r\n" + "30\r\n" + "null\r\n" + "30\r\n"
            + "null\r\n" + "number of records 2\r\n"
            + "record with id 2 successfully deleted from the database\r\n"
            + "delete failed there is no record with id 2\r\n"
            + "delete failed there is no record with id 4\r\n"
            + "delete failed there is no record with id 10\r\n"
            + "record with id 1 successfully deleted from the database\r\n"
            + "keyword tree\r\n" + "this tree is empty\r\n" + "cost tree\r\n"
            + "this tree is empty\r\n" + "date tree\r\n" + "this tree is empty",
            output);

    }


    public void testMaxSem() {
        tree.toInOrderString(tree.returnRoot());
        String output = systemOut().getHistory();
        assertEquals(output, "");
        tree.insert("300", sem);
        tree.insert("301", sem1);
        tree.insert("200", sem2);
        assertEquals(sem1.toString(), tree.maxSem(tree.returnRoot())
            .toString());
        tree.search(tree.returnRoot(), "300");
        output = systemOut().getHistory();
        assertFuzzyEquals("", output);
        tree.search(tree.returnRoot(), "3030");
        output = systemOut().getHistory();
        assertFuzzyEquals("search failed there is no record with id 3030",
            output);
    }


    public void testDelete3() {
        tree.insert("300", sem);
        tree.insert("301", sem1);
        tree.insert("200", sem2);
        NodeK<String, Seminar> test = tree.returnNode(tree.returnRoot(), "300");
        NodeK<String, Seminar> test1 = tree.returnNode(tree.returnRoot(),
            "303");
        NodeK<String, Seminar> test2 = tree.returnNode(tree.returnRoot(),
            "301");
        tree.delete(test);
        tree.deleteRec(test1, test);
        tree.delete(test2);
        String output = systemOut().getHistory();
        assertFuzzyEquals(output, "");
    }


    public void testPrintReverse() {

        tree.insert("300", sem);
        String output = systemOut().getHistory();
        tree.insert("301", sem1);
        output += systemOut().getHistory();
        tree.insert("200", sem2);
        tree.printReverse(tree.returnRoot(), true, 0);
        output += systemOut().getHistory();
        tree.insert("30", sem);
        tree.insert("35", sem1);
        tree.insert("400", sem2);
        tree.insert("10", sem);
        tree.insert("351", sem1);
        tree.insert("220", sem2);
        tree.insert("330", sem);
        tree.insert("331", sem1);
        tree.insert("2040", sem2);
        tree.insert("340", sem);
        tree.insert("01", sem1);
        tree.insert("20", sem2);
        output += systemOut().getHistory();
        assertFuzzyEquals("null\r\n" + "301\r\n" + "null\r\n" + "300\r\n"
            + "null\r\n" + "200\r\n" + "null\r\n" + "null\r\n" + "301\r\n"
            + "null\r\n" + "300\r\n" + "null\r\n" + "200\r\n" + "null", output);
    }


    public void testSearchSpe() {
        tree.insert("200", sem2);
        tree.insert("201", null);
        tree.insert("199", null);
        assertTrue(tree.specificSearch(tree.returnRoot(), "200"));
        assertTrue(tree.specificSearch(tree.returnRoot(), "201"));
        assertTrue(tree.specificSearch(tree.returnRoot(), "199"));
        assertFalse(tree.specificSearch(tree.returnRoot(), "19"));
        assertTrue(tree.searchID(tree.returnRoot(), "200"));
        assertTrue(tree.searchID(tree.returnRoot(), "201"));
        assertTrue(tree.searchID(tree.returnRoot(), "199"));
        assertFalse(tree.searchID(tree.returnRoot(), "19"));

    }


    public void testPrinting() {
        tree.insert("200", sem2);
        tree.insert("201", null);
        tree.insert("199", null);
        tree.insert("20", sem2);
        tree.insert("1", null);
        tree.insert("19", null);
        tree.insert("20", sem2);
        tree.insert("21", null);
        tree.insert("99", null);
        tree.insert("220", sem2);
        tree.insert("241", sem3);
        tree.insert("39", null);
        tree.printReverse(tree.returnRoot(), true, 0);
        String output = systemOut().getHistory();
        assertFuzzyEquals("null\r\n"
            + "99\r\n"
            + "null\r\n"
            + "39\r\n"
            + "null\r\n"
            + "241\r\n"
            + "null\r\n"
            + "220\r\n"
            + "null\r\n"
            + "21\r\n"
            + "null\r\n"
            + "201\r\n"
            + "null\r\n"
            + "200\r\n"
            + "null\r\n"
            + "20\r\n"
            + "null\r\n"
            + "20\r\n"
            + "null\r\n"
            + "199\r\n"
            + "null\r\n"
            + "19\r\n"
            + "null\r\n"
            + "1\r\n"
            + "null", output);
    }

}
