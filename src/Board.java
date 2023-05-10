import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    private static LinkedList<Card> onBoard = new LinkedList<Card>();
    private static ArrayList<String> stats = new ArrayList<>();
    public static LinkedList<Card> getOnBoard() {
        return onBoard;
    }


    public static Card getTopCard(){
        if(Board.onBoard.size()>0){
            return onBoard.get(0);
        }
        return null;
    }

    public static int calculateScore() {
        int totalScore=0;
        for(Card cards : onBoard){
            totalScore+=cards.getPoint();
        }
        return totalScore;
    }
    public static void clear() {
        onBoard.clear();
    }
    public static void printInfo() {
        System.out.println(onBoard);
    }
    public static void reset(){
        onBoard.clear();
        stats.clear();

    }
    public static ArrayList<String> calculateStats(){
        return stats;
    }
}
