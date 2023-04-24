import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class File {
    private static Scanner input;
    public static void openFile(){
        try {
            input = new Scanner(Paths.get("points.txt"));
        } catch (IOException e) {
            System.err.println("Error opening file.");
            throw new RuntimeException(e);
        }
    }
    public static void setPoints(){
        try{
            while(input.hasNextLine()){
                String[] currArr = input.nextLine().split(" ");
                for(Card current : Deck.getDeck()){
                    if(current.getRank().equals(currArr[0].charAt(1)) || current.getRank().equals('*') || current.getSuit().equals(currArr[0].charAt(0)) || current.getSuit().equals('*')){
                        current.setPoint(Integer.parseInt(currArr[1]));
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format");
            throw new RuntimeException(e);
        } catch (NoSuchElementException e){
            System.err.println();
        } catch (IllegalStateException e){
            System.err.println();
        }
    }
    public static void closeFile(){
        if(input!= null){
            input.close();
        }
    }
}
