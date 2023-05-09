import java.util.Random;
import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
        score=0;
        System.out.println(name+" "+" Added Successfully.");
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name+" "+"\'s cards: "+hand);
        System.out.println("Which card do you want to play? Please type index number.");
        int chosen = scanner.nextInt();
        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
    }

}
