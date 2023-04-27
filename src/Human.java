public class Human extends Player{
    public Human(String name, String surname) {
        super(name, surname);
        score=0;
    }

    @Override
    public void play() {
        System.out.println("Human playing");
    }
}
