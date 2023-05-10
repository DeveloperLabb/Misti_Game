import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class HighScore {
    static ScoreSet[] scores = new ScoreSet[10];

    static void AddScore(String name, int score){
        for(int a=0; a<scores.length; a++){
            ScoreSet set = scores[a];
            if(set == null){
                scores[a] = new ScoreSet(name, score);
                Save();
                return;
            }
            if(score > set.score){
                Shift(a);
                scores[a] = new ScoreSet(name, score);
                Save();
                return;
            }
        }
    }
    static void Shift(int index){
        for(int a=scores.length-1; a>index; a--){
            scores[a] = scores[a-1];
        }
    }
    static void Save(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt", false));
            for(int a=0; a<scores.length; a++){
                ScoreSet set = scores[a];
                if(set == null) break;
                writer.write(set.name+"\n"+set.score);
                if(a != scores.length-1) writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void Load(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
            int index = 0;
            String line = reader.readLine();
            while(line != null){
                scores[index] = new ScoreSet(line, Integer.parseInt(reader.readLine()));
                index++;
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            Save();
        }
    }
    static void Print(){
        for(ScoreSet set:scores){
            if(set != null)
                System.out.println(set.name + " - " + set.score);
        }
    }	
}
