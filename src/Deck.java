import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private final static String[] suits = {"S","C","H","D"};
    private final static String[] ranks = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    private static ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        deckMake();
        Collections.shuffle(deck);
        deckCut();
        pullPoints();
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
    public void deckCut() {
        int cutPoint = new Random().nextInt(0,deck.size()); // choose a random cut point.
        ArrayList<Card> cutDeck = new ArrayList<>();
        cutDeck.addAll(deck.subList(cutPoint, deck.size()));
        cutDeck.addAll(deck.subList(0, cutPoint));
        deck=cutDeck;
    }
    public void dealBoard(){
        for(int i = 0;i<4;i++){
            Board.getDeck().add(deck.get(0));
            deck.remove(0);
        }
    }
    public void deal(Player player,Player player1){
        for(int i =0;i<4;i++){
            player.hand.add(deck.get(0));
            deck.remove(0);
            player1.hand.add(deck.get(0));
            deck.remove(0);
        }
    }
    public void deal(Player player,Player player1,Player player2){
        for(int i =0;i<4;i++){
            player.hand.add(deck.get(0));
            deck.remove(0);
            player1.hand.add(deck.get(0));
            deck.remove(0);
            player2.hand.add(deck.get(0));
            deck.remove(0);

        }
    }
    public void deal(Player player,Player player1,Player player2,Player player3){
        player.hand.add(deck.get(0));
        deck.remove(0);
        player1.hand.add(deck.get(0));
        deck.remove(0);
        player2.hand.add(deck.get(0));
        deck.remove(0);
        player3.hand.add(deck.get(0));
        deck.remove(0);
    }
}
