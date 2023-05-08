public class Main {
    public static void main(String[] args) {
        Game game=new Game(3,1);
        game.start();
        game.printInfo();
        game.deal();
        game.printInfo();
    }
}