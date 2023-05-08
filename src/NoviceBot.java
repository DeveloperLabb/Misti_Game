public class NoviceBot extends Player{
    private static int numberOfNoviceBot = 0;

    @Override
    public void play() {

    }

    public NoviceBot() {
        name="Novice Bot";
        surname=Integer.toString(numberOfNoviceBot);
        score=0;
        numberOfNoviceBot++;
        System.out.println(name+" "+surname+" Added Successfully.");
    }
}
