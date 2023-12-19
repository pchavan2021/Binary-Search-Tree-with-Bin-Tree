

public class SemSearch {
    /**
     * @param args
     *            Command line parameters
     * @throws Exception
     * @throws NumberFormatException
     */
    public static void main(String[] args)
        throws NumberFormatException,
        Exception {
        // This is the main file for the program.
        Seminar dum = new Seminar();

        if (args != null && args.length == 2) {

            CommandProcessor processor = new CommandProcessor(Integer.parseInt(
                args[0]), args[1]);

        }
        else {
            CommandProcessor hello = new CommandProcessor(128,
                "P2Sample_input.txt");

        }
    }
}
