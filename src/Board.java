import java.util.LinkedList;

public class Board {
    private static LinkedList<Card> onBoard = new LinkedList<Card>();

    public static LinkedList<Card> getOnBoard() {
        return onBoard;
    }
    public static void calculateScore() {

    }
    public static void clear() {
        onBoard.clear();
    }
    public static void printInfo() {
        System.out.println(onBoard);
    }

}
