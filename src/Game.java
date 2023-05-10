import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int numberOfPlayer;
    private int gameMode;//1-Succinct 2-Verbose
    private Deck deck;
    private String[] parameters; //Parameterslardan sadece file name boşta.


    public Game(int numberOfPlayer, int gameMode) {
        this.numberOfPlayer = numberOfPlayer;
        this.gameMode = gameMode;

    }
    public Game(String[] parameters){
        try{
            Validate.validateNumOfPlayers(parameters[0]);
            numberOfPlayer=Integer.parseInt(parameters[0]);
            Validate.validateArgumentNumber(parameters,numberOfPlayer);
            Validate.validateFile(parameters[1]);
            File.setFileName(parameters[1]);
            for(int a = 0;a<numberOfPlayer;a++){
                Validate.validateNameAndLevel(parameters[2+a]);
            }
            Validate.validateVerbosenessLevel(parameters[parameters.length-1]);
            gameMode=Integer.valueOf(parameters[parameters.length-1]);
            System.out.println("Validation completed.");
            this.parameters=parameters;
            deck = new Deck();
        }catch(IllegalArgumentException e ){
            System.err.println(e);
            System.err.println("Please input valid arguments.Like : \n For two player : \"2 input.txt Mert-4 Baha-2 2\"");
            System.out.println("Shutting Down.Restart again.");
            System.exit(1);
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Please input valid arguments.Like : \n For two player : \"2 input.txt Mert-4 Baha-2 2\"");
            System.out.println("Shutting Down.Restart again.");
            System.exit(1);
        }
    }
    public void start(){
        Player current;
        for(int a = 0;a<numberOfPlayer;a++){
            String[] temp = (parameters[2+a].split("-"));
            switch (Integer.valueOf(temp[1])){
                case 1:
                    current=new NoviceBot(temp[0]);
                    players.add(current);
                    break;
                case 2:
                    current=new RegularBot(temp[0]);
                    players.add(current);
                    break;
                case 3:
                    current=new ExpertBot(temp[0]);
                    players.add(current);
                    break;
                case 4:
                    current=new Human(temp[0]);
                    players.add(current);
                    break;
            }
        }
        deck.deal();
        for(Card cards : Board.getOnBoard()){
            Board.calculateStats().add(cards.getRank());
        }
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
            if(gameMode==2){//verbose
                for(Player players : players){
                    System.out.print(players.toString()+"\t");
                }
            }

            for(int b = 0 ;b<4;b++){
                for(Player player : players){
                    System.out.println();
                    System.out.println("---------------");
                    printBoard();
                    if(gameMode==2 && !(player instanceof Human )){//verbose
                        System.out.println(player.name+"\'s cards: "+player.hand);
                    }
                    player.play();
                    Board.calculateStats().add(Board.getOnBoard().get(0).getRank());
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
            System.out.println(lastCollector.name+" collected remaining cards.");
        }
        for(Player players : players){
            System.out.print(players.toString()+"\t");
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
