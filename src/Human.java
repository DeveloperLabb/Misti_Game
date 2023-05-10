import java.util.InputMismatchException;
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
        boolean done = false;
        int chosen = 0;
        while(!done){
            try{
                System.out.println("Which card do you want to play? Please type index number.");
                chosen = scanner.nextInt();
                Validate.validateHumanInput(String.valueOf(chosen));
                if(chosen>hand.size()-1){
                    System.out.println("Please type correct index number.");
                    continue;
                }
                done = true;
            }catch(IllegalArgumentException e){
                System.err.println(e);
            }catch(InputMismatchException e){
                scanner.next();
                System.out.println("Please type an integer type.");
            }
        }

        Board.getOnBoard().addFirst(hand.get(chosen));
        hand.remove(chosen);
    }

}
