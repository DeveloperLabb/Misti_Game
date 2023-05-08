public class Human extends Player{
    public Human(String name, String surname) {
        super(name, surname);
        score=0;
        System.out.println(name+" "+surname+" Added Successfully.");
    }

    @Override
    public void play() {
        System.out.println("Human playing");
    }
}
