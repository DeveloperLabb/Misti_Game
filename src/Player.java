import java.util.ArrayList;

public class Player implements PlayerAPI{
    protected  ArrayList<Card> hand = new ArrayList<Card>();

    @Override
    public void play() {

    }

    @Override
    public void calculateScore() {

    }

    @Override
    public void printInfo() {
        for(Card curr : hand){
            System.out.println(curr.toString());
        }
    }
}
