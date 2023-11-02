import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * test for the semsearch
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     * 
     * @throws Exception
     * @throws NumberFormatException
     */
    public void testMInitx() throws NumberFormatException, Exception {
        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        SemSearch.main(null);
    }


    /**
     * 
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * 
     * @return the string
     * 
     * @throws IOException
     * 
     */

    public static String readFile(String path) throws IOException

    {
        final byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);

    }


    /**
     * Full parser test
     * 
     * @throws Exception
     * @throws NumberFormatException
     */
    public void testParserfull() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "218";
        args[1] = "P2syntaxInsert_input.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();

        String referenceOutput = readFile("P2syntaxInsert_output.txt");
        assertFuzzyEquals(referenceOutput, output);

    }

    /**
     * tests the command 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testCommand() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "1024";
        args[1] = "cmd.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();

        String referenceOutput = readFile("cmdout.txt");
        assertFuzzyEquals(referenceOutput, output);
    }

    /**
     * another test 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testCommand2() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "1024";
        args[1] = "c.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();

        assertFuzzyEquals("location tree\r\n" + "e\r\n" + "id tree\r\n"
            + "this tree is empty\r\n"
            + "search failed there is no record with id 1\r\n"
            + "seminars matching keyword vt\r\n"
            + "insert failed bad x y coordinates 1 10\r\n"
            + "insert failed bad x y coordinates 10 1024\r\n"
            + "successfully inserted record with id 1\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 2\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 10\r\n"
            + "id 10 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "successfully inserted record with id 3\r\n"
            + "id 3 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 0 y 0 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n" + "id tree\r\n"
            + "null\r\n" + "10\r\n" + "null\r\n" + "3\r\n" + "null\r\n"
            + "2\r\n" + "null\r\n" + "1\r\n" + "null\r\n"
            + "number of records 4\r\n" + "date tree\r\n" + "null\r\n"
            + "1203301125\r\n" + "null\r\n" + "0701250830\r\n" + "null\r\n"
            + "0610071600\r\n" + "null\r\n" + "0610051600\r\n" + "null\r\n"
            + "number of records 4\r\n" + "keyword tree\r\n" + "null\r\n"
            + "science\r\n" + "null\r\n" + "high_performance_computing\r\n"
            + "null\r\n" + "grids\r\n" + "null\r\n" + "computer_science\r\n"
            + "null\r\n" + "computer\r\n" + "null\r\n"
            + "computation_biology\r\n" + "null\r\n" + "virginia_tech\r\n"
            + "null\r\n" + "virginia_tech\r\n" + "null\r\n" + "vt\r\n"
            + "null\r\n" + "vt\r\n" + "null\r\n" + "vt\r\n" + "null\r\n"
            + "hpc\r\n" + "null\r\n" + "hci\r\n" + "null\r\n"
            + "computer_science\r\n" + "null\r\n" + "computer_science\r\n"
            + "null\r\n" + "cse\r\n" + "null\r\n" + "biology\r\n" + "null\r\n"
            + "bioinformatics\r\n" + "null\r\n" + "number of records 18\r\n"
            + "cost tree\r\n" + "null\r\n" + "45\r\n" + "null\r\n" + "30\r\n"
            + "null\r\n" + "25\r\n" + "null\r\n" + "17\r\n" + "null\r\n"
            + "number of records 4\r\n" + "location tree\r\n" + "i\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 3\r\n" + "leaf with 2 objects 1 2\r\n"
            + "e\r\n" + "leaf with 1 objects 10\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n"
            + "insert failed there is already a record with id 10\r\n"
            + "seminars matching keyword vt\r\n"
            + "id 10 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "found record with id 1\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "seminars with costs in range 30 to 50\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "7 nodes visited in this search\r\n"
            + "seminars with dates in range 0 to 1\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "id 10 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "8 nodes visited in this search\r\n"
            + "record with id 1 successfully deleted from the database\r\n"
            + "id tree\r\n" + "null\r\n" + "10\r\n" + "null\r\n" + "3\r\n"
            + "null\r\n" + "2\r\n" + "null\r\n" + "number of records 3\r\n"
            + "location tree\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 3\r\n"
            + "leaf with 1 objects 2\r\n" + "e\r\n"
            + "leaf with 1 objects 10\r\n" + "e\r\n" + "e\r\n" + "e\r\n"
            + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e\r\n" + "e",
            output);
    }

    /**
     * another test
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testCommand3() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "1024";
        args[1] = "p.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();

        assertFuzzyEquals("successfully inserted record with id 1\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 2\r\n"
            + "id 2 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 10\r\n"
            + "id 10 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "successfully inserted record with id 3\r\n"
            + "id 3 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 0 y 0 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n"
            + "successfully inserted record with id 4\r\n"
            + "id 4 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 0 y 0 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n"
            + "successfully inserted record with id 5\r\n"
            + "id 5 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "successfully inserted record with id 8\r\n"
            + "id 8 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "id tree\r\n" + "null\r\n" + "10\r\n" + "null\r\n" + "8\r\n"
            + "null\r\n" + "5\r\n" + "null\r\n" + "4\r\n" + "null\r\n" + "3\r\n"
            + "null\r\n" + "2\r\n" + "null\r\n" + "1\r\n" + "null\r\n"
            + "number of records 7\r\n" + "cost tree\r\n" + "null\r\n"
            + "45\r\n" + "null\r\n" + "30\r\n" + "null\r\n" + "30\r\n"
            + "null\r\n" + "25\r\n" + "null\r\n" + "25\r\n" + "null\r\n"
            + "17\r\n" + "null\r\n" + "17\r\n" + "null\r\n"
            + "number of records 7\r\n"
            + "record with id 10 successfully deleted from the database\r\n"
            + "id tree\r\n" + "null\r\n" + "8\r\n" + "null\r\n" + "5\r\n"
            + "null\r\n" + "4\r\n" + "null\r\n" + "3\r\n" + "null\r\n" + "2\r\n"
            + "null\r\n" + "1\r\n" + "null\r\n" + "number of records 6\r\n"
            + "cost tree\r\n" + "null\r\n" + "45\r\n" + "null\r\n" + "30\r\n"
            + "null\r\n" + "30\r\n" + "null\r\n" + "25\r\n" + "null\r\n"
            + "25\r\n" + "null\r\n" + "17\r\n" + "null\r\n"
            + "number of records 6\r\n"
            + "delete failed there is no record with id 9\r\n" + "id tree\r\n"
            + "null\r\n" + "8\r\n" + "null\r\n" + "5\r\n" + "null\r\n" + "4\r\n"
            + "null\r\n" + "3\r\n" + "null\r\n" + "2\r\n" + "null\r\n" + "1\r\n"
            + "null\r\n" + "number of records 6\r\n" + "cost tree\r\n"
            + "null\r\n" + "45\r\n" + "null\r\n" + "30\r\n" + "null\r\n"
            + "30\r\n" + "null\r\n" + "25\r\n" + "null\r\n" + "25\r\n"
            + "null\r\n" + "17\r\n" + "null\r\n" + "number of records 6\r\n"
            + "record with id 2 successfully deleted from the database\r\n"
            + "id tree\r\n" + "null\r\n" + "8\r\n" + "null\r\n" + "5\r\n"
            + "null\r\n" + "4\r\n" + "null\r\n" + "3\r\n" + "null\r\n" + "1\r\n"
            + "null\r\n" + "number of records 5\r\n" + "cost tree\r\n"
            + "null\r\n" + "45\r\n" + "null\r\n" + "30\r\n" + "null\r\n"
            + "25\r\n" + "null\r\n" + "25\r\n" + "null\r\n" + "17\r\n"
            + "null\r\n" + "number of records 5\r\n"
            + "record with id 4 successfully deleted from the database\r\n"
            + "id tree\r\n" + "null\r\n" + "8\r\n" + "null\r\n" + "5\r\n"
            + "null\r\n" + "3\r\n" + "null\r\n" + "1\r\n" + "null\r\n"
            + "number of records 4\r\n" + "cost tree\r\n" + "null\r\n"
            + "45\r\n" + "null\r\n" + "30\r\n" + "null\r\n" + "25\r\n"
            + "null\r\n" + "17\r\n" + "null\r\n" + "number of records 4\r\n"
            + "delete failed there is no record with id 2\r\n" + "id tree\r\n"
            + "null\r\n" + "8\r\n" + "null\r\n" + "5\r\n" + "null\r\n" + "3\r\n"
            + "null\r\n" + "1\r\n" + "null\r\n" + "number of records 4\r\n"
            + "date tree\r\n" + "null\r\n" + "1203301125\r\n" + "null\r\n"
            + "0701250830\r\n" + "null\r\n" + "0610071600\r\n" + "null\r\n"
            + "0610051600\r\n" + "null\r\n" + "number of records 4\r\n"
            + "cost tree\r\n" + "null\r\n" + "45\r\n" + "null\r\n" + "30\r\n"
            + "null\r\n" + "25\r\n" + "null\r\n" + "17\r\n" + "null\r\n"
            + "number of records 4\r\n"
            + "seminars with dates in range 0 to 2\r\n"
            + "id 1 title overview of hci research at vt\r\n"
            + "date 0610051600 length 90 x 10 y 10 cost 45\r\n"
            + "description this seminar will present an overview of hci research at vt\r\n"
            + "keywords hci computer_science vt virginia_tech\r\n"
            + "id 5 title computational biology and bioinformatics in cs at virginia tech\r\n"
            + "date 0610071600 length 60 x 10 y 10 cost 30\r\n"
            + "description introduction to bioinformatics and computation biology\r\n"
            + "keywords bioinformatics computation_biology biology computer_science vt virginia_tech\r\n"
            + "id 8 title computing systems research at vt\r\n"
            + "date 0701250830 length 30 x 30 y 10 cost 17\r\n"
            + "description seminar about the computing systems research at vt\r\n"
            + "keywords high_performance_computing grids vt computer science\r\n"
            + "id 3 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 0 y 0 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n"
            + "9 nodes visited in this search", output);
    }

    /**
     * another test
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testCommand4() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "128";
        args[1] = "dog.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();
        assertFuzzyEquals("keyword tree\r\n" + "this tree is empty\r\n"
            + "successfully inserted record with id 3\r\n"
            + "id 3 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 43 y 3 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n" + "keyword tree\r\n"
            + "null\r\n" + "computer_science\r\n" + "null\r\n" + "hpc\r\n"
            + "null\r\n" + "cse\r\n" + "null\r\n" + "number of records 3\r\n"
            + "insert failed there is already a record with id 3\r\n"
            + "keyword tree\r\n" + "null\r\n" + "computer_science\r\n"
            + "null\r\n" + "hpc\r\n" + "null\r\n" + "cse\r\n" + "null\r\n"
            + "number of records 3\r\n"
            + "successfully inserted record with id 33\r\n"
            + "id 33 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 35 x 100 y 99 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n"
            + "successfully inserted record with id 32\r\n"
            + "id 32 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 325 x 100 y 33 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n"
            + "successfully inserted record with id 333\r\n"
            + "id 333 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 325 x 100 y 33 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n" + "keyword tree\r\n"
            + "null\r\n" + "computer_science\r\n" + "null\r\n"
            + "computer_science\r\n" + "null\r\n" + "computer_science\r\n"
            + "null\r\n" + "computer_science\r\n" + "null\r\n" + "hpc\r\n"
            + "null\r\n" + "hpc\r\n" + "null\r\n" + "hpc\r\n" + "null\r\n"
            + "hpc\r\n" + "null\r\n" + "cse\r\n" + "null\r\n" + "cse\r\n"
            + "null\r\n" + "cse\r\n" + "null\r\n" + "cse\r\n" + "null\r\n"
            + "number of records 12\r\n"
            + "successfully inserted record with id 333\r\n"
            + "id 333 title overview of hpc and cse research at vt\r\n"
            + "date 1203301125 length 0 x 0 y 0 cost 25\r\n"
            + "description learn what kind of research is done on hpc and cse at vt\r\n"
            + "keywords hpc cse computer_science\r\n" + "location tree\r\n"
            + "i\r\n" + "i\r\n" + "i\r\n" + "leaf with 1 objects 333\r\n"
            + "leaf with 1 objects 3\r\n" + "e\r\n" + "i\r\n"
            + "leaf with 2 objects 32 333\r\n" + "leaf with 1 objects 33\r\n"
            + "insert failed there is already a record with id 33\r\n"
            + "insert failed there is already a record with id 32\r\n"
            + "record with id 3 successfully deleted from the database\r\n"
            + "location tree\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 333\r\n" + "e\r\n" + "e\r\n" + "i\r\n"
            + "leaf with 2 objects 32 333\r\n" + "leaf with 1 objects 33\r\n"
            + "record with id 32 successfully deleted from the database\r\n"
            + "location tree\r\n" + "i\r\n" + "i\r\n" + "i\r\n"
            + "leaf with 1 objects 333\r\n" + "e\r\n" + "e\r\n" + "i\r\n"
            + "leaf with 1 objects 333\r\n" + "leaf with 1 objects 33\r\n"
            + "record with id 333 successfully deleted from the database\r\n"
            + "record with id 33 successfully deleted from the database\r\n"
            + "delete failed there is no record with id 32\r\n"
            + "input is not a valid integer\r\n" + "location tree\r\n" + "i\r\n"
            + "e\r\n" + "e", output);
    }
}
