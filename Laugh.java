import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Laugh {
    String laugh_path="";
    static Boolean no_laughs;
    Clip clip;

    public Laugh(){
        no_laughs = true;
        laugh_path = RandomLaugh();

    }




    private static String RandomLaugh() {
        try {
            no_laughs = true;
            String[] pathnames;

            File laugh_directory = new File("resources/laughs");

            pathnames = laugh_directory.list();

            if (pathnames.length > 0) {
                int rnd = new Random().nextInt(pathnames.length);
                no_laughs = false;
            return pathnames[rnd];
        }
        else{
            return "No Laughs :(";
        }
    }
    catch(Exception e){
        return "No Laughs :(";
    }
        
    }
    public String getLaughPath(){
        try{
        return laugh_path;
        }
        catch (Exception e){
            return "No Laughs :(";
        }
    }
    public Boolean checkLaughs(){
        if (no_laughs == true){
            return false;
        }
        else{
            return true;
        }
    }
    public void PlayLaugh() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(clip != null){
            clip.stop();

        }
        AudioInputStream audioInputStream = 
        AudioSystem.getAudioInputStream(new File("resources/laughs/"+laugh_path));
        
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        this.resetLaugh();
    }
    private void resetLaugh(){
        laugh_path = RandomLaugh();
    }
}