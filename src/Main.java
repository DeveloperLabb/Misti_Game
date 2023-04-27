public class Main {
    public static Deck deck = new Deck();
    public static Player human = new Human("Sai","pe");
    public static Player expertBot = new ExpertBot();
    public static Player noviceBot = new NoviceBot();
    public static Player regularBot = new RegularBot();

    public static void main(String[] args) {

        System.out.println(deck.getDeck());
        System.out.println(regularBot);
    }
}