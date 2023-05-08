import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int numberOfPlayer;
    private int gameMode;//1-Succinct 2-Verbose
    private Deck deck;

    public Game(int numberOfPlayer, int gameMode) {
        this.numberOfPlayer = numberOfPlayer;
        this.gameMode = gameMode;
        deck = new Deck();
    }
    public void start(){
        System.out.println("Please input your name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Please input your surname : ");
        String surname = scanner.next();
        Player current;
        current= new Human(name,surname);
        players.add(current);
        for(int a = 1;a<numberOfPlayer;a++){
            System.out.println("Which bot you want to add :\n\t1- Novice Bot\n\t2- Regular Bot\n\t3- Expert Bot");
            int chosen = scanner.nextInt();
            switch (chosen){
                case 1:
                    current=new NoviceBot();
                    players.add(current);
                    break;
                case 2:
                    current=new RegularBot();
                    players.add(current);
                    break;
                case 3:
                    current=new ExpertBot();
                    players.add(current);
                    break;
            }
        }
        deck.deal();
    }
    public void deal(){
        for(int i = 0; i < 4; i++){
            for(Player players : players){
                deck.deal(players);
            }
        }
    }
    public void printInfo(){
        Board.printInfo();
        for(Player curr : players){
            curr.printInfo();
        }
        deck.printInfo();
    }
}
