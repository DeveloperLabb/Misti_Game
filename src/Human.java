import java.util.Random;

public class Human extends Player{
    public Human(String name, String surname) {
        super(name, surname);
        score=0;
        System.out.println(name+" "+surname+" Added Successfully.");
    }

    @Override
    public void play() {
        Random random = new Random();
        int chosen = random.nextInt(0,hand.size());
        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
    }
}
