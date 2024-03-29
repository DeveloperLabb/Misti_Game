import java.util.ArrayList;

public abstract class Player implements PlayerAPI {
    protected ArrayList<Card> hand = new ArrayList<Card>();
    protected ArrayList<Card> wonHand = new ArrayList<Card>();
    protected ArrayList<Card> mistiHand = new ArrayList<Card>();
    protected String name;
    protected int score = 0;


    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    @Override
    public abstract void play();

    @Override
    public void calculateScore() {
        score=0;
        for(Card cards : wonHand){
            score+=cards.getPoint();
        }
        for(Card cards : mistiHand){
            score+=cards.getPoint()*5;
        }
    }
    @Override
    public void printInfo() {
        System.out.println(toString());
        System.out.println(hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int check() {
        if(Board.getOnBoard().size()==2 && Board.getOnBoard().get(1).getRank().equals(Board.getOnBoard().get(0).getRank())){
            return 1;// Mişti
        }
        if (Board.getOnBoard().size()>1 && Board.getOnBoard().get(0).getRank().equals("J")){
            return -1;// Normal collect
        }
        if(Board.getOnBoard().size()>2 && Board.getOnBoard().get(0).getRank().equals(Board.getOnBoard().get(1).getRank())){
            return -1;// Normal Collect
        }
        return 0;//No collect
    }

}
