import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI{

    public GUI(){
        JFrame frame = new JFrame();
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        placeComponents(panel);
        frame.add(panel);
      
    }
    private static void placeComponents(JPanel panel){

        panel.setLayout(null);
        JLabel label = new JLabel("Laugh Tracks");

        label.setBounds(125,20,100,25);
        panel.add(label);

        JButton laughbutton = new JButton("laugh");
        laughbutton.setBounds(125,80,100,25);
        panel.add(laughbutton);
    }
    public static void main(String[] args){
        new GUI();
        System.out.println("Hello, World.");

    }
}