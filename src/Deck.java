import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final static String[] suits = {"S","C","H","D"};
    private final static String[] ranks = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    private static ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        deckMake();
        Collections.shuffle(deck);
        //pullPoints();
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    private void deckMake(){
        for(String suit : suits){
            for(String rank :ranks){
                Card temp = new Card(suit,rank);
                deck.add(temp);
            }
        }
    }
    private void pullPoints(){
        File.openFile();
        File.setPoints();
        File.closeFile();
    }
}
