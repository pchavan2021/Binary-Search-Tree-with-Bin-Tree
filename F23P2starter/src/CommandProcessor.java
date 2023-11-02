
import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 * 
 *
 * @author Evan Howe (evanhowe03)
 * @author Pallavi Chavan (Pallucha21)
 * @version 9/14/2023
 */
public class CommandProcessor {
    private DataBase dataBase;

    public CommandProcessor(int size, String file) throws Exception {

        int worldSize = size;
        dataBase = new DataBase(worldSize);

        try {

            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNext()) {
                String word = scanner.next().trim();

                try {
                    if (word.equalsIgnoreCase("insert")) {
                        insert(scanner);
                    }
                    else if (word.equalsIgnoreCase("search")) {
                        search(scanner);
                    }
                    else if (word.equalsIgnoreCase("delete")) {
                        delete(scanner);
                    }
                    else if (word.equalsIgnoreCase("print")) {
                        print(scanner);
                    }
                    else {
                        System.out.println("Unknown command: " + word);
                    }
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Input is not valid.");

                }
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void insert(Scanner scanner) throws Exception {

        int id = scanner.nextInt();
        scanner.nextLine();
        String title = scanner.nextLine().trim();
        String date = scanner.next();
        int length = scanner.nextInt();
        short x = scanner.nextShort();
        short y = scanner.nextShort();
        int cost = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        // String[] words = line.split(" ");
        String[] words = line.trim().split("\\s+");
        String des = scanner.nextLine().trim();

        // create a Seminar
        Seminar mySeminar = new Seminar(id, title, date, length, x, y, cost,
            words, des);

        // later add to database
        dataBase.add(mySeminar);

    }


    public void search(Scanner scanner) {
        try {
            if (scanner.hasNext()) {
                String search = scanner.next();

                if (search.equalsIgnoreCase("ID")) {
                    int id = scanner.nextInt();
                    dataBase.searchId(id);
                }
                else if (search.equalsIgnoreCase("COST")) {
                    int lowCost = scanner.nextInt();
                    int highCost = scanner.nextInt();
                    dataBase.searchCost(lowCost, highCost);
                }
                else if (search.equalsIgnoreCase("DATE")) {

                    String first = scanner.next();
                    String second = scanner.next();

                    dataBase.searchDate(first, second);
                }
                else if (search.equalsIgnoreCase("keyword")) {
                    String key = scanner.next();
                    dataBase.searchKeyWord(key);
                }
                else {
                    // Assume this is the "location" case.
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int radius = scanner.nextInt();
                    dataBase.searchLocation(x, y, radius);
                }
            }
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Input is not valid.");
            // You can handle the exception or rethrow it as needed.
        }

    }


    public void delete(Scanner scanner) {
        try {

            int delete = scanner.nextInt();
            dataBase.delete(delete);

        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Input is not a valid integer.");

        }
    }


    public void print(Scanner scanner) {
        try {

            String print = scanner.next();
            switch (print.toLowerCase()) {
                case "id":
                    dataBase.printID();
                    break;
                case "cost":
                    dataBase.printCost();
                    break;
                case "date":
                    dataBase.printDate();
                    break;
                case "keyword":
                    dataBase.printKeyword();
                    break;
                case "location":
                    dataBase.printLocation();
                    break;
                default:
                    System.out.println("Unknown print type: " + print);
                    break;

            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Input is not valid.");
            scanner.nextLine();
        }
    }

}
