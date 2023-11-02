import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version 10/10/23
 * Test case for the syntax insert files
 */
public class SyntaxInsertTest extends TestCase {
    /**
     * constructor
     * @param path this the input file
     * @return the string
     * @throws IOException
     */
    public static String readFile(String path) throws IOException

    {
        final byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);

    }

    /**
     * test the inser files
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testSyntaxInsert() throws NumberFormatException, Exception {
        final String[] args = new String[2];
        args[0] = "218";
        args[1] = "P2syntaxInsert_input.txt";

        SemSearch.main(args);
        String output = systemOut().getHistory();

        String referenceOutput = readFile("P2syntaxInsert_output.txt");
        assertFuzzyEquals(referenceOutput, output);
    }

}
