import java.util.ArrayList;

public abstract class Player implements PlayerAPI{
    protected  ArrayList<Card> hand = new ArrayList<Card>();
    protected  ArrayList<Card> wonHand = new ArrayList<Card>();
    protected  ArrayList<Card> mistiHand= new ArrayList<Card>();
    protected String name;
    protected String surname;
    protected int score;

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Player() {
    }

    @Override
    public abstract void play();
    @Override
    public void calculateScore(){

    }
    @Override
    public void printInfo() {
        System.out.println(toString());
        System.out.println(hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                '}';
    }
}
