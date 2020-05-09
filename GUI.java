import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.CardLayout;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GUI {

    static Laugh clicked_laugh = new Laugh();
    JFrame frame = new JFrame();
    JPanel panelController = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JMenuBar menuBar;
    JMenu fileMenu, submenu;
    JMenuItem menuItem;
    static JButton laughbutton = new JButton("laugh");
    CardLayout cl = new CardLayout();
    public GUI() {
        
        panelController.setLayout((cl));
        panelController.add(panelFirst, "1");
        panelController.add(panelSecond, "2");
        cl.show(panelController, "1");

        placeLaughButton(panelFirst);
        placeLaughLabel(panelFirst);
        frame.add(panelController);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription("Menu with menu items");
        menuBar.add(fileMenu);

        menuItem = new JMenuItem("Next Stage", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Proceed to next stage");
        fileMenu.add(menuItem);

        frame.setJMenuBar(menuBar);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void placeLaughButton(JPanel panel) {

        panel.setLayout(null);

        laughbutton.setBounds(125, 80, 100, 25);
        laughbutton.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {
                    clicked_laugh.PlayLaugh();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(laughbutton);

}
    private static void placeLaughLabel(JPanel panel){
        JLabel label = new JLabel("Laugh Tracks");

        label.setBounds(125, 20, 100, 25);
        panel.add(label);
    }

    public static void main(String[] args){
        new GUI();

    }
}