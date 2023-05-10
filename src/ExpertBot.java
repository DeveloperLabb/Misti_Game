import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

public class ExpertBot extends Player{
    private ArrayList<Integer> stats = new ArrayList<>();
    @Override
    public void play() {
        ListIterator<Card> iterator = hand.listIterator();
        Card chosen = hand.get(0);
        int freqMax = Collections.frequency(Board.calculateStats(),hand.get(0).getRank());
        for(Card cards : hand){
            if(freqMax<Collections.frequency(Board.calculateStats(),cards.getRank())){
                chosen=cards;
                freqMax=Collections.frequency(Board.calculateStats(),cards.getRank());
            }
        }
        //System.out.println(chosen.getRank()+"------"+freqMax);
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
                else if (curr.getRank().equals("J")) {
                    if (Board.calculateScore() + curr.getPoint() > 0) {
                        chosen = curr;
                    }
                }
            }

        }
        System.out.println(name+" "+chosen+" played");
        Board.getOnBoard().addFirst(chosen);
        hand.remove(chosen);
    }

    public ExpertBot(String name) {
        super("Expert Bot "+name);
        score=0;
        System.out.println(name+" "+" Added Successfully.");
    }
}
