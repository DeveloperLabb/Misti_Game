import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int numberOfPlayer;
    private int gameMode;//1-Succinct 2-Verbose
    private Deck deck = new Deck();
    private String[] parameters;

    public Game(int numberOfPlayer, int gameMode) {
        this.numberOfPlayer = numberOfPlayer;
        this.gameMode = gameMode;

    }
    public Game(String[] parameters){
        this.parameters=parameters;
    }
    public void start(){
        System.out.println("Please input your name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Player current;
        current= new Human(name);
        players.add(current);
        for(int a = 1;a<numberOfPlayer;a++){
            System.out.println("Which bot you want to add :\n\t1- Novice Bot\n\t2- Regular Bot\n\t3- Expert Bot");
            int chosen = scanner.nextInt();
            switch (chosen){
                case 1:
                    current=new NoviceBot("Baha");
                    players.add(current);
                    break;
                case 2:
                    current=new RegularBot("Aras");
                    players.add(current);
                    break;
                case 3:
                    current=new ExpertBot("Mert");
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
    public void play(){
        int current = 48/(Integer.valueOf(numberOfPlayer)*4);
        Player lastCollector = players.get(0);
        for(int a = 0;a<current;a++){
            deal();
            System.out.println("Round :"+(a+1));
            if(gameMode==2){
                for(Player players : players){
                    System.out.print(players.toString()+"\t");
                }
            }

            for(int b = 0 ;b<4;b++){
                for(Player player : players){
                    System.out.println();
                    System.out.println("---------------");
                    printBoard();
                    if(gameMode==2){
                        System.out.println(player.name+"\'s cards: "+player.hand);
                    }
                    player.play();
                    if(player.check()==1){
                        player.mistiHand.addAll(Board.getOnBoard());
                        Board.clear();
                        lastCollector=player;
                        player.calculateScore();
                        System.out.println(player.name+" "+"done Misti");
                    }
                    if(player.check()==-1){
                        player.wonHand.addAll(Board.getOnBoard());
                        Board.clear();
                        lastCollector=player;
                        player.calculateScore();
                        System.out.println(player.name+" "+"collect cards.");
                    }
                    if(player.check()==0){

                    }

                }
            }
        }
        if(Board.getOnBoard().size()>0){
            lastCollector.wonHand.addAll(Board.getOnBoard());
            Board.clear();
        }
    }
    public void reset(){
        Board.reset();
    }
    private void printBoard(){
        System.out.println("Board : "+Board.getOnBoard());
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
