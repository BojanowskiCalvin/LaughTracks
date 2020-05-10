import javax.swing.JLabel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
public class Warden {
    String opening_speech;
    int [] warden_nums = new int[2];
    ArrayList<String> dialogue_array = new ArrayList<>();
    public Warden() {
        randomDiceObjective();
        opening_speech = "Alright prisoner, just roll a " + warden_nums[0] + " and a " + warden_nums[1] + " to proceed.";
       try( Scanner s = new Scanner(
            new File("resources/warden/Warden_Dialogue_Dice_Roll_.txt")))
            {
                while(s.hasNext()){
                    dialogue_array.add(s.nextLine());
                }
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        
    }

    private void randomDiceObjective() {
        Random rand = new Random();
        warden_nums[0] = rand.nextInt((6 - 1 ) + 1)+1;
        warden_nums[1] = rand.nextInt((6 - 1) + 1)+1;

    }
    public String Dialogue(){
        Random rand = new Random();
        int random_line = rand.nextInt(dialogue_array.size());
        return dialogue_array.get(random_line);
    }
    public String getOpeningSpeech(){
        return opening_speech;
    }
    public String CheckRoll(Player player){
        int [] playerRolls = player.Roll(this);
        if (ArrayMatch(playerRolls, warden_nums) == true) {
            return "Congratulations, you walk free!";
        }
        else{
            return this.Dialogue();
        }
    }
    private Boolean ArrayMatch(int[] ar1, int[] ar2) {
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return Arrays.equals(ar1,ar2);

    }
 
}