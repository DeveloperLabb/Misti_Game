import java.util.Random;

public class NoviceBot extends Player{
    private static int numberOfNoviceBot = 0;

    @Override
    public void play() {
        Random random = new Random();
        int chosen = random.nextInt(0,hand.size());
        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
    }

    public NoviceBot() {
        name="Novice Bot";
        surname=Integer.toString(numberOfNoviceBot);
        score=0;
        numberOfNoviceBot++;
        System.out.println(name+" "+surname+" Added Successfully.");
    }
}
