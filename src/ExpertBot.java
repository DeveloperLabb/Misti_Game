import java.util.Random;

public class ExpertBot extends Player{
    private static int numberOfExpertBot = 0;
    @Override
    public void play() {
        Random random = new Random();
        int chosen = random.nextInt(0,hand.size());
        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
        check();
    }

    public ExpertBot() {
        name="Expert Bot";
        surname=Integer.toString(numberOfExpertBot);
        score=0;
        numberOfExpertBot++;
        System.out.println(name+" "+surname+" Added Successfully.");

    }
}
