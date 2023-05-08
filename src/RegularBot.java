public class RegularBot extends Player{
    private static int numberOfRegularBot = 0;
    public RegularBot() {
        name="Regular Bot";
        surname=Integer.toString(numberOfRegularBot);
        score=0;
        numberOfRegularBot++;
        System.out.println(name+" "+surname+" Added Successfully.");
    }

    @Override
    public void play() {

    }
}
