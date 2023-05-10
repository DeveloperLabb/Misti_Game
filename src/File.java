import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class File {
    private static Scanner input;
    private static String fileName;

    public static void setFileName(String fileName) {
        File.fileName = fileName;
    }

    public static void openFile() {
        try {
            input = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Error opening file.\n This program continue with default card points(1)");
        }
    }

    public static void setPoints() {
        try {
            while (input.hasNextLine()) {
                String[] currArr = input.nextLine().split(" ");
                for (Card current : Deck.getDeck()) {
                    if(current.getPoint() != 1){
                        continue;
                    }
                    if ((current.getSuit().equals(Character.toString(currArr[0].charAt(0)))  && current.getRank().equals(Character.toString(currArr[0].charAt(1)))) || (current.getSuit().equals(Character.toString(currArr[0].charAt(0))) && currArr[0].charAt(1) == '*' )  || (current.getRank().equals(Character.toString(currArr[0].charAt(1))) && currArr[0].charAt(0) == '*')) {
                        current.setPoint(Integer.parseInt(currArr[1]));
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format");
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            System.err.println();
        } catch (IllegalStateException e) {
            System.err.println();
        }
    }

    public static void closeFile() {
        if (input != null) {
            input.close();
        }
    }
}
