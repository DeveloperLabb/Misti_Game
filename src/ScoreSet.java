public class ScoreSet{
    String name;
    int score;

    ScoreSet(String _name, int _score){
        name = _name;
        score = _score;
    }

    @Override
    public String toString() {
        return name+": "+score;
    }
}