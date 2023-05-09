import java.util.ArrayList;
import java.util.Random;

public class ExpertBot extends Player{
    private ArrayList<Integer> stats = new ArrayList<>();
    @Override
    public void play() {

    }

    public ExpertBot(String name) {
        super("Expert Bot "+name);
        score=0;
        System.out.println(name+" "+" Added Successfully.");
    }

}
