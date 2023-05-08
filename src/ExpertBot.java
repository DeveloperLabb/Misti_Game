public class ExpertBot extends Player{
    private static int numberOfExpertBot = 0;
    @Override
    public void play() {

    }

    public ExpertBot() {
        name="Expert Bot";
        surname=Integer.toString(numberOfExpertBot);
        score=0;
        numberOfExpertBot++;
        System.out.println(name+" "+surname+" Added Successfully.");

    }
}
