import java.util.Random;

public class Player {
    int [] result = new int[2];
    public Player(){
        result[0] = 1;
        result[1] = 1;

    }
    public int[] Roll(Warden warden){
        Random rand = new Random();

        result[0] = rand.nextInt((6 - 1) + 1)+1;
        result[1] = rand.nextInt((6 - 1) + 1)+1;
        return result;
    }
    public String[] DiceImage(){
        String[] file_paths = new String [2];
        file_paths[0] = "resources/dice/dice"+result[0]+".png";
        file_paths[1] = "resources/dice/dice"+result[1]+".png";
        return file_paths;
    }
}