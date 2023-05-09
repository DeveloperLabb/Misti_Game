public class Main {
    public static void main(String[] args) {
        Game game=new Game(3,1);
        game.start();
        game.printInfo();
        game.play();
        game.printInfo();
        for(Player players:game.getPlayers()){
            System.out.println(players.wonHand);
            System.out.println(players.mistiHand);
            System.out.println(players.hand);
        }
    }
}