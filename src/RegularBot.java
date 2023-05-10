import java.util.ListIterator;
import java.util.Random;

public class RegularBot extends Player{
    public RegularBot(String name) {
        super("Regular Bot "+name);
        score=0;
        System.out.println(name+" "+" Added Successfully.");
    }

    @Override
    public void play() {
        ListIterator<Card> iterator = hand.listIterator();
        Card chosen = hand.get(0);
        while (iterator.hasNext()) {
            Card curr = iterator.next();
            if(Board.getOnBoard().size()==0){
                if(chosen.getRank().equals("J")){
                    Random random = new Random();
                    curr = hand.get(random.nextInt(0,hand.size()));
                    chosen=curr;
                }
            }
            if (Board.getOnBoard().size() > 0){
                if (curr.getRank().equals(Board.getTopCard().getRank())) {
                    if (Board.calculateScore() + curr.getPoint() > 0) {
                        chosen = curr;
                    }
                }

            }
            else if (curr.getRank().equals("J")) {
                if (Board.calculateScore() + curr.getPoint() > 0) {
                    chosen = curr;
                }
            }
    }
        System.out.println(name+" "+chosen+" played");
        Board.getOnBoard().addFirst(chosen);
        hand.remove(chosen);
    }
}
