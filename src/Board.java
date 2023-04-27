import java.util.ArrayList;

public class Board {
    private static ArrayList<Card> deck = new ArrayList<Card>();

    public static ArrayList<Card> getDeck() {
        return deck;
    }
    public void calculateScore() {

    }
    public void clear() {
        deck.clear();
    }
}
