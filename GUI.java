import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI{

    public GUI(){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
    }
    public static void main(String[] args){
        new GUI();
        System.out.println("Hello, World.");

    }
}