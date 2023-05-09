import java.util.Random;

public class NoviceBot extends Player{

    @Override
    public void play() {
        Random random = new Random();
        int chosen = random.nextInt(0,hand.size());
        System.out.println(name+" "+ hand.get(chosen) +" played");
        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
    }

    public NoviceBot(String name) {
        super("Novice Bot "+name);
        score=0;
        System.out.println(name+" "+" Added Successfully.");
    }

}
